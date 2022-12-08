package teamprojectmvp.MVP_Src.MVP_src;

import teamprojectmvp.MVP_Src.MVP_src.AllModules;
import teamprojectmvp.MVP_Src.Tabs.*;


import javax.swing.*;

final class HomePageLayout{
    private HomePageLayout(){}
    static final public float fileSelectorWidthPer = 0.25f;//25 percent of window width
    static final public int fileSelectorMinWidthPx = 140;//140 pixels

    static public final float infoTabHeightPer = 0.90f;//90 percent of window height
    static final public float infoTabWidthPer = 0.25f;//25 percent of window width
}

public class HomePage{
    public static class TabIndex{
        public static final int fileName = 0;
        public static final int textOutput = 1;
    }

    private final JTabbedPane m_MainTabbedPane = new JTabbedPane();
    private final JTabbedPane m_InfoTabbedPane = new JTabbedPane();
    private final OpenedFileNameTab m_FileNameTab = new OpenedFileNameTab();
    private final Tabs.TextOutputTab m_TextOutputTab = new Tabs.TextOutputTab();

    HomePage(JFrame frame, StudentInfo studentInfo, AllModules allModuleList){
        setupFileSelector(frame, studentInfo, allModuleList);
        setupMainTabbedPane(frame);
        setupInfoTabbedPane(frame);
    }

    public void setActiveInfoTab(int index){
        m_InfoTabbedPane.setSelectedIndex(index);
    }

    private void setupMainTabbedPane(JFrame frame){
        int offsetX = 15;
        m_MainTabbedPane.setBounds(
                Math.max(HomePageLayout.fileSelectorMinWidthPx,
                        (int)(frame.getWidth() * HomePageLayout.fileSelectorWidthPer)),
                0,
                (int)((1.0f - HomePageLayout.fileSelectorWidthPer) * frame.getWidth()) - offsetX,
                frame.getHeight());
        m_MainTabbedPane.addTab("No Data", new NoDataTab(frame));
        frame.add(m_MainTabbedPane);
        m_MainTabbedPane.repaint();
    }

    private void setupInfoTabbedPane(JFrame frame){
        int offsetY = 38;
        m_InfoTabbedPane.setBounds(
                0,
                (int)((1.0f - HomePageLayout.infoTabHeightPer) * frame.getHeight()),
                (int)((HomePageLayout.infoTabWidthPer) * frame.getWidth()),
                (int)(HomePageLayout.infoTabHeightPer * frame.getHeight()) - offsetY);
        m_InfoTabbedPane.addTab("Viewing", m_FileNameTab);
        m_InfoTabbedPane.addTab("Output", m_TextOutputTab);
        frame.add(m_InfoTabbedPane);
        m_InfoTabbedPane.repaint();
    }

    private void setupFileSelector(JFrame frame, StudentInfo studentInfo, AllModules allModuleList){
        FileSelector fileSelector = new FileSelector("Upload Data");
        fileSelector.setExtensionFilter("csv");
        fileSelector.setBounds(0,
                0,
                Math.max(HomePageLayout.fileSelectorMinWidthPx,
                        (int)(frame.getWidth() * HomePageLayout.fileSelectorWidthPer)),
                (int)((1.0f - HomePageLayout.infoTabHeightPer) * frame.getHeight()));
        fileSelector.attachTo(frame);
        fileSelector.repaint();
        fileSelector.setAction(path -> {
            studentInfo.load(path);
            allModuleList.load(path);
            m_MainTabbedPane.removeAll();
            m_MainTabbedPane.addTab("Analyze Student",
                    new JScrollPane(new StudentTab(frame, studentInfo, m_TextOutputTab, this, allModuleList)));
            //m_MainTabbedPane.addTab("Analyze Module", new ModuleTab(frame, studentInfo));
            m_MainTabbedPane.addTab("Visualization Settings", new Tabs.VisualizationSettingsTab());
            m_FileNameTab.setFileName('\n' + path);
            m_InfoTabbedPane.setSelectedIndex(TabIndex.fileName);
        } );
    }
}
