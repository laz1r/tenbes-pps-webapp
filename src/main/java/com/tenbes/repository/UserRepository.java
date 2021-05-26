package com.tenbes.repository;

import com.tenbes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// aka DAO

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}