package com.example.micromall.repository;

import com.example.micromall.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 14760
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {




}
