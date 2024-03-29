
package ejercicio_circuitobolas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener{
    
    JPanel panel;
    JButton btn;
    ImageIcon bg;
    int milis;
    
    Competidor c1,c2;
    
    public Frame(){
        this.setTitle("Pista");
        this.setSize(1000, 500);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btn = new JButton("Iniciar");
        btn.setBounds(10,420,80,40);
        btn.addActionListener(this);
        
        panel = new Panel();
        panel.setBounds(10, 10, 900, 400);
        
        bg = new ImageIcon("src/Ejercicio_CircuitoBolas/pista.png");
        
        milis = 20;
        c1 = new Competidor(30,1,0,10,milis);
        c2 = new Competidor(28,2,0,10,milis);
        
        this.add(panel);
        this.add(btn);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn){
            c1.start();
            c2.start();
            btn.setEnabled(false);
        }
    }
    
    public class Panel extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);  
            //this.setBackground(Color.BLUE);
            g.drawImage(bg.getImage(), 0, 0, 900, 400, null);
            
            g.fillOval(c1.getPosX(), c1.getPosY(), 50, 50);
            
            g.setColor(Color.red);
            g.fillOval(c2.getPosX(), c2.getPosY(), 50, 50);
            repaint();
        }
    }
}
