package com.icm.components.metro;

import com.icm.components.tools.ToolsMetroICM;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Israel-ICM
 */
public class TextFieldMetroICM extends JTextField implements ComponentListener{
    private final JButton btnLimpiar = new JButton();
    private Color borderColor = ToolsMetroICM.METRO_COLOR_BORDER_BASE;
    private Color background = ToolsMetroICM.METRO_COLOR_BACKGROUND_TEXT_BASE;
    private ImageIcon iconBlack = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"textFieldMetro/limpiarDark.png"));
    private ImageIcon iconWhite = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"textFieldMetro/limpiarLight.png"));
    private boolean sw_dark = false;    
    private boolean band = true;
    private Dimension dimensionTextField = new Dimension(150, 38);
    private int heightButton = dimensionTextField.height - 10;
    
    private String placeholder = "";
    private Color placeholder_color= new Color(0,0,0);
    
    public TextFieldMetroICM(){
        super();
        fuente();
        
        setBackground();
        setSize(dimensionTextField);
        setPreferredSize(dimensionTextField);
        addButtonLimpiar();
        addPlaceHolder();
    }
    
    private void setBackground(){
        setBackground(background);
    }
    
    private void fuente(){
        this.setFont(new Font(ToolsMetroICM.FUENTE, Font.PLAIN, ToolsMetroICM.TEXT_SIZE));
    }
    
    private void borde()
    {
        Border border = BorderFactory.createLineBorder(borderColor ,2);
        setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, btnLimpiar.getSize().width + 5 )));
        
    }
    
    private void addPlaceHolder(){
        setMargin( new Insets(-40, 12, 30, 0));
        getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                band = (getText().length()>0) ? false:true ;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                band = false;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {}
          
        });
    }
    
    private void addButtonLimpiar(){
        btnLimpiar.setText("");                        
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setMargin(new Insets(2, 2, 2, 2));
        btnLimpiar.setVisible(true);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add( btnLimpiar );
        setVisible(true);
        addComponentListener(this);                
        setSelectionColor(btnLimpiar.getBackground());
        buttonClearResized();        
        
        btnLimpiar.addMouseListener( new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {                
                ((JTextField) btnLimpiar.getParent()).setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                btnLimpiar.setOpaque(true);  
                btnLimpiar.setIcon( (sw_dark)? iconBlack:iconWhite );     
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLimpiar.setOpaque(false);  
                btnLimpiar.setIcon( null );     
            }
        });
    }
    
    public void setPlaceholder(String placeholder)
    {
        this.placeholder = placeholder;
    }
    
    public void setPlaceholderColor(Color phColor) {
        this.placeholder_color = phColor;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //color de placeholder                         
        g.setColor( new Color(placeholder_color.getRed(), placeholder_color.getGreen(), placeholder_color.getBlue(), 90));
        //dibuja texto
        g.drawString((band)?placeholder:"",
                     getMargin().left,
                     (getSize().height)/2 + getFont().getSize()/2 );
      }
    
    public void setDark(boolean sw_dark) {
        this.sw_dark = sw_dark;        
    }
    
    public void setButtonClearColor(Color button_color) {
        btnLimpiar.setBackground(button_color); 
        setSelectionColor(btnLimpiar.getBackground());
    }
    
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        borde();
    }
    
    /** Ajusta la dimension y posicion del boton X*/
    private void buttonClearResized()
    {
        //tamaño boton
        heightButton = this.getSize().height - 10;
        btnLimpiar.setSize( new Dimension(heightButton, heightButton));
        btnLimpiar.setPreferredSize( new Dimension(heightButton, heightButton) );
        //posicion
        btnLimpiar.setLocation(getWidth()-btnLimpiar.getWidth()-5, 5);
        borde();
    }
    
    //------------
    @Override
    public void componentResized(ComponentEvent e) {
        buttonClearResized(); 
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}   
}
