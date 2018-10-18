import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class imagebut extends JFrame
{
static GraphicsDevice device = GraphicsEnvironment
        .getLocalGraphicsEnvironment().getScreenDevices()[0];
public static void main(String args [])
{
    imagebut w = new imagebut();
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //w.setSize(300,300);
    w.setVisible(true);

}
public imagebut()
{   

    setLayout(null); // :-)
    device.setFullScreenWindow(this);
    PicPanel mainPanel = new PicPanel("aihex.png");
    device.setFullScreenWindow(this);
    mainPanel.setBounds(0,0,device.getFullScreenWindow().getWidth(),device.getFullScreenWindow().getHeight());
   
    JButton btn1 = new JButton("Full-Screen");
    btn1.addActionListener((ActionEvent e) -> {
        device.setFullScreenWindow(this);
    });
    JButton btn2 = new JButton("Normal");
    btn2.addActionListener((ActionEvent e) -> {
        device.setFullScreenWindow(null);
    });
    JButton btn3 = new JButton("Start");
    btn3.addActionListener((ActionEvent e) -> {
        new Input().setVisible(true);
    });
    btn3.setVisible(false);
    JProgressBar jProgressBar1 = new javax.swing.JProgressBar();
    
    
        

        jProgressBar1.setBackground(new java.awt.Color(21, 34, 97));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, device.getFullScreenWindow().getWidth()/2-150)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, device.getFullScreenWindow().getWidth()/2-100)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, device.getFullScreenWindow().getHeight()/2+650)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, device.getFullScreenWindow().getHeight()/2-300)
                .addComponent(btn3)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        this.setVisible(true);
  /*  mainPanel.setLayout(new java.awt.BorderLayout());
    mainPanel.add(btn1,BorderLayout.CENTER);
    mainPanel.add(btn2,BorderLayout.NORTH);
    mainPanel.add(btn3,BorderLayout.EAST);
    mainPanel.add(jProgressBar1,BorderLayout.SOUTH);
    */
    add(mainPanel);
    device.setFullScreenWindow(null);
    device.setFullScreenWindow(this);

        try {
            for(int i=0;i<=100;i++){
            sleep(24);
            if(i>90)
            btn3.setVisible(true);
            jProgressBar1.setValue(i);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(imagebut.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        jProgressBar1.setVisible(false);
}

class PicPanel extends JPanel{

    private BufferedImage image;
    private int w,h;
    public PicPanel(String fname){

        //reads the image
        try {
            image = ImageIO.read(new File(fname));
           // w = image.getWidth();
           // h = image.getHeight();
           w=device.getFullScreenWindow().getWidth();
           h=device.getFullScreenWindow().getHeight();
        } catch (IOException ioe) {
            System.out.println("Could not read in the pic");
            //System.exit(0);
        }

    }

    public Dimension getPreferredSize() {
        return new Dimension(w,h);
    }
    //this will draw the image
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
    }
}

}
