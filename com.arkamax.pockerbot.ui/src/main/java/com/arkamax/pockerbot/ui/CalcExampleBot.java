/**
 * 
 */
package com.arkamax.pockerbot.ui;

import java.awt.AWTException;
import java.awt.Rectangle;

import com.arkamax.pockerbot.ui.mouse.MouseAWTUtils;
import com.arkamax.pockerbot.ui.utils.User32Utils;
import com.sun.jna.platform.DesktopWindow;

/**
 * @author frolov
 *
 */
public class CalcExampleBot {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public static void main(String[] args) throws InterruptedException, AWTException {

		DesktopWindow windowHolder = User32Utils.findAndShowWindow("Calculator");

		if (windowHolder != null) {
			Rectangle locAndSize = windowHolder.getLocAndSize();
			MouseAWTUtils.getInstance().mouseMove(windowHolder.getLocAndSize().x, windowHolder.getLocAndSize().y);
			Thread.sleep(1000);
			int fivex= locAndSize.x + (int)locAndSize.width/3;
			int fivey= locAndSize.y + (int)locAndSize.height*3/4;
			MouseAWTUtils.getInstance().mouseMove(fivex,fivey);
			MouseAWTUtils.getInstance().mouseLeftClick();
			Thread.sleep(1000);
			fivex= locAndSize.x + (int)locAndSize.width*8/9;
			fivey= fivey + 20;
			Thread.sleep(1000);
			MouseAWTUtils.getInstance().mouseMove(fivex,fivey);
			MouseAWTUtils.getInstance().mouseLeftClick();
			fivex= locAndSize.x + (int)locAndSize.width/3;
			fivey= locAndSize.y + (int)locAndSize.height*3/4;
			
			Thread.sleep(1000);
			MouseAWTUtils.getInstance().mouseMove(fivex,fivey);
			MouseAWTUtils.getInstance().mouseLeftClick();
			
			fivex= locAndSize.x + (int)locAndSize.width*8/9;
			fivey= fivey + 80;
			Thread.sleep(1000);
			MouseAWTUtils.getInstance().mouseMove(fivex,fivey);
			MouseAWTUtils.getInstance().mouseLeftClick();
		}
	}

}
