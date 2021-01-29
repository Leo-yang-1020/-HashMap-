package space.glimmer.lab;

import space.glimmer.lab.container.Bucket;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        GlimmerHashMap tmap = new GlimmerHashMap();
        tmap.put("EaFBFBFBFBFBFBFBFBFB", "b");
        tmap.put("FBEaFBFBFBFBFBFBFBFB", "b");
        tmap.put("FBFBEaFBFBFBFBFBFBFB", "b");
        tmap.put("FBFBFBEaFBFBFBFBFBFB", "b");
        tmap.put("FBFBFBFBEaFBFBFBFBFB", "b");
        tmap.put("FBFBFBFBFBEaFBFBFBFB", "b");
        tmap.put("FBFBFBFBFBFBEaFBFBFB", "b");
        tmap.put("FBFBFBFBFBFBFBEaFBFB", "b");
        tmap.put("FBFBFBFBFBFBFBFBEaFB", "b");
        tmap.put("a", "b");
        tmap.put("b", "b");
        System.out.println(tmap.size());
    }
}
