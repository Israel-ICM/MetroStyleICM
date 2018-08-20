package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Israel-ICM
 */
public class ButtonMenuMetroICM extends ButtonMetroICM implements MouseListener{
    private int _widthBorder = 3;
    private Dimension _dimension = new Dimension(130, 130);
    private ImageIcon _icon = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"buttonMenuMetro/word.png"));
    public ButtonMenuMetroICM(){
        super();
        cargarFormaButtonMenu();
        cargarDimension();
        cargarIcon();
        this.addMouseListener(this);
    }
    private void cargarFormaButtonMenu(){
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
    }
    private void cargarDimension(){
        setSize(_dimension);
        setPreferredSize(_dimension);
    }
    private void cargarIcon(){
        setIcon(_icon);
    }
    private void cargarBorder(Color color){
        LineBorder border=new LineBorder(color, _widthBorder);
        this.setBorder(border);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        cargarBorder(new Color(0, 0, 0, 60));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(null);
    }
}
