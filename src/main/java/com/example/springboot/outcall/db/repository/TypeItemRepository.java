package com.example.springboot.outcall.db.repository;

import com.example.springboot.outcall.db.entity.TypeItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeItemRepository extends JpaRepository<TypeItemEntity, Integer> {

	TypeItemEntity getTypeItemEntityByName(String nameTypeEnum);
}
