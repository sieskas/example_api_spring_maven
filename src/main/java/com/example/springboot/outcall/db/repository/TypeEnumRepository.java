package com.example.springboot.outcall.db.repository;

import com.example.springboot.outcall.db.entity.TypeEnumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeEnumRepository extends JpaRepository<TypeEnumEntity, Integer> {

	TypeEnumEntity getTypeEnumEntityByNameTypeEnum(String nameTypeEnum);
}
