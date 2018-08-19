package com.example.rkdls.apiproject1.data;

public class CpuItem {
    // 변수 이름은 태그 이름과 똑같이 해야 함
    private String prod_name;
    private String maker;
    private int min_price;
    private int avr_price;
    private String danawaUrl;

    public CpuItem(String name, String maker, int minPrice, int avrPrice) {
        this.prod_name = name;
        this.maker = maker;
        this.min_price = minPrice;
        this.avr_price = avrPrice;
    }

    public String getName() {
        return prod_name;
    }

    public String getMaker() {
        return maker;
    }

    public int getMinPrice() {
        return min_price;
    }

    public int getAvrPrice() {
        return avr_price;
    }

    public String getDanawaUrl() {
        return danawaUrl;
    }
}
