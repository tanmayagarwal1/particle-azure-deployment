package com.uhg.tanmay.particle.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class SParticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "price")
    double price;

    @Column(name = "quantity")
    long quantity;

    @Column(name = "type")
    String type;

    @Column(name = "tid")
    int tid;

    @Column(name = "charge")
    double charge;

    @Column(name = "spin")
    int spin;

    @Column(name = "mass")
    double mass;

    public SParticle(double price, long quantity, String type, int tid, double charge, int spin, double mass) {
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.tid = tid;
        this.charge = charge;
        this.spin = spin;
        this.mass = mass;
    }

    public SParticle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getSpin() {
        return spin;
    }

    public void setSpin(int spin) {
        this.spin = spin;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}