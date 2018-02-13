package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

/**
 *
 * @author Israel-ICM
 */
public class LinkMetroICM extends LabelMetroICM implements MouseListener{
    private final Color _colorLinkInitial = new Color(0, 102, 204);
    private final Color _colorLinkHover = new Color(0, 153, 204);
    private final Color _colorLinkClick = new Color(0, 51, 102);
    private String _link = "";
    
    public LinkMetroICM(){
        super();
        cargarLink();
        cargarCursor();
        this.addMouseListener(this);
    }
    
    private void cargarLink(){
        Font font=this.getFont();
        Map atributes=font.getAttributes();
        atributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        this.setFont(font.deriveFont(atributes));
        this.setForeground(_colorLinkInitial);
    }
    
    private void cargarCursor(){
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public void setTextSize(int textSize){
        this._textSize = textSize;
        this.cargarFuente();
        cargarLink();
    }
    
    public void setUrl(String url){
        this._link = url;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setForeground(_colorLinkInitial);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setForeground(_colorLinkClick);
        if(!_link.isEmpty())
            ToolsMetroICM.openLink(_link);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setForeground(_colorLinkHover);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setForeground(_colorLinkHover);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setForeground(_colorLinkInitial);
    }
}
