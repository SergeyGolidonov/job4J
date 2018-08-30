package ru.job4j.search.banktransfer;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class BankActionsTest {

    @Test
    public void whenMoneyTransferWasSuccessful() {
        BankActions bank = new BankActions();
        bank.addUser(new User("John", "passport 551533"));
        bank.addAccauntToUser("passport 551533", new Accaunt(100, "John 001"));
        bank.addUser(new User("Mikky", "passport 550034"));
        bank.addAccauntToUser("passport 550034", new Accaunt(950, "Mikky 007"));
        bank.transferMoney("passport 551533", "John 001", "passport 550034", "Mikky 007", 50);
        double srcResult = bank.findAccauntByRequisite(bank.getUserAccaunts("passport 551533"), "John 001").getValue();
        double dstResult = bank.findAccauntByRequisite(bank.getUserAccaunts("passport 550034"), "Mikky 007").getValue();
        double srcExpected = 50;
        double dstExpected = 1000;
        assertThat(true, is((srcResult == srcExpected) && (dstResult == dstExpected)));
    }

    @Test
    public void whenMoneyTransferWasFail() {
        BankActions bank = new BankActions();
        bank.addUser(new User("John", "passport 551533"));
        bank.addAccauntToUser("passport 551533", new Accaunt(100, "John 001"));
        bank.addUser(new User("Mikky", "passport 550034"));
        bank.addAccauntToUser("passport 550034", new Accaunt(950, "Mikky 007"));
        boolean result = bank.transferMoney("passport 551533", "strange accaunt", "passport 550034", "Mikky 007", 50);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddingUserAccauntWasFailed() {
        BankActions bank = new BankActions();
        bank.addUser(new User("John", "passport 551533"));
        bank.addAccauntToUser("wrong passport", new Accaunt(100, "John 001"));
        int result = bank.getUserAccaunts("passport 551533").size();
        int expected = 0;
        assertThat(result, is(expected));
    }
}