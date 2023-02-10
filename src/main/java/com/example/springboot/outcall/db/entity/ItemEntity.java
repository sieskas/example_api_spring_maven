package com.example.springboot.outcall.db.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "item")
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_type", nullable = false)
	private TypeItemEntity idType;

	@ManyToOne
	@JoinColumn(name = "id_invoice", insertable = false, updatable = false)
	private InvoiceEntity invoiceEntity;

	@Column(name = "price", nullable = false, precision = 10)
	private BigDecimal price;
}
