package com.toy.data.structure.tree;

import org.apache.commons.lang.StringUtils;

public class BinaryTree {

    private Leaf root;

    /**
     * 初始化根节点
     * @param data
     */
    public void initRoot(String data) {
        if (root == null) {
            root = new Leaf();
        }
        root.setData(null);
        root.setLeft(null);
        root.setData(data);
    }

    /**
     * 查找节点是不是存在
     * @param value
     * @param node
     * @return
     */
    public Leaf search(String value, Leaf node) {
        if (node == null) {
            return null;
        }

        if (StringUtils.equals(node.getData(), value)) {
            return node;
        }else{
            search(value, node.getLeft());
            search(value, node.getRight());
        }
        return null;
    }

    /**
     * 添加数据到子节点
     * @param value
     */
    public void add(String value) {
        if (root == null) {
            initRoot(value);
            return;
        }

        /**
         * 数据已经存在了，无须添加数据
         */
        Leaf leaf = locate(root, value);
        if( leaf == null ){ // 没有找到适合插入的数据
            return;
        }

        if (StringUtils.equals(leaf.getData(), value)) {
            return; // 数据已经存在了
        }

        if (value.compareTo(leaf.getData()) < 0) { // 放入左子节点
            Leaf temp = new Leaf();
            temp.setData(value);
            temp.setLeft(null);
            temp.setRight(null);
            leaf.setLeft(temp);
        }else{ // 放入右子节点
            Leaf temp = new Leaf();
            temp.setData(value);
            temp.setLeft(null);
            temp.setRight(null);
            leaf.setRight(temp);
        }
    }

    /**
     * 查找能够插入的位置
     * @param root
     * @param data
     * @return
     */
    private Leaf locate(Leaf root, String data) {
        if (root == null) {
            return null;
        }

        if (data.compareTo(root.getData()) == 0) {
            return null;
        }

        if (root.getLeft() == null && data.compareTo(root.getData()) < 0) {
            return root;
        }

        if (root.getLeft() != null && data.compareTo(root.getData()) < 0) {
            return locate(root.getLeft(), data);
        }

        if (root.getRight() == null && data.compareTo(root.getData()) > 0) {
            return root;
        }

        if (root.getRight() != null && data.compareTo(root.getData()) > 0) {
            return locate(root.getRight(), data);
        }

        return null;
    }



    public int depth(Leaf leaf){
        if( leaf == null ){
            return 0;
        }

        int left = 0;
        int right = 0;
        if(leaf.getLeft() != null){
            left =  depth(leaf.getLeft() ) + 1;
        }

        if(leaf.getRight() != null){
            right = depth(leaf.getRight()) + 1;
        }
        return Math.max(left, right);
    }

}
