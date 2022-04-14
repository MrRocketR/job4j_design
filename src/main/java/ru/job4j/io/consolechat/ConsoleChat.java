package ru.job4j.io.consolechat;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> bot = readPhrases();
        boolean mark = false;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String answerBot;
        String  userAnswer = "закончить";
        do {
            System.out.println("Пиши:");
            userAnswer = scanner.nextLine();
            System.out.println("Ты ввел = " + userAnswer);
            log.add(userAnswer);
            System.out.println("Mark = " + mark);
            if (STOP.equals(userAnswer)) {
                System.out.println("Бот молчит!");
                log.add("Бот молчит!");
                mark = true;
            } else if (CONTINUE.equals(userAnswer)) {
                System.out.println("Продолжаем наш разговор");
                log.add("Продолжаем наш разговор");
                mark = false;
            } else if (!mark) {
                answerBot = bot.get(random.nextInt(bot.size()));
                log.add(answerBot);
                System.out.println(answerBot);
            }
        } while (!OUT.equals(userAnswer));
        System.out.println("Пока!");
        log.add("Пока!");
        saveLog(log);
    }


    private List<String> readPhrases() {
        List<String> readPhrases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            String line;
            while ((line = br.readLine()) != null) {
             readPhrases.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readPhrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            for (String s:log) {
                pw.println(s);
            }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/data/log.txt", "./src/data/answers.txt");
        cc.run();
    }
}
