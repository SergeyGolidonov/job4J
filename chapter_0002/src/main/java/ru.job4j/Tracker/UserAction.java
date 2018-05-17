package ru.job4j.tracker;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}