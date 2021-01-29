package space.glimmer.lab.container;

import java.util.ArrayList;

/**
 * @author Lehr
 * @create: 2021-01-16
 * 二叉搜索树实现,需要完成除了getType的其他接口
 */
public class Bst implements BucketContainer {

    /**
     * 二叉搜索树的根节点
     */
    private Node root = null;

    /**
     * 二叉树的结构
     */
    public static class Node {
        private Entry data;
        private Node leftChild;
        private Node rightChild;

        public Node() {
        }

        public Node(Entry data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Entry getData() {
            return data;
        }
    }

    /**
     * 写死的,不能修改
     *
     * @return
     */
    @Override
    public String getType() {
        return "bst";
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
        //todo:write your code here for part-b
        Node node = search(key, root);
        if(node==null)
            return null;
        return node.data;
    }

    /**
     * 添加一个元素
     *
     * @param e
     */
    @Override
    public void addElement(Entry e) {
        //todo:write your code here for part-b
    }

    /**
     * 更新一个节点
     *
     * @param e
     */
    @Override
    public void updateElement(Entry e) {
        //todo:write your code here for part-b
        if (root == null) {
            root = new Node(e, null, null);
        } else {
            insert(e, root);
        }
    }

    /**
     * 删除一个节点
     *
     * @param key
     */
    @Override
    public void removeElement(String key) {
        //todo:write your code here for part-b
        remove(key,root);
    }

    /**
     * 按照树的"先序遍历",遍历并返回所有元素
     *
     * @return
     */
    @Override
    public Entry[] traverse() {
        //todo:write your code here for part-b
        int i=0;
        ArrayList<Entry>entries=new ArrayList<>();
        class Preorder{
              void preOrder(Node node){
                if(node!=null){
                    entries.add(node.data);
                }
                if(node.leftChild!=null)
                    preOrder(node.leftChild);
                if (node.rightChild!=null)
                    preOrder(node.rightChild);
            }
        }
        Preorder preorder=new Preorder();
        preorder.preOrder(root);
        return entries.toArray(new Entry[entries.size()]);
    }

    @Override
    public int getNum() {
        return getSize(root);
    }

    /**
     * 二叉搜索树的插入结点操作
     *
     * @param e
     * @param root
     * @return
     */
    private Node insert(Entry e, Node root) {
        int compareResult;
        if (root == null)
            return new Node(e, null, null);
        else {
            compareResult = compare(e.key, root);
            if (compareResult < 0) {
                root.leftChild = insert(e, root.leftChild);
                //递归，如果key比现在的结点的key小，则找左子树
            } else if (compareResult > 0) {
                root.rightChild = insert(e, root.rightChild);
            } else {
                root.data.value = e.value;
                //如果key相同，说明是更新操作
            }
        }
        return root;
    }

    /**
     * 找到某个BST的结点子结点中最小的,用于remove时找到后继结点
     *
     * @param node
     * @return
     */
    private Node findMin(Node node) {
        if (node == null)
            return node;
        else {
            if (node.leftChild != null)
                return findMin(node.leftChild);
            else
                return node;
        }
    }

    private Node findMax(Node node) {
        if (node == null)
            return node;
        else {
            if (node.rightChild != null)
                return findMax(node.rightChild);
            else
                return node;
        }
    }

    /**
     * 比较函数，定义了二叉搜索树的key的比较方法,包括key为null时的规则
     *
     * @param key
     * @param node
     * @return
     */
    private int compare(String key, Node node) {
        int compareResult;
        if (key == null) {
            if (node.data.key == null)
                //当key和当前结点的key都为null时，说明找到了结点
                compareResult = 0;
            else {
                //当key为null，但当前的结点key不是null时，接续搜索当前结点的左结点
                compareResult = -1;
            }
        } else {
            if (node.data == null) {
                //key不为空，但当前结点的key为null,继续搜索当前结点的右结点
                compareResult = 1;
            } else {
                //key和当前结点的key都不为null,进行字符串大小比较
                compareResult = key.compareTo(node.data.key);
            }
        }
        return compareResult;
    }

    /**
     * 根据key移除某个结点
     *
     * @param key
     * @param node
     * @return 返回删除的结点的entry，如果没有相应结点，返回null
     */
    private Entry remove(String key, Node node) {
        Node parent = null;
        Node current = node;
        int compareResult;
        while (current != null) {
            //找到要删除结点及其父节点
            compareResult = compare(key, current);
            if (compareResult < 0) {
                parent = current;
                current = current.leftChild;
            } else if (compareResult > 0) {
                parent = current;
                current = current.rightChild;
            } else
                break;
        }
        if (current == null)
            return null;
            //没有找到时，返回null
        else {
            if (current.rightChild != null) {
                if (current.leftChild != null) {
                    //左右子树均存在的情况,还需要找到其前驱结点和前驱结点的父结点，也就是左子树的最右结点
                    Node precursor = current.leftChild;
                    Node precursorParent = current;
                    while (precursor.rightChild != null) {
                        precursorParent = precursor;
                        precursor = precursor.rightChild;
                    }
                    Entry entry=current.data;
                    current.data = precursor.data;
                    if(precursorParent!=current)
                    precursorParent.rightChild = precursor.leftChild;
                    else{
                        current.leftChild=precursor.leftChild;
                    }
                    return entry;//返回删除的结点的值
                } else {
                    //当右子树存在，而左子树不存在时
                    if (parent == null) {
                        //当要删除的结点为头结点时
                        root = root.rightChild;
                        return node.data;
                    } else {
                        if (parent.leftChild == current) {
                            //当前结点为父节点的左子树
                            parent.leftChild = current.rightChild;
                        } else if (parent.rightChild == current) {
                            //当前结点为父节点的右子树时
                            parent.rightChild = current.rightChild;
                        }
                    }
                }
            } else {
                if (current.leftChild != null) {
                    //右子树为空，左子树不为空时
                    if (parent == null) {
                        root = root.leftChild;
                        return node.data;
                    }
                    if (parent.leftChild == current) {
                        //当前结点为父节点的左子树
                        parent.leftChild = current.leftChild;
                    } else if (parent.rightChild == current) {
                        //当前结点为父节点的右子树时
                        parent.rightChild = current.leftChild;
                    }
                } else {
                    //左子树和右子树均为空时
                    if (parent == null) {
                        //要删除的结点为根节点时
                        root = null;
                        return node.data;
                    }
                    if (parent.leftChild == current) {
                        //当前结点为父节点的左子树
                        parent.leftChild = null;
                    } else if (parent.rightChild == current) {
                        //当前结点为父节点的右子树时
                        parent.rightChild = null;
                    }
                }
            }
        }
        return current.data;

    }



    /**
     * 根据key搜索结点
     *
     * @param key
     * @return
     */
    private Node search(String key, Node node) {
        int compareResult;
        if (node == null)
            return null;
        else {
            compareResult = compare(key, node);
            if (compareResult == 0)
                return node;
            else if (compareResult < 0)
                return search(key, node.leftChild);
            else return search(key, node.rightChild);

        }

    }
    /**
     * 先序遍历BST
     *
     * @param node
     * @return
     */
    private void preOrder(Node node) {
        if (node == null)
            return ;
        System.out.println(node.data.value);
        if (node.leftChild != null)
            preOrder(node.leftChild);
        if (node.rightChild != null)
            preOrder(node.rightChild);
    }
    private int getSize(Node root){
        if(root==null)
            return 0;
        return getSize(root.rightChild)+getSize(root.leftChild)+1;
    }
}
