package DSAA;

public interface Queue<T> {
    // How many items are in the Queue?
    public int size();
    // Look at, but don't remove, the next item.
    public T peek();
    // Return an item.
    public T pop();
    // Return an itemAdd a new item.
    public void push(T input);

}
