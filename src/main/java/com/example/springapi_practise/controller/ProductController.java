package com.example.springapi_practise.controller;


import com.example.springapi_practise.Product.ProductModel;
import com.example.springapi_practise.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;
    @GetMapping("/Books")
    public String get()
    {
        return "This is simple method";
    }
    @GetMapping("/productslist")
    public ResponseEntity<List<ProductModel>>  getAllProduct()
    {
        List<ProductModel> ProductList= productService.AllProduct();
        if(ProductList.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(ProductList));

    }
    @GetMapping("/product1/{id}")
    public ProductModel getProductById(@PathVariable("id") int id)
    {
        return productService.ProductById(id);
    }
//    public ResponseEntity<ProductModel> getProductByID(@RequestParam long id)
//    {
//        ProductModel productModel= (ProductModel) productService.ProductById(id);
//        {
//            if(productModel==null)
//            {
//               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            }
//            return ResponseEntity.of(Optional.of(productModel));
//        }
//    }
    @PostMapping("/products")
    public ProductModel addProduct(@RequestBody ProductModel productModel){
        ProductModel p=this.productService.addproduct(productModel);
        return p;
    }
    @DeleteMapping("/prod/{Productid}")
    public void deleteProduct(@PathVariable("ProductId") int Productid){
        this.productService.deleteProduct(Productid);
    }
    @PutMapping("/product/{id}")
    public ProductModel updateProduct(@RequestBody ProductModel productModel,@PathVariable("Id") int pid)
    {
        this.productService.updateProduct(productModel,pid);
        return productModel;
    }

}
