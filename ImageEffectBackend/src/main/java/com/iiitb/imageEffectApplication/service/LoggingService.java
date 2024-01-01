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

    @Autowired
    LogModelRepository logModelRepository;


    public LoggingService() {}

    public void addLog(String fileName, String effectName, String optionValues) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = dtf.format(now);
        LogModel logModel = new LogModel(timeStamp, fileName, effectName, optionValues);
        logModelRepository.save(logModel);
    }



    public List<LogModel> getAllLogs() {return logModelRepository.findAll();}

    public List<LogModel> getLogsByEffect(String effectName) {
        System.out.println(convertToTitleCaseIteratingChars(effectName));
        return logModelRepository.getLogModelByEffectName(convertToTitleCaseIteratingChars(effectName));
    }

    public void clearLogs() {
        System.out.println("Deleting");
        logModelRepository.deleteAll();
    }

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
