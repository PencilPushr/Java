package com.company.LL;

public class listNode {

    private com.company.LL.listNode next;
    private String content;

    public listNode(String s){
        this.content = s;
        this.next = null;
    }

    //overloaded constructor in which we are aware of the next element (and what it is going to be)
    public listNode(String s, com.company.LL.listNode n){
        this.content = s;
        this.next = n;
    }

    public com.company.LL.listNode getNext(){
        return this.next;
    }

    public String getContent(){
        return content;
    }

    public void linkToNext(com.company.LL.listNode n){
        this.next = n;
    }

}
