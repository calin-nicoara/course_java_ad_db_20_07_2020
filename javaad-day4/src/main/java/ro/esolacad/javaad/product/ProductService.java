package ro.esolacad.javaad.product;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final StoreProductRepository storeProductRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
//    private final EmailService emailService;

    public List<SimpleProductModel> findAllProducts(final int page, final int size) {
        return productRepository.findAll(PageRequest.of(page, size, Sort.by("id")))
                .stream()
                .map(ProductMapper::toSimpleProductModel)
                .collect(Collectors.toList());
    }

    public void saveProduct(SimpleProductModel productModel) {
        Product product = Product.builder()
                .name(productModel.getName())
                .brand(productModel.getBrand())
                .price(productModel.getPrice())
                .build();

        productRepository.save(product);
        applicationEventPublisher.publishEvent(new ProductSavedEvent(this,product));
//        emailService.sendEmailProductCreated(product);
    }

    public void saveProductAndStoreProducts(Product product, List<Long> storeIds,
                                            Integer initialStock) {
        Product savedProduct = productRepository.save(product);

//        if(true) {
//            throw new RuntimeException("Problem in DB world!");
//        }

        List<StoreProduct> storeProducts = storeIds.stream()
                .map(storeId ->
                        StoreProduct.builder()
                                .storeId(storeId)
                                .stock(initialStock)
                                .product(savedProduct)
                                .build()
                )
                .collect(Collectors.toList());

        storeProductRepository.saveAll(storeProducts);
    }

    public Product findProductById(Long id) {
        Optional<Product> productOptional
                = productRepository.findById(id);

        return productOptional.orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    public Optional<ProductModel> findProductByIdWithOptional(Long id) {
        return productRepository.findById(id)
                .map(this::mapProductToProductModel);
    }

    private ProductModel mapProductToProductModel(final Product product) {
        List<StoreProductModel> storeProductModels = storeProductRepository.findByProduct(product)
                .stream()
                .map(storeProduct -> StoreProductModel.builder()
                        .storeId(storeProduct.getStoreId())
                        .stock(storeProduct.getStock())
                        .build())
                .collect(Collectors.toList());

        return ProductModel
                .builder()
                .id(product.getId())
                .brand(product.getBrand())
                .price(product.getPrice())
                .storeProductList(storeProductModels)
                .build();
    }

    public void changeName(Long id) {
        productRepository.findById(id)
                .ifPresent(product -> {
                    product.setName("NEW UPDATED NAME!!");
//            productRepository.save(product);
                });
    }


}
