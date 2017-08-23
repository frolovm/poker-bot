/**
 * 
 */
package com.arkamax.pockerbot.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mmarquee.automation.UIAutomation;
import mmarquee.automation.controls.AutomationApplication;
import mmarquee.automation.controls.AutomationButton;
import mmarquee.automation.controls.AutomationEditBox;
import mmarquee.automation.controls.AutomationWindow;
import mmarquee.automation.controls.menu.AutomationMainMenu;
import mmarquee.automation.controls.menu.AutomationMenuItem;

/**
 * @author frolov
 *
 */
public class TestAutomation {

	static Logger logger = LoggerFactory.getLogger(TestAutomation.class);

	public static void main(String[] args) throws Exception {
		UIAutomation automation = UIAutomation.getInstance();
		AutomationApplication application = automation.launchOrAttach("notepad.exe");

		// Wait for the process to start
		application.waitForInputIdle(5000);

		AutomationWindow window = automation.getDesktopWindow("Untitled - Notepad");
		String name = window.name();
		logger.info(name);

		Object framework = window.getFramework();
		logger.info("Framework is " + framework.toString());

		logger.info("Modal = " + window.isModal());

		AutomationEditBox edit = window.getEditBox(0);

		edit.setValue("This is a test of automation");

		window.focus();
		window.maximize();


		// Interact with menus
		AutomationMainMenu menu = window.getMainMenu();

		AutomationMenuItem exit = menu.getMenuItem("File", "Exit");
		exit.click();

		AutomationWindow popup = window.getWindow("Notepad");
		AutomationButton btn = popup.getButton("Don't Save");

		btn.click();

		logger.info("All closed down now");

	}
}
