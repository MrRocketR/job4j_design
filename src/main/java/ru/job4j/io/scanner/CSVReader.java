package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
    String param1 = argsName.get("path");
    String param2 = argsName.get("delimiter");
    String param3 = argsName.get("out");
    String param4 = argsName.get("filter");
    Scanner scanner = new Scanner(new File(param1));

    }

}
/*

В качестве входных данных задается путь к файлу path, разделитель delimiter, приемник данных out и фильтр по столбцам filter.
Ключ -out имеет только два допустимых значения stdout или путь к файлу, куда нужно вывести.
Например, если есть файл CSV со столбцами name, age, birthDate, education, children и программа запускается таким образом:

java -jar target/csvReader.jar -path=file.csv -delimiter=";"  -out=stdout -filter=name,age

то программа должна прочитать файл по пути file.csv
и вывести только столбцы name, age в консоль. В качестве разделителя данных выступает ;
 */