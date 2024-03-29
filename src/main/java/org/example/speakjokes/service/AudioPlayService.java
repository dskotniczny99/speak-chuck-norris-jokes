package org.example.speakjokes.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@Service
@Slf4j
public class AudioPlayService {

    private static final int BUFFER_SIZE = 4096;

    public void play(InputStream inputStream ) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            log.info("Playback Started.");

            byte[] bufferBytes = new byte[BUFFER_SIZE];
            int readBytes = -1;
            while ((readBytes = audioStream.read(bufferBytes)) != -1) {
                sourceDataLine.write(bufferBytes, 0, readBytes);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            audioStream.close();

            log.info("Playback has been finished.");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            log.info("Error occured during playback process:" + ex.getMessage());
        }
    }
}
