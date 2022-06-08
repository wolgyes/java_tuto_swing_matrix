package visuals;

import visuals.panels.HeaderPanel;
import visuals.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    private static MainGUI instance;

    /**
     * Creates new form MainGUI
     * @param width width of the window
     * @param height height of the window
     */
    public MainGUI(int width, int height){
        instance = this;

        // Set the dimensions
        Dimension windowSize = new Dimension(width, height);
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());

        // Calculate and set the startup location (at center of the screen)
        int windowX = (screenSize.width - windowSize.width) / 2;
        int windowY = (screenSize.height - windowSize.height) / 2;

        setBounds(windowX, windowY, windowSize.width, windowSize.height);
        setLayout(null);

        // Default close operations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Remove any decorator
        setUndecorated(true);

        // Call the init method for the GUI elements
        initializeComponents();
    }

    /**
     * Initialize the components of the GUI
     */
    private void initializeComponents() {
        HeaderPanel headerPanel = new HeaderPanel(this,0, 0, getWidth(), 30);
        add(headerPanel);

        MainPanel mainPanel = new MainPanel(0, 30, getWidth(), getHeight() - 30);
        add(mainPanel);
    }

    public static MainGUI getInstance(){
        return instance;
    }
}
