package ui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;

public abstract class Paneles {

   
    static final class HorizontalPanel extends JPanel {

        HorizontalPanel(){
           setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
           setBounds(0, 0, 150, 500); 
           setBackground(Color.WHITE);
           setBorder(new LineBorder(Color.BLACK,1,false));

           add(Box.createRigidArea(new Dimension(0, 25)));
           add(setTituloMenu());
           add(Box.createRigidArea(new Dimension(0, 100)));
        
        }

        private Box setTituloMenu(){

            Box box = Box.createHorizontalBox();
            box.add(new JLabel(new ImageIcon("src/images/menu.png")));
            box.add(Box.createRigidArea(new Dimension(15, 0)));
            box.add(new JLabel("Menu"));
            return box;
        }

        public void setItemMenu(JLabel titulo){
            Box box = Box.createHorizontalBox();
            box.add(titulo);
            add(box);
            add(Box.createRigidArea(new Dimension(0, 10)));
        }

        
    } 

    static final class VerticalPanel extends JPanel {
        VerticalPanel(){
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            setBounds(150, 25, 540, 100);
            setBackground(Color.WHITE);
            setBorder(new LineBorder(Color.BLACK,1,false));
        }

        Box setEncabezado(String nombreIcono, String titulo){
            Box box = Box.createHorizontalBox();
            box.add(Box.createRigidArea(new Dimension(80,0)));
            box.add(new JLabel(new ImageIcon(String.format("src/images/%s",nombreIcono))));
            box.add(Box.createRigidArea(new Dimension(30,0)));
            if(nombreIcono.equals("main.png")){
                box.add(new JLabel(String.format("Conversor %s",titulo)));
            }else{
                box.add(new JLabel(String.format("Conversor de %s",titulo)));
            }
            
            box.add(Box.createRigidArea(new Dimension(50,0)));
            box.add(Box.createRigidArea(new Dimension(60,0)));
            return box;
        }

        Box setCerrarMinimizar(JLabel cerrar, JLabel minimizar){
            Box box2 = Box.createVerticalBox();
            Box innerBox = Box.createHorizontalBox();
            innerBox.add(minimizar);
            innerBox.add(Box.createRigidArea(new Dimension(10, 0)));
            innerBox.add(cerrar);
            box2.add(innerBox);
            box2.add(Box.createVerticalStrut(50));
            return box2;
        }
    }

}
