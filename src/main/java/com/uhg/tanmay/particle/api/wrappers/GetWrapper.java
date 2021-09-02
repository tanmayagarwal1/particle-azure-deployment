package com.uhg.tanmay.particle.api.wrappers;

public class GetWrapper {
    int tid;
    String type;
    long quantity;
    double price;

    public GetWrapper(int tid, String type, long quantity, double price) {
        this.tid = tid;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public GetWrapper() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GetWrapper{" +
                "tid=" + tid +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
