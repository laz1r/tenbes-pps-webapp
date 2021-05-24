package com.tenbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenbes.entity.Links;

@Repository
public interface LinkRepository extends JpaRepository<Links, Long>{

}