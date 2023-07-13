package ui;

import ui.Paneles.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import Classs.Datos;
import Classs.ExcepcionesConversor;
import Classs.Longitud;
import Classs.Moneda;
import Classs.Temperatura;
import Data.Database;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.time.LocalDate;


final class MyMenu extends JFrame{
    
    
    private String[] items = {"Divisas","Temperatura","Longitud","Datos","Informacion"};
    private JLabel[] labes = new JLabel[items.length];
    //paneles
    private HorizontalPanel panelHorizontal = new HorizontalPanel();
    private VerticalPanel panelVertical = new VerticalPanel();
    //contenido principal
    //titulos     
    private JLabel labelTitulo = new JLabel();
    private JLabel deLabel = new JLabel("De");
    private JLabel paraLabel = new JLabel("A");
    //botones
    private JLabel mostrarResultado = new JLabel(new ImageIcon("src/images/archivo.png"));
    private JLabel mostrarResultadoReverso = new JLabel(new ImageIcon("src/images/swap.png"));
    //campos
    private JTextField field = new JTextField();
    private JComboBox[] boxes = new JComboBox[2];
    //logo
    private JLabel logoOne = new JLabel(new ImageIcon("src/images/one.png"));
    private JLabel textoLabel[] = new JLabel[3];


    MyMenu(){
       
        //render labes para horizontal y vertical items
        for (int i=0; i<labes.length; i++) {
            labes[i] =  new JLabel(items[i]); 
            panelHorizontal.setItemMenu(labes[i]);
            if(i<(labes.length-1)){
                setEventMouseLabel(i);
            }
           
            
        }
        
        labes[labes.length-1].addMouseListener(new MouseAdapter(){
             @Override
             public void mouseClicked(MouseEvent event){
                mostrarContenido(false);
             }
        });
        
        
        labelTitulo.setBounds(180, 150, 50, 30);
        
        
        field.setBounds(180, 180, 200, 30);
        field.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        deLabel.setBounds(180, 250, 50, 30);
        paraLabel.setBounds(420, 250, 50, 30);
        
        boxes[0] = new JComboBox<>();
        generateJComboBox(boxes[0], 180, 300);

        boxes[1] = new JComboBox<>();
        generateJComboBox(boxes[1], 420, 300);

        mostrarResultado.setBounds(190, 380,64,64);
        setEventoResultado(mostrarResultado, field, false);
        
        mostrarResultadoReverso.setBounds(430, 380,64,64);
        setEventoResultado(mostrarResultadoReverso, field, true);
         
        if(labelTitulo.getText().length()<=0){
            logoOne.setBounds(320,200, 200, 60);
            for(int i=0; i<textoLabel.length; i++){
                textoLabel[i] = new JLabel();
                
            } 

            textoLabel[0].setBounds(320, 230, 200, 100);
            textoLabel[0].setText("Conversor Alura latam ONE"); 
            textoLabel[1].setBounds(350, 250, 200, 100);
            textoLabel[1].setText("Grupo 5 Año 2023"); 
            textoLabel[2].setBounds(350, 290, 200, 100);
            textoLabel[2].setText(String.format("Fecha: %s",LocalDate.now())); 
            mostrarContenido(false);
        }

    
        add(labelTitulo);
        add(field);
        add(deLabel);
        add(paraLabel);
        add(boxes[0]);
        add(boxes[1]);
        add(mostrarResultado);
        add(mostrarResultadoReverso);
        add(panelVertical);
        add(panelHorizontal);
        add(logoOne);
        add(textoLabel[0]);
        add(textoLabel[1]);
        add(textoLabel[2]);
 

        
        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    
    private JLabel cerraJframe(){

        JLabel label = new JLabel(new ImageIcon("src/images/close.png"));
        label.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e){
              System.exit(0);
             }
         });

         return label;
    }

    private JLabel minimizarJframe(){
         
        JLabel label = new JLabel(new ImageIcon("src/images/minimize.png")); 
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
              setState(JFrame.ICONIFIED);
             }
        });

        return label;

    }

    private void setEventMouseLabel(int index){
         labes[index].addMouseListener(new MouseAdapter() {
            @Override
             public void mouseClicked(MouseEvent e){
               panelVertical.removeAll();
               panelVertical.revalidate();
               panelVertical.repaint();
                
               mostrarContenido(true);

               labes[index].setText("");
               labes[index].setText(items[index]);

                if(labes[index].getText().equals(items[0])){
                   labelTitulo.setText("Monto");
                   addItems(boxes, Moneda.divisas);

                }else if(labes[index].getText().equals(items[1])){
                   labelTitulo.setText("Grado");
                   addItems(boxes,Temperatura.grados);

                }else if(labes[index].getText().equals(items[2])){
                    labelTitulo.setText("Unidad");  
                    addItems(boxes,Longitud.unidades);
                }else{
                    labelTitulo.setText("Tamaño");  
                    addItems(boxes,Datos.tamanos);
                }
                      
                
               panelVertical.add(panelVertical.setEncabezado(items[index].toLowerCase()+".png", 
                                                             items[index].toLowerCase()));
               panelVertical.add(panelVertical.setCerrarMinimizar(cerraJframe(), minimizarJframe()));
             }
        });  
    }

    private void generateJComboBox(JComboBox box,int x, int y){
        box.setBounds(x,y, 100, 30);
        box.setBackground(Color.WHITE);
        
    }

    private void addItems(JComboBox[] boxes, String[] data){

        for(int i=0; i<boxes.length; i++){
            boxes[i].removeAllItems();
            for(int j=0; j<data.length; j++){
                boxes[i].addItem(data[j]);
            } 
        }
    }

    private void mostrarContenido(boolean accion){

        if(accion){
            labelTitulo.setVisible(true);
            deLabel.setVisible(true);
            paraLabel.setVisible(true);
            boxes[0].setVisible(true);
            boxes[1].setVisible(true);
            field.setVisible(true);
            for(int i=0; i<textoLabel.length; i++){
                textoLabel[i].setVisible(false);
                
            } 
            logoOne.setVisible(false);
            mostrarResultado.setVisible(true);
            mostrarResultadoReverso.setVisible(true); 

        }else{
            panelVertical.removeAll();
            panelVertical.revalidate();
            panelVertical.repaint();

            labelTitulo.setVisible(false);
            deLabel.setVisible(false);
            paraLabel.setVisible(false);
            boxes[0].setVisible(false);
            boxes[1].setVisible(false);
            field.setVisible(false);
            mostrarResultado.setVisible(false);
            mostrarResultadoReverso.setVisible(false);

            panelVertical.add(panelVertical.setEncabezado("main.png", "Alura"));
            panelVertical.add(panelVertical.setCerrarMinimizar(cerraJframe(), minimizarJframe()));
            for(int i=0; i<textoLabel.length; i++){
                textoLabel[i].setVisible(true);
                
            } 
            logoOne.setVisible(true);

            
                                           
        }   
            
    }

    private void setEventoResultado(JLabel boton,JTextField field, boolean accionReveso){
       boton.addMouseListener(new MouseAdapter() {
         
         @Override
         public void mouseClicked(MouseEvent e){
            String sms;
            if(field.getText().length() <=0)
            {   
                sms = String.format("Campo %s esta vacío", labelTitulo.getText().toLowerCase());
                JOptionPane.showMessageDialog(null, sms,"Conversor Alura", JOptionPane.ERROR_MESSAGE);
                throw new ExcepcionesConversor.CampoVacio(sms);
            }

            if(!field.getText().matches("^[0-9]+$"))
            {   sms = String.format("%s... Valor no válido", (field.getText().length() < 3) ? field.getText() 
                                                                                                   : field.getText().substring(0, 3));
                JOptionPane.showMessageDialog(null, sms,"Conversor Alura", JOptionPane.ERROR_MESSAGE);
                throw new ExcepcionesConversor.ValorInvalido(sms);
            }

            if(boxes[0].getSelectedItem().equals(boxes[1].getSelectedItem()))
            {   
                sms =  "Es el mismo ítem";
                JOptionPane.showMessageDialog(null, sms,"Conversor Alura", JOptionPane.ERROR_MESSAGE);
                throw new ExcepcionesConversor.ConversorMismoItem(sms);
            }

            if(labelTitulo.getText().equals("Monto"))
            {
                for (Moneda monedas : Database.getMonedasValues()) 
                {
                    if(!accionReveso)
                    { 
                        if(monedas.getValorDesde().equals(boxes[0].getSelectedItem()) &&
                           monedas.getValorPara().equals(boxes[1].getSelectedItem()))
                        {
                            JOptionPane.showMessageDialog(null,monedas.operacion(new BigDecimal(field.getText())));
                        } 

                        }else
                        {
                            if(monedas.getValorDesde().equals(boxes[1].getSelectedItem()) &&
                               monedas.getValorPara().equals(boxes[0].getSelectedItem()))
                              {
                               boxes[0].setSelectedItem(monedas.getValorDesde()); 
                               boxes[1].setSelectedItem(monedas.getValorPara()); 
                               JOptionPane.showMessageDialog(null,monedas.operacion(new BigDecimal(field.getText())));
                               break;     
                               } 
                         
                        }    
                }

            }else if(labelTitulo.getText().equals("Grado"))
            {
                Temperatura temperatura = Database.getTemperatura((String)boxes[0].getSelectedItem(), 
                                                                  (String)boxes[1].getSelectedItem());
                
                if(accionReveso)
                {  
                   boxes[0].setSelectedItem(temperatura.getValorPara()); 
                   boxes[1].setSelectedItem(temperatura.getValorDesde());    
                   temperatura = Database.getTemperatura((String)boxes[0].getSelectedItem(), 
                                                         (String)boxes[1].getSelectedItem());
                }
                JOptionPane.showMessageDialog(null,temperatura.operacion(new BigDecimal(field.getText().trim())));
            
            }else if(labelTitulo.getText().equals("Unidad"))
            {
                for (Longitud longitud : Database.getLongitudValue()) 
                {
                    if(!accionReveso)
                    {
                        if(longitud.getValorDesde().equals(boxes[0].getSelectedItem()) &&
                           longitud.getValorPara().equals(boxes[1].getSelectedItem()))
                          {
                            JOptionPane.showMessageDialog(null,longitud.operacion(new BigDecimal(field.getText())));
                          }

                    }else
                    {   
                         if(longitud.getValorDesde().equals(boxes[1].getSelectedItem()) &&
                            longitud.getValorPara().equals(boxes[0].getSelectedItem()))
                            {
                               boxes[0].setSelectedItem(longitud.getValorDesde()); 
                               boxes[1].setSelectedItem(longitud.getValorPara());

                              JOptionPane.showMessageDialog(null,longitud.operacion(new BigDecimal(field.getText())));
                              break;
                            }  
                    }
                }
            }else
            {
                for(Datos datos : Database.getDatosValue())
                {
                    if(!accionReveso)
                    {
                        if(datos.getValorDesde().equals(boxes[0].getSelectedItem()) &&
                           datos.getValorPara().equals(boxes[1].getSelectedItem()))
                          {
                            JOptionPane.showMessageDialog(null,datos.operacion(new BigDecimal(field.getText())));
                          }

                    }else
                    {   
                         if(datos.getValorDesde().equals(boxes[1].getSelectedItem()) &&
                            datos.getValorPara().equals(boxes[0].getSelectedItem()))
                            {
                               boxes[0].setSelectedItem(datos.getValorDesde()); 
                               boxes[1].setSelectedItem(datos.getValorPara());

                              JOptionPane.showMessageDialog(null,datos.operacion(new BigDecimal(field.getText())));
                              break;
                            }  
                    }
                }
            }
         }
        
       });
    }


}

public class App {
    //punto de entrada
    public static void main(String[] args) throws Exception {
        new MyMenu();
    }
}
