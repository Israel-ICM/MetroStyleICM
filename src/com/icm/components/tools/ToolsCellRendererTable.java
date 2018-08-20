package com.icm.components.tools;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * 
 * @author Israel-ICM
 */
public class ToolsCellRendererTable  extends DefaultTableCellRenderer {
    private Color _selected_color = ToolsMetroICM.METRO_COLOR_BASE;
    private Color color1 = new Color(255,255,255);
    private Color color2 = new Color(249,249,249);
    
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {    
        setEnabled(table == null || table.isEnabled());
        setBackground(Color.white);
        table.setFont(new Font(_fuente, Font.PLAIN, _textSize));
        setFont(new Font(_fuente, Font.PLAIN, _textSize));
        
        if(selected)
            setBackground(_selected_color);
        else
            setBackground((row % 2 == 1)?this.color1:this.color2);
        
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        return this;
    }
    
    
}//--> fin clase
