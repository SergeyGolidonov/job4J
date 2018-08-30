package ru.job4j.search.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class BankActions {
    private HashMap<User, List<Accaunt>> accaunts = new HashMap<>();

    public void addUser(User user) {
        this.accaunts.putIfAbsent(user, new ArrayList<Accaunt>());
    }

    public void deleteUser(User user) {
        this.accaunts.remove(user);
    }

    public void addAccauntToUser(String passport, Accaunt accaunt) {
        List<Accaunt> list = this.getUserAccaunts(passport);
        if (list.indexOf(accaunt) < 0) {
            list.add(accaunt);
        }
    }

    public void deleteAccauntFromUser(String passport, Accaunt accaunt) {
        this.getUserAccaunts(passport).remove(accaunt);
    }

    public List<Accaunt> getUserAccaunts(String passport) {
        List<Accaunt> result = new ArrayList<>();
        for (Map.Entry<User, List<Accaunt>> pair : this.accaunts.entrySet()) {
            if (passport.equals(pair.getKey().getPassport())) {
                result = pair.getValue();
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = true;
        Accaunt srcAccaunt = this.findAccauntByRequisite(this.getUserAccaunts(srcPassport), srcRequisite);
        Accaunt dstAccaunt = this.findAccauntByRequisite(this.getUserAccaunts(dstPassport), dstRequisite);
        if (srcAccaunt == null || dstAccaunt == null || (srcAccaunt.getValue() - amount) < 0) {
            result = false;
        } else {
            srcAccaunt.setValue(srcAccaunt.getValue() - amount);
            dstAccaunt.setValue(dstAccaunt.getValue() + amount);
        }
        return result;
    }

    public Accaunt findAccauntByRequisite(List<Accaunt> list, String requisite) {
        Accaunt result = null;
        for (Accaunt account : list) {
            if (requisite.equals(account.getRequisites())) {
                result = account;
                break;
            }
        }
        return result;
    }
}