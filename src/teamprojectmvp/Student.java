package teamprojectmvp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {
    public String course;
    private final HashMap<String, Integer> m_ModuleResult = new HashMap<>();
    void AddModuleMark(String module, int marks){
        m_ModuleResult.put(module, marks);
    }
    void Get(String module){ m_ModuleResult.get(module); }
    Set<Map.Entry<String, Integer>> EntrySet(){ return m_ModuleResult.entrySet(); }
}