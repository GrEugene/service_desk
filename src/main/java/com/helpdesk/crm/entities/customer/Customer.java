package com.helpdesk.crm.entities.customer;

import com.helpdesk.crm.dto.customer.CustomerRequest;
import com.helpdesk.crm.entities.market.Market;
import com.helpdesk.crm.repositories.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    @SequenceGenerator(name = "customers_id_seq", sequenceName = "customers_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String phone;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Market market;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Customer> customers = new HashSet<>();

    public Customer(CustomerRequest customerRequest) {
        this.id = customerRequest.getId();
        this.name = customerRequest.getName();
        this.phone = customerRequest.getPhone();
        this.email = customerRequest.getEmail();
    }
}
