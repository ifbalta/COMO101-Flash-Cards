import javax.swing.*;
import java.awt.*;

public class ComoApplet extends JApplet{
    
  public void init(){
    try{
    getContentPane().add(new ComoPanels());
    setPreferredSize(new Dimension(659,550));
    }catch(Exception ite){
    JOptionPane.showMessageDialog(null, "Sorry, something went wrong here\n" + ite.toString());
    }
  }
    
}
