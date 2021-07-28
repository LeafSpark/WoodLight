package com.woodlight.editor;

import com.woodlight.editor.Info;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
@Deprecated
public class InfoFrame extends JDialog implements WindowListener {
    public int OpenedTimesFrame = 0;
    public int ClosedTimesFrame = 0;


    public InfoFrame(Info infoCL) {
        infoCL.start();
        this.setVisible(true);
        this.setBounds(200, 200, 500, 500);
        this.addWindowListener(this);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setTitle("Info Menu");
        TextArea label = new TextArea();
        add(label);
        label.setBounds(30, 30, 60, 45);
        label.setText("Times Opened: " + infoCL.OpenedTimes + "\nTimes Closed: " + infoCL.ClosedTimes + "\nMemory: NOT COMING SOON!");
        label.setEditable(false);
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
