package com.arkamax.pockerbot.ui.calc;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

public class WindowSearchCalback implements WNDENUMPROC {

	private static List<HWND> childList = new ArrayList<HWND>();

	public WindowSearchCalback() {
	}

	@Override
	public boolean callback(HWND hWnd, Pointer data) {
		char[] textBuffer = new char[512];
		char[] textBuffer2 = new char[512];
		User32.INSTANCE.GetClassName(hWnd, textBuffer, 512);
		User32.INSTANCE.GetWindowText(hWnd, textBuffer2, 512);
		String wText = Native.toString(textBuffer);
		String wText2 = Native.toString(textBuffer2);
		childList.add(hWnd);
		System.out.println("className: " + wText + " title: " + wText2);
		return true;
	}

	public List<HWND> getChildList() {
		return childList;
	}

}
