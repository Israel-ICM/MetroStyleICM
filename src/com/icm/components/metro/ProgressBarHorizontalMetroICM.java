package com.icm.components.metro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Israel-ICM
 */
public class ProgressBarHorizontalMetroICM extends JPanel{
    private Dimension _dimension = new Dimension(350, 15);
    private Color _background = new Color(51, 153, 255);
    private Font fuente = new Font("Garamond", 1, 40);
    
    JLabel punto1;
    JLabel punto2;
    JLabel punto3;
    JLabel punto4;
    JLabel punto5;
    public ProgressBarHorizontalMetroICM(){
        //super();
        cargarDimension();
        
        setLayout(null);

        punto1=new JLabel();
        punto1.setFont(fuente);
        punto1.setText(".");
        
        punto2=new JLabel();
        punto2.setFont(fuente);
        punto2.setText(".");
        
        punto3=new JLabel();
        punto3.setFont(fuente);
        punto3.setText(".");
        
        punto4=new JLabel();
        punto4.setFont(fuente);
        punto4.setText(".");
        
        punto5=new JLabel();
        punto5.setFont(fuente);
        punto5.setText(".");
        
        cargarBackground();
        
        add(punto1);
        add(punto2);
        add(punto3);
        add(punto4);
        add(punto5);
        
        int x = -25, y = -25;
        
        punto1.setBounds(x, y, 12, 48);
        punto2.setBounds(x, y, 12, 48);
        punto3.setBounds(x, y, 12, 48);
        punto4.setBounds(x, y, 12, 48);
        punto5.setBounds(x, y, 12, 48);
        
        ProgressBarThread progress=new ProgressBarThread(punto1, punto2, punto3, punto4, punto5);
        progress.start();
        progress=null;
    }
    
    private void cargarBackground(){
        punto1.setForeground(_background);
        punto2.setForeground(_background);
        punto3.setForeground(_background);
        punto4.setForeground(_background);
        punto5.setForeground(_background);
    }
    
    private void cargarDimension(){
        setSize(_dimension);
        setPreferredSize(_dimension);
    }
    
    public void setColorProgressBar(Color progress_color){
        _background=progress_color;
        cargarBackground();
    }
    
    public class ProgressBarThread extends Thread{
        JLabel punto;
        JLabel punto2;
        JLabel punto3;
        JLabel punto4;
        JLabel punto5;
        JPanel panel;
        int positionX;
        int fin=100;

        int velocidad=0;
        public ProgressBarThread(JLabel a, JLabel b, JLabel c, JLabel d, JLabel e){
            punto=a;
            punto2=b;
            punto3=c;
            punto4=d;
            punto5=e;
            positionX=-1;//a.getX();
            panel=(JPanel) a.getParent();
        }
        /**
         * La lógica es dividir el ancho del panel en 5
         * cosa de tener el 20% del centro donde la velocidad debe bajar
         * 
         */
        @Override
        public void run(){
            for(int i=0;true;i++){
                sleep();
                
                PuntoThread punt=new PuntoThread(punto, 2, 1);
                punt.start();
                punt=null;

                sleep();

                PuntoThread punt2=new PuntoThread(punto2, 2, 1);
                punt2.start();
                punt2=null;

                sleep();

                PuntoThread punt3=new PuntoThread(punto3, 2, 1);
                punt3.start();
                punt3=null;

                sleep();

                PuntoThread punt4=new PuntoThread(punto4, 2, 1);
                punt4.start();
                punt4=null;

                sleep();

                PuntoThread punt5=new PuntoThread(punto5, 2, 1);
                punt5.start();
                punt5=null;

                sleepNew();
            }
        }

        private void sleep(){
            try {
                Thread.sleep(200);
            }
            catch(InterruptedException ex) {
                System.out.println(""+ex.getMessage());
            }
        }

        private void sleepNew(){
            int ancho_estimado=576;
            int tiempo_estimado=2300;
            try {
                Thread.sleep((panel.getWidth()*tiempo_estimado)/ancho_estimado);
            }
            catch(InterruptedException ex) {
                System.out.println(""+ex.getMessage());
            }
        }
    }
    
    
    public class PuntoThread extends Thread{
        JLabel punto;
        JPanel panel;

        int velocidad_norm=3;
        int velocidad_fin=3;
        public PuntoThread(JLabel a, int velocidad, int velocidad_fin){
            punto=a;
            panel=(JPanel) a.getParent();
            this.velocidad_norm=velocidad;
            this.velocidad_fin=velocidad_fin;
        }
        /**
         * La logica es dividir el ancho del panel en 3
         * cosa de tener el 30% del centro donde la velocidad debe bajar
         * 
         */
        @Override
        public void run(){
            int velocidad=velocidad_norm;
            int aux=(int) ((int) panel.getWidth()*0.33);

            for(int i=-20;i<panel.getWidth();i++){
                punto.setLocation(i, punto.getY());
                if(((aux))==i)//Aqui ingresa cuando llegó al centro (20%)
                    velocidad=7;
                if(((aux*2))==i)//Aqui ingresa cuando el 20% del centro finalizó y debe volver a la velocidad normal
                    velocidad=velocidad_fin;
                sleep(velocidad);
            }
        }

        private void sleep(int delay){
            try {
                Thread.sleep(delay);
            }
            catch(InterruptedException ex) {
                System.out.println(""+ex.getMessage());
            }
        }
    }
}
