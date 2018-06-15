package ru.job4j.brackets;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Main {
    public static void main(String[] args) {
        //String line = "a[b({c}d)e]";
        String line = "a[b({c}d)e](fff)";
        Info result = SortBrackets.parseBracket(line);
        System.out.println(line);
        System.out.println("valid = " + result.isValid());
        if (result.isValid()) {
            for (Item item : result.getItems()) {
                System.out.println("" + item.getBracket() + ", " +
                        item.getBracket().getBeginBracket() + " нач.позиция = " +
                        item.getBeginPos() + ", кон.позиция = " + item.getEndPos());
            }
        }
    }
}