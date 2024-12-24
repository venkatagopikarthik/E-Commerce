package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
		
	}
	@GetMapping("product/{id}")
	public ResponseEntity<Product> getproduct(@PathVariable int id) {
		Product product=service.getProductById(id);
		if(product!=null)
		return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product, 
			                             @RequestPart MultipartFile imageFile ){
		try {
		Product product1= service.addProduct(product,imageFile);
		return new ResponseEntity<>(product1,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/product/{productId}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
		Product product=service.getProductById(productId);
		byte[] imageFile=product.getImageData();
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf(product.getImageType()))
				.body(imageFile);
	}
	

}
