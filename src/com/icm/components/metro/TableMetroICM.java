package com.icm.components.metro;

import com.icm.components.tools.ToolsCellRendererTable;
import com.icm.components.tools.ToolsHeaderCellRendererTable;
import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
/**
 * 
 * @author Israel-ICM
 */
public class TableMetroICM extends JTable {
    private Color _selected_color = ToolsMetroICM.METRO_COLOR_BASE;
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    public TableMetroICM(){
        
        this.setAutoCreateColumnsFromModel(true);
        this.setAutoscrolls(true);
        this.setVisible(true);
        
        /** header */
        JTableHeader jtableHeader = this.getTableHeader();
        jtableHeader.setDefaultRenderer(new ToolsHeaderCellRendererTable());
        this.setTableHeader(jtableHeader );
        
        /** celdas */
        this.setSelectionBackground(_selected_color);
        this.setSelectionForeground(new Color(255, 255, 255));
        this.setGridColor(new java.awt.Color(221, 221, 221));
        this.setDefaultRenderer (Object.class, new ToolsCellRendererTable());
        
        this.setVisible(true);
    }
}