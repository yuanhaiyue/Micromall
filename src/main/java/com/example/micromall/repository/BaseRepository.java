package com.example.micromall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author 14760
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Object>, JpaSpecificationExecutor<T> {
}
