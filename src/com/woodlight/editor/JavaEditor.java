package com.woodlight.editor;

/*

  Documentation:
    This program is a starter program like MS Notepad. It's similar but with the purpose
of helping people to learn Java and AWT lib. There are many comments designed to help you learn the purpose
of each line of Java code. It is recommended to read the Java wiki before continuing to the code part of this starter program.
There is no guarantee that this will work if modified. Use at your own risk. The Java version this program is built on is
Java 1.15.0_01 (15). That means you will have to get the JDK of Java 15 not the Java SE versions or the "Standard Edition".
The JDK is the Java Development Kit which will help you program your first Java programs. It is also recommended to use the
latest version of Java.

  This second part is about installation of this simple Notepad like program. Go to https://www.jetbrains.com/idea/download and
download the latest version of IntelliJ IDEA. At the time of writing the latest version is 2020.3.1. After you have installed IntelliJ
IDEA, select Create New Project. Select Java and click OK. Then click OK again and you will be directed to a page that you can setup your
project such as the name and directory. After you have chosen the appropriate settings click OK. Go to the project directory and
copy and paste this .java file in to the src folder. After you have done that go back into IntelliJ IDEA and you should see
JavaEditor.java in your src folder. Go and double click it and the file will open. That's all for this part!



    Java Docs:

    1. The Basics
        First you must understand what are Java classes. They are created by doing public class <class name> {********}. After you have created a Java class, there will be a built in Java library called java.*. Using the built in Java library
we can create basic Java programs that print words. First try creating a Java program with the following lines: 1. public class <your file name> 2. public static void main(String args[]) {} and inside the brackets type System.out.println("Hello World!").
Now build it using the build option on the top bar. Click "Build Project" and then wait for it to build. After it has done building click the green run button on the right hand side. You should see inside the console that the words Hello World!
has been printed. The System library is a built in library in the Java library. It contains stuff like print or other things that you can do in the console. Next we are going to learn about the AWT package which is much more complicated.
The AWT package needs to be imported unlike the System package. You can import it by typing these lines of code in your 1st line: import java.awt.*. The * symbol is there so we don't have to import every single class of the AWT package.
Next we are going to learn some of the AWT code. AWT has something called a Frame or another word for Window. You have to add this line to your import line which should look like this: public class <your file name> extends Frame. That creates a Frame.
A Frame is basically a Window in Java. You can program a Button into the Frame or a TextBox into the Frame as everything is in the Frame, which makes the Frame extremely important. There are many things in the AWT Graphics Package. You can create a
colorful background or some colored and beautiful buttons and objects in the Frame.

    2. The Swing Package
        The Swing package is a more modern version of the AWT Package. It has several more features and much more frame types and objects. One example is the Tab. I'm sure many of you have heard of a tab too. It's basically the same in Swing.
Although I don't know too much about Swing, you also need to import it with javax: import javax.swing.*. A Frame is called a Frame in AWT, but in the Swing library, it's called a JFrame. The button is also called a JButton too! It's the same thing
as in AWT. So it's JButton b = new JButton! Also you need to make it visible too and change it's x, y, z. Things are similar in Swing but just with different names. There are many more objects in Swing and AWT that this guide can't cover them alL!
There are more advanced version of these graphic APIs like DirectX 12 and OpenGL and OpenCL but they are much more harder to learn.

 */

import com.woodlight.editor.*;
import com.woodlight.editor.tools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Deprecated
public class JavaEditor extends Frame implements WindowListener, ComponentListener, ActionListener {
    public TextArea area;
    public Info infoCL;

    public JavaEditor() {
        infoCL = new Info();
    }

    public void init_java_start() {
        File theDir = new File("c:/users/chenx/Downloads/javaeditor");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        setTitle("JavaEditor");
        addWindowListener(this);
        addComponentListener(this);
        setSize(1600, 1000); //setting window size using setSize from java.awt.*
        setLayout(null); //null = no layout
        setVisible(true); //true/false bool      ---    toggle
        /*
        setBackground(Color.null);
        Set the background
         */
        area = new TextArea(""); //replace with wat u want when u start, not recommended as can interfere with other classes/functions
        add(area); // Add Large TextArea AWT
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("File"); //menu bar --- def: the bar at the top
        //Menu Config
        //add some more menu items if needed

        MenuItem i1 = new MenuItem("Debug"); //Menu ITEM
        MenuItem i2 = new MenuItem("New Window"); //Menu ITEM
        MenuItem i3 = new MenuItem("Open"); //Menu ITEM                     //Menu items from java.awt
        MenuItem i4 = new MenuItem("Save"); //Menu ITEM
        MenuItem i5 = new MenuItem("Force Close"); //Menu ITEM
        MenuItem i6 = new MenuItem("Settings");//Menu ITEM
        MenuItem i7 = new MenuItem("Safe Mode");//Menu ITEM
        MenuItem info = new MenuItem("Info"); //Menu ITEM
        MenuItem newFrame = new MenuItem("New Frame");
        menu.add(i1); //add menu ITEM1
        menu.add(i2); //add menu ITEM2
        menu.add(i3); //add menu ITEM3
        menu.add(i4); //add menu ITEM4
        menu.add(i5); //add menu ITEM5
        menu.add(i6); //add menu ITEM6
        menu.add(i7); //add menu ITEM7
        menu.add(info);
        menu.add(newFrame);
        mb.add(menu);
        setMenuBar(mb);
        /*
        Menu Listeners
        example= i?.addActionListener(??? or THIS)

         */
        i4.addActionListener(this); //import listener
        i3.addActionListener(this); //import listener
        i2.addActionListener(this); //import listener
        i5.addActionListener(this); //import listener
        i6.addActionListener(this); //import listener
        i7.addActionListener(this); //import listener
        i1.addActionListener(this); //import listener
        newFrame.addActionListener(this);
        info.addActionListener(this);
        ThreadDebug d = new ThreadDebug();
        d.start();


        // TODO Events; JavaEditorEvents

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);   //CLOSE
        //System.out.println("ERROR WITH CLOSING"); //Ignore
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        //debug line
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //Some Function or etc.
        //System.out.println("Working Function"); //debug line
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //System.out.println("Working Function"); //debug line
        //Some Function or etc.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {
        try {
            area.setBounds(10, 50, getWidth() - 20, getHeight() - 80); //Size and XY of dynamic resizing
        } catch (Exception exception) {
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        //debug line
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "New Frame") {
            NewFrame frame = new NewFrame();
        }
        if (e.getActionCommand() == "Info") {
            InfoFrame inframe = new InfoFrame(infoCL);
        }
        if (e.getActionCommand() == "Settings") {
            Setting newset = new Setting(); //new instance of this program aka new tab
        }
        if (e.getActionCommand() == "Force Close") {
            //Force "Close"
            dispose();
            System.out.println("Did not Stop? Trying 1/8"); //try 1
            System.exit(0);
            System.out.println("Did not Stop? Trying 2/8"); //try 2
            System.exit(0);
            System.out.println("Did not Stop? Trying 3/8"); //try 3
            System.exit(0);
            System.out.println("Did not Stop? Trying 4/8"); //try 4
            System.exit(0);
            System.out.println("Did not Stop? Trying 5/8"); //try 5
            System.exit(0);
            System.out.println("Did not Stop? Trying 6/8"); //try 6
            System.exit(0);
            System.out.println("Did not Stop? Trying 7/8"); //try 7
            System.exit(0);
            System.out.println("Error with Stopping! Try 8/8"); //final try 8/8 === ERROR SHUTDOWN
            System.out.println("Stopping Debug");
            //End//
        }
        if (e.getActionCommand() == "Safe Mode") {
            NewDebugTab newin = new NewDebugTab(); //new instance of this program aka new tab

        }
        if (e.getActionCommand() == "New Window") {
            JavaEditor newins = new JavaEditor(); //new instance of this program aka new tab

        }

        if (e.getActionCommand() == "Open") {
            //lol test alpha --

            // Open Dialog
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            }
            // do something


            //Scanner object for File "(Java)Class "READ"
            try {
                File myObj = chooser.getSelectedFile(); //create a new file at this path
                Scanner myReader = new Scanner(myObj); //create a scanner object
                String filetext = ""; //leave this empty otherwise file wont save
                while (myReader.hasNextLine()) {
                    filetext = filetext + myReader.nextLine() + "\n"; //keep putting spaces after reading the lines of the file
                }
                area.setText(filetext); //loads the text in memory
                myReader.close(); //close reader
            } catch (FileNotFoundException ed) {
                System.out.println("An error occurred."); //can't read file so outputs a ERROR
                //Error
            }
        }

        if (e.getActionCommand() == "Save") {
            // save file
            try {
                setTitle("JavaEditor");
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    // do something
                }
                File myObj = chooser.getSelectedFile(); //creates a new file in memory
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName()); //some line to tell u it worked
                } else {
                    System.out.println("File already exists."); //the file is still there
                }
                FileWriter myWriter = new FileWriter(myObj.getPath()); //writing to the file
                myWriter.write(area.getText()); //gets the text
                myWriter.close(); //closes
                System.out.println("Successfully wrote to the file."); //write successful
            } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.out.println("An error occurred.");
            }
            //error in writing process
            System.out.println("Error with writing, try again later");
        }
    }
}
