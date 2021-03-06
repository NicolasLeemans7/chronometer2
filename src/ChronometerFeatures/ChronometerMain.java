package ChronometerFeatures;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChronometerMain implements ActionListener {
    
    private JButton leftButton, upButton, rightButton;
    private JLabel myText1;
    private JLabel myText2;
    
    private ChronoContext myContext;

    public ChronometerMain() {
        init();
    }
    
    // it is considered good programming practice that the actual
    // user interface code is not put in the class Constructor itself 
    private void init() {
        leftButton = new JButton("left");
        leftButton.addActionListener(this);
        upButton = new JButton("up");
        upButton.addActionListener(this);
        rightButton = new JButton("right");
        rightButton.addActionListener(this);
        myText1 = new JLabel();
        myText2 = new JLabel();

        myContext = new ChronoContext(myText1);
        myText1.setText(myContext.getDisplayText());
        myText2.setText(myContext.getStateText());
        

        JFrame myFrame = new JFrame("Chronometer");
        Container myContent = myFrame.getContentPane();
        // grid layout with 2 rows and 3 columns
        myContent.setLayout(new GridLayout(2,3));
        // filling first row of grid (3 columns) with text information
        myContent.add(myText1,0);
        myContent.add(myText2,1);
        myContent.add(new JLabel());    // Don't ask…
        // filling second row of grid (3 columns) with buttons
        myContent.add(leftButton);
        myContent.add(upButton);
        myContent.add(rightButton);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myContext.run();
    }
    
    public void actionPerformed(ActionEvent e) {
        if((JButton)e.getSource()==leftButton) {
            myContext.buttonpushed(ButtonType.LEFT);
        }
        else if((JButton)e.getSource()==upButton){
            myContext.buttonpushed(ButtonType.UP);
         }
        else if((JButton)e.getSource()==rightButton){
        	myContext.buttonpushed(ButtonType.RIGHT);
        }
        
        myText1.setText(myContext.getDisplayText());
        myText2.setText(myContext.getStateText());
    }
    
    public static void main(String[] args) {
        ChronometerMain myClock = new ChronometerMain();
    }
   
}
