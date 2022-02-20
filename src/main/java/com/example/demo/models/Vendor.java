package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "vendor")
public class Vendor {

    static final String SQ_CLIENT = "vendor_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_CLIENT)
    @SequenceGenerator(name = SQ_CLIENT, sequenceName = SQ_CLIENT,
            allocationSize = 1,initialValue=1)
    private Integer id;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private String pincode;

    @JoinColumn(name = "vendor_id", referencedColumnName = "id", updatable = false, insertable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> productList;
}
