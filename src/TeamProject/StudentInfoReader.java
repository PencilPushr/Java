package TeamProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class CSVParser {
    List<String> ParseLine(String line) {
        String token = new String();
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char currChar = line.charAt(i);
            if (currChar == ',') {
                tokens.add(token.strip());
                token = "";
                continue;
            }
            token += currChar;
            if (i == line.length() - 1) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}

public class StudentInfoReader {
    boolean ReadFile(String fileName, HashMap<Integer, Student> regToStudent) {
        Scanner s;
        try {
            s = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        List<String> header = m_Parser.ParseLine(s.nextLine());
        while (s.hasNextLine()) {
            List<String> tokens = m_Parser.ParseLine(s.nextLine());
            Student student = new Student();
            int i = 0;
            regToStudent.put(Integer.valueOf(tokens.get(i++)), student);
            student.SetCourse(tokens.get(i++));
            int read = i;
            for (; i < header.size() - read; i++) {
                if (!tokens.get(i).equals("")) {
                    student.AddModuleMark(header.get(i), Integer.parseInt(tokens.get(i)));
                }
            }
        }
        return true;
    }

    final private CSVParser m_Parser = new CSVParser();
}