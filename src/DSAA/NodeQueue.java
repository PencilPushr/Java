package DSAA;

class NodeQueue<T> implements Queue {
    public NodeQueue() {
        this.root = null;
    }

    class Node<T> {
        public T content;
        public Node<T> next;

        public Node(T c) {
            this.content = c;
        }
    }

    private Node<T> root;
    private int length;

    public int size() {
        return this.length;
    }

    public T peek() {
        if (this.root != null) {
            return (T) this.root.content;
        } else {
            return (T) null;
        }
    }

    public T pop() {
        if (this.root != null) {
            T temp = (T) this.root.content;
            this.root = this.root.next;
            return temp;
        } else {
            return (T) null;
        }
    }

    public void push(Object input) {
        Node<T> newNode = new Node<T>((T) input);
        this.length++;
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node<T> temp = root;
            for (int i = 1; i < (this.size() -1); i++) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}
