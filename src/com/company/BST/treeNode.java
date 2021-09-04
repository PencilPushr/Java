package com.company.BST;

public class treeNode {
    private treeNode leftChild;
    private treeNode rightChild;
    private String key;
    private String value;
    public treeNode(String k, String v){
        this.key = k;
        this.value = v;
        this.leftChild = null;
        this.rightChild = null;
    }
    public treeNode getLeft(){
        return this.leftChild;
    }
    public treeNode getRight(){
        return this.rightChild;
    }
    public String getKey(){
        return this.key;
    }
    public String getValueByKey(String k){
        int other = Main.alphabeticValue(k);
        int self = Main.alphabeticValue(this.key);
        if (other == self){
            return this.value;
        }else{
            if (other < self){
                if (this.leftChild != null){
                    return this.leftChild.getValueByKey(k);
                }else{
                    return "Sorry, no such key exists.";
                }
            }else{
                if (this.rightChild != null){
                    return this.rightChild.getValueByKey(k);
                }else{
                    return "Sorry, no such key exists.";
                }
            }
        }
    }
    public void linkToChild(treeNode n){
        int self = Main.alphabeticValue(this.key);
        int child = Main.alphabeticValue(n.getKey());
        if (child < self){
            if (this.leftChild == null){
                this.leftChild = n;
            }else{
                this.leftChild.linkToChild(n);
            }
        }else{
            if (this.rightChild == null){
                this.rightChild = n;
            }else{
                this.rightChild.linkToChild(n);
            }
        }
    }
}
