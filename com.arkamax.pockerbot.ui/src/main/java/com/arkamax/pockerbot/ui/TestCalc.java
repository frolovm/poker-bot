/**
 * 
 */
package com.arkamax.pockerbot.ui;

import java.awt.Rectangle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arkamax.pockerbot.ui.mouse.MouseAWTUtils;

import mmarquee.automation.UIAutomation;
import mmarquee.automation.controls.AutomationWindow;

/**
 * @author frolov
 *
 */
public class TestCalc {
	static Logger logger = LoggerFactory.getLogger(TestCalc.class);

	public static void main(String[] args) throws Exception {
		UIAutomation automation = UIAutomation.getInstance();
		// AutomationApplication application =
		// automation.launchOrAttach("calc");
		AutomationWindow window = automation.getDesktopWindow("Calculator");
		if (window == null) {
			return;
		}
		window.focus();
		String name = window.name();
		logger.warn(name);
		AutomationWindow calcWindow = window.getWindow("Calculator");
		logger.warn(calcWindow.name());
		Thread.sleep(1000);
		Rectangle rectangle = calcWindow.getBoundingRectangle().toRectangle();
		logger.warn(rectangle.toString());
		MouseAWTUtils.getInstance().mouseMove(rectangle.x,rectangle.y);
		Thread.sleep(1000);
	}
}
