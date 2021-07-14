package com.example.infs3605.Entities;

import com.example.infs3605.R;

import java.util.ArrayList;

public class Shopping {

    private int shoppingImage;
    private String shoppingCategory;
    private String shoppingName;
    private double shoppingPrice;

    public Shopping(int shoppingImage, String shoppingCategory, String shoppingName, double shoppingPrice) {
        this.shoppingImage = shoppingImage;
        this.shoppingCategory = shoppingCategory;
        this.shoppingName = shoppingName;
        this.shoppingPrice = shoppingPrice;
    }

    public int getShoppingImage() {
        return shoppingImage;
    }

    public void setShoppingImage(int shoppingImage) {
        this.shoppingImage = shoppingImage;
    }

    public String getShoppingCategory() {
        return shoppingCategory;
    }

    public void setShoppingCategory(String shoppingCategory) {
        this.shoppingCategory = shoppingCategory;
    }

    public String getShoppingName() {
        return shoppingName;
    }

    public void setShoppingName(String shoppingName) {
        this.shoppingName = shoppingName;
    }

    public double getShoppingPrice() {
        return shoppingPrice;
    }

    public void setShoppingPrice(double shoppingPrice) {
        this.shoppingPrice = shoppingPrice;
    }

    public static ArrayList<Shopping> getShoppingList() {
        ArrayList<Shopping> shoppingList = new ArrayList<>();

        shoppingList.add(new Shopping(R.drawable.shopping1,"Apparel","T-Shirt",27.00));
        shoppingList.add(new Shopping(R.drawable.shopping2,"Apparel","Long Sleeve T-Shirt",35.00));
        shoppingList.add(new Shopping(R.drawable.shopping3,"Apparel","Hooded Sweat Shirt",92.00));
        shoppingList.add(new Shopping(R.drawable.shopping4,"Accessories","Glasses Case",29.00));
        shoppingList.add(new Shopping(R.drawable.shopping5,"Accessories","Glasses Pouch",8.95));
        shoppingList.add(new Shopping(R.drawable.shopping6,"Accessories","Scrunchies",6.50));
        shoppingList.add(new Shopping(R.drawable.shopping7,"Books","Aboriginal Myths, Legends and Fables",28.00));
        shoppingList.add(new Shopping(R.drawable.shopping8,"Books","A Beginner's Guide to Australian Aboriginal Words",8.00));
        shoppingList.add(new Shopping(R.drawable.shopping9,"Books","Aboriginal Stories",35.00));
        shoppingList.add(new Shopping(R.drawable.shopping10,"Art","Kangaroo Sunset 22x12cm",65.00));
        shoppingList.add(new Shopping(R.drawable.shopping11,"Art","Freshwater, Arnhem Land 60x120cm",690.00));
        shoppingList.add(new Shopping(R.drawable.shopping12,"Art","Freshwater, Saltwater Arnhem Land 60x120cm",690.00));
        shoppingList.add(new Shopping(R.drawable.shopping13,"Artefacts","Brolgas Emu Caller",95.00));
        shoppingList.add(new Shopping(R.drawable.shopping14,"Artefacts","Clapsticks",65.00));
        shoppingList.add(new Shopping(R.drawable.shopping15,"Artefacts","15 inch Boomerang",75.00));

        return shoppingList;
    }
}
