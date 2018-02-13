package com.icm.components.tools;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author Israel-ICM
 */
public class ToolsMetroICM {
    public static final String FUENTE = "Century Gothic";
    public static final int TEXT_SIZE = 12;
    public static final Color COLOR_DARK = new Color(255, 255, 255);
    public static final Color COLOR_LIGHT = new Color(0, 0, 0);
    //public static final Color METRO_COLOR_BASE = new Color(51, 153, 255);//Azul  Este es el color base para todos los componentes
    public static final Color METRO_COLOR_BASE = new Color(0, 153, 153);//Verde  Este es el color base para todos los componentes
    public static final Color METRO_COLOR_BORDER_BASE = new Color(0, 0, 0, 90);//Funciona para el borde(textField, passwordField, combobox, etc)
    public static final Color METRO_COLOR_BACKGROUND_TEXT_BASE = new Color(238, 238, 238);//Funciona para el background(textField, passwordField, combobox, etc)
    public static final int COMPONENT_HEIGHT = 32;
    public static final String PATH_IMAGE = "/com/icm/components/img/";
            
    public static void openLink(String link){
        try{
            if(link.indexOf("http") == -1)
                link = "http://"+link;
            Desktop.getDesktop().browse(new URI(link));
        }
        catch(Exception e){
            System.out.println("Error ToolsMetroICM/openLink(): "+e.getMessage());
        }
    }
}
