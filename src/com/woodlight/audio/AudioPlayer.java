package com.woodlight.audio;

import com.woodlight.WoodLight;
import org.apache.commons.lang3.ClassUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {

    Long currentFrame;
    Clip clip;

    String status;

    AudioInputStream audioInputStream;
    static String file;

    public void startPlayer(String filePath) {
        try {

            clip = AudioSystem.getClip();

            clip.loop(Clip.LOOP_CONTINUOUSLY);

            file = filePath;

            audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());

            clip.open(audioInputStream);

            this.play();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Pause");
                System.out.println("2. Resume");
                System.out.println("3. Restart");
                System.out.println("4. Exit");
                System.out.println("5. Jump to specific time");
                int choice = scanner.nextInt();
                this.gotoChoice(choice);
                if (choice == 4) {
                    break;
                }
            }
            scanner.close();
        } catch (Exception exception) {
            System.out.println("[AudioPlayer] Error with playing sound!");
            WoodLight woodLight = new WoodLight();
            if (woodLight.STACK_TRACES) {
                exception.printStackTrace();
            }
        }
    }

    private void gotoChoice(int choice) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (choice) {
            case 1 -> pause();
            case 2 -> resumeAudio();
            case 3 -> restart();
            case 4 -> stop();
            case 5 -> {
                System.out.println("Enter time (" + 0 + ", " + clip.getMicrosecondLength() + ")");
                Scanner scanner = new Scanner(System.in);
                long c1 = scanner.nextLong();
                jump(c1);
            }
        }
    }

    public void play() {
        clip.start();

        status = "play";
    }

    public void pause() {
        if (status.equals("paused")) {
            System.out.println("Audio is already paused!");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already being played!");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void jump(long c) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        if (c > 0 && c < clip.getMicrosecondLength()) {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
