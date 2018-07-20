package ru.job4j.brackets;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Check {
    private String input;
    private int lengthInput;
    private Stack stack;

    //В конструкторе инициализируем поля
    public Check(String input) {
        this.input = input;
        this.lengthInput = input.length();
        stack = new Stack(lengthInput);
    }

    public boolean makeCheck(String s) {
        for (int i = 0; i < lengthInput; i++) {  // начинаем последовательно считывать
            char ch = input.charAt(i);              // считывание символа
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.addElement(ch);
                    break;
                case '}':
                case ']':
                case ')':

                    if (!stack.isEmpty()) {                                 //если стек не пустой
                        char chClosed = (char) stack.deleteElement();             //удалить и проверить

                        if ((ch == '}' && chClosed != '{')
                                || (ch == ']' && chClosed != '[')
                                || (ch == ')' && chClosed != '('));
                    } return true;
                    default:    // для других символов действия не выполняются
                    break;
            }
        }
        if (!stack.isEmpty()) {
        }
        return true;
    }
}