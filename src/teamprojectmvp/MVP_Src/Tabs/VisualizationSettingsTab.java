package Tabs;

import javax.swing.*;
import java.awt.*;

/**
 * Class to visualise the statistics and information.
 */
public class VisualizationSettingsTab extends JPanel {
    public VisualizationSettingsTab(){
        setupDropdownMenu();
        setLayout(new FlowLayout());
    }

    /**
     * Graph types
     */
    public enum GraphType{
        HISTOGRAM,
        BAR_GRAPH,
        SCATTER_PLOT,
        LINE_GRAPH,
        DEVIATION_GRAPH,
        ERROR_TYPE
    }

    private JComboBox<String> m_GraphMenu;

    /**
     * Accessor method for the combo box to get the selected item from the combo box and return selected graph type
     * @return GraphType returns selected graph type from the combo box
     */
    public GraphType getSelectedGraphType(){
        String selectedItem = (String)m_GraphMenu.getSelectedItem();
        assert selectedItem != null;
        GraphType graphType = GraphType.ERROR_TYPE;
        switch (selectedItem) {
            case "Histogram" -> graphType = GraphType.HISTOGRAM;
            case "Bar Graph" -> graphType = GraphType.BAR_GRAPH;
            case "Scatter Plot" -> graphType = GraphType.SCATTER_PLOT;
            case "Line Graph" -> graphType = GraphType.LINE_GRAPH;
            case "Deviation Graph" -> graphType = GraphType.DEVIATION_GRAPH;
        }
        assert graphType != GraphType.ERROR_TYPE;//should never happen
        return graphType;
    }

    /**
     * Setups combo box to contain pre-declared graph type string names
     */
    private void setupDropdownMenu(){
        String[] graphTypes = { "Histogram", "Bar Graph", "Scatter Plot", "Line Graph", "Deviation Graph" };
        m_GraphMenu = new JComboBox<>(graphTypes);
        add(new JLabel("Graph type: "));
        add(m_GraphMenu);
    }
}
