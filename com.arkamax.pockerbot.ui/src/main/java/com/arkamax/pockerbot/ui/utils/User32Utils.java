/**
 * 
 */
package com.arkamax.pockerbot.ui.utils;

import java.util.List;

import com.arkamax.pockerbot.ui.components.WindowHolder;
import com.arkamax.pockerbot.ui.jna.User32Extra;
import com.sun.jna.platform.DesktopWindow;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.WINDOWINFO;

/**
 * @author frolov
 *
 */
public class User32Utils {

	private static User32Extra user32 = User32Extra.INSTANCE;

	public static WindowHolder findAndShowWindow(String className, String windowsName) {
		HWND hWnd = user32.FindWindow(className, windowsName);
		if (hWnd == null) {
			System.out.println("there is no running calc app");
			return null;
		}
		user32.ShowWindow(hWnd, User32.SW_SHOW);
		WINDOWINFO pwi = new WINDOWINFO();
		WindowHolder windowHolder = new WindowHolder(hWnd, pwi);
		user32.SetForegroundWindow(hWnd);
		return windowHolder;
	}

	public static boolean showWindow(HWND handler) {
		return user32.SetForegroundWindow(handler);
	}

	public static WindowHolder findChildWindowByText(WindowHolder parenWindow, String text) {
		WinDef.DWORD fiveButton = new WinDef.DWORD(Long.parseLong(text));
		WinDef.HWND fiveButtonWnd = user32.GetWindow(parenWindow.getParentWindow(), fiveButton);
		if (fiveButtonWnd == null) {
			return null;
		}
		WINDOWINFO pwi = new WINDOWINFO();
		System.out.println(user32.GetWindowInfo(fiveButtonWnd, pwi));
		WindowHolder windowHolder = new WindowHolder(fiveButtonWnd, pwi);
		return windowHolder;
	}

	public static DesktopWindow findAndShowWindow(String title) {
		List<DesktopWindow> allWindows = WindowUtils.getAllWindows(true);
		for (DesktopWindow window : allWindows) {
			if (window.getTitle().equals(title)) {
				user32.SetForegroundWindow(window.getHWND());
				return window;
			}
		}
		return null;
	}

}
