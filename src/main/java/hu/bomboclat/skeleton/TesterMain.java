package hu.bomboclat.skeleton;

import java.util.Scanner;

public class TesterMain {
    public static int tabCount = 0;

    public static void main(String[] args){
        TestClass tester = new TestClass();
        
        System.out.println("1. Step on empty pipe from pump");
        System.out.println("2. Step on occupied pipe from pump");
        System.out.println("3. Step on empty pipe from city");
        System.out.println("4. Step on occupied pipe from city");
        System.out.println("5. Step on empty pipe from source ");
        System.out.println("6. Step on occupied pipe from source");
        System.out.println("7. Step on pump from pipe");
        System.out.println("8. Step on city from pipe");
        System.out.println("9. Step on source from pipe");
        System.out.println("10. Water flows on Pump from Source");
        System.out.println("11. Water flows in City");
        System.out.println("12. Water flows in bloked input of Pump");
        System.out.println("13. Change Pump");
        System.out.println("14. Water flows out of broken Pipe");
        System.out.println("15. Fix Pipe");
        System.out.println("16. Place Pipe on Pump");
        System.out.println("17. Place Pipe on Pipe");
        System.out.println("18. Place Pump on Pump");
        System.out.println("19. Place Pump on Pipe");
        System.out.println("20. Pick up Pipe on City");
        System.out.println("21. Pick up Pipe on Pump");
        System.out.println("22. Pick up Pipe on Pipe");
        System.out.println("23. Pick up Pipe on Source");
        System.out.println("24. Destroy Pump and Fix Pump");
        System.out.println("25. Test Water Step Source");
        System.out.println("26. Test Water Step City");
        System.out.println("27. Test Water Step Pump");
        System.out.println("28. Test Drill Pipe On Pipe");
        System.out.println("29. Pick up Pump on City");
        System.out.println("30. Pick up Pump on Pump");
        System.out.println("31. Pick up Pump on Pipe");
        System.out.println("32. Pick up Pump on Source");

        int answer;
        Scanner sc = new Scanner(System.in);

        answer = Integer.parseInt(sc.nextLine());

        sc.close();

        switch(answer) {
            case 1: tester.TestStepOnEmptyPipePump(); break;
            case 2: tester.TestStepOnOccupiedPipePump(); break;
            case 3: tester.TestStepOnEmptyPipeCity(); break;
            case 4: tester.TestStepOnOccupiedPipeCity(); break;
            case 5: tester.TestStepOnEmptyPipeSource(); break;
            case 6: tester.TestStepOnOccupiedPipeSource(); break;
            case 7: tester.TestStepOnPumpFromPipe(); break;
            case 8: tester.TestStepOnCityFromPipe(); break;
            case 9: tester.TestStepOnSourceFromPipe(); break;
            case 10: tester.TestWaterFlowsSourceToPump(); break;
            case 11: tester.TestWaterFlowsInCity(); break;
            case 12: tester.TestWaterFlowsInBlocked(); break;
            case 13: tester.TestChangePump(); break;
            case 14: tester.TestWaterFlowsOutOfBrokenPipe(); break;
            case 15: tester.TestFixPipe(); break;
            case 16: tester.TestPlacePipeOnPump(); break;
            case 17: tester.TestPlacePipeOnPipe(); break;
            case 18: tester.TestPlacePumpOnPump(); break;
            case 19: tester.TestPlacePumpOnPipe(); break;
            case 20: tester.TestPickUpPipeOnCity(); break;
            case 21: tester.TestPickUpPipeOnPump(); break;
            case 22: tester.TestPickUpPipeOnPipe(); break;
            case 23: tester.TestPickUpPipeOnSource(); break;
            case 24: tester.TestDestroyPumpFixPump(); break;
            case 25: tester.TestWaterStepSource(); break;
            case 26: tester.TestWaterStepCity(); break;
            case 27: tester.TestWaterStepPump(); break;
            case 28: tester.TestDrillPipe(); break;
            case 29: tester.TestPickUpPumpOnCity(); break;
            case 30: tester.TestPickUpPumpOnPump(); break;
            case 31: tester.TestPickUpPumpOnPipe(); break;
            case 32: tester.TestPickUpPumpOnSource(); break;
            default: break;
        }
    }
    
}
