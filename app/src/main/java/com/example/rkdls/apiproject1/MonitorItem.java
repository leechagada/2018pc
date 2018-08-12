package com.example.rkdls.apiproject1;

public class MonitorItem {
    private String maker;
    private int minPrice;

    public MonitorItem(String maker, int minPrice) {
        this.maker = maker;
        this.minPrice = minPrice;
    }

    public String getMaker() {
        return maker;
    }

    public int getMinPrice() {
        return minPrice;
    }
}
