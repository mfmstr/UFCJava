package ge.ufc.jobs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ge.ufc.figures.Circle;

public class JobCircle implements Job {
    private static final Logger lgg = LogManager.getLogger();
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	File file = new File("circles.json");
		
		
		if(!file.isFile()) {
			try {
			file.createNewFile();
			}
			catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		double radius = Math.random() * 100 + 1;
		
		Circle c = new Circle(radius);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String cToJson = gson.toJson(c);
		
		lgg.info("Added New Circle");
		
		try {
			Files.write(Paths.get(file.getPath()), cToJson.getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
}

