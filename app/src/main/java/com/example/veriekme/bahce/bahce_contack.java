package com.example.veriekme.bahce;

public class bahce_contack {


    private String urunAdi;
    private String fiyat1;
    private String fiyat2;
    private String fiyat3;
    private String imgUrl;
    private int resim;

    public bahce_contack(String urunAdi, String fiyat1, String fiyat2, String fiyat3, String imgUrl, int resim) {
        this.urunAdi = urunAdi;
        this.fiyat1 = fiyat1;
        this.fiyat2 = fiyat2;
        this.fiyat3 = fiyat3;
        this.imgUrl = imgUrl;
        this.resim = resim;
    }

    //getter

    public String getImgUrl() {
        return imgUrl;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public String getFiyat1() {
        return fiyat1;
    }

    public String getFiyat2() {
        return fiyat2;
    }

    public String getFiyat3() {
        return fiyat3;
    }

    public int getResim() {
        return resim;
    }

    //setter

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public void setFiyat1(String fiyat1) {
        this.fiyat1 = fiyat1;
    }

    public void setFiyat2(String fiyat2) {
        this.fiyat2 = fiyat2;
    }

    public void setFiyat3(String fiyat3) {
        this.fiyat3 = fiyat3;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }
}
