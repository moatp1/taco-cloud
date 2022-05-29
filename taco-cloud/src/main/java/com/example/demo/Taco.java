	package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.*;
@Data
@Entity
public class Taco {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date createAt;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	@ManyToMany(targetEntity = Ingredient.class)
	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<Ingredient> ingredients = new ArrayList<>();
	@PrePersist
	void createAt() {
		this.createAt = new Date();
	}
}
