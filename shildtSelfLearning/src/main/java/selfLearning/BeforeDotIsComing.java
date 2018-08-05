package selfLearning;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class BeforeDotIsComing {
    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(System.in);
        int count=0;
        System.out.println("Начинайте вводить данные.");
        while(true) {
            String  c = br.nextLine();
            char[] ch = c.toCharArray();
            for(char e : ch) {
                if((e == '.')&(ch.length<79))
                {
                    System.out.println(count);
                    break;
                } else count++;
            }
            System.out.println("Количество символов до точки:" + count);
        }
    }
}