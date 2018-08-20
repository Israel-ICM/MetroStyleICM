package com.icm.components.metro;

import com.icm.components.tools.ToolsComboboxUI;
import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

/**
 * 
 * @author Israel-ICM
 */
public class ComboboxMetroICM extends JComboBox{
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    private Color _background = ToolsMetroICM.METRO_COLOR_BASE;
    private Dimension _dimension = new Dimension(150, ToolsMetroICM.COMPONENT_HEIGHT);
    private Color _borderColor = ToolsMetroICM.METRO_COLOR_BORDER_BASE;
    
    public ComboboxMetroICM()
    {
        setPreferredSize(_dimension);
        setSize(_dimension);
        setForeground(Color.BLACK);
        this.setFont(new Font(_fuente, Font.PLAIN, _textSize));
        setBorder(BorderFactory.createLineBorder(_borderColor, 2));
        setUI(ToolsComboboxUI.createUI(this));
        setVisible(true);
    }

}

