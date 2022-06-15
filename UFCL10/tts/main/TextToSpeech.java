package tts.main;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

	public static void main(String[] args) {
		
		String txt;
		
		txt = "Hello World";
		
		Voice voice;//Creating object of Voice class
        voice = VoiceManager.getInstance().getVoice("kevin");
        if (voice != null) {
            voice.allocate();
            voice.setRate(190);
            voice.setPitch(150);
            voice.setVolume(3);
            
            if(txt == "How are you?") {
            	voice.speak("Fine, what about you?");
            }else if(txt == "How old are you?") {
            	voice.speak("24 Years old");
            }else if(txt == "Can you sing?") {
            	voice.speak("Not yet");
            }else {
            	voice.speak(txt + " | Just repeated your text");
            }
        }

	}

}
