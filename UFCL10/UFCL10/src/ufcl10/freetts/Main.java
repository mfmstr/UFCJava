package ufcl10.freetts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class Main {
	
    public static void speak(String text) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice textaudio;
        textaudio = VoiceManager.getInstance().getVoice("kevin16");
        if (textaudio != null) {
            textaudio.allocate();
        }
        try {
            textaudio.setRate(150);
            textaudio.setPitch(150);
            textaudio.setVolume(6);
           
            
            // თუ ტექსტს წინ მივუწერთ "ten"("keyword")-ს, მაშინ ათჯერ გაიმეორებს "ten"-ის შემდეგ არსებულ ტექსტს.
            if(text.substring(0, 3).equals("ten")) {

        		text = text.substring(3, text.length());
        		
            	for(int i = 0; i < 10; i++) {
            		textaudio.speak(text);
            	}
            }else if(text.equals("minimizeme")) {
            	// თუ გადავცემთ სიტყვა "minimizeme"-ს, იქამდე მოაკლებს ბოლო ასოს და იტყვის, სანამ არ დაცარიელდება.
            	while(text != "") {
            		textaudio.speak(text);
            		text = text.substring(0, text.length() - 1);
            	}
            }else if(text.equals("how are you?")) {
            	text = "fine, what about you?";
            	textaudio.speak(text);
            }else if(text.equals("how old are you?")) {
            	text = "24";
            	textaudio.speak(text);
            }else {
            	textaudio.speak(text);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	speak("tengeometria"); // 10-ჯერ იძახის გეომეტრიას;
    	speak("minimizeme"); // ამცირებს სიტყვა "minimizeme"-ს ბოლოდან, იქამდე სანამ არ დაცარიელდება;
    	speak("how are you?"); // პასუხობს ამ კითხვაზე;
    	speak("how old are you?"); // პასუხობს ასაკს;
    	speak("Liverpool is the best football club in the world"); // პირდაპირ ამბობს ისეთ ტექსტს, რომელზეც რაიმე ფუნქცია არ არის განსაზღვრული.
    }
}