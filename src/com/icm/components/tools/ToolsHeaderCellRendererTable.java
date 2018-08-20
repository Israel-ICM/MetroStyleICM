package com.icm.components.tools;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * @author Israel-ICM
 */
public class ToolsHeaderCellRendererTable implements TableCellRenderer{
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JComponent jcomponent = null;
        
        if(value instanceof String ) {
            jcomponent = new JLabel((String) "   " + value);
            ((JLabel)jcomponent).setHorizontalAlignment(SwingConstants.LEFT );
            ((JLabel)jcomponent).setSize( 60, jcomponent.getWidth() );
            ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
            ((JLabel)jcomponent).setFont(new Font(_fuente, Font.PLAIN, _textSize));
        } 
        
        jcomponent.setEnabled(true);        
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(221, 211, 211)));
        jcomponent.setOpaque(true);
        jcomponent.setBackground( Color.WHITE );
        //jcomponent.setToolTipText("Colum No. "+(column+1));
        
        return jcomponent;
    }
    
}
