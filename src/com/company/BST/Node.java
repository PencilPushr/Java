package com.company.BST;

public class Node {
    class listNode{
        private listNode next;
        private String content;
        public listNode(String s){
            this.content = s;
            this.next = null;
        }
        //overloaded constructor in which we are aware of the next element (and what it is going to be)
        public listNode(String s, listNode n){
            this.content = s;
            this.next = n;
        }
        public listNode getNext(){
            return this.next;
        }
        public String getContent(){
            return content;
        }
        public void linkToNext(listNode n){
            this.next = n;
        }
    }
}
