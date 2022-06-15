package tts.main;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

	public static void main(String[] args) {
		
		String txt;
		
		txt = "Hello World";
		
		Voice voice;
        voice = VoiceManager.getInstance().getVoice("kevin");
        if (voice != null) {
            voice.allocate();
            voice.setRate(190);
            voice.setPitch(150);
            voice.setVolume(3);

            if(txt.substring(0, 3) == "ten"){  // tu sitkvas win mivuwert ten(keyword)-s voices gamoidzaxebs 10jer;
                txt = txt.substring(3, txt.length());
                for(int i = 0; i < 10; i++){
                    voice.speak(txt);
                }
            }elseif(txt == "sheamokle"){
                while(txt != ""){
                    txt = txt.substring(0, txt.length() - 1); // kovel sitkvas moaklebs bolo asos sanam ar gaxdeba carieli;
                }
            }else{
            
            if(txt == "How are you?") {
            	voice.speak("Fine, what about you?"); // am kitxvebze pasuxobs
            }else if(txt == "How old are you?") {
            	voice.speak("24 Years old");
            }else if(txt == "Can you sing?") {
            	voice.speak("Not yet");
            }else {
            	voice.speak(txt + " | Just repeated your text");
            }
        }

            voice.dellocate();

        }

	}

}
