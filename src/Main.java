import java.util.Scanner;

public class Main {
    public static int tabCount = 0;

    public static void main(String[] args){
        TestClass tester = new TestClass();
        
        System.out.println("Pl (0. Teszt 1.)");
        System.out.println("2 Step on empty pipe from pump");
        System.out.println("3 Step on occupied pipe from pump");
        System.out.println("4 Step on empty pipe from city");
        System.out.println("5 Step on occupied pipe from city");
        System.out.println("6 Step on empty pipe from source ");
        System.out.println("7 Step on occupied pipe from source");
        System.out.println("11. Water flows on Pump from Source");
        System.out.println("12 Water flows in City");
        System.out.println("13 Water flows in bloked input of Pump");
        System.out.println("14. Change Pump");
        System.out.println("15. Water flows out of broken Pipe");
        System.out.println("16. Fix Pipe");
        System.out.println("17. Place Pipe on Pump");
        System.out.println("18. Place Pipe on Pipe");
        System.out.println("19. Place Pump on Pump");
        System.out.println("20. Place Pump on Pipe");
        System.out.println("21. Pick up Pipe on City");
        System.out.println("22. Pick up Pipe on Pump");
        System.out.println("23. Pick up Pipe on Pipe");
        System.out.println("24. Pick up Pipe on Source");
        System.out.println("26. Test Water Step Source");
        System.out.println("27. Test Water Step City");
        System.out.println("28. Test Water Step Pump");
        System.out.println("29. Test Drill Pipe On Pipe");

        int answer;
        Scanner sc = new Scanner(System.in);

        answer = Integer.parseInt(sc.nextLine());

        sc.close();

        switch(answer) {
            case 0: tester.Test1(); break;
            case 1: break; // elcsuszott a szekvenciadiagram szamoas a vegleges pdf-ben. Majd a megbeszelesen max atirjuk a szamozasokat
            case 2: tester.TestStepOnEmptyPipePump(); break;
            case 3: tester.TestStepOnOccupiedPipePump(); break;
            case 4: tester.TestStepOnEmptyPipeCity(); break;
            case 5: tester.TestStepOnOccupiedPipeCity(); break;
            case 6: tester.TestStepOnEmptyPipeSource(); break;
            case 7: tester.TestStepOnOccupiedPipeSource(); break;
            case 11: tester.TestWaterFlowsSourceToPump(); break;
            case 12: tester.TestWaterFlowsInCity(); break;
            case 13: tester.TestWaterFlowsInBlocked(); break;
            case 14: tester.TestChangePump(); break;
            case 15: tester.TestWaterFlowsOutOfBrokenPipe(); break;
            case 16: tester.TestFixPipe(); break;
            case 17: tester.TestPlacePipeOnPump(); break;
            case 18: tester.TestPlacePipeOnPipe(); break;
            case 19: tester.TestPlacePumpOnPump(); break;
            case 20: tester.TestPlacePumpOnPipe(); break;
            case 21: tester.TestPickUpPipeOnCity(); break;
            case 22: tester.TestPickUpPipeOnPump(); break;
            case 23: tester.TestPickUpPipeOnPipe(); break;
            case 24: tester.TestPickUpPipeOnSource(); break;
            case 26: tester.TestWaterStepSource(); break;
            case 27: tester.TestWaterStepCity(); break;
            case 28: tester.TestWaterStepPump(); break;
            case 29: tester.TestDrillPipe(); break;
            default: break;
        }
    }
}
