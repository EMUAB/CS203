package hw2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class RandomShapeTester {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("HW2 Random Shape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RandomShape r = new RandomShape();
        frame.add(r);
        frame.setVisible(true);
    }
}
