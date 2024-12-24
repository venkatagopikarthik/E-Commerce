package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Product {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String brand;
	private BigDecimal price;
	private String category;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")//json format is used to convert json to object and object to json and some formats
	private Date releaseDate;
	private boolean productAvailable;
	private int stockQuantity;
	
	
	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageData;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isproductAvailable() {
		return productAvailable;
	}
	public void setproductAvailable(boolean available) {
		this.productAvailable = available;
	}
	public int getstockQuantity() {
		return stockQuantity;
	}
	public void setstockQuantity(int quantity) {
		this.stockQuantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", desc=" + description + ", brand=" + brand + ", price=" + price + ", category="
				+ category + ", releaseDate=" + releaseDate + ", available=" + productAvailable + ", quantity=" + stockQuantity
				+ "]";
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	

}
