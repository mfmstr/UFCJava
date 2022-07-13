package ufc.l16.main;

public class InvalidUserOrPasswordException extends Exception{
	public InvalidUserOrPasswordException() {
		System.err.print("Dafiksirda usernamis an parolis araswori formati");
	}
}
