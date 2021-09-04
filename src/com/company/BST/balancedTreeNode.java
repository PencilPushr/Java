package com.company.BST;

public class balancedTreeNode {
    private balancedTreeNode leftChild;
    private balancedTreeNode rightChild;
    private balancedTreeNode parent;
    private String key;
    private String value;
    private int height;
    public balancedTreeNode(String k, String v){
        this.key = k;
        this.value = v;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 0;
    }
    public int getBalance() {
        if (this.leftChild == null && this.rightChild == null){
            //this is a leaf node!
            return 0;
        } else if (this.rightChild == null){
            //right is null, but left isn't!
            return (0 - this.leftChild.getHeight());
        } else if (this.leftChild == null){
            //left is null, but right isn't!
            return this.rightChild.getHeight();
        } else {
            //neither side is null!
            return (this.rightChild.getHeight() - this.leftChild.getHeight());
        }
    }
    public void updateHeight() {
        int leftHeight = -1;
        int rightHeight = -1;
        if (this.leftChild != null){
            leftHeight = this.leftChild.getHeight();
        }
        if (this.rightChild != null){
            rightHeight = this.rightChild.getHeight();
        }
        this.height = (1 + Math.max(leftHeight, rightHeight));
    }
    public int getHeight(){
        return this.height;
    }
    public String getKey(){
        return this.key;
    }
    public void setLeft(balancedTreeNode n){
        this.leftChild = n;
    }
    public void setRight(balancedTreeNode n){
        this.rightChild = n;
    }
    public balancedTreeNode getLeft(){
        return this.leftChild;
    }
    public balancedTreeNode getRight(){
        return this.rightChild;
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
}
