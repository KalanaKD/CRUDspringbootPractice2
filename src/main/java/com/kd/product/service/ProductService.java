package com.kd.product.service;

import com.kd.product.dto.ProductDTO;
import com.kd.product.model.Product;
import com.kd.product.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo  productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts(){
        List<Product> productList =  productRepo.findAll();
        return modelMapper.map(productList, new TypeToken<List<ProductDTO>>(){}.getType());
    }

    public ProductDTO getProductById(Integer id){
        Product product = productRepo.getProductById(id);
        return modelMapper.map(product, ProductDTO.class);
    }

    public ProductDTO saveProduct(ProductDTO newProduct){
        productRepo.save(modelMapper.map(newProduct, Product.class));
        return newProduct;
    }

    public ProductDTO updateProduct(ProductDTO newProduct){
        productRepo.save(modelMapper.map(newProduct, Product.class));
        return newProduct;
    }

    public String deleteProductById(Integer id){
        productRepo.deleteById(id);
        return "Product with id: "+id+" has been deleted";
    }
}
