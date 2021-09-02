package com.uhg.tanmay.particle.api.wrappers;

public class TotalWrapper {
    int tid;
    long total_quantity;
    double total_price;
    double average;

    public TotalWrapper(int tid, long total_quantity, double total_price, double average) {
        this.tid = tid;
        this.total_quantity = total_quantity;
        this.total_price = total_price;
        this.average = average;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public long getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(long total_quantity) {
        this.total_quantity = total_quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public TotalWrapper() {
    }
}
