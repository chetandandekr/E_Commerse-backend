package com.chetan.e_commerse.reposietry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chetan.e_commerse.entity.Catagory;

@Repository
public interface CatagoryRepositery  extends JpaRepository<Catagory, Long>{

	Optional<Catagory> findByName(String catagoryName);
}
