package ufc.l27.main;

public class FacialEmotion {
	private String eyebrows;
	private String mouth;
	
	public FacialEmotion(String eyebrows, String mouth) {
		this.eyebrows = eyebrows;
		this.mouth = mouth;
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
	@Override
	public String toString() {
		return "FacialEmotion [eyebrows=" + eyebrows + ", mouth=" + mouth + "]";
	}

	public void setMouth(String mouth) {
		this.mouth = mouth;
	}
	
	
}
