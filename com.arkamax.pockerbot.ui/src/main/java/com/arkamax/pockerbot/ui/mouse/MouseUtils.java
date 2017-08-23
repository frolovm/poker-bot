package com.arkamax.pockerbot.ui.mouse;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.platform.win32.WinUser.*;
import com.sun.jna.win32.StdCallLibrary;

public class MouseUtils {

	public interface User32 extends StdCallLibrary {
		public static final long MOUSEEVENTF_MOVE = 0x0001L;
		public static final long MOUSEEVENTF_VIRTUALDESK = 0x4000L;
		public static final long MOUSEEVENTF_ABSOLUTE = 0x8000L;
		public static final int SM_CXSCREEN = 0x0;
		public static final int SM_CYSCREEN = 0x1;
		User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

		DWORD SendInput(DWORD dWord, INPUT[] input, int cbSize);

		boolean ClientToScreen(HWND hWnd, POINT lpPoint);
		
	    boolean GetWindowRect(HWND hWnd, RECT rect);
		
		int GetSystemMetrics(int index);
	}

	public static boolean mouseMove(HWND hWnd) {
		INPUT input = new INPUT();
		input.type = new DWORD(INPUT.INPUT_MOUSE);

		input.input.setType("mi");
		RECT rect = new RECT();
		User32.INSTANCE.GetWindowRect(hWnd, rect);
		POINT point = new POINT(rect.getPointer());
		System.out.println("Before : " + point.x + " " + point.y);
		User32.INSTANCE.ClientToScreen(hWnd, point);
		System.out.println("After : " + point.x + " " + point.y);
		input.input.mi.dx = new LONG(point.x * 65536 / User32.INSTANCE.GetSystemMetrics(User32.SM_CXSCREEN));
		input.input.mi.dy = new LONG(point.y * 65536 / User32.INSTANCE.GetSystemMetrics(User32.SM_CXSCREEN));

		input.input.mi.mouseData = new DWORD(0);
		input.input.mi.dwFlags = new DWORD(
				User32.MOUSEEVENTF_MOVE | User32.MOUSEEVENTF_VIRTUALDESK | User32.MOUSEEVENTF_ABSOLUTE);
		// input.input.mi.dwFlags = new DWORD(0x8000L);
		input.input.mi.time = new DWORD(0);

		INPUT[] inArray = { input };

		int cbSize = input.size(); // mouse input struct size
		DWORD nInputs = new DWORD(1); // number of inputs
		DWORD result = User32.INSTANCE.SendInput(nInputs, inArray, cbSize);
		return result.intValue() == 1;
	}

}