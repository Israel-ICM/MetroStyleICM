package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

/**
 *
 * @author Israel-ICM
 */
public class RadioButtonMetroICM extends JRadioButton{
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    private Color _theme = ToolsMetroICM.COLOR_LIGHT;
    private ImageIcon _iconChecked;
    private ImageIcon _iconUnchecked;
    
    private boolean sw_dark = false;
    public RadioButtonMetroICM(){
        super();
        cargarComponentTheme();
        setFocusPainted(false);
        setOpaque(false);
    }
    
    private void cargarComponentTheme(){
        cargarFuente();
        cargarTheme();
        cargarCheck();
        setForeground(_theme);
    }
    
    private void cargarFuente(){
        this.setFont(new Font(_fuente, Font.PLAIN, _textSize));
        this.setForeground(Color.WHITE);
    }
    
    private void cargarTheme(){
        if(sw_dark){
            _iconChecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"radioButtonMetro/radioCheckedDark.png"));
            _iconUnchecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"radioButtonMetro/radioUncheckedDark.png"));
        }
        else{
            _iconChecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"radioButtonMetro/radioCheckedLight.png"));
            _iconUnchecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"radioButtonMetro/radioUncheckedLight.png"));
        }
    }
    
    private void cargarCheck(){
        setIcon(_iconUnchecked);
        setSelectedIcon(_iconChecked);
        /*setPressedIcon(_iconChecked);
        setRolloverIcon(_iconUnchecked);
        setRolloverSelectedIcon(_iconChecked);*/
        repaint();
    }
    
    @Override
    public void setSelected(boolean selected){
        super.setSelected(selected);
        cargarCheck();
    }
    
    public void setDark(boolean dark){
        sw_dark=dark;
        _theme = sw_dark? ToolsMetroICM.COLOR_DARK : ToolsMetroICM.COLOR_LIGHT;
        cargarComponentTheme();
    }
}
