package hu.bomboclat;

import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import hu.bomboclat.Graphics.GameFrame;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.MouseButton;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.driver.JMenuItemMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.DialogFixture;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InaccessibleObjectException;

public class GuiTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;
    private GameFrame frame;

    //Modify coordinates accordingly to your screen
    private Point Source = new Point(480, 135);
    private Point City = new Point(95, 135);
    private Point leftPump = new Point(100, 390);
    private Point rightPump = new Point(555, 390);
    private Point newlyPlacedPump = new Point(335, 280);
    private Point pipeFromCityToSource = new Point(260,135);
    private Point pipeFromPumpToPump = new Point(285, 390);
    private Point pipeFromCityToPump = new Point(400, 300);
    private Point pipeFromSourceToPump = new Point(205, 315);

    @Override
    protected void onSetUp(){
        frame = GuiActionRunner.execute(() -> new GameFrame("GuiTest"));
        window = new FrameFixture(robot(), frame);
        window.show();
    }

    protected void startGameWithTwoPlayers(){
        window.menuItem("MenuButton").click();
        window.menuItem("NewGameMenuButton").click();
        window.textBox("NumberOfMechanics").enterText("1");
        window.textBox("NumberOfNomads").enterText("1");
        window.button(JButtonMatcher.withText("StartNewGame")).click();
    }

    protected void pressPassButton(int times){
        for(int i = 0; i < times; ++i){
            window.button(JButtonMatcher.withText("Pass")).click();
        }
    }

    protected void moveAndClickXY(Point point){
        robot().click(point, MouseButton.LEFT_BUTTON, 1);
    }

    protected void exitGame(){
        window.button(JButtonMatcher.withText("OK")).click();
        window.menuItem("MenuButton").click();
        window.menuItem("ExitButton").click();
    }

    protected void pressButton(String buttonName){
        window.button(JButtonMatcher.withName(buttonName)).click();
    }

    protected void placePipeFromCityToLeftPump(){
        pressButton("Move");
        moveAndClickXY(City);
        pressButton("Pick Up Pipe");
        pressButton("Move");
        moveAndClickXY(pipeFromCityToSource);
        pressButton("Move");
        moveAndClickXY(Source);
        pressButton("Move");
        moveAndClickXY(pipeFromSourceToPump);
        pressButton("Pass");
        pressButton("Pass");
        pressButton("Move");
        moveAndClickXY(leftPump);
        pressButton("Place Pipe");
    }

    @Test
    public void PlayAGameWithTwoPlayersAndOnlyPressPassThenExit(){
        startGameWithTwoPlayers();
        pressPassButton(20);
        assertTrue(frame.currentGame.isFinished());
        assertEquals(1, frame.currentGame.GetResult());
        exitGame();
    }

    @Test
    public void PlayAGameWithTwoPlayersNomadPunturesPipeAndWin(){
        startGameWithTwoPlayers();
        pressButton("Pass");
        pressButton("Move");
        moveAndClickXY(pipeFromPumpToPump);
        pressButton("Drill");
        pressPassButton(19);
        assertTrue(frame.currentGame.isFinished());
        assertEquals(0, frame.currentGame.GetResult());
        exitGame();
    }

    @Test
    public void PlayAGameWithTwoPlayersNomadPuncturesPipeButMechanicFixesSoTheyWin() {
        startGameWithTwoPlayers();
        pressButton("Move");
        moveAndClickXY(Source);
        pressButton("Move");
        moveAndClickXY(pipeFromSourceToPump);
        pressButton("Move");
        moveAndClickXY(leftPump);
        pressButton("Pass");
        pressButton("Move");
        moveAndClickXY(pipeFromPumpToPump);
        pressButton("Drill");
        pressButton("Move");
        moveAndClickXY(rightPump);
        pressButton("Pass");
        pressButton("Move");
        moveAndClickXY(pipeFromPumpToPump);
        pressButton("Fix");
        pressPassButton(18);
        assertTrue(frame.currentGame.isFinished());
        assertEquals(1, frame.currentGame.GetResult());
        exitGame();
    }

    @Test
    public void TestForGlueWorking(){
        startGameWithTwoPlayers();
        pressButton("Glue");
        assertTrue(frame.currentGame.getCurrPlayfield().getPipes().get(0).getSticky());
    }

    @Test
    public void TestForLubeWorking(){
        startGameWithTwoPlayers();
        pressButton("Pass");
        pressButton("Move");
        moveAndClickXY(new Point(300, 392));
        pressButton("Lube");
        assertTrue(frame.currentGame.getCurrPlayfield().getPipes().get(2).getSlippery());
    }

    @Test
    public void TestForPlacePump(){
        startGameWithTwoPlayers();
        pressButton("Move");
        moveAndClickXY(City);
        pressButton("Pick Up Pump");
        pressButton("Move");
        moveAndClickXY(pipeFromCityToPump);
        assertEquals(4, frame.currentGame.getCurrPlayfield().getNodes().size());
        assertEquals(4, frame.currentGame.getCurrPlayfield().getPipes().size());
        pressButton("Place Pump");
        assertEquals(5, frame.currentGame.getCurrPlayfield().getNodes().size());
        assertEquals(5, frame.currentGame.getCurrPlayfield().getPipes().size());
        pressButton("Move");
        moveAndClickXY(newlyPlacedPump);
        assertEquals(frame.currentGame.getCurrPlayfield().getNodes().get(4), frame.currentGame.getCurrPlayer().getField());
    }

    @Test
    public void TestForPlacePipe(){
        startGameWithTwoPlayers();
        placePipeFromCityToLeftPump();
        assertEquals(5, frame.currentGame.getCurrPlayfield().getPipes().size());
        pressPassButton(18);
    }
}
