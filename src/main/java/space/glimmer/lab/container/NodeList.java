package space.glimmer.lab.container;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Lehr
 * @create: 2021-01-16
 * 链表的实现,需要完成除了getType的其他接口
 * 你可以选择自己手写一遍实现,也可以学习使用Java 泛型容器里的LinkedList实现好了的链表直接写这里
 */
public class NodeList implements BucketContainer {
    private LinkedList<Entry> linkedList;

    public NodeList() {
        linkedList = new LinkedList<>();
    }

    /**
     * 写死的,不能修改,用来判断具体的数据结构
     *
     * @return
     */
    @Override
    public String getType() {
        return "nodelist";
    }

    /**
     * 搜索某个元素并返回
     * 其中key是这个元素Entry的key
     *
     * @param key
     * @return
     */
    @Override
    public Entry searchElement(String key) {
        //todo:write your code here for part-a
        for (Entry entry : linkedList) {
            if (key == null) {
                if (entry.key == null)
                    return entry;
            } else if (entry.key.equals(key))
                return entry;
        }
        return null;
    }

    /**
     * 添加一个元素，主要用于添加原来不存在该key的entry
     *
     * @param e
     */
    @Override
    public void addElement(Entry e) {
        //todo:write your code here for part-a
        linkedList.add(e);
    }


    /**
     * 更新一个节点,如果结点不存在，则创建结点
     *
     * @param e
     */
    @Override
    public void updateElement(Entry e) {
        //todo:write your code here for part-a
        boolean isExist = false;
        for (Entry entry : linkedList) {
            if (e.key == null) {
                if (entry.key == null) {
                    entry.value = e.value;
                    isExist = true;
                    break;
                }
            } else if (entry.key.equals(e.key)) {
                entry.value = e.value;
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            linkedList.add(e);
        }
    }

    /**
     * 删除一个节点
     *
     * @param key
     */
    @Override
    public void removeElement(String key) {
        //todo:write your code here for part-a
        for (Entry entry : linkedList) {
            if (key == null) {//对key为空的特殊处理
                if (entry.key == null) {
                    linkedList.remove(entry);
                    break;
                }
            } else if (entry.key.equals(key)) {
                linkedList.remove(entry);
                break;
            }
        }
    }

    /**
     * 遍历并返回所有元素
     *
     * @return
     */
    @Override
    public Entry[] traverse() {
        //todo:write your code here for part-a
        ArrayList<Entry> list = new ArrayList<>();
        //这里不确定长度，并且没有删除等操作，适合使用ArrayList
        for (Entry entry : linkedList) {
            list.add(entry);
        }
        return list.toArray(new Entry[list.size()]);
        //将arrayList转化为普通的数组
    }

    @Override
    public int getNum() {
        return linkedList.size();
    }
}
