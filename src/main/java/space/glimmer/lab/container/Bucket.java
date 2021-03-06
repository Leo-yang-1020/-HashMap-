package space.glimmer.lab.container;

/**
 * @author Lehr
 * @create: 2021-01-16
 * 代表的是哈希桶(或者又称为 槽 slot)
 * 被哈希到这个位置的数据都存在这里
 * https://www.jianshu.com/p/dbe7a1ea5928
 */
public class Bucket {

    /**
     * 真正存放数据的容器,可能是链表,可能是二叉搜索树(BST)
     * 存放数据的容器其实就是你要实现的数据结构
     * 数据结构里的每个节点类型都是Entry,即封装了一组Key-Value,具体可以去Entry类里看
     */
    private BucketContainer container;

    /**
     * 初始化操作,默认的container为nodelist
     */
    public Bucket() {
        container = new NodeList();
    }

    /**
     * 检测container类型的,这里是测试代码需要检查,不能修改
     *
     * @return
     */
    public String checkContainerType() {
        return container.getType();
    }

    /**
     * 从这个bucket里通过key查找某个value
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        //todo:write your code here for part-a
        Entry entry = container.searchElement(key);
        if(entry==null)
            return null;
        else return entry.value;
    }

    /**
     * 存放一组key/value到这个bucket的数据容器里去
     * 并返回之前key位置的值,如果之前的key位置不存在，则返回空
     *
     * @param key
     * @param value
     * @return
     */
    public String putValue(String key, String value) {
        //todo:write your code here for part-a
        String s = getValue(key);
        //找原来位置的值,用于返回
        Entry entry = new Entry(key, value);
        container.updateElement(entry);
        return s;
    }

    /**
     * 删除某个key位置的值,并返回原有的value
     *
     * @param key
     * @return
     */
    public String removeValue(String key) {
        //todo:write your code here for part-a
        String value = getValue(key);
        if(value ==null)
            return null;//如果发现原来没有该key，直接返回空，无需移除操作,加快效率
        else{
            container.removeElement(key);
            return value;
        }
    }
    /**
     *
     */
    public int getNum(){
        return container.getNum();
    }
    public Entry[] getAllEntries(){
        return container.traverse();
    }
    /**
     * 冲突过多时为了防止链表退化时,所有数据从链表形式转换为二叉搜索树形式的操作
     */
    public void nodelistToBst() {
        //todo:write your code here for part-b
        Entry[] entries = container.traverse();
        container=new Bst();
        for(Entry entry: entries){
            container.updateElement(entry);
        }
    }

    /**
     * 当元素较少时,为了降低维护数据结构的开销,二叉搜索树变成链表的操作
     */
    public void bstToNodelist() {
        //todo:write your code here for part-b
        Entry[] entries = container.traverse();
        container=new NodeList();
        for(Entry entry: entries){
            container.addElement(entry);
        }

    }

}
