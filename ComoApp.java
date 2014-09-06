import javax.swing.*;
import java.awt.*;

public class ComoApp extends JFrame{
  public static void main(String[] args){
    JFrame frame = new JFrame("COMO101 Practice MATLAB Code");
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ComoPanels());   
    frame.pack();
    frame.setPreferredSize(new Dimension(100,100));
    frame.setVisible(true);


    
  }
}