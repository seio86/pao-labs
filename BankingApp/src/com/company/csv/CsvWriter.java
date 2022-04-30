package com.company.csv;

import java.io.IOException;

public interface CsvWriter<T> {
    void writeToCsv(T object) throws IOException;
}
