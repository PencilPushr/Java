package DSAA;
import DSAA.Assignment.*;

import DSAA.Labs.SinglyLinkedList;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        /*
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

        //SinglyLinkedList list = new SinglyLinkedList();
         */

        PMTree pmtree = new PMTree();
        PMList pmlist = new PMList();
        ArrayList<PMList.Entry> listofPM = new ArrayList<PMList.Entry>();
        listofPM.addAll(pmlist.getPrimeMinisters());
        for(int i = 0; i < listofPM.size(); i++){
            pmtree.insert(listofPM.get(i).days,listofPM.get(i).name);
        }
        System.out.println(pmtree.nthShortest(10));
        System.out.println(pmtree.nthShortest(20));
        System.out.println(pmtree.nthShortest(30));
        System.out.println(pmtree.nthShortest(40));
        System.out.println(pmtree.nthShortest(50));


    }
}
