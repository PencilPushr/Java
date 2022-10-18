package TeamProject;

import Exercises3.ex2.CityData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class projectCSVreader {

    public class studentDetails{

        //public int id;

        public String course;

        //module codes
        public int CE101_4_FY;
        public int CE101_4_SP;
        public int CE141_4_AU;
        public int CE141_4_FY;
        public int CE142_4_AU;
        public int CE142_4_FY;
        public int CE151_4_AU;
        public int CE152_4_SP;
        public int CE153_4_AU;
        public int CE154_4_SP;
        public int CE155_4_SP;
        public int CE161_4_AU;
        public int CE162_4_SP;
        public int CE163_4_AU;
        public int CE164_4_SP;


        public studentDetails(String coursename, int CE101_FY,
                              int CE101_SP, int CE141_AU, int CE141_FY,
                              int CE142_AU, int CE142_FY, int CE151_AU,
                              int CE152_SP, int CE153_AU, int CE154_SP,
                              int CE155_SP, int CE161_AU, int CE162_SP,
                              int CE163_AU, int CE164_SP){

            this.course = coursename;
            this.CE101_4_FY = CE101_FY;
            this.CE101_4_SP = CE101_SP;
            this.CE141_4_AU = CE141_AU;
            this.CE141_4_FY = CE141_FY;
            this.CE142_4_AU = CE142_AU;
            this.CE142_4_FY = CE142_FY;
            this.CE151_4_AU = CE151_AU;
            this.CE152_4_SP = CE152_SP;
            this.CE153_4_AU = CE153_AU;
            this.CE154_4_SP = CE154_SP;
            this.CE155_4_SP = CE155_SP;
            this.CE161_4_AU = CE161_AU;
            this.CE162_4_SP = CE162_SP;
            this.CE163_4_AU = CE163_AU;
            this.CE164_4_SP = CE164_SP;




        }
    }

    private HashMap<Integer, projectCSVreader.studentDetails> studentRegtoDetails;

    projectCSVreader(String filename) throws FileNotFoundException {

        this.studentRegtoDetails = new HashMap<Integer, studentDetails>();

        Scanner s = new Scanner(new File(filename + ".csv"));
        boolean first = true;

        while(s.hasNext()) {
            String thing = s.nextLine();
            if (first == false) {
                String[] line = thing.split(",");
                studentDetails temp = new studentDetails((line[1]), )
            }
            first=false;

        }

    }

}
