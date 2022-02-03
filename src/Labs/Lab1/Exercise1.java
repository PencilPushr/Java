package Labs.Lab1;

public class Exercise1 {

    void printOddUpTo(int inputInt){
        if (inputInt >=0){
            for (int i = 0; i <= inputInt; i++) {
                if(i % 2 == 1 || i == inputInt) System.out.println(i);
            }
        }
    }

    String getABCUpTo(char inputChar){
        if((inputChar > 65 && inputChar < 91) || (inputChar > 97 && inputChar < 123)){
            StringBuilder strbldr = new StringBuilder();
            if (inputChar < 91){
                for (int c =65; c<=inputChar; c++) {
                    strbldr.append((char) c);
                    //System.out.println(c + ": " + (char)c);
                }
                return strbldr.toString();
            } else
                for (int c=97; c<=inputChar; c++) {
                    strbldr.append((char) c);
                //System.out.println(c + ": " + (char)c);
            }   return strbldr.toString();
        }
        return null;
    }

}
