package com.chetan.e_commerse.reposietry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chetan.e_commerse.entity.Product;
@Repository
public interface ProductRepositery extends JpaRepository<Product, Long> {

}
