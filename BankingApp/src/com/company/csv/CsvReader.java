package com.company.csv;

import java.util.List;

public interface CsvReader <T>{
    List<T> readFromCsv(T object);
}
