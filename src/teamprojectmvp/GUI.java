package teamprojectmvp;

import javax.swing.*;
import java.awt.*;

class GUI{ final private StudentInfo m_StudentInfo;
    public GUI(float percent, StudentInfo studentInfo){
        m_StudentInfo = studentInfo;
        JFrame frame = new JFrame();
        InitFrame(frame, percent);
        InitPages(frame);
    }
    private void InitFrame(JFrame frame, float percent){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        percent = Math.max(0.0f, Math.min(percent * 0.01f, 1.0f));
        float windowX = ((1.0f - percent) * (float)screenSize.getWidth()) * 0.5f;
        float windowY = ((1.0f - percent) * (float)screenSize.getHeight()) * 0.5f;
        float windowW = percent * (float)screenSize.getWidth();
        float windowH = percent * (float)screenSize.getHeight();
        frame.setBounds((int)windowX, (int)windowY, (int)windowW, (int)windowH);
        frame.setResizable(false);
        frame.setTitle("Team Project");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void InitPages(JFrame frame){
        HomePage homepage = new HomePage(frame, m_StudentInfo);
    }

}

