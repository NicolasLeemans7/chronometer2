package ChronometerFeatures;

public interface ClockState {
    void start_stop(ChronoContext context); // button 1 pressed
    void laps(ChronoContext context); // button 2 pressed
    void reset(ChronoContext context); // button 2 pressed
    String getDisplayString(ChronoContext context);
    String getStateString();
}
