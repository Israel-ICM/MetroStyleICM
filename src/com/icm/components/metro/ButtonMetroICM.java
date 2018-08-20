package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author Israel-ICM
 */
public class ButtonMetroICM extends JButton{
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    private Color _theme = ToolsMetroICM.COLOR_LIGHT;
    private Color _background = ToolsMetroICM.METRO_COLOR_BASE;
    private Dimension _dimension = new Dimension(130, ToolsMetroICM.COMPONENT_HEIGHT);
    
    public ButtonMetroICM(){
        super();
        cargarFuente();
        cargarBackground();
        cargarBorde();
        cargarDimension();
        setFocusPainted(false);
    }
    
    private void cargarFuente(){
        this.setFont(new Font(_fuente, Font.PLAIN, _textSize));
        this.setForeground(Color.WHITE);
    }
    
    private void cargarBorde(){
        LineBorder border=new LineBorder(_background, 0);
        this.setBorder(border);
    }
    
    private void cargarBackground(){
        this.setBackground(_background);
    }
    
    private void cargarDimension(){
        setSize(_dimension);
        setPreferredSize(_dimension);
    }
}
