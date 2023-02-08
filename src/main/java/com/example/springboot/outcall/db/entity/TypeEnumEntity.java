package com.example.springboot.outcall.db.entity;

import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "TypeEnum")
@EntityListeners(AuditingEntityListener.class)
public class TypeEnumEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;
}
