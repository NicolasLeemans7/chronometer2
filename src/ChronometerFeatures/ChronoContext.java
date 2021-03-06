package ChronometerFeatures;

import javax.swing.*;

class ChronoContext {

    public long offset;
    public long pauseTime;
    public long lapsTime;
    
    private ClockState currentState;
    
    private JLabel display;
    // The method run() ensures that every second the value of display is modified with setText(...).
    // In this sense, ChronometerMain acts as some kind of Observer of ChronoContext.

    public ChronoContext(JLabel d) {
        currentState = ZeroState.instance();
        offset = System.currentTimeMillis();
        display = d;
    }
    
    public void run() {
  	  while (true) {
		  try { Thread.sleep(1000); }
	      catch (InterruptedException e) {
	          e.printStackTrace(); 
	      }
	      display.setText(this.currentState.getDisplayString(this));
	      }
    }
    
    public void buttonpushed(ButtonType b) {
    	switch (b) {
    	case LEFT : currentState.start_stop(this);
    		break;
    	case UP : currentState.laps(this);
    		break;
    	case RIGHT : currentState.reset(this);
    		break;
    	default : System.out.println("Button not recognised");
    		break;
    	}
    }
        
    public void transition(ClockState NextState) {
        currentState = NextState;
    }
    
    public String getDisplayText() { return currentState.getDisplayString(this); }
    
    public String getStateText() { return currentState.getStateString(); }
 }
