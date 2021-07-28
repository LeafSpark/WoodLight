package com.woodlight.editor;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
@Deprecated
public class NewDebugTab extends Frame implements WindowListener {
    public TextArea xxx;

    public NewDebugTab() {
        System.out.println("Setting Working +++++");
        setTitle("JavaEditor(Safe Mode)");
        setSize(400, 400);
        setVisible(true);
        TextArea xxx = new TextArea("SAFE|MODE");
        xxx.setBounds(50, 100, 150, 30);
        setBackground(Color.BLUE);
        add(xxx);
        addWindowListener(this);
        Menu men = new Menu("TOOL");
        MenuBar mbx = new MenuBar();
        MenuItem i1 = new MenuItem("PRINT TEXT");
        men.add(i1);
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

