package ro.esolacad.javaad.product;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductResourceTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Sql(value = "/sql/add_products.sql")
    @Sql(value = "/sql/delete_all.sql", executionPhase = AFTER_TEST_METHOD)
    public void testGetProduct() throws Exception {
        Product expectedProduct = Product.builder()
                .id(-1L)
                .name("Ionut")
                .price(BigDecimal.ONE.setScale(2))
                .brand("Coca-Cola")
                .build();

        String expectedProductAsString = objectMapper.writeValueAsString(expectedProduct);


        MvcResult mvcResult = mockMvc.perform(get("/product/v2/-1").contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals(expectedProductAsString, contentAsString);
    }
}
