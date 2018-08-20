package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JList;

/**
 *
 * @author Israel-ICM
 */
public class ListMetroICM extends JList{
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    private Color _theme = ToolsMetroICM.COLOR_LIGHT;
    private Color _cellBackground = ToolsMetroICM.METRO_COLOR_BASE;
    private Dimension _dimension = new Dimension(130, ToolsMetroICM.COMPONENT_HEIGHT);
    private int _cellHeigth = ToolsMetroICM.COMPONENT_HEIGHT;
    
    public ListMetroICM(){
        super();
        cargarFuente();
        cargarCeldas();
    }
    
    private void cargarFuente(){
        setFont(new Font(_fuente, Font.PLAIN, _textSize));
    }
    
    private void cargarCeldas(){
        setFixedCellHeight(_cellHeigth);
        setSelectionBackground(_cellBackground);
    }
}
