package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Israel-ICM
 */
public class LabelMetroICM extends JLabel{
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    private Color _theme = ToolsMetroICM.COLOR_LIGHT;
    public LabelMetroICM(){
        super();
        cargarFuente();
        cargarTheme();
    }
    
    public void cargarFuente(){
        this.setFont(new Font(_fuente, Font.PLAIN, _textSize));
    }
    
    private void cargarTheme(){
        this.setForeground(_theme);
    }
    
    public void setDark(boolean sw_dark){
        _theme = sw_dark? ToolsMetroICM.COLOR_DARK : ToolsMetroICM.COLOR_LIGHT;
        cargarTheme();
    }
}
