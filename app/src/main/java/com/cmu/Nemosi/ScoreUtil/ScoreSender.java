package com.cmu.Nemosi.ScoreUtil;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class ScoreSender {
    public static void sendScore(String url, JSONObject data) throws IOException {
        String query = data.toString();

        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Length", String.valueOf(query.length()));
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        connection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(query);
        outputStream.flush();
        outputStream.close();
    }
}
