package space.glimmer.lab;

import space.glimmer.lab.container.Bst;
import space.glimmer.lab.container.Entry;

public class BstTest {
    public static void main(String[] args) {
        Bst  bst=new Bst();
        bst.updateElement(new Entry("5","zzy"));
        bst.updateElement(new Entry("2","zzm"));
        bst.updateElement(new Entry("4","zzp"));
        bst.updateElement(new Entry("3","zzx"));
        bst.updateElement(new Entry("9","zzo"));
        bst.updateElement(new Entry("1","zzz"));
        bst.removeElement("2");
        Entry[] traverse = bst.traverse();
        for(Entry entry:traverse){
            System.out.println(entry.key);
        }


    }
}
