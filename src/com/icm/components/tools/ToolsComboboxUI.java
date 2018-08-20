package com.icm.components.tools;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * 
 * @author Israel-ICM
 */

public class ToolsComboboxUI extends BasicComboBoxUI{
    private Color background = ToolsMetroICM.METRO_COLOR_BACKGROUND_TEXT_BASE;
    private ImageIcon espacio =  new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"comboboxMetro/espacio_35px.png"));
    private Color _color = ToolsMetroICM.METRO_COLOR_BASE;
    
    public static ComboBoxUI createUI(JComponent c) {
        return new ToolsComboboxUI();
    }
    
    @Override 
    protected JButton createArrowButton() {                 
        JButton button = new JButton();
        button.setText("");
        button.setBorder(BorderFactory.createLineBorder(background, 2));
        button.setContentAreaFilled(false);
        button.setIcon( new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"comboboxMetro/comboboxLight.png")) );
        return button;
    }      
    
    
    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus){
        g.setColor(background);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    
    @Override
    protected ListCellRenderer createRenderer(){
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list,Object value,int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                list.setSelectionBackground(background);
                if (isSelected){
                    setBackground( _color );
                    setForeground(Color.WHITE);
                }
                else{
                    setBackground( Color.WHITE );            
                    setForeground( new Color(0, 0, 0));
                }
                if(index!=-1){          
                  setIcon(espacio);          
                }
                return this;
            }
        };
    }
}