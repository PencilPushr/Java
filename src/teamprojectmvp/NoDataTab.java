package teamprojectmvp;

import javax.swing.*;
import java.awt.*;

public class NoDataTab extends JPanel {
    private final JFrame m_Frame;
    NoDataTab(JFrame frame){
        m_Frame = frame;
    }
    public void paintComponent(Graphics gfx){
        super.paintComponent(gfx);
        gfx.setFont(new Font(gfx.getFont().getFontName(), Font.PLAIN, 25));
            gfx.drawString("Upload data to start analyzing",
                    Math.max(Layout.fileSelectorMinWidthPx, (int)(m_Frame.getWidth() * Layout.fileSelectorWidthPer)),
                    (int)(m_Frame.getHeight() * 0.5f));
    }
}
