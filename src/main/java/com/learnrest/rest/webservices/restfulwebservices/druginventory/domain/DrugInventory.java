package com.learnrest.rest.webservices.restfulwebservices.druginventory.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "drug_inventory")
@Getter
@Setter
public class DrugInventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "br_id")
    private long barCodeId;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "inventory")
    private double inventory;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    public DrugInventory() {
    }

    @Override
    public String toString() {
        return "DrugInventory{" +
                "id=" + id +
                ", barCodeId=" + barCodeId +
                ", drugName='" + drugName + '\'' +
                ", unitPrice=" + unitPrice +
                ", sellingPrice=" + sellingPrice +
                ", inventory=" + inventory +
                ", expiryDate=" + expiryDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
