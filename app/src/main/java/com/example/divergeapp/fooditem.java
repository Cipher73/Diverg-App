package com.example.divergeapp;

public class fooditem {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFoodtitle() {
        return foodtitle;
    }

    public void setFoodtitle(String foodtitle) {
        this.foodtitle = foodtitle;
    }

    String description;
    String price;
    String foodtitle;
    int CountInCart=0;
    public int getCountInCart() {
        return CountInCart;
    }

    public void setCountInCart(int countInCart) {
        CountInCart = countInCart;
    }


    public fooditem(String description, String price, String foodtitle) {
        this.description = description;
        this.price = price;
        this.foodtitle = foodtitle;
    }


}
