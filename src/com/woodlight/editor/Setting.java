package com.woodlight.editor;

import java.awt.*;
import java.awt.event.*;
@Deprecated
public class Setting extends Frame implements WindowListener, ActionListener, ComponentListener {
    public TextArea text;

    public Setting() {
        System.out.println("Setting Working +++++");
        setTitle("Settings");
        setSize(400, 400);
        setVisible(true);
        addWindowListener(this);
        addComponentListener(this);
        Button settingButton = new Button("Select Save Destination");
        settingButton.setBounds(50, 100, 150, 30);
        add(settingButton);
        setLayout(null);
        TextArea text = new TextArea("Input Destination");
        add(text);
        text.setBounds(20, 50, 250, 50);
        settingButton.addActionListener(this);
        Button bb = new Button("SAFE MODE");
        bb.setBounds(20, 70, 150, 30);
        bb.setVisible(true);
        System.out.println(getCursor());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Select Save Destination") {
            System.out.println("select save clicked");
            String str = text.getText();
            System.out.println(str);
        }
    }


    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
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
