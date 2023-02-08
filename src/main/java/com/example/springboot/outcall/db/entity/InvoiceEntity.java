package com.example.springboot.outcall.db.entity;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "Invoice")
@EntityListeners(AuditingEntityListener.class)
public class InvoiceEntity {
	@Id
	@Column(name = "num_Account", nullable = false, length = 100)
	private String numAccount;

	@OneToMany(mappedBy = "numAccount")
	private List<ItemEntity> items = new ArrayList<>();
}
