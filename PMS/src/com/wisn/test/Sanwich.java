/**
 * 
 */
package com.wisn.test;

/**
 * @author Wisn
 * 2016年10月15日   下午12:35:03
 * 
 */
public class Sanwich extends Lunch {
    private Bread bread = new Bread();

    public Sanwich() { System.out.println("Sanwich()"); }

   /* public static void main(String[] args) {
        Sanwich sanwich = new Sanwich();
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
Meal()
Lunch()
Meal()
Lunch()
Bread()
Sanwich()
false
    }*/
    public static void main(String args[]) {

        final Thread t = new Thread() {

                public void run() {
                    pong();
                }
            };

        t.run();
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }
}
class Meal {
    Meal() { System.out.println("Meal()"); }
}

class Bread {
    static Lunch lunch = new Lunch();

    Bread() { System.out.println("Bread()"); }
}

class Lunch extends Meal {
    public Lunch() { System.out.println("Lunch()"); }
}

