import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class ComoPanels extends JPanel{
  //buttons
  private JButton askbutton = new JButton("Generate Question"), checkbutton = new JButton("Check Answer"),
    resetbutton = new JButton("Reset");
  //text area
  private JTextArea inputfield = new JTextArea(140,29),
    resultfield = new JTextArea("Model Answer Appears Here",140,29); 
  //question field
  private JTextField instructfield = new JTextField(15);
  //Labels
  private JLabel instruct = new JLabel("Question:");
  //function choices
  private String[] functions = {"estimateProbability", "estimateIntegral", "estimateExpectation",
    "confidenceProbability","confidenceIntegral","confidenceExpectation","randomWalks"};
  
  public ComoPanels(){
    JPanel display = new JPanel();
    display.setLayout(new GridLayout(1,2));
    BListener ml = new BListener();
    //listeners
    askbutton.addActionListener(ml);
    checkbutton.addActionListener(ml);
    resetbutton.addActionListener(ml);
    inputfield.setBackground(Color.lightGray);
    resultfield.setBackground(Color.pink);
    display.add(inputfield);
    display.add(resultfield);
    
    String fill = "";
    try{
      Scanner defscan = new Scanner(new File("Instructions.txt"));
      
      while(defscan.hasNext()){            
        fill += defscan.nextLine() + "\n";
      }
    }catch(FileNotFoundException fe){
      System.out.println("File not found");
      System.exit(1);
    }
    inputfield.setText(fill);
    
    add(instruct);
    add(instructfield);
    add(askbutton);
    add(checkbutton);
    add(resetbutton);
    add(display);
    
    setPreferredSize(new Dimension(650,500));
    
    
  }
  
  private class BListener implements ActionListener{
    public void actionPerformed(ActionEvent ae){
      Object source = ae.getSource();
      Random rand = new Random();
      
      int select = 0;
      if(source == askbutton){
        select = rand.nextInt(functions.length);
        instructfield.setText(functions[select]);
      }else if(source == checkbutton){
        String filename =  instructfield.getText() + ".txt";
        String answer = "";
        //Get Answers Here
        try{
          Scanner filescan = new Scanner(new File(filename));
          
          while(filescan.hasNext()){            
            answer += filescan.nextLine() + "\n";
          }
        }catch(FileNotFoundException fe){
          answer = "File not found";
          System.exit(1);
        }
        resultfield.setText(answer);
        //End answer try-catch block and else if
      }else if(source == resetbutton){
        instructfield.setText("");
        resultfield.setText("");
        inputfield.setText("");        
      }
    }
  }
  
}