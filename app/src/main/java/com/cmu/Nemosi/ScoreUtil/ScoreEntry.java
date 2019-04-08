package com.cmu.Nemosi.ScoreUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class ScoreEntry {
    enum Category {
        LOGICAL_THINKING,
        SEMANTIC_MEMORY,
        PROCEDURAL_MEMORY,
        EPISODIC_MEMORY
    }

    private final int gameId;
    private final Category category;
    private final int patientId;
    private final int score;
    private final Date timestamp;

    public ScoreEntry(int gameId, Category category, int patientId, int score, Date timestamp){
        this.gameId = gameId;
        this.category = category;
        this.patientId = patientId;
        this.score = score;
        this.timestamp = timestamp;
    }

    public void send() throws JSONException, IOException { //TODO deal with exceptions
        JSONObject data = new JSONObject()
                .put("patient_id", patientId)
                .put("timestamp", new Timestamp(timestamp.getTime()));

        String categoryString;
        String urlEnding;

        switch(category){
            case LOGICAL_THINKING:
                categoryString = "logical_thinking_score";
                urlEnding = "logical";
                break;
            case SEMANTIC_MEMORY:
                categoryString = "semantic_score";
                urlEnding = "semantic";
                break;
            case PROCEDURAL_MEMORY:
                categoryString = "procedural_score";
                urlEnding = "procedural";
                break;
            case EPISODIC_MEMORY:
                categoryString = "episodic_score";
                urlEnding = "episodic";
                break;
            default:
                throw new RuntimeException("Missing category enum.");
        }

        data.put(categoryString, score);
        String url = "https://kinect.andrew.cmu.edu/ga/" + urlEnding; //TODO may be changed

        ScoreSender.sendScore(url, data);
    }
}
