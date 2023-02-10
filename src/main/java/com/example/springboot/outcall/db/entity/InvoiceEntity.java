package com.example.springboot.outcall.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "invoice")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice", nullable = false)
    private Integer id;

    @Column(name = "num_account", nullable = false, length = 100)
    private String numAccount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_invoice")
    private Set<ItemEntity> itemEntities = new LinkedHashSet<>();

}