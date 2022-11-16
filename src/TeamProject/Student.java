package TeamProject;

import java.util.HashMap;

public class Student {
    private String m_Course;
    private HashMap<String, Integer> m_ModuleResult = new HashMap<>();

    void AddModuleMark(String module, int marks) {
        m_ModuleResult.put(module, marks);
    }

    void SetCourse(String course) {
        m_Course = course;
    }

}