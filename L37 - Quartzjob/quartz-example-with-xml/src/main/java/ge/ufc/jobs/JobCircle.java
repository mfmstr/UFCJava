package ge.ufc.jobs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ge.ufc.figures.Circle;

public class JobCircle implements Job {
    private static final Logger lgg = LogManager.getLogger();
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	File file = new File("circles.json");
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	ArrayList<Circle> circles = new ArrayList<>();;
    	double radius = Math.random() * 100 + 1;
    	Circle c = new Circle(radius);
		
		if(!file.isFile()) {
			try {
			file.createNewFile();
			}
			catch(IOException e) {
				throw new RuntimeException(e);
			}
		}else {
			try {
				String json = Files.readString(Path.of(file.getAbsolutePath()));
				  circles = new Gson().fromJson(json, new TypeToken<ArrayList<Circle>>() {}.getType());
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		}

		circles.add(c);
		
		String cToJson = gson.toJson(circles);
		
		lgg.info("Added New Circle");
		
		try {
			Files.write(Paths.get(file.getPath()), cToJson.getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
}

