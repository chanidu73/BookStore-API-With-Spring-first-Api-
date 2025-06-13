package com.example.demo.repository;
import com.example.demo.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthorRepository extends JpaRepository<AuthorModel , Long> {

}
