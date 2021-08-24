package Excercises2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class BrainLobeGUI extends JComponent {

    List<Lobe> lobeList = new ArrayList<Lobe>();

    public BrainLobeGUI(){
        addLobes();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //System.out.println();
                //no clue how I am supposed to return the name of the lobes if clicked on
                //I'm assuming I'm creating bounding boxes or a range of coordinates that if the mouse is clicked there
                //we return the name of the lobe, but theres only 24 hours till this is due
            }
        });
    }

    public void addLobes(){

        lobeList.add(new Lobe("Frontal Left", Color.BLUE,100,100,100,100));
        lobeList.add(new Lobe("Frontal Right", Color.BLUE,201,100,100,100));//add the width to the x (same plane) + 1 (prevent overlapping)

        lobeList.add(new Lobe("Parietal Left", Color.RED,50,201,150,100)); //add height from the lobes above
        lobeList.add(new Lobe("Parietal Right", Color.RED,201,201,150,100));

        lobeList.add(new Lobe("Occipital Left", Color.GREEN,100,302,100,100));
        lobeList.add(new Lobe("Occipital Right", Color.GREEN,201,302,100,100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        for (int i = 0; i < lobeList.size(); i++) {
            graphics.setColor(lobeList.get(i).getColor());
            graphics.drawRect(lobeList.get(i).getX(),lobeList.get(i).getY(), lobeList.get(i).getWidth(),lobeList.get(i).getHeight());
            graphics.drawString(lobeList.get(i).toString(),lobeList.get(i).getX() + 25,lobeList.get(i).getY() + 50);
        }
    }

    public List<Lobe> getLobeList() {
        return lobeList;
    }

}
