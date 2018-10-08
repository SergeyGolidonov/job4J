package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String ime) {
        super(ime);
    }
}