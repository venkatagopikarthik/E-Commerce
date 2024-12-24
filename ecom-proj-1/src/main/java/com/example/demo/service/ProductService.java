package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
private ProductRepo repo;
	public List<Product> getAllProducts() {
		 List<Product> products = repo.findAll();
	return products;
	}
	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);//here we use orElse or get because findById may return null if there is no data
	}
	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageData(imageFile.getBytes());
		return repo.save(product);
	}

}
