package ufc.l13.files;

import java.io.*;

public class FindFile {

	public static void main(String[] args) throws IOException {
		File progFiles = new File("C:\\Program Files");
		if (!progFiles.exists() || !progFiles.isDirectory()) {
			System.out.println(
				"File does not exist or is not a directory"); 
			return;
		}
		findFile(progFiles, ".exe");
	}

	private static void findFile(File sourceDir, String name) 
			throws IOException {
			File[] childFiles = sourceDir.listFiles(new FileSearcher(name));
			if(childFiles != null) {
				for (int i = 0; i < childFiles.length; i++) {
					if (childFiles[i].isFile()) {
						System.out.println(childFiles[i].getCanonicalPath()); 
					} else { findFile(childFiles[i], name); }
				}	
			}
		}


}

class FileSearcher implements FilenameFilter {
	private String fileName;

	public FileSearcher(String fileName) {
		this.fileName = fileName;
	}

	public boolean accept(File dir, String name) {
		File file = new File(dir, name);
		
		// FileSearcher-ს შევუცვალეთ ლოგიკა და რადგანაც გვინდოდა გვეპოვნა ყველა .exe დაბოლოვებული ფაილი, შევამოწმეთ პირველ რიგში ფაილის დასახელების სიგრძე უნდა ყოფილიყო 4-ზე მეტი, რადგან (.exe) უკვე 4 სიმბოლოს შეიცავს, 
		// შემდეგ კი, substring მეთოდის საშუალებით შევადარეთ (.exe) და ფაილის დასახელების ბოლო 4 სიმბოლო.
		if(name.length() > 4) {
			if (file.isFile() && name.substring(name.length() - 4).equals(fileName)){
				return true;
			}
		}

		if (file.isDirectory()) {
			return true;
		}
		
		return false;
	}
}
