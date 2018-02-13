package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 *
 * @author Israel-ICM
 */
public class ButtonBorderMetroICM extends ButtonMetroICM{
    private int _widthBorder = 3;
    private Color _theme = ToolsMetroICM.COLOR_LIGHT;
    public ButtonBorderMetroICM(){
        super();
        cargarComponentTheme();
    }
    
    private void cargarComponentTheme(){
        cargarBorder(_theme);
        cargarBackground(_theme);
        setForeground(_theme);
    }
    
    private void cargarBorder(Color color){
        LineBorder border=new LineBorder(color, _widthBorder);
        this.setBorder(border);
    }
    
    private void cargarBackground(Color color){
        this.setBackground(color);
        setOpaque(false);
    }
    
    public void setDark(boolean sw_dark){
        _theme = sw_dark? ToolsMetroICM.COLOR_DARK : ToolsMetroICM.COLOR_LIGHT;
        cargarComponentTheme();
    }
    
    public void setBorderColor(Color color){
        cargarBorder(color);
    }
}
