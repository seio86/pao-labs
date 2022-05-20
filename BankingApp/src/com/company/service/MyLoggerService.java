package com.company.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class MyLoggerService {
    private BufferedWriter bufferedWriter;

    public MyLoggerService(String filename, boolean append) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filename, append));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info(String msg) {
        StringBuilder finalMsg = buildMessage(msg);
        try {
            bufferedWriter.write(finalMsg.toString());
            System.out.println(finalMsg);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder buildMessage(String msg) {
        StringBuilder finalMsg = new StringBuilder()
                .append("\"") // """
                .append(msg)
                .append("\"")
                .append(",")
                .append("\"") // """
                .append(new Timestamp(System.currentTimeMillis()))
                .append("\"\n"); // """
        return finalMsg;
    }

    public void severe(String msg) {
        info(msg);
        System.err.print(buildMessage(msg));
    }
}
