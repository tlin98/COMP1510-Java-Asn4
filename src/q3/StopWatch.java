package q3;

import javax.swing.JFrame;

/**
 * <h1>Stop Watch</h1>
 * 
 * <p>Creates a GUI Stop Watch from the StopWatchPanel. Tests the stop watch. 
 * The Stop watch has 3 buttons to control it, start, stop, and clear.</p>
 *
 * @author Lin, Tony
 * @version 1.0 Dec 7, 2016
 */
public class StopWatch {
    
    /**
     * <p>Width of JFrame.</p>
     */
    public static final int WIDTH = 600;
    
    /**
     * <p>Height of JFrame.</p>
     */
    public static final int HEIGHT = 400;
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // your code will go here!!!
        JFrame frame = new JFrame("Stop Watch");
        frame.getContentPane().add(new StopWatchPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        
        System.out.println("Question three was called and ran sucessfully.");
    }

};
