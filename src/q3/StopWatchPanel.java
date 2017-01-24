package q3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <h1>Stop Watch Panel</h1>
 * 
 * <p>
 * Simulates a stop watch with GUI. Uses Javax.swing.Timer which is 
 * inaccurate to one-tenth of a second. Has three buttons to control 
 * the stop watch; start, stop, and clear.
 * </p>
 * 
 * @author Lin, Tony
 * @version 1.0 Dec 7, 2016
 */
@SuppressWarnings("serial")
public class StopWatchPanel extends JPanel {

    /**
     * <p>
     * Time incrementing at 100ms.
     * </p>
     */
    public static final int INCREMENT = 100;

    /**
     * <p>
     * One second in milliseconds.
     * </p>
     */
    public static final int SECOND = 1000;

    /**
     * <p>
     * Maximum width of the Grid Layout.
     * </p>
     */
    public static final int GRID_WIDTH = 3;

    /**
     * <p>
     * Height of JButtons Start, Stop, and Clear.
     * </p>
     */
    public static final int BUTTON_HEIGHT = 35;

    /**
     * <p>
     * Font size for stringTime.
     * </p>
     */
    public static final int FONT_SIZE = 60;

    /**
     * <p>
     * Integer 10. Useful for dividing or multiplying things.
     * </p>
     */
    public static final int TEN = 10;
    
    /**
     * <p>
     * Holds the value of time for Stop Watch. Incremented by Timer.
     * </p>
     */
    private int time;

    /**
     * <p>
     * JButton that starts the timer and increment the integer time by 100 per 
     * 100 milliseconds.
     * </p>
     */
    private JButton start;

    /**
     * <p>
     * JButton that stops the timer from incrementing time.
     * </p>
     */
    private JButton stop;

    /**
     * <p>
     * JLabel that sets the time as a string format. Uses simpleDateFormat.
     * </p>
     */
    private JLabel stringTime;

    /**
     * <p>
     * JButton that clears the time and sets it back to 0.
     * </p>
     */
    private JButton clear;

    /**
     * <p>
     * The timer for StopWatch. Uses Javax.swing.Timer. Not very accurate.
     * </p>
     */
    private Timer stopWatch;

    /**
     * <p>
     * Sets restraints and limitation for each cell or object added to
     * GridLayout.
     * </p>
     */
    private GridBagConstraints c;

    /**
     * <h2>Stop Watch Panel</h2>
     * <p>
     * Creates a panel within JFrame that holds the time for timer, and buttons 
     * to control the timer.
     * </p>
     */
    public StopWatchPanel() {
        init();

        // All the buttons made here.
        start = new JButton("Start");
        stop = new JButton("Stop");
        clear = new JButton("Clear");
        stringTime = new JLabel("00:00:0");

        // Add functions to buttons and font style to stringTime
        start.addActionListener(new WatchButtonListener());
        stop.addActionListener(new WatchButtonListener());
        clear.addActionListener(new WatchButtonListener());
        stringTime.setFont(new Font("San-Serif", Font.PLAIN, FONT_SIZE));

        c.gridwidth = GRID_WIDTH;
        c.weighty = (double) 1 - (GRID_WIDTH / TEN);
        c.ipady = BUTTON_HEIGHT * 2;
        c.gridx = 1;
        c.gridy = 0;
        add(stringTime, c);
        c.weighty = (double) GRID_WIDTH / TEN;
        c.weightx = (double) GRID_WIDTH / TEN;
        c.ipady = BUTTON_HEIGHT;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(start, c);
        c.gridx = 1;
        add(stop, c);
        c.gridx = 2;
        add(clear, c);

    }

    /**
     * <p>
     * Initialize the panel with basic things. Includes GridLayout, and set 
     * time to 0.
     * </p>
     */
    private void init() {
        setBackground(Color.gray);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        time = 0;

        // Creates timer here
        stopWatch = new Timer(INCREMENT, new TimeListener());
        stopWatch.stop();
    }

    /**
     * <p>
     * Action event listener for timer.
     * </p>
     * 
     * @author Lin, Tony
     * @version 1.0 Dec 7, 2016
     */
    private class TimeListener implements ActionListener {

        /**
         * <p>
         * Every time the timer object sends a event here, time increments by
         * 100 millisecond. Timer sends an event every 100 millisecond.
         * </p>
         * 
         * @param e
         *            action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            time += INCREMENT;
            if (time % SECOND != 0) {
                stringTime.setText(
                        (new SimpleDateFormat("mm:ss"))
                        .format(new Date(time)) + ":" 
                        + time % SECOND / INCREMENT);
            } else {
                stringTime.setText((new SimpleDateFormat("mm:ss"))
                        .format(new Date(time)) + ":0");
            }
        }
    }

    /**
     * <p>
     * Action event listener for buttons.
     * </p>
     * 
     * @author Lin, Tony
     * @version 1.0 Dec 7, 2016
     */
    private class WatchButtonListener implements ActionListener {

        /**
         * <p>
         * For each button that sends an event, it will do what the button asks
         * it to do. For start button, it starts the timer. For stop button, it
         * stops the timer. For clear button, it clears the time.
         * </p>
         * 
         * @param event
         *            action event
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == start) {
                stopWatch.start();
            } else if (event.getSource() == stop) {
                stopWatch.stop();
            } else if (event.getSource() == clear) {
                stopWatch.stop();
                time = 0;
                stringTime.setText("00:00:0");
            }
        }
    }
}