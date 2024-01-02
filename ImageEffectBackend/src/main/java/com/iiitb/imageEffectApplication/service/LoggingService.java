package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.model.LogModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LoggingService {

    //LogModelRepository to access the database and perform operations on the table present over there
    @Autowired
    LogModelRepository logModelRepository;


    public LoggingService() {}

    //Function to add a log (a row) to the table to the H2 database
    public void addLog(String fileName, String effectName, String optionValues) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = dtf.format(now);
        LogModel logModel = new LogModel(timeStamp, fileName, effectName, optionValues);
        logModelRepository.save(logModel);
    }


    //Function to fetch all the rows from the H2 database
    public List<LogModel> getAllLogs() {return logModelRepository.findAll();}

    //Function to fetch all the rows of a specific filter from the H2 database
    public List<LogModel> getLogsByEffect(String effectName) {
        System.out.println(convertToTitleCaseIteratingChars(effectName));
        return logModelRepository.getLogModelByEffectName(convertToTitleCaseIteratingChars(effectName));
    }

    //Clear the entire table
    public void clearLogs() {
        System.out.println("Deleting");
        logModelRepository.deleteAll();
    }

    //Function to get all the rows between two specific time stamps from the H2 database
    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        List<LogModel> allLogs = logModelRepository.findAll();
        List<LogModel> query = new ArrayList<>();
        try {
            for (LogModel log : allLogs) {
                String timestamp = log.getTimestamp();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                LocalDateTime localDateTime = LocalDateTime.parse(timestamp, dateTimeFormatter);
                if ((startTime.isBefore(localDateTime) || startTime.isEqual(localDateTime)) && (endTime.isAfter(localDateTime) || endTime.isEqual(localDateTime)))
                    query.add(log);
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid date-time format");
        }
        return query;
    }

    //Function to generate the title case of a string
    public static String convertToTitleCaseIteratingChars(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }

}
