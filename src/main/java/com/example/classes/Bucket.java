package com.example.classes;

import java.util.ArrayList;

public class Bucket {
    public static ArrayList<Product> bucketProducts = new ArrayList<>();

    public static void addToBucket(Product product){
        bucketProducts.add(product);
    }
    public static int countBucket(){
        int result = 0;
        for(Product product : bucketProducts){
            result += product.getAmount() * product.getCost();
        }
        return result;
    }
}
