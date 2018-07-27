
/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

/*
Программа переводит галлоны в литры
 */

public class GalToLit {
    public static void main(String[] args) {
        double gallons = 10.0;
        double liters = gallons * 3.7584;
        System.out.println(gallons + " галлонам соответствует " + liters + " литров.");
    }
}