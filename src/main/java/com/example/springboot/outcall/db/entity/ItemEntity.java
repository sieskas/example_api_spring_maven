package com.example.springboot.outcall.db.entity;

import java.math.BigDecimal;
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
@Table(name = "Item")
@EntityListeners(AuditingEntityListener.class)
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_type", nullable = false)
	private TypeEnumEntity idType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "num_Account", nullable = false)
	private InvoiceEntity numAccount;

	@Column(name = "price", nullable = false, precision = 10)
	private BigDecimal price;
}
