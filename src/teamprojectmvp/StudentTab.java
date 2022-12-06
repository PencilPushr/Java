package teamprojectmvp;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StudentTab extends JPanel {
    StudentTab(JFrame frame, StudentInfo info){
        SetUpDrawDumpButton(frame, info);
    }

    void SetUpDrawDumpButton(JFrame frame, StudentInfo info){
        JButton dumpRawButton = new JButton("Dump raw data");
        dumpRawButton.setLocation(
                Math.max(Layout.fileSelectorMinWidthPx, (int)(frame.getWidth() * Layout.fileSelectorWidthPer)),
                100);
        this.add(dumpRawButton);
        dumpRawButton.addActionListener(
                e -> {
                    if(e.getSource() == dumpRawButton){
                        for(Map.Entry<Integer, Student> studentInfo : info.EntrySet()){
                            System.out.print("Student Registration number: ");
                            System.out.println(studentInfo.getKey());
                            System.out.print("Course: ");
                            System.out.println(studentInfo.getValue().course);
                            for (Map.Entry<String, Integer> moduleInfo : studentInfo.getValue().EntrySet()){
                                System.out.print(moduleInfo.getKey());
                                System.out.print(" : ");
                                System.out.println(moduleInfo.getValue());
                            }
                            System.out.println();
                        }
                    }
                }
        );
        frame.add(this);
    }
}
