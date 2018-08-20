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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Israel-ICM
 */
public class PasswordFieldMetroICM extends JPasswordField implements ComponentListener{
    private final JButton btnVerPassword = new JButton();
    private Color borderColor = ToolsMetroICM.METRO_COLOR_BORDER_BASE;
    private Color background = ToolsMetroICM.METRO_COLOR_BACKGROUND_TEXT_BASE;
    private ImageIcon _iconDark = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"passwordFieldMetro/passwordVerDark.png"));
    private ImageIcon _iconLight = new ImageIcon(getClass().getResource(ToolsMetroICM.PATH_IMAGE+"passwordFieldMetro/passwordVerLight.png"));
    private boolean sw_dark = false;    
    private boolean sw_existe_texto = true;
    private Dimension dimensionTextField = new Dimension(150, 38);
    private int heightButton = dimensionTextField.height - 10;
    
    private String placeholder = "";
    private Color placeholder_color= new Color(0,0,0);
    
    public PasswordFieldMetroICM(){
        super();
        fuente();
        
        setBackground();
        setSize(dimensionTextField);
        setPreferredSize(dimensionTextField);
        addButtonVerPassword();
        addPlaceHolder();
    }
    
    private void fuente(){
        this.setFont(new Font(ToolsMetroICM.FUENTE, Font.PLAIN, ToolsMetroICM.TEXT_SIZE));
    }
    
    private void borde()
    {
        Border border = BorderFactory.createLineBorder( borderColor ,2);
        setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, btnVerPassword.getSize().width + 5 )));
        
    }
    
    private void setBackground(){
        setBackground(background);
    }
    
    private void addPlaceHolder(){
        setMargin( new Insets(-40, 12, 30, 0));
        getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                sw_existe_texto = (getText().length()>0) ? false:true ;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                sw_existe_texto = false;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {}
          
        });
    }
    
    private String strPasswordAux = "";
    private boolean sw_btnVerPresionado = false;
    private void addButtonVerPassword(){
        btnVerPassword.setText("");                        
        btnVerPassword.setBorderPainted(false);
        btnVerPassword.setContentAreaFilled(false);
        btnVerPassword.setMargin(new Insets(2, 2, 2, 2));
        btnVerPassword.setVisible(true);
        btnVerPassword.setFocusPainted(false);
        btnVerPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add( btnVerPassword );
        setVisible(true);
        addComponentListener(this);                
        setSelectionColor(btnVerPassword.getBackground());
        buttonClearResized();        
        
        btnVerPassword.addMouseListener( new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {                
                //((JTextField) btnVerPassword.getParent()).setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                strPasswordAux = ((JTextField) btnVerPassword.getParent()).getText();
                ((JTextField) btnVerPassword.getParent()).setText("");
                sw_btnVerPresionado = true;
                //System.out.println("se oprime");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ((JTextField) btnVerPassword.getParent()).setText(strPasswordAux);
                strPasswordAux = "";
                sw_btnVerPresionado = false;
                //System.out.println("se suelta");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnVerPassword.setOpaque(true);  
                btnVerPassword.setIcon( (sw_dark)? _iconDark:_iconLight );     
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnVerPassword.setOpaque(false);  
                btnVerPassword.setIcon( null );     
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
    
    
    
    public void setDark(boolean sw_dark) {
        this.sw_dark = sw_dark;        
    }
    
    public void setButtonClearColor(Color button_color) {
        btnVerPassword.setBackground(button_color); 
        setSelectionColor(btnVerPassword.getBackground());
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
        btnVerPassword.setSize( new Dimension(heightButton, heightButton));
        btnVerPassword.setPreferredSize( new Dimension(heightButton, heightButton) );        
        //posicion
        btnVerPassword.setLocation(getWidth()-btnVerPassword.getWidth()-5, 5);
        borde();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println(strPasswordAux.isEmpty()+" -- "+sw_btnVerPresionado);
        if(strPasswordAux.isEmpty() && !sw_btnVerPresionado){
            //color de placeholder                         
            g.setColor(new Color(placeholder_color.getRed(), placeholder_color.getGreen(), placeholder_color.getBlue(), 90));
            //dibuja texto
            g.drawString((sw_existe_texto)?placeholder:"", getMargin().left, (getSize().height)/2 + getFont().getSize()/2 );
        }
        if(sw_btnVerPresionado){
            g.setColor(new Color(placeholder_color.getRed(), placeholder_color.getGreen(), placeholder_color.getBlue(), 100));
            g.drawString(strPasswordAux, getMargin().left, (getSize().height)/2 + getFont().getSize()/2 );
        }
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
