package TeamProject;

import java.util.HashMap;

class Application{
    public Application(){

    }

    void LoadFile(){
        m_Reader.ReadFile("DataFile.csv", RegNoToStudent);
    }

    final private HashMap<Integer, Student> RegNoToStudent = new HashMap<>();
    final private StudentInfoReader m_Reader = new StudentInfoReader();
}