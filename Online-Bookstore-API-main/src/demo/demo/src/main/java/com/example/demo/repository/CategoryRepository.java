package com.example.demo.repository;
import com.example.demo.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<CategoryModel ,Long>{

}
