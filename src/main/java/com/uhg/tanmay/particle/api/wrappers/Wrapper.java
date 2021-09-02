package com.uhg.tanmay.particle.api.wrappers;

public class Wrapper {

    int tid;
    double price;
    long quantity;

    public Wrapper(int tid, double price, long quantity) {
        this.tid = tid;
        this.price = price;
        this.quantity = quantity;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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

    public Wrapper() {
    }
}
