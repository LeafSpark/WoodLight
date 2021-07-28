package com.woodlight.graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleRectangle extends JFrame {
    public int x = 0;
    public int y = 0;

    DrawPanel drawPanel = new DrawPanel();

    public SimpleRectangle() {
        Action rightAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                x += 10;
                drawPanel.repaint();
            }
        };

        Action leftAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                x -= 10;
                drawPanel.repaint();
            }
        };

        Action upAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                y -= 10;
                drawPanel.repaint();
            }
        };

        Action downAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                y += 10;
                drawPanel.repaint();
            }
        };


        InputMap inputMap = drawPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = drawPanel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        inputMap.put(KeyStroke.getKeyStroke("UP"), "upAction");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        actionMap.put("rightAction", rightAction);
        actionMap.put("leftAction", leftAction);
        actionMap.put("upAction", upAction);
        actionMap.put("downAction", downAction);

        add(drawPanel);

        setTitle("RectangleDrawing");

        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        this.setIconImage(new ImageIcon(getClass().getResource("/com/woodlight/resources/icon.png")).getImage());
    }

    private class DrawPanel extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 50, 50);
        }

        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }
    }
}
