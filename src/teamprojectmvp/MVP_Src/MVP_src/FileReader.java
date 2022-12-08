package teamprojectmvp.MVP_Src.MVP_src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class CSVParser{    
    public List<String> parseLine(String line){
        String token = new String();
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < line.length(); i++){
            char currChar = line.charAt(i);
            if (currChar == ',') {
                tokens.add(token.strip());
                token = "";
                continue;
            }
            token += currChar;
            if (i == line.length() - 1){
                tokens.add(token);
            }
        }
        return tokens;
    }
}

//This is currently very break-prone.
// TODO: add data validation
public class FileReader {
    final static private CSVParser m_Parser = new CSVParser();

    public static boolean readStudentData(String fileName, HashMap<Integer, Student> regToStudent){
        Scanner s;
        try{
           s = new Scanner(new java.io.FileReader(fileName));
        }catch (FileNotFoundException e) {
            return false;
        }
        List<String> header = m_Parser.parseLine(s.nextLine());
        while(s.hasNextLine()){
           List<String> tokens = m_Parser.parseLine(s.nextLine());
           Student student = new Student();
           int i = 0;
           regToStudent.put(Integer.valueOf(tokens.get(i++)), student);
           student.course = tokens.get(i++);
           int read = i;
           for (; i < header.size() - read; i++){
              if (!tokens.get(i).equals("")){
                 student.addModuleMark(header.get(i), Integer.parseInt(tokens.get(i)));
              }
           }
        }
        return true;
    }

    public static boolean readModules(String fileName, ArrayList<String> modules){
        Scanner s;
        try{
            s = new Scanner(new java.io.FileReader(fileName));
        }catch (FileNotFoundException e) {
            return false;
        }
        List<String> header = m_Parser.parseLine(s.nextLine());
        for (int i = 2; i < header.size(); i++){
            modules.add(header.get(i));
        }
        return true;
    }
}
