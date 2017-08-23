package com.arkamax.pockerbot.ui.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.W32APIOptions;

public interface User32Extra extends User32 {

    User32Extra INSTANCE = (User32Extra) Native.loadLibrary("user32", User32Extra.class, W32APIOptions.DEFAULT_OPTIONS);

	public static final long MOUSEEVENTF_MOVE = 0x0001L;
	public static final long MOUSEEVENTF_VIRTUALDESK = 0x4000L;
	public static final long MOUSEEVENTF_ABSOLUTE = 0x8000L;
	public static final int SM_CXSCREEN = 0x0;
	public static final int SM_CYSCREEN = 0x1;

	public static final DWORD GW_OWNER = new DWORD(4);
	
	DWORD SendInput(DWORD dWord, INPUT[] input, int cbSize);

	boolean ClientToScreen(HWND hWnd, POINT lpPoint);
	
    boolean GetWindowRect(HWND hWnd, RECT rect);
    

	boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);

	boolean EnumChildWindows(HWND hWnd, WNDENUMPROC lpEnumFunc, Pointer data);

	int GetWindowText(HWND hWnd, char[] lpString, int nMaxCount);

	int GetClassName(HWND hWnd, char[] lpClassName, int nMaxCount);

	public HWND GetWindow(HWND hWnd, DWORD cmd);

	HWND GetParent(HWND hWnd);
	
}
