package com.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ITEMS")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@Column(name = "DELETED_AT")
	private LocalDateTime deletedAt;
	
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Category category;
	
	@Column(name = "STOCK")
	private Integer stock;
}
