package com.chetan.e_commerse.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Catagory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private String name;
	@OneToMany (mappedBy ="catagory",cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
}
