package sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Recorder {

			String file_path="/OOP.DSAI.20212.12/resources/audio/RecordAudio.wav";
			File wavFile = new File(file_path);
			

			AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
			

			TargetDataLine line;
			AudioFormat getAudioFormat() {
			    float sampleRate = 16000;
			    int sampleSizeInBits = 8;
			    int channels = 1;
			    boolean signed = true;
			    boolean bigEndian = true;
			    AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
			                                         channels, signed, bigEndian);
			    return format;
			}
			void start() {
			    try {
			        AudioFormat format = getAudioFormat();
			        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			
			        if (!AudioSystem.isLineSupported(info)) {
			            System.out.println("Line not supported");
			            System.exit(0);
			        }
			        line = (TargetDataLine) AudioSystem.getLine(info);
			        line.open(format);
			        line.start();   
			
			        AudioInputStream ais = new AudioInputStream(line);
			
			        System.out.println("Start recording...");
			
			        
			        AudioSystem.write(ais, fileType, wavFile);
			
			    } catch (LineUnavailableException ex) {
			        ex.printStackTrace();
			    } catch (IOException ioe) {
			        ioe.printStackTrace();
			    }
			}
			public void finish() {
			    line.stop();
			    line.close();
			    System.out.println("Finished");
			}
			public void begin() {
					
			  Thread stopper = new Thread(new Runnable() {
			        public void run() {
			        	start();
			        }
			    });
			  stopper.start();
			}
			public static void main(String[] args) {
				Recorder recorder = new Recorder();

				recorder.begin();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				recorder.finish();
				recorder.play();
				
				
			}
			public void play() {
		        File sound = new File(file_path);

		        try {
		            AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
		            Clip c = AudioSystem.getClip();
		            c.open(ais); 
		            System.out.println("Playing");
		            c.start(); 

		            Thread.sleep((int)(c.getMicrosecondLength() * 0.001));
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }

			  }
			}
