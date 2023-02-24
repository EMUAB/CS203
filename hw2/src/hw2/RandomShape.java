package hw2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.sound.sampled.Line;
import javax.swing.*;

public class RandomShape extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int toDraw = new Random().nextInt(5);
        int length = new Random().nextInt(75) + 25;
        int red = new Random().nextInt(256);
        int green = new Random().nextInt(256);
        int blue = new Random().nextInt(256);
        Color color = new Color(red, green, blue);
        g2.setColor(color);
        int shapeX = new Random().nextInt(500);
        int shapeY = new Random().nextInt(500);
        switch (toDraw) {
            //Square
            case 0:
                Rectangle square = new Rectangle(shapeX, shapeY, 50, 30);
                g2.draw(square);
                break;
            //Circle
            case 1:
                Ellipse2D.Double circle = new Ellipse2D.Double(shapeX, shapeY, 50, 50);
                g2.draw(circle);
                break;
            //Rectangle
            case 2:
                int rectSize = 50;
                Rectangle rect = new Rectangle(shapeX, shapeY, length * 2, length);
                g2.draw(rect);
                break;
            //Equilateral Triangle
            case 3:
                int[] triX = new int[3];
                int[] triY = new int[3];
                for (int i = 0; i < 3; i++) {
                    triX[i] = (int) (shapeX + (length * Math.sin(Math.toRadians(120 * i))));
                    triY[i] = (int) (shapeY + (length * Math.cos(Math.toRadians(120 * i))));
                }
                Polygon triangle = new Polygon(triX, triY, 3);
                g2.draw(triangle);
                break;
            //Regular Pentagon
            case 4:
                int[] pentX = new int[5];
                int[] pentY = new int[5];
                for (int j = 0; j < 5; j++) {
                    pentX[j] = (int) (shapeX + (length * Math.sin(Math.toRadians(72 * j))));
                    pentY[j] = (int) (shapeY + (length * Math.cos(Math.toRadians(72 * j))));
                }
                Polygon pentagon = new Polygon(pentX, pentY, 5);
                g2.draw(pentagon);
                break;
        }
        System.out.printf("Shape %d of n = %d drawn with color (r%d, g%d, b%d) at location (%d, %d)", toDraw, length, red, green, blue, shapeX, shapeY);
    }
}
