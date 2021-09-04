package com.company.BST;

public class balancedBinaryTree {
    balancedTreeNode root;
    public balancedBinaryTree(){
        this.root = null;
    }
    public void add(String k, String v){
        if (root == null){
            this.root = new balancedTreeNode(k,v);
        }else{
            root = this.insert(root, new balancedTreeNode(k,v));
        }
    }
    private balancedTreeNode insert(balancedTreeNode o, balancedTreeNode n) {
        if (Main.alphabeticValue(o.getKey()) > Main.alphabeticValue(n.getKey())) {
            if (o.getLeft() != null){
                this.insert(o.getLeft(), n);
            } else {
                o.setLeft(n);
            }
        } else if (Main.alphabeticValue(o.getKey()) < Main.alphabeticValue(n.getKey())) {
            if (o.getRight() != null){
                this.insert(o.getRight(), n);
            } else {
                o.setRight(n);
            }
        } else {
            throw new RuntimeException("Duplicate Key!");
        }
        return rebalance(o);
    }
    public String retrieveValueByKey(String k){
        if (this.root == null){
            return "Sorry, no such key exists.";
        }
        return this.root.getValueByKey(k);
    }
    private balancedTreeNode rotateRight(balancedTreeNode y) {
        balancedTreeNode x = y.getLeft();
        balancedTreeNode z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        y.updateHeight();
        x.updateHeight();
        return x;
    }
    private balancedTreeNode rotateLeft(balancedTreeNode y) {
        balancedTreeNode x = y.getRight();
        balancedTreeNode z = x.getLeft();
        x.setLeft(y);
        y.setRight(z);
        y.updateHeight();
        x.updateHeight();
        return x;
    }
    //takes a node and ensures that it is balanced
    private balancedTreeNode rebalance(balancedTreeNode z) {
        z.updateHeight();
        int balance = z.getBalance();
        if (balance > 1) {
            if (z.getRight().getRight().getHeight() > z.getRight().getLeft().getHeight()) {
                z = this.rotateLeft(z);
            } else {
                z.setRight(rotateRight(z.getRight()));
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (z.getLeft().getLeft().getHeight() > z.getLeft().getRight().getHeight()) {
                z = this.rotateRight(z);
            } else {
                z.setLeft(rotateLeft(z.getLeft()));
                z = rotateRight(z);
            }
        }
        return z;
    }
}
