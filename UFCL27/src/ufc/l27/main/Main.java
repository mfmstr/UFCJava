package ufc.l27.main;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Choose Eyebrows from: upward, downward, raised, neutral");
		
		Scanner sc = new Scanner(System.in);
		
		String resEyebrows = sc.nextLine();
		
		while(true) {
			if("upward".equals(resEyebrows)) {
				break;
			}else if("downward".equals(resEyebrows)) {
				break;
			}else if("raised".equals(resEyebrows)) {
				break;
			}else if("neutral".equals(resEyebrows)) {
				break;
			}else {
				System.out.println("Incorrect Input. Select From Words Above.");
				resEyebrows = sc.nextLine();
			}
		}
		

		System.out.println("Choose Mouth from: smile, frown, laugh, neutral");
		
		String resMouth = sc.nextLine();
		
		while(true) {
			if("smile".equals(resMouth)) {
				break;
			}else if("frown".equals(resMouth)) {
				break;
			}else if("laugh".equals(resMouth)) {
				break;
			}else if("neutral".equals(resMouth)) {
				break;
			}else {
				System.out.println("Incorrect Input. Select From Words Above.");
				resMouth = sc.nextLine();
			}
		}
		
		FacialEmotion fe = new FacialEmotion(resEyebrows, resMouth);
		
		System.out.println(serialize(fe));
		
		System.out.println(deserialize(serialize(fe)));
		
		System.out.println(SerializeRec(deserialize(serialize(fe))));
	}
	
	public static String serialize(FacialEmotion feo) {
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		Gson gson = gb.create();
		String JString = gson.toJson(feo);
		return JString;
	}
	
	public static FacialEmotionRecognized deserialize(String JString) {
		Gson gson = new Gson();
		FacialEmotion fe = gson.fromJson(JString, FacialEmotion.class);
		
		String eye = fe.getEyebrows();
		String mouth = fe.getMouth();
		String emotion;
		
		if(eye.equals("upward") && mouth.equals("smile")) {
			emotion = "Happy Smile";
		}else if(eye.equals("upward") && mouth.equals("frown")) {
			emotion = "Displeasure Smile";
		}else if(eye.equals("upward") && mouth.equals("laugh")) {
			emotion = "On Funny Mood";
		}else if(eye.equals("upward") && mouth.equals("neutral")) {
			emotion = "Surprised";
		}else if(eye.equals("downward") && mouth.equals("smile")) {
			emotion = "Devil Smile";
		}else if(eye.equals("downward") && mouth.equals("frown")) {
			emotion = "Angry";
		}else if(eye.equals("downward") && mouth.equals("laugh")) {
			emotion = "Fake Laugh";
		}else if(eye.equals("downward") && mouth.equals("neutral")) {
			emotion = "Sad";
		}else if(eye.equals("raised") && mouth.equals("smile")) {
			emotion = "Dreaming";
		}else if(eye.equals("raised") && mouth.equals("frown")) {
			emotion = "Badly Surprised";
		}else if(eye.equals("raised") && mouth.equals("laugh")) {
			emotion = "Hearing good jokes";
		}else if(eye.equals("raised") && mouth.equals("neutral")) {
			emotion = "Thinking...";
		}else if(eye.equals("neutral") && mouth.equals("smile")) {
			emotion = "Fake Smile";
		}else if(eye.equals("neutral") && mouth.equals("frown")) {
			emotion = "On a bad MOOD";
		}else if(eye.equals("neutral") && mouth.equals("laugh")) {
			emotion = "Kinda Happy";
		}else if(eye.equals("neutral") && mouth.equals("neutral")) {
			emotion = "Neutral";
		}else {
			emotion = "Unknown Emotion";
		}
		
		FacialEmotionRecognized res = new FacialEmotionRecognized(eye, mouth, emotion);
		return res;
		
	}
	
	public static String SerializeRec(FacialEmotionRecognized fer) {
		
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		Gson gson = gb.create();
		
		return gson.toJson(fer);
		
	}
	
}
