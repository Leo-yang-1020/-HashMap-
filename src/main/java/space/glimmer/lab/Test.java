package space.glimmer.lab;

public class Test {
    public static void main(String[] args) {
        GlimmerHashMap gmp=new GlimmerHashMap();
        gmp.put("123","zzy");
        gmp.put("123","zzp");
        gmp.put("456","zzx");
        gmp.put(null,"zza");
        gmp.put(null,"zzb");
        gmp.put(null,null);
        gmp.put("JunkFood","KFC");
        gmp.remove("JunkFood");
        System.out.println(gmp.get("JunkFood"));

    }
}
