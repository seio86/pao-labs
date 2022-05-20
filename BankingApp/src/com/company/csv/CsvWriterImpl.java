package com.company.csv;

import com.company.entities.FieldsListIt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class CsvWriterImpl<T> implements CsvWriter<T> {
    private FileWriter fileWriter;
    // check if header is already written
    private FileReader fileReader;

    @Override
    public void writeToCsv(T object) {
        String filename = object.getClass().getSimpleName() + ".csv";
        try {
            fileWriter = new FileWriter(filename, true);
            fileReader = new FileReader(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!hasHeader()) {
            writeHeader(object);
        }
        writeRow((FieldsListIt) object);

        //close
        try {
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeRow(FieldsListIt object) {
        object.csvValues().forEach(e -> {
            try {
                fileWriter.write("\"");
                fileWriter.write(e);
                fileWriter.write("\"");

                fileWriter.write(",");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        try {
            fileWriter.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeHeader(T object) {
        for (Field declaredField : object.getClass().getDeclaredFields()) {
            try {
                fileWriter.write(declaredField.getName());
                fileWriter.write(",");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            fileWriter.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean hasHeader() {
        int b;
        try {
            b = fileReader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return b != -1;
    }
}
