package Labs;

import java.util.ArrayList;

public class doublylinkedlist {

    class Main {
        public static void main(String[] args) {
            System.out.println("Hello world!");
            Queue<String> storage1;
            Queue<String> storage2;

            storage1 = (Queue) new NodeQueue<String>();
            storage1.push("Hello.\n");
            storage1.push("Horrible weather!!!\n");
            storage1.push("Goodbye.\n");
            System.out.print("And now, a typical British conversation.\n");
            System.out.print(storage1.pop());
            System.out.print(storage1.pop());
            System.out.print(storage1.pop());
        }
    }
    interface Queue<T> {
        // How many items are in the Queue?
        public int size();
        // Look at, but don't remove, the next item.
        public T peek();
        // Return an item.
        public T pop();
        // Return an itemAdd a new item.
        public void push(T input);

    }
    interface Stack<T> {
        // How many items are in the Queue?
        public int stackSize();
        // Look at, but don't remove, the next item.
        public T stackPeek();
        // Return an item.
        public T stackPop();
        // Return an itemAdd a new item.
        public void stackPush(T input);

    }
    class ArrayQueue<T> implements Queue {
        private ArrayList<T> storage;
        public ArrayQueue(){
            storage = new ArrayList<T>();
        }
        public int size(){
            return storage.size();
        }

        public T peek(){
            if (this.size() > 0){
                return (T)this.storage.get(0);
            }else{
                return (T)null;
            }
        }

        public T pop(){
            if (this.size() > 0){
                T temp = (T)this.storage.get(0);
                //Now we need to move elements down
                if (this.size() > 1){
                    for(int i= 1 ; i < this.size(); i++){
                        this.storage.set((i-1), this.storage.get(i));
                    }
                }
                storage.remove(this.size() - 1);
                return temp;
            }else{
                return (T)null;
            }
        }

        public void push(Object input){
            this.storage.add((T)input);
        }
    }
    class NodeQueue<T> implements Queue {
        public NodeQueue(){
            this.root = null;
            this.length = 0;
        }
        class Node<T>{
            public T content;
            public Node<T> next;
            public Node(T c){
                this.content = c;
            }
        }
        private Node<T> root;
        private int length;
        public int size(){
            return this.length;
        }
        public T peek(){
            if (this.root != null){
                return (T)this.root.content;
            }else{
                return (T)null;
            }
        }
        public T pop(){
            if (this.root != null){
                T temp = (T)this.root.content;
                this.root = this.root.next;
                return temp;
            }else{
                return (T)null;
            }
        }
        public void push(Object input){
            Node<T> newNode = new Node<T>((T)input);
            this.length++;
            if (this.root == null){
                this.root = newNode;
            }else{
                Node<T> temp = root;
                for(int i = 1; i < (this.length - 1); i++){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
    }

    class DoubleLinkedList<T>implements Queue, Stack{
        DoubleLinkedListNode root;
        DoubleLinkedListNode tip;
        int length;
        public DoubleLinkedList(){
            this.root = null;
            this.tip = root;
            this.length = 0;
        }

        public int Size(){
            return length;
        }
        public int stackSize(){
            return this.Size();
        }

        public T stackPop(){
            if (this.length == 0){
                return null;
            } else if (this.length == 1){
                T temp = (T) this.tip.content;
                this.tip = null;
                this.root = null;
                return temp;
            } else {
                T temp = (T) this.tip.content;
                this.tip = this.tip.parent;
                this.tip.child = null;
                return temp;
            }
        }

        public T stackPeek(){
            if (this.length == 0){
                return null;
            } else {
                return (T) this.tip.content;
            }
        }

        public void stackPush(Object input){
            DoubleLinkedListNode dNode = new DoubleLinkedListNode(input);
            dNode.child = this.tip;
            if (this.length == 0){
                this.tip = dNode;
                this.root = dNode;
            } else{
                this.tip.child = dNode;
                dNode.child = null;
                this.tip = dNode;
            }
        }
        // How many items are in the Queue?
        public int size(){
            return this.length;
        }
        // Look at, but don't remove, the next item.
        public T peek(){
            if (this.length == 0){
                return null;
            } else {
                return (T) this.root.content;
            }
        }
        // Return an item.
        public T pop(){
            if (this.length == 0){
                return null;
            } else if (this.length == 1){
                T temp = (T) this.tip.content;
                this.tip = null;
                this.root = null;
                return temp;
            } else {
                T temp = (T) this.root.content;
                this.root = this.root.child;
                this.root.parent = null;
                return temp;
            }
        }
        // Return an itemAdd a new item.
        public void push(Object input){
            this.stackPush(input);
        }
    }

    class DoubleLinkedListNode<T>{
        DoubleLinkedListNode parent;
        DoubleLinkedListNode child;
        T content;
        public DoubleLinkedListNode(T input){
            this.content = input;
        }

    }

//dll satisfies both constraints for queue and stack
//just add the methods for queue into doubly linked list.

}
