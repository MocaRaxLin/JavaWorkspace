import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


public class MidiPlayer {
	private File midiFile;
	private Sequence sequence;
	private Sequencer sequencer;
	private int loopTimes;
	public MidiPlayer(String setMidiSoundPath,int setLoopTimes){
		midiFile = new File(setMidiSoundPath);
		loopTimes = setLoopTimes;
	}
	public void play(){
		try {
			sequence = MidiSystem.getSequence(midiFile);
		} catch (InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		}
		
		// Create a sequencer for the sequence
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		//plating times (insert 0 = play 1 times,-1 = keep looping)
        sequencer.setLoopCount(loopTimes);
        
		// Start playing
        sequencer.start();
        
        //setEnding
        if(loopTimes>=0){
        while(true){
        	if(sequencer.getMicrosecondPosition() == sequence.getMicrosecondLength()){
        		if(loopTimes == 0){
        		this.stop();
        		System.out.println("stoped");
            	break;
        		}else{
        			loopTimes--;
        			System.out.println(loopTimes);
        			
        		}
        	}
        }
        }
        
	}
	public void stop(){
		sequencer.stop();
		sequencer.close();
	}
}