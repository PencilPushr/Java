package teamprojectmvp.MVP_Src.Tabs;


import teamprojectmvp.MVP_Src.MVP_src.StudentInfo;

import javax.swing.*;

public class ModuleTab extends JPanel {
    public ModuleTab(JFrame frame, StudentInfo info) {
        setupVisualiseButton(info);
    }

    private void setupVisualiseButton(StudentInfo info){
        JButton visualiseButton = new JButton("Visualise");
        add(visualiseButton);
    }
}