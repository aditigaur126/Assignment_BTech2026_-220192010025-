package dsa.games;

import java.util.*;

//0--rock 
//1--scissor
//2--paper
public class rockpaper {
    static Scanner sc = new Scanner(System.in);

    public static String comp() {
        Random r = new Random();
        int choice = r.nextInt(3);
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Scissor";

            case 2:
                return "Paper";
            default:
                return "fault";
        }
    }

    public static String user() {

        int n = sc.nextInt();

        switch (n) {
            case 1:
                return "Rock";
            case 2:
                return "Scissor";

            case 3:
                return "Paper";
            default:
                return "fault";

        }

    }

    public static void play() {
        while (true) {
            String c = comp();
            String u = user();
            if ((u == "Rock" && c == "Scissor") || (u == "Paper" && c == "Rock") || (u == "Scissor" && c == "Paper")) {
                System.out.println("user won as computer chose:" + c);
            } else if ((c == "Rock" && u == "Scissor") || (c == "Paper" && u == "Rock")
                    || (c == "Scissor" && u == "Paper")) {
                System.out.println("user lose as computer chose:" + c + " user chose:" + u);
            } else if (c == u) {
                System.out.println("Match Draw as computer chose:" + c + " user chose:" + u);
            } else {
                System.out.println("Error");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Choose \n 1.Rock\n 2. Scissors\n 3. Paper");
        play();
        sc.close();

    }

}
