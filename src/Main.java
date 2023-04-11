import java.util.Scanner;

public class Main {
    public static int tabCount = 0;

    public static void main(String[] args){
        TestClass tester = new TestClass();
        
        System.out.println("Pl (0. Teszt 1.)");
        System.out.println("14. Change Pump");
        System.out.println("19. Place Pump on Pump");
        System.out.println("20. Place Pump on Pipe");
        System.out.println("26. Test Water Step Source");
        System.out.println("27. Test Water Step City");
        System.out.println("28. Test Water Step Pump");
        System.out.println("29. Test Drill Pipe On Pipe");

        int answer;
        Scanner sc = new Scanner(System.in);

        answer = Integer.parseInt(sc.nextLine());

        sc.close();

        switch(answer) {
            case 0: tester.Test1();
            case 14: tester.TestChangePump();
            case 19: tester.TestPlacePumpOnPump();
            case 20: tester.TestPlacePumpOnPipe();
            case 26: tester.TestWaterStepSource();
            case 27: tester.TestWaterStepCity();
            case 28: tester.TestWaterStepPump();
            case 29: tester.TestDrillPipe();
            default:;
        }
    }
}
