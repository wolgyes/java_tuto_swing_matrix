package visuals.panels;

import visuals.MainGUI;
import visuals.templates.buttons.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

public class HeaderPanel extends JPanel implements MouseListener, MouseMotionListener {

    private final MainGUI core;

    private boolean isMousePressed = false;
    private Point lastPosition;

    /**
     * Header panel constructor
     */
    public HeaderPanel(MainGUI core, int x, int y, int width, int height) {
        super();

        setBounds(x, y, width, height);
        this.core = core;

        // Set the layout
        setLayout(null);

        // Initialize the components
        initializeComponents();

        // Mouse Listeners for dragging the window
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * Initialize the components of the GUI
     */
    private void initializeComponents(){
        // Set the title to the left side of the panel
        JLabel title = new JLabel("Ortogonálisok");
        title.setBounds(5, 0, 200, 30);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // Set the close button to the right side of the panel
        MyButton closeButton = new MyButton("X", getWidth() - 30, 0, 30, 30);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.addActionListener(e -> {
            // Ask it, really want to close?
            int answer = JOptionPane.showConfirmDialog(MainGUI.getInstance(), "Are you sure you want to close the program?", "Close", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                // Close the program
                System.exit(0);
            }
        });
        add(closeButton);

        // Set the minimize button to the right side of the panel
        MyButton minimizeButton = new MyButton("-", getWidth() - 60, 0, 30, 30);
        minimizeButton.setFont(new Font("Arial", Font.BOLD, 14));
        minimizeButton.addActionListener(e -> {
            // Minimize the program
            MainGUI.getInstance().setState(JFrame.ICONIFIED);
        });
        add(minimizeButton);

        // Set the background color
        setBackground(new Color(34, 76, 245));
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        isMousePressed = true;
        lastPosition = e.getLocationOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        if (isMousePressed) {
            Point currentPosition = e.getLocationOnScreen();

            int x = currentPosition.x - lastPosition.x;
            int y = currentPosition.y - lastPosition.y;

            core.setLocation(core.getX() + x, core.getY() + y);

            lastPosition = currentPosition;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
