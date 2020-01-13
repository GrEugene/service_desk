package com.helpdesk.crm.repositories.worker;

import com.helpdesk.crm.repositories.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "workers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Worker extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workers_id_seq")
    @SequenceGenerator(name = "workers_id_seq", sequenceName = "workers_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Worker> workers = new HashSet<>();
}