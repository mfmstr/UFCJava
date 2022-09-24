package ge.ufc.jobs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ge.ufc.figures.Rectangle;

public class JobRect implements Job {
    private static final Logger lgg = LogManager.getLogger();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	File file = new File("rectangles.json");
		
		
		if(!file.isFile()) {
			try {
			file.createNewFile();
			}
			catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		double a = Math.random() * 100 + 1;
		double b = Math.random() * 100 + 1;
		
		Rectangle r = new Rectangle(a, b);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String rToJson = gson.toJson(r);
		
		lgg.info("Added New Rectangle");
		
		try {
			Files.write(Paths.get(file.getPath()), rToJson.getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
}
