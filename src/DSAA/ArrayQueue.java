package DSAA;

import java.util.ArrayList;

class ArrayQueue<T> implements Queue{
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
