package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String fnfe) {
        super(fnfe);
    }
}