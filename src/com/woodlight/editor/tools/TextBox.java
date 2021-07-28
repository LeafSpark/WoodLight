package com.woodlight.editor.tools;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
@Deprecated
public class TextBox extends Frame implements WindowListener {

    public TextBox() {
        this.setVisible(true);
        this.setBounds(300, 300, 700, 500);
        this.addWindowListener(this);
        TextArea textArea = new TextArea();
        textArea.setBounds(10, 10, 120, 85);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
