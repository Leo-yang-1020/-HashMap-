package space.glimmer.lab;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        //Map<String, String> smap = new HashMap();//一般的HashMap
        GlimmerHashMap smap=new GlimmerHashMap();
        smap.put("Hello", "Hey");
        smap.put("Fruit", "Apple");
        smap.put("Vegetable", "Tomato");
        smap.put("JunkFood", "FrenchFried");
        System.out.println(smap.get("JunkFood"));
        smap.put("JunkFood", "Cola");
        smap.put("JunkFood", "OrangeJuice");
        smap.put("JunkFood", "KFC");
        smap.put("Drink", "Cola");

        GlimmerHashMap tmap = new GlimmerHashMap();

//        for (Map.Entry<String, String> entry : smap.entrySet()) {
//            tmap.put(entry.getKey(), entry.getValue());
//        }
        System.out.println(smap.get("JunkFood"));
        smap.remove("JunkFood");
        System.out.println(smap.get("JunkFood"));

//        GlimmerHashMap gmp=new GlimmerHashMap();
//        gmp.put("Drink","cola");
//        gmp.remove("Drink");
//        System.out.println(gmp.get("Drink"));
    }
}
