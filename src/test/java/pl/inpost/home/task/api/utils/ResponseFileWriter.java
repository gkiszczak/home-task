package pl.inpost.home.task.api.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.inpost.home.task.api.model.Point;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ResponseFileWriter {

    private static final String DIRECTORY = "target/reports/response/";
    private static final String POINTS_FILE_PATH = DIRECTORY + "parcellockers.%s.json"; 
    
    

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void savePointsToFile(String city, List<Point> points) {
        try {
            File directory = new File(DIRECTORY);
            if (!directory.exists()) {
                  directory.mkdirs();
            }
            String filePath = POINTS_FILE_PATH.formatted(city.toLowerCase());
            File file = new File(filePath);
             objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, points);
            System.out.println("Points saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving points to file: " + e.getMessage());
        }
    }
}