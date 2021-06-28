package Euler.P19;

class p19 {

    int lastDay = 0;
    int numOfSundays = 0;

    public static void main(String[] args) {
        p19 project = new p19();

        project.dateLoop();
        System.out.println(project.numOfSundays);
    }

    public void dateLoop(){
        int counter1 = 0;
        int counterd = 1;
        int counterm = 1;
        int countery = 1900;

        while(countery < 2001){
            counter1++;
            counterd++;

            MaxDay(counterm, countery);

            if (counterd > lastDay){
                counterd = 1;
                counterm++;
            }

            if(counterm > 12){
                counterm = 1;
                countery++;
            }

            //checking for How many Sundays fell on the FIRST OF the month (NOT THE FIRST MONTH)
            if (counter1 % 7 == 6 && countery > 1900 && counterd == 1){
                numOfSundays++;
            }
        }
    }

    public void MaxDay(int x, int z){
        int m = x;//months
        int y = z;//years

        //handles months
        if (m == 2) {
            lastDay = 28;
        }
        if (m == 1 || m == 3 || m == 5 || m == 7 ||m == 8 || m == 10 || m == 12){
            lastDay = 31;
        }else if (!(m == 2)){
            lastDay = 30;
        }

        //handles whether or not we are in a leap year or not
        if (y > 1900 && y % 4 == 0 || y % 400 == 0) {
            lastDay = 29;
        }
    }
}
