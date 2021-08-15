package Excercises2;

import java.util.ArrayList;

public class ThreeDimentionalArrayList<T> extends ArrayList<ArrayList<ArrayList<T>>>{
/*
    public void addToInnerArray(int index, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }
        this.get(index).add(element);
    }

    public void addToInnerArray(int index, int index2, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ArrayList<T> inner = this.get(index);
        while (index2 >= inner.size()) {
            inner.add(null);
        }

        inner.set(index2, element);
    }

    public void addToInnerArray(int index, int index2, int index3, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ArrayList<T> inner2 = this.get(index);
        while (index2 >= inner2.size()) {
            inner2.add(null);
        }

        ArrayList<ArrayList<T>> inner3 = this.get(index);
        while (index2 >= inner3.size()) {
            inner3.add(null);
        }
        inner3.set(index3, element);
    }*/
}
