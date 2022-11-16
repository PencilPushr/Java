package TeamProject;

import javax.swing.*;
import java.awt.*;

class GUI{

    private JFrame m_Frame = new JFrame();

    public GUI(int size){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        m_Frame.setSize((int)screenSize.getWidth()/size, (int)screenSize.getHeight()/size);
        InitFrame();

    }

    public GUI(int width, int height){
        m_Frame.setSize(height, width);
        InitFrame();

    }

    private void InitFrame(){

        m_Frame.setVisible(true);
        m_Frame.setTitle("Team Project(borderLayout)");
        m_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}