package com.tenbes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenbes.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{

}