package com.company.BST;

public class binaryTree {
    treeNode root;
    public binaryTree(){
        this.root = null;
    }
    public void add(String k, String v){
        if (root == null){
            this.root = new treeNode(k,v);
        }else{
            treeNode temp = new treeNode(k,v);
            this.root.linkToChild(temp);
        }
    }
    public String retrieveValueByKey(String k){
        if (this.root == null){
            return "Sorry, no such key exists.";
        }
        return this.root.getValueByKey(k);
    }
}
