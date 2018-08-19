package com.example.rkdls.apiproject1.data;

public class MonitorItem {
    private String maker;
    private int min_price;

    public MonitorItem(String maker, int minPrice) {
        this.maker = maker;
        this.min_price = minPrice;
    }

    public String getMaker() {
        return maker;
    }

    public int getMinPrice() {
        return min_price;
    }
}