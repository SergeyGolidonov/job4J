package ru.job4j.Tracker;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}