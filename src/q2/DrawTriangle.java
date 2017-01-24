package q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;

/**
 * <h1>Draw Triangle</h1>
 * 
 * <p>
 * Draws a triangle in a window. On mouse-press again, the triangle will
 * disappear and a new triangle will be drawn. Triangle is Equilateral triangle.
 * </p>
 * 
 * @author Lin, Tony
 * @version 1.0 Dec 5, 2016
 * 
 */
@SuppressWarnings("serial")
public class DrawTriangle extends JFrame {

    /**
     * <p>
     * Width of JFrame.
     * </p>
     */
    public static final int WIDTH = 800;

    /**
     * <p>
     * Height of JFrame.
     * </p>
     */
    public static final int HEIGHT = 600;

    /**
     * <p>
     * Sets up a JFrame to hold a JPanel that allows the user to draw a
     * triangle.
     * </p>
     */
    public DrawTriangle() {
        super("Tony Lin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawTrianglePanel());
        // you can change this size but don't make it HUGE!
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    /**
     * <p>
     * Draws a triangle based on mouse-clicks which provides the origin of the
     * triangle.
     * </p>
     */
    private final class DrawTrianglePanel extends JPanel implements 
        MouseListener, MouseMotionListener {

        /**
         * <p>
         * First rotation of triangle.
         * </p>
         */
        private static final double THETA1 = 2 * Math.PI / 3;
        
        /**
         * <p>
         * Second rotation of triangle.
         * </p>
         */
        private static final double THETA2 = 4 * Math.PI / 3;
        
        /**
         * <p>
         * Origin point. Based on the position of mouse pressed.
         * </p>
         */
        private Point origin;
        
        /**
         * <p>
         * First point. Based on the position of mouse dragged.
         * </p>
         */
        private Point point;
        
        /**
         * <p>
         * Second point. Based on the distance from point 1 to origin, at 120
         * degree angle.
         * </p>
         */
        private Point point2;
        
        /**
         * <p>
         * Third point. Based on distance from point 1 to origin, at 120 degree
         * angle opposite of point2.
         */
        private Point point3;

        /**
         * <p>
         * Adds mouse listener to the panel.
         * </p>
         */
        private DrawTrianglePanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        /**
         * <p>
         * Draws triangle based on position of points. Uses an origin 
         * point from mouse pressed and the new position from mouse drag 
         * to determine the distance for point 2 and 3. Triangle is an 
         * equilateral triangle.
         * </p>
         * 
         * @param g
         *            graphics component
         */
        @SuppressWarnings("static-access")
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // DRAWING CODE HERE
            //System.out.println("Paint called");
            g.setColor(Color.red);

            if (point == origin) {
                g.clearRect(0, 0, this.WIDTH, this.HEIGHT);
            } else {
                int px = (int) Math
                        .round(Math.cos(THETA1) * (point.x - origin.x) 
                                + Math.sin(THETA1) * (point.y - origin.y)) 
                                + origin.x;
                int py = (int) Math
                        .round(-1.0 * Math.sin(THETA1) * (point.x - origin.x) 
                                + Math.cos(THETA1) * (point.y - origin.y))
                                + origin.y;
                point2 = new Point(px, py);
                g.drawLine(point2.x, point2.y, point.x, point.y);
                px = (int) Math.round(Math.cos(THETA2) * (point.x - origin.x) 
                                + Math.sin(THETA2) * (point.y - origin.y))
                                + origin.x;
                py = (int) Math
                        .round(-1.0 * Math.sin(THETA2) * (point.x - origin.x) 
                                + Math.cos(THETA2) * (point.y - origin.y))
                                + origin.y;
                point3 = new Point(px, py);
                g.drawLine(point3.x, point3.y, point.x, point.y);
                g.drawLine(point3.x, point3.y, point2.x, point2.y);
            }
        }

        /**
         * <p>
         * When mouse button is pressed down, sets origin point.
         * </p>
         * 
         * @param e
         *            mouse event
         */
        public void mousePressed(MouseEvent e) {
            //System.out.println("Mouse pressed called");
            origin = e.getPoint();
        }

        /**
         * <p>
         * When mouse button is released, let go.
         * </p>
         * 
         * @param e
         *            mouse event
         */
        public void mouseReleased(MouseEvent e) {
            //System.out.println("Mouse released called");

        }

        /**
         * <p>
         * When mouse button is dragged from mouse pressed to it's current
         * position, sets first triangle point.
         * </p>
         * 
         * @param e
         *            mouse event
         */
        public void mouseDragged(MouseEvent e) {
            //System.out.println("Mouse dragged called");
            point = e.getPoint();
            repaint();

        }

        /**
         * <p>
         * When mouse is hovered over the panel.
         * </p>
         * 
         * @param e
         *            mouse event
         */
        public void mouseEntered(MouseEvent e) {
        }

        /**
         * <p>
         * When mouse exits the component.
         * </p>
         * 
         * @param e
         *            mouse event
         */
        public void mouseExited(MouseEvent e) {
        }
        
        /**
         * <p>
         * When mouse is pressed and released.
         * </p>
         * 
         * @param e
         *            mouse event
         */
        public void mouseClicked(MouseEvent e) {
        }

        /**
         * <p>
         * When mouse is moved around JPanel, but no mouse button clicked.
         * </p>
         * 
         * @param e
         *            mouse event
         */
        public void mouseMoved(MouseEvent e) {
        }

    }

    /**
     * <h2>Main</h2>
     * 
     * <p>
     * Point of entry into the program.
     * </p>
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        new DrawTriangle();
    }

};
