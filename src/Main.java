import java.util.Scanner;

public class Main {
    public static int tabCount = 0;

    public static void main(String[] args){
        TestClass tester = new TestClass();
        
        System.out.println("1. Teszt 1.\n");

        int answer;
        Scanner sc = new Scanner(System.in);

        answer = Integer.parseInt(sc.nextLine());

        sc.close();

        switch(answer) {
            case 1: tester.Test1();
            default:;
        }
    }
}
