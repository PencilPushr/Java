package teamprojectmvp.MVP_Src.Tabs;

import teamprojectmvp.MVP_Src.*;
import teamprojectmvp.MVP_Src.MVP_src.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Set;

final class StudentTabLayout{
    static final public float fileSelectorWidthPer = 0.25f;//25 percent of window width
    static final public int fileSelectorMinWidthPx = 140;//140 pixels

    public final int tabStartPosX = 10;
    private int m_SoFarPosY;

    public int componentHeight;
    public int yOffsetBetweenComponentsPx = 5;

    static public final float componentWidth = 0.50f;

    private boolean firstCalcY = true;

    private final JFrame m_Frame;
    StudentTabLayout(JFrame frame){
        m_Frame = frame;
        componentHeight = (int)(frame.getHeight() * 0.10f);
        m_SoFarPosY = 10;
    }

    public int calculateY()
    {
        if (firstCalcY){
            firstCalcY = false;
            return m_SoFarPosY;
        }
        m_SoFarPosY += yOffsetBetweenComponentsPx + componentHeight;
        return m_SoFarPosY;
    }

    public int calculateWidth(float percent){
        return (int)(percent *
                (m_Frame.getWidth() - Math.max(fileSelectorMinWidthPx, m_Frame.getWidth() * fileSelectorWidthPer)));
    }

    public int getMaxY(){
        return m_SoFarPosY + componentHeight * 5;//leave some space at the bottom
    }
}

public class StudentTab extends JPanel {
    private JComboBox<String> m_ModuleMenu;
    private final StudentInfo m_StudentInfo;
    private JTextField m_RegNoTextInputField;
    private JComboBox<String> m_SchemeMenu;
    StudentTabLayout m_Layout;

    public StudentTab(JFrame frame, StudentInfo info,
                      Tabs.TextOutputTab textOutputTab, HomePage homePage, AllModules allModuleList){
        m_StudentInfo = info;
        m_Layout = new StudentTabLayout(frame);
        setUpDumpRawButton(frame, textOutputTab, homePage);
        setupStudentRegInputField();
        setupStudentModuleMenu();
        setupAllModuleRadioButtons(frame, allModuleList);
        setupSchemeMenu();
        setupVisualiseButton(info);
        setPreferredSize(
                new Dimension(
                    Math.max(StudentTabLayout.fileSelectorMinWidthPx, 0),
                    m_Layout.getMaxY()
                )
        );
        setLayout(null);
    }

    private void setUpDumpRawButton(JFrame frame, Tabs.TextOutputTab textOutputTab, HomePage homePage){
        JButton dumpRawButton = new JButton("Dump raw data");
        dumpRawButton.setBounds(m_Layout.tabStartPosX, m_Layout.calculateY(),
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);
        add(dumpRawButton);
        dumpRawButton.addActionListener(
                e -> {
                    StringBuilder output = new StringBuilder();
                    if(e.getSource() == dumpRawButton){
                        for(Map.Entry<Integer, Student> studentInfo : m_StudentInfo.entrySet()){
                            output.append("Student registration number: "); output.append(studentInfo.getKey());
                            output.append('\n');
                            output.append("Course: "); output.append(studentInfo.getValue().course);
                            output.append('\n');
                            for (Map.Entry<String, Integer> moduleInfo : studentInfo.getValue().entrySet()){
                                output.append(moduleInfo.getKey()); output.append(" : "); output.append(moduleInfo.getValue());
                                output.append('\n');
                            }
                            output.append('\n');
                        }
                    }
                    textOutputTab.setOutput(output.toString());
                    homePage.setActiveInfoTab(HomePage.TabIndex.textOutput);
                }
        );
        frame.add(this);
    }

    private void setupVisualiseButton(StudentInfo info){
        JButton visualiseButton = new JButton("Visualise");
        add(visualiseButton);
        visualiseButton.setBounds(m_Layout.tabStartPosX, m_Layout.calculateY(),
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);
    }

    private void setupStudentRegInputField(){
        int maxRegNoLen = 7;
        m_RegNoTextInputField = new JTextField();
        m_RegNoTextInputField.setColumns(maxRegNoLen);
        m_RegNoTextInputField.setEditable(true);
        m_RegNoTextInputField.setDocument(new TextFieldLimit(maxRegNoLen));
        m_RegNoTextInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateStudentModuleMenu();
                updateAllModuleRadioButtons();
            }
        });
        JLabel label = new JLabel("Student registration number: ");
        add(label);
        add(m_RegNoTextInputField);
        int y = m_Layout.calculateY();
        label.setBounds(m_Layout.tabStartPosX, y,
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);
        m_RegNoTextInputField.setBounds(170, y,
                m_Layout.calculateWidth(StudentTabLayout.componentWidth), m_Layout.componentHeight);
    }

    private void setupAllModuleRadioButtons(JFrame frame, AllModules allModulesList){
        JLabel label = new JLabel("Specific module group to analyze: ");
        label.setBounds(m_Layout.tabStartPosX,  m_Layout.calculateY(),
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);

        add(label);
        int tab = 20;
        int temp = m_Layout.componentHeight;
        m_Layout.componentHeight = 25;
        for (int i = 0; i < allModulesList.size(); i++) {
            JRadioButton b = new JRadioButton(allModulesList.get(i));
            b.setName(allModulesList.get(i));
            b.setEnabled(false);
            b.setBounds(tab + m_Layout.tabStartPosX, m_Layout.calculateY() + m_Layout.componentHeight,
                    m_Layout.calculateWidth(StudentTabLayout.componentWidth), m_Layout.componentHeight);
            add(b);
        }
        m_Layout.componentHeight = temp;
    }

    private void updateAllModuleRadioButtons(){
        Set<String> modules = getStudentModules();
        if (modules == null){
            for (var component : getComponents()) {
                if (component instanceof JRadioButton)
                    component.setEnabled(false);
            }
            return;
        }
        for (var component : getComponents()){
            if (component instanceof JRadioButton){
                for (String module : modules){
                    if (component.getName().equals(module)){
                        component.setEnabled(true);
                        break;
                    }
                }
            }
        }
    }

    private void setupStudentModuleMenu() {
        String[] noModule = { "Enter Reg No" };
        m_ModuleMenu = new JComboBox<>(noModule);
        JLabel label = new JLabel("Individual module: ");
        add(label);
        add(m_ModuleMenu);

        int y = m_Layout.calculateY();
        label.setBounds(m_Layout.tabStartPosX, y,
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);
        m_ModuleMenu.setBounds(113, y,
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);
    }

    private Set<String> getStudentModules(){
        String regNoStr = m_RegNoTextInputField.getText();
        if (regNoStr.equals("")){
            m_ModuleMenu.addItem("Enter Reg No");
            return null;
        }
        try {
            int regNo = Integer.parseInt(regNoStr);
            Student student = m_StudentInfo.get(regNo);
            if (student == null) return null;
            return student.keySet();
        }catch (NumberFormatException e){
            return null;
        }
    }

    private void updateStudentModuleMenu(){
        m_ModuleMenu.removeAllItems();
        Set<String> modules = getStudentModules();
        if (modules == null){
            m_ModuleMenu.addItem("Invalid Reg No");
            return;
        }
        for (String module : modules){
            m_ModuleMenu.addItem(module);
        }
    }

    private void setupSchemeMenu(){
        m_SchemeMenu = new JComboBox<>(StudentAnalyzeScheme.array());
        JLabel label = new JLabel("Scheme: ");
        add(label);
        add(m_SchemeMenu);

        int y = m_Layout.calculateY();
        label.setBounds(m_Layout.tabStartPosX, y,
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);
        m_SchemeMenu.setBounds(60, y,
                m_Layout.calculateWidth(StudentTabLayout.componentWidth),
                m_Layout.componentHeight);
    }
}
