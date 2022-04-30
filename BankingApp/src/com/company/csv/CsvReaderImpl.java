package com.company.csv;

import com.company.entities.ConstructorAdaptor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CsvReaderImpl<T> implements CsvReader<T> {
    private FileReader fileReader;

    @Override
    public List<T> readFromCsv(T object) {
        List<T> list = new ArrayList<>();
        String filename = object.getClass().getSimpleName() + ".csv";
        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(fileReader);
        scanner.useDelimiter(",");

        //skip header
        scanner.nextLine();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            //https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
            String[] args = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            List<String> listArr = Arrays.stream(args).map(s -> s.replaceAll("^\"|\"$", "")).collect(Collectors.toList());
            String[] stringArray = listArr.toArray(new String[0]);

            ConstructorAdaptor<T> myObj = (ConstructorAdaptor<T>) object;
//            System.out.println(object.getClass());
//            for (String s : stringArray) {
//                System.out.println("FIELD = " + s);
//            }
            T myInstance = myObj.allStringConstructor(stringArray);
            list.add(myInstance);
        }
        return list;
    }
}
