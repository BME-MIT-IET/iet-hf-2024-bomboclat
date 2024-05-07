package hu.bomboclat;

import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;

import hu.bomboclat.Graphics.GameFrame;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void ExitTest() {
        window.menuItem("MenuButton").click();
        window.menuItem("ExitButton").click();
    }

}
