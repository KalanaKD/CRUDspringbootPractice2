package com.kd.product.controller;

import com.kd.product.dto.ProductDTO;
import com.kd.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproducts")
    public List<ProductDTO> getAllProds(){
        return productService.getAllProducts();
    }

    @GetMapping("/getproduct/{id}")
    public ProductDTO getProd(@PathVariable("id") Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/addproduct")
    public ProductDTO addProd(@RequestBody ProductDTO newProduct){
        return productService.saveProduct(newProduct);
    }

    @PutMapping("/updateproduct")
    public ProductDTO updateProd(@RequestBody ProductDTO newProduct){
        return productService.updateProduct(newProduct);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProd(@PathVariable("id") Integer id){
        productService.deleteProductById(id);
        return "Product deleted successfully";
    }

}
