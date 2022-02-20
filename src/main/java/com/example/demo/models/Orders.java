package com.example.demo.models;


import com.example.demo.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Orders {

    static final String SQ_CLIENT = "order_id_seq";

    // todo: add purchase time

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_CLIENT)
    @SequenceGenerator(name = SQ_CLIENT, sequenceName = SQ_CLIENT,
            allocationSize = 1,initialValue=1)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "paid")
    private boolean paid;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @JoinColumn(name = "id", referencedColumnName = "id", updatable = false, insertable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Cart cart;


}
