package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "drugs")
public class Medicine implements Comparable<Medicine> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String medicine;

    @Column
    private String dosage;

    @Column
    private String quantity;

    @Column
    private String expiration;

    @Column(name = "int_expiration")
    private Integer intExpiration;

    public Medicine() {
    }

    public Medicine(String medicine, String dosage, String quantity, String expiration, Integer intExpiration) {
        this.medicine = medicine;
        this.dosage = dosage;
        this.quantity = quantity;
        this.expiration = expiration;
        this.intExpiration = intExpiration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public Integer getIntExpiration() {
        return intExpiration;
    }

    public void setIntExpiration(Integer intExpiration) {
        this.intExpiration = intExpiration;
    }

    @Override
    public int compareTo(Medicine o) {
        return this.medicine.compareTo(o.medicine);
    }

//    @Override
//    public int compare(Medicine o1, Medicine o2) {
//        return o1.getIntExpiration().compareTo(o2.getIntExpiration());
//    }
}