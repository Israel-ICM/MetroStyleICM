package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.AbstractBorder;
/**
 *
 * @author Israel-ICM
 */
public class LabelRoundMetroICM extends JLabel {
    private Dimension _dimension = new Dimension(150, 150);
    private AbstractBorder _circleBorder = new ToolsCircleBorder();       
    private int _grosorBorder = 1; 
    private Color _colorBorder = new Color(0, 0, 0, 60);//Color.BLACK;
    private ImageIcon _icon = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"labelRoundMetro/user.png"));
    
    public LabelRoundMetroICM()
    {
        super();
        initComponent();
        cargarDimension();
        cargarIcon();
    }
    
    private void initComponent(){
        setText("");
        setOpaque(true);
        setHorizontalAlignment(CENTER);       
        setVisible(true);
        setBorder(_circleBorder);
        setLineBorder(0);
    }
    
    private void cargarDimension(){
        setSize(_dimension);
        setPreferredSize(_dimension);
    }
    
    private void cargarIcon(){
        setIcon(_icon);
    }
    
    public void setLineColor(Color color) {
        _circleBorder = new ToolsCircleBorder(color, _grosorBorder);
        _colorBorder = color;
        setBorder(_circleBorder); 
    }

    public void setLineBorder(int lineBorder) {
        _circleBorder = new ToolsCircleBorder(_colorBorder, lineBorder);
        this._grosorBorder = lineBorder;        
        setBorder(_circleBorder); 
    }
}