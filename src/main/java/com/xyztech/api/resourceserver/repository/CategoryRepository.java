package com.xyztech.api.resourceserver.repository;


import com.xyztech.api.resourceserver.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
