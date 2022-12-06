package teamprojectmvp;

import javax.swing.*;

public class HomePage{
    JTabbedPane m_TabbedPane = new JTabbedPane();

    HomePage(JFrame frame, StudentInfo studentInfo){
        SetupFileSelector(frame, studentInfo);
        SetupTabbedPane(frame);
    }

    void SetupTabbedPane(JFrame frame){
        m_TabbedPane.setBounds(
                Math.max(Layout.fileSelectorMinWidthPx, (int)(frame.getWidth() * Layout.fileSelectorWidthPer)),
                0,
                (int)((1.0f - Layout.fileSelectorWidthPer) * frame.getWidth()),
                frame.getHeight());
        m_TabbedPane.repaint();
        m_TabbedPane.addTab("No Data", new NoDataTab(frame));
        frame.add(m_TabbedPane);
    }

    void SetupFileSelector(JFrame frame, StudentInfo studentInfo){
        FileSelector m_FileSelector = new FileSelector("Upload Data");
        m_FileSelector.SetExtensionFilter("csv");
        m_FileSelector.SetBounds(0,
                0,
                Math.max(Layout.fileSelectorMinWidthPx, (int)(frame.getWidth() * Layout.fileSelectorWidthPer)),
                frame.getHeight());
        m_FileSelector.AttachTo(frame);
        m_FileSelector.Repaint();
        m_FileSelector.SetAction( path -> {
             studentInfo.Load(path);
             m_TabbedPane.removeAll();
             m_TabbedPane.addTab("Analyze Student", new StudentTab(frame, studentInfo));
             m_TabbedPane.addTab("Analyze Module", new ModuleTab(frame, studentInfo));
        } );
    }
}
