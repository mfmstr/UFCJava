package ufc.l13.files;

import java.io.File;
import java.io.IOException;
public class FindAllFiles {
    public static void main(String[] args) throws IOException {
    	// მოცემული კოდი ბეჭდავს მითითებული დირექტორიის ყველა ფოლდერისა თუ ფაილის დასახელებას და მისამართს. ასევე ამოწმებს საწყისი დირექტორიის რეალურობას და არ არსებობის შემთხვევაში გამოაქვს შესაბამისი შეტყობინება.
        File currentDir = new File("C:\\Program Files");
        if(currentDir.isDirectory()) {
        System.out.println("Tavdapirveli misamarti: " + currentDir.getAbsolutePath());
        String[] files = currentDir.list();
        for (int i = 0; i < files.length; i++) {
            File dirItem = new File(currentDir, files[i]);            
            System.out.print(dirItem.getAbsolutePath());
            System.out.print(" - ");
            System.out.print(dirItem.getCanonicalPath());
            System.out.print(" - ");
            if (dirItem.isDirectory()) {
                System.out.println(" | direqtoria");
            }
            if (dirItem.isFile()) {
                System.out.println(" | faili");                
            }
        }
        }else {
        	System.out.println("mititebuli direqtoria ar arsebobs");
        }
    }
}

