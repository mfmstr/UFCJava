package ufc.l27.main;

public class FacialEmotionRecognized {
	private String eyebrows;
	private String mouth;
	private String emotion;
	
	@Override
	public String toString() {
		return "FacialEmotionRecognized [eyebrows=" + eyebrows + ", mouth=" + mouth + ", emotion=" + emotion + "]";
	}

	public FacialEmotionRecognized(String eyebrows, String mouth, String emotion) {
		this.eyebrows = eyebrows;
		this.mouth = mouth;
		this.emotion = emotion;
	}
	
	public String getEyebrows() {
		return eyebrows;
	}
	public void setEyebrows(String eyebrows) {
		this.eyebrows = eyebrows;
	}
	public String getMouth() {
		return mouth;
	}
	public void setMouth(String mouth) {
		this.mouth = mouth;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
}
