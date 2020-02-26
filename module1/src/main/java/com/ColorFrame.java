package com;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

//@Component
public class ColorFrame extends JFrame {
    // @Autowired
    private Color color;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        Random rand = new Random();
        getContentPane().setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
