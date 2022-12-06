package teamprojectmvp;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSelector implements ActionListener {
    public interface Action{
        void Perform(String path);
    }
    final private JButton m_Button;
    final private JFileChooser m_FileChooser;
    private boolean m_GetSuccess = false;

    Action m_Action = null;

    FileSelector(String name){
        m_Button = new JButton(name);
        m_FileChooser = new JFileChooser();
        m_Button.addActionListener(this);
    }

    public boolean Successful(){
        return m_GetSuccess;
    }

    public void SetExtensionFilter(String... ext){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("", ext);
        m_FileChooser.setFileFilter(filter);
    }

    public void SetAction(Action action){
        m_Action = action;
    }

    public void SetBounds(int x, int y, int w, int h){
        m_Button.setBounds(x, y, w, h);
    }

    public void AttachTo(JFrame frame){ frame.add(m_Button); }

    public void Repaint(){
        m_Button.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m_Button){
            if (m_FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                String path = m_FileChooser.getSelectedFile().getAbsolutePath();
                if(!new File(path).isFile()){
                    JOptionPane.showMessageDialog(null, "Invalid File");
                    return;
                }
                m_GetSuccess = true;
                m_Action.Perform(path);
                return;
            }
            m_GetSuccess = false;
        }
    }
}
