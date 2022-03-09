package Labs.Lab9.labexercise3;

public class MyInputInfo implements Comparable{ //is meant to hold only one key press, Hashmap will hold multiple of these

    private boolean isNumber;
    private String content;

    MyInputInfo(String input){

        if (input.equals("")){
            System.out.print("No Empty inputs.");
            System.exit(1);
        }else{
            input = input.substring(0, 1);
        }

    }

    @Override
    public int compareTo(Object o) {
        // First case, they are the same.
        if (this.toString().equals(o.toString())) return 0;


    }


    @Override
    public String toString() {
        return this.content;
    }

    public boolean getIsNumber(){
        return this.isNumber;
    }
}