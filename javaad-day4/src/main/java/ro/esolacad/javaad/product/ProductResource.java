package ro.esolacad.javaad.product;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public List<SimpleProductModel> findAllProducts(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        return productService.findAllProducts(page, size);
    }

    @GetMapping("/v2/{productId}")
    public Product findById(@PathVariable("productId") Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> findByIdOrNotFound(@PathVariable("productId") Long id) {
        return productService.findProductByIdWithOptional(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody @Valid SimpleProductModel product,
                            BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        productService.saveProduct(product);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable("productId") Long id,
                              @RequestBody SimpleProductModel product) {
        product.setId(id);
        productService.saveProduct(product);
    }
}
