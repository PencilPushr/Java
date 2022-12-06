package teamprojectmvp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//This class was created to wrap m_RegNoToStudent since application passes it on it gui,
//so it needs protection.
public class StudentInfo {
    final private HashMap<Integer, Student> m_RegNoToStudent = new HashMap<>();
    final private StudentInfoReader m_Reader = new StudentInfoReader();

    boolean IsEmpty(){ return m_RegNoToStudent.isEmpty(); }
    Student Get(Integer regNo){ return m_RegNoToStudent.get(regNo); }
    Set<Map.Entry<Integer, Student>> EntrySet(){ return m_RegNoToStudent.entrySet(); }
    void Load(String path){ m_Reader.ReadFile(path, m_RegNoToStudent); }
}
