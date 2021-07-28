package com.woodlight;

import com.woodlight.annotation.Main;
import com.woodlight.audio.AudioPlayer;
import com.woodlight.datasets.FindNumber;
import com.woodlight.editor.JavaEditor;
import com.woodlight.editor.tools.NoClose;
import com.woodlight.expression.State;
import com.woodlight.graphic.SimpleRectangle;
import com.woodlight.graphic.game.WoodGame;
import com.woodlight.logging.Logger;
import com.woodlight.math.utils.LeafComplex;
import com.woodlight.system.CheckSystem;
import com.woodlight.thread.LightThread;
import com.woodlight.thread.WoodThreadCalls;
import jdk.jfr.*;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.SystemUtils;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

@Main
@Enabled
@Experimental
@Name("WoodLight")
@Registered
@SuppressWarnings(value = "depracation")
@Category("main")
public final class WoodLight extends JFrame implements WindowListener {
    public UUID token = UUID.fromString("00000000-0000-0000-0000-000000000000");
    public LightThread lightThread;
    public State programState;
    public boolean running = true;
    public boolean STACK_TRACES = false;
    public final String[] prefix = {"[WoodLight] ", "[TokenCheck] ", "[ErrorHandler] ", "[LightThread] "};
    public final byte exitState = -1;

    public void generateMap(double[] array, double length) {
        Random random = new Random();
        for (int i = 0; i <= length; i++) {
            array[i] = random.nextDouble();
        }
    }

    public WoodLight() {
        // basic
    }

    public void start_init() {

        System.out.println(Color.GREEN + "Starting WoodLight..." + Color.RESET);
        Logger logger = new Logger();

        try {

            this.setBounds(100, 100, 1000, 600);
            this.setVisible(true);
            this.addWindowListener(this);
            this.setTitle("WoodLight by LeafSpark");

            programState = State.OK;

            // Initializing

            MenuBar menuBar = new MenuBar();

            Menu menu = new Menu("Options");
            Menu menu1 = new Menu("Tools");
            Menu menu2 = new Menu("Misc");

            menuBar.add(menu);
            menuBar.add(menu1);
            menuBar.add(menu2);

            String textAreaText = "WoodLight by LeafSpark. Use the Menu Bar to learn more.\nPrivate tool, so I guess this menu is useless.\nPlease enter your token in the console.";

            TextArea lightTextArea = new TextArea();

            lightTextArea.setVisible(true);
            lightTextArea.setBounds(25, 50, 400, 300);
            lightTextArea.setEditable(false);
            lightTextArea.setText(textAreaText);

            add(lightTextArea);

            CheckSystem checkSystem = new CheckSystem();

            this.setIconImage(new ImageIcon(getClass().getResource("/com/woodlight/resources/icon.png")).getImage());

            Scanner userInputToken = new Scanner(System.in);
            System.out.println("Enter token: ");

            try {
                token = UUID.fromString(userInputToken.nextLine());
            } catch (Exception exception) {
                if (this.STACK_TRACES) {
                    programState = State.ERROR;
                    exception.printStackTrace();
                    this.printStackTrace();
                }
                userInputToken.close();
                invalidTokenEvent();
            }


            InitializationTest initializationTest = new InitializationTest();
            SimpleRectangle simpleRectangle = new SimpleRectangle();
            WoodGame woodGame = new WoodGame();
            JavaEditor javaEditor = new JavaEditor();
            javaEditor.init_java_start();

            System.out.println("WoodRuntime 11 running.");
            run("runtime.exe");

            AudioPlayer audioPlayer = new AudioPlayer();
            Scanner fileInput = new Scanner(System.in);
            System.out.println("Enter music file path: ");
            String audioPath = fileInput.nextLine();
            audioPlayer.startPlayer(audioPath);

            System.out.println("leafCommand v12 started\n");
            while (true) {
                try {
                    Scanner cmd = new Scanner(System.in);
                    String nextLine = cmd.nextLine();
                    exec(nextLine);
                } catch (Exception exception) {
                    break;
                }
            }
        } catch (Exception exception) {
            if (STACK_TRACES) {
                exception.printStackTrace();
            }
            System.out.println("A fatal error has occurred. WoodLight shutting down!");
            System.exit(exitState);
        }
    }

    public void checkUUIDWithArray(String[] uuidArray, UUID token) {
        try {
            for (int i = 0; i <= uuidArray.length; i++) {
                if (uuidArray[i].equals(token.toString())) {
                    InitializationTest initializationTest = new InitializationTest();
                    SimpleRectangle simpleRectangle = new SimpleRectangle();
                    WoodGame woodGame = new WoodGame();
                    JavaEditor javaEditor = new JavaEditor();
                    javaEditor.init_java_start();

                    run("runtime.exe");
                }
            }
        } catch (Exception exception) {
            if (this.STACK_TRACES = true) {
                exception.printStackTrace();
                this.printStackTrace();
            } else {
                System.out.println(Color.RED + "The token checker ran into a unknown error.\nError: " + exception.getMessage());
            }
        }

    }

    public void UUIDFileCheck(String token) {
        try {
            File file = new File("token_keys.ini");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            String[] uuidFile = {""};
            int amountRead = 0;
            while ((line = bufferedReader.readLine()) != null) {
                uuidFile[amountRead] = String.valueOf(stringBuffer.append(line));
                stringBuffer.append("\n");
                amountRead++;
            }
            fileReader.close();
            checkArrayUUID(uuidFile, token);
        } catch (IOException exception) {
            if (this.STACK_TRACES = true) {
                exception.printStackTrace();
                this.printStackTrace();
            }
            System.out.println(Color.RED + "The file checker ran into a unknown error.\nError: " + exception.getMessage());
        }
    }

    public void checkArrayUUID(String[] uuidArray, String token) {
        boolean validUUID = false;
        boolean invalidUUID = false;
        try {
            checkUUIDWithArray(uuidArray, UUID.fromString(token));
        } catch (Exception exception) {
            if (this.STACK_TRACES = true) {
                exception.printStackTrace();
                this.printStackTrace();
            }
            if (invalidUUID = true) {
                System.out.println("Something's wrong with the config file! Please download the program again.");
                System.exit(0);
            }
            invalidUUID = true;
            System.out.println("Something's wrong with the config file! Please download the program again.");
        }
    }

    public void run(String file) throws IOException {

        try {
            Runtime runtimeBuilder = Runtime.getRuntime();
            Process process = runtimeBuilder.exec(SystemUtils.getUserDir() + "\\" + file);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String output = null;

            OutputStream outputStream = process.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            System.out.println(Color.YELLOW + "--------------------------------------------------------------" + Color.RESET);

            while ((output = stdInput.readLine()) != null) {
                System.out.println(output);
            }

            System.out.println(Color.YELLOW + "--------------------------------------------------------------" + Color.RESET);
        } catch (Exception exception) {
            if (this.STACK_TRACES = true) {
                exception.printStackTrace();
                this.printStackTrace();
            }
        }
    }

    public void exec(String command) throws IOException {

        try {
            Runtime runtimeBuilder = Runtime.getRuntime();
            Process process = runtimeBuilder.exec("leafexec.exe " + command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String output = null;

            OutputStream outputStream = process.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            while ((output = stdInput.readLine()) != null) {
                System.out.println(output);
            }
        } catch (Exception exception) {
            if (this.STACK_TRACES = true) {
                exception.printStackTrace();
                this.printStackTrace();
            }
        }
    }


    public void invalidTokenEvent() throws InterruptedException {
        System.out.println(Color.RED + prefix[1] + "Invalid token/UUID!");
        for (int i = 1; i <= 3; i++) {
            if (i == 3) {
                System.out.println(Color.RED + prefix[0] + "Exiting in 1 second");
            }
            if (i == 2) {
                System.out.println(Color.RED + prefix[0] + "Exiting in 2 seconds");
            }
            if (i == 1) {
                System.out.println(Color.RED + prefix[0] + "Exiting in 3 seconds");
            }
            Thread.sleep(1000);
        }
        System.exit(-1);
    }

    public void printStackTrace() {
        System.out.println("\n" + Color.BLUE_UNDERLINED + "WoodLight Stack Trace:");
        programState = State.WARN;
        boolean runstate = this.running;
        boolean active = this.isActive();
        System.out.println("---------------------------");
        System.out.println("Running = " + runstate);
        System.out.println("Active = " + active);
        System.out.println("-----System Info-----------");
        System.out.println(System.getProperties());
        System.out.println("---------------------------");
    }

    public void differentRun() {}

    public void initConfig() throws IOException {
        File file = new File("config.ini");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        ArrayList<String> config = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            config.add(line);
        }
        configOptions(config);
        fileReader.close();
    }

    public void configOptions(ArrayList<String> config) throws IOException {
        if (config.get(2).equals("stacktraces = 0")) {
            STACK_TRACES = false;
        } else if (config.get(2).equals("stacktraces = 1")) {
            STACK_TRACES = true;
        } else {
            throw new IOException("Config file options not found. Make sure that the config file is not damaged.");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException, ClassNotFoundException {
        WoodLight light = new WoodLight();
        light.differentRun();
        light.start_init();
        light.initConfig();
        WoodThreadCalls threadCalls = new WoodThreadCalls();
        try {
            if (args[1].equals("--stacktraces")) {
                light.STACK_TRACES = true;
            }
        } catch (Exception exception) {
            WoodLight light2 = new WoodLight();
            WoodThreadCalls threadCalls2 = new WoodThreadCalls();
            light.start_init();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("WoodLight started.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        running = false;
        System.out.println("WoodLight stopping!");
        Runtime.getRuntime().halt(0);
    }


    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public final long average(long[] array) {
        double temp = 0D;
        for (int i = 0; i <= array.length; i++) {
            temp = temp + array[i] + array[i + 1];
        }
        return (long) (temp / array.length);
    }
}
