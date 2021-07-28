package com.woodlight.editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
@Deprecated
public class Info extends Thread {
    public int OpenedTimes;
    public int ClosedTimes;

    @Override
    public void run() {
        while (true) {
            try {
                File myObj = new File("c:\\Users\\chenx\\JavaEditorConfig.config");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName()); //some line to tell u it worked
                } else {
                    System.out.println("File already exists."); //the file is still there
                }
                FileWriter myWriter = new FileWriter(myObj.getPath()); //writing to the file
                String fileSource = "timesOpened: " + OpenedTimes + "\ntimesClosed: " + ClosedTimes + "\nlastFile: ";
                myWriter.write(fileSource);
                myWriter.close(); //closes
                System.out.println("Successfully wrote to the file."); //write successful
            } catch (IOException exception) {
                System.out.println("An error occurred. " + exception.getMessage());
                exception.printStackTrace();
            }
        }
        //error in writing process
    }
}
