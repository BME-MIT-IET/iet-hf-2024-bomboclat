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
    private Point Source = new Point(440, 135);
    private Point City = new Point(60, 135);
    private Point leftPump = new Point(65, 390);
    private Point rightPump = new Point(515, 390);
    private Point newlyPlacedPump = new Point(335, 280);
    private Point pipeFromCityToSource = new Point(260,135);
    private Point pipeFromPumpToPump = new Point(285, 390);
    private Point pipeFromCityToPump = new Point(400, 300);
    private Point pipeFromSourceToPump = new Point(350, 195);

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
        window.button(JButtonMatcher.withName("Pass")).click();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(pipeFromPumpToPump);
        window.button(JButtonMatcher.withName("Drill")).click();
        pressPassButton(19);
        assertTrue(frame.currentGame.isFinished());
        assertEquals(0, frame.currentGame.GetResult());
        exitGame();
    }

    @Test
    public void PlayAGameWithTwoPlayersNomadPuncturesPipeButMechanicFixesSoTheyWin() {
        startGameWithTwoPlayers();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(Source);
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(pipeFromSourceToPump);
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(leftPump);
        window.button(JButtonMatcher.withName("Pass")).click();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(pipeFromPumpToPump);
        window.button(JButtonMatcher.withName("Drill")).click();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(rightPump);
        window.button(JButtonMatcher.withName("Pass")).click();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(pipeFromPumpToPump);
        window.button(JButtonMatcher.withName("Fix")).click();
        pressPassButton(18);
        assertTrue(frame.currentGame.isFinished());
        assertEquals(1, frame.currentGame.GetResult());
        exitGame();
    }

    @Test
    public void TestForGlueWorking(){
        startGameWithTwoPlayers();
        window.button(JButtonMatcher.withName("Glue")).click();
        assertTrue(frame.currentGame.getCurrPlayfield().getPipes().get(0).getSticky());
    }

    @Test
    public void TestForLubeWorking(){
        startGameWithTwoPlayers();
        window.button(JButtonMatcher.withName("Pass")).click();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(new Point(300, 392));
        window.button(JButtonMatcher.withName("Lube")).click();
        assertTrue(frame.currentGame.getCurrPlayfield().getPipes().get(2).getSlippery());
    }

    @Test
    public void TestForPlacePump(){
        startGameWithTwoPlayers();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(City);
        window.button(JButtonMatcher.withName("Pick Up Pump")).click();
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(pipeFromCityToPump);
        assertEquals(4, frame.currentGame.getCurrPlayfield().getNodes().size());
        assertEquals(4, frame.currentGame.getCurrPlayfield().getPipes().size());
        window.button(JButtonMatcher.withName("Place Pump")).click();
        assertEquals(5, frame.currentGame.getCurrPlayfield().getNodes().size());
        assertEquals(5, frame.currentGame.getCurrPlayfield().getPipes().size());
        window.button(JButtonMatcher.withName("Move")).click();
        moveAndClickXY(newlyPlacedPump);
        assertEquals(frame.currentGame.getCurrPlayfield().getNodes().get(4), frame.currentGame.getCurrPlayer().getField());
    }


}