package ge.ufc.jobs;

import java.io.File;

import java.io.FileWriter;
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

import ge.ufc.figures.Rectangle;
import ge.ufc.figures.Triangle;

public class JobTr implements Job {
    private static final Logger lgg = LogManager.getLogger();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	File file = new File("triangles.json");
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	ArrayList<Triangle> triangles = new ArrayList<>();;
    	double a = Math.random() * 100 + 1;
    	double b = Math.random() * 100 + 1;
    	double c = Math.random() * 100 + 1;
    	Triangle t = new Triangle(a, b, c);
		
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
				triangles = new Gson().fromJson(json, new TypeToken<ArrayList<Triangle>>() {}.getType());
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		}

		triangles.add(t);
		
		String cToJson = gson.toJson(triangles);
		
		lgg.info("Added New Triangle");
		
		try {
			Files.write(Paths.get(file.getPath()), cToJson.getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}
}
