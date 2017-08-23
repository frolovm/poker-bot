/**
 * 
 */
package com.arkamax.pockerbot.ui.mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * @author frolov
 *
 */
public class MouseAWTUtils {

	private static MouseAWTUtils mouseAWTUtils;
	private Robot robot;

	private MouseAWTUtils() throws AWTException {
		robot = new Robot();
		robot.setAutoDelay(40);
		robot.setAutoWaitForIdle(true);
	}

	public static MouseAWTUtils getInstance() throws AWTException {
		if (mouseAWTUtils == null) {
			mouseAWTUtils = new MouseAWTUtils();
		}
		return mouseAWTUtils;
	}

	public void mouseMove(int x, int y) {
		robot.mouseMove(x, y);
	}

	public void mouseMoveAndClick(int x, int y) {
		robot.mouseMove(x, y);
		leftClick();
	}

	public void mouseLeftClick() {
		leftClick();
	}

	private void leftClick() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(200);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(200);
	}

}
