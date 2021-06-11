package com.tenbes.repository;

import com.tenbes.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// aka DAO

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT U FROM User U Where U.email = ?1 AND U.pass = ?2")
	Optional<User> loginByEmailAndPass(String email, String pass);
}