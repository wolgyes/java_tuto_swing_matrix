package visuals.templates.buttons;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    /**
     * Button constructor
     */
    public MyButton(String text, int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setText(text);
        setBackground(new Color(34, 76, 245));
        setForeground(Color.white);
        setFont(new Font("Arial", Font.BOLD, 20));

        setBorder(null);
    }
}
