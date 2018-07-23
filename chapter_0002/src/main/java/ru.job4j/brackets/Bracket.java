package ru.job4j.brackets;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public enum Bracket {
    SQUARE('[', ']'),
    ROUND('(', ')'),
    CURLY('{', '}');

    private char begin;
    private char end;

    /**
     * Конструктор.
     * @param begin - символ открывающей скобки.
     * @param end - символ закрывающей скобки.
     */
    Bracket(char begin, char end) {
        this.begin = begin;
        this.end = end;
    }

    public char getBeginBracket() {
        return this.begin;
    }

    public char getEndBracket() {
        return this.end;
    }
}