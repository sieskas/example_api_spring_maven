package com.example.springboot.outcall.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_item")
public class TypeItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
