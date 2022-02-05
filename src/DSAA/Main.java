package DSAA;

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
