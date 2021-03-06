package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

/**
 *
 * @author Israel-ICM
 */
public class CheckBoxMetroICM extends JCheckBox implements MouseListener{
    private final String _fuente = ToolsMetroICM.FUENTE;
    public int _textSize = ToolsMetroICM.TEXT_SIZE;
    private Color _theme = ToolsMetroICM.COLOR_LIGHT;
    private ImageIcon _iconChecked;
    private ImageIcon _iconUnchecked;
    
    private boolean sw_dark = false;
    public CheckBoxMetroICM(){
        super();
        cargarComponentTheme();
        setFocusPainted(false);
        setOpaque(false);
        this.addMouseListener(this);
    }
    
    private void cargarComponentTheme(){
        cargarFuente();
        cargarTheme();
        cargarCheck();
    }
    
    private void cargarFuente(){
        this.setFont(new Font(_fuente, Font.PLAIN, _textSize));
        this.setForeground(_theme);
    }
    
    private void cargarTheme(){
        if(sw_dark){
            _iconChecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"checkBoxMetro/checkedDark.png"));
            _iconUnchecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"checkBoxMetro/uncheckedDark.png"));
        }
        else{
            _iconChecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"checkBoxMetro/checkedLight.png"));
            _iconUnchecked = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"checkBoxMetro/uncheckedLight.png"));
        }
    }
    
    private void cargarCheck(){
        setIcon(this.isSelected()? _iconChecked : _iconUnchecked);
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        cargarCheck();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
