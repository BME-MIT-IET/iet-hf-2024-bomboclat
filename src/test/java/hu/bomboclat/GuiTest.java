package hu.bomboclat;

import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;

import hu.bomboclat.Graphics.GameFrame;
import org.assertj.swing.core.GenericTypeMatcher;
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

public class GuiTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @Override
    protected void onSetUp(){
        GameFrame frame = GuiActionRunner.execute(() -> new GameFrame("GuiTest"));
        window = new FrameFixture(robot(), frame);
        window.show();
    }

    @Test
    public void PlayAGameWithTwoPlayersAndOnlyPressPassThenExit() throws AWTException, InterruptedException {
        window.menuItem("MenuButton").click();
        window.menuItem("NewGameMenuButton").click();
        window.textBox("NumberOfMechanics").enterText("1");
        window.textBox("NumberOfNomads").enterText("1");
        window.button(JButtonMatcher.withText("StartNewGame")).click();
        for(int i = 0; i < 20; ++i){
            window.button(JButtonMatcher.withText("Pass")).click();
        }
        window.button(JButtonMatcher.withText("OK")).click();
        window.menuItem("MenuButton").click();
        window.menuItem("ExitButton").click();
    }

}
