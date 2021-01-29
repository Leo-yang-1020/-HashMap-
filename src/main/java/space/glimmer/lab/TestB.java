package space.glimmer.lab;

import space.glimmer.lab.container.Bst;
import space.glimmer.lab.container.Bucket;
import space.glimmer.lab.container.Entry;

public class TestB {
    public static void main(String[] args) {
        Bst tmap = new Bst();

        tmap.updateElement(new Entry("EaFBFBFBFBFBFBFBFBFB", "b"));
        tmap.updateElement(new Entry("FBEaFBFBFBFBFBFBFBFB", "c"));
        tmap.updateElement(new Entry("FBFBEaFBFBFBFBFBFBFB", "d"));
        tmap.updateElement(new Entry("FBFBFBEaFBFBFBFBFBFB", "e"));
        tmap.updateElement(new Entry("FBFBFBFBEaFBFBFBFBFB", "f"));
        tmap.updateElement(new Entry("FBFBFBFBFBEaFBFBFBFB", "g"));
        tmap.updateElement(new Entry("FBFBFBFBFBFBEaFBFBFB", "h"));
        tmap.updateElement(new Entry("FBFBFBFBFBFBFBEaFBFB", "i"));
        tmap.searchElement("FBFBFBFBFBFBFBFBEaFB");
        tmap.updateElement(new Entry("FBFBFBFBFBFBFBFBEaFB", "j"));
        System.out.println(tmap.getNum());
        System.out.println(tmap.searchElement("FBFBFBFBFBFBFBFBEaFB").value);
    }
}
