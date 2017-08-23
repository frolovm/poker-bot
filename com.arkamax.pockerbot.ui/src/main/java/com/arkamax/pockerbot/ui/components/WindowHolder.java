/**
 * 
 */
package com.arkamax.pockerbot.ui.components;

import java.awt.Rectangle;

import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinUser.WINDOWINFO;

/**
 * @author frolov
 *
 */
public class WindowHolder {

	private HWND parentWindow;

	private RECT rect;

	private RECT clientRect;

	private WINDOWINFO info;

	public WindowHolder(HWND parentWindow) {
		super();
		this.parentWindow = parentWindow;
	}

	public WindowHolder(HWND parentWindow, RECT rect) {
		super();
		this.parentWindow = parentWindow;
		this.rect = rect;
	}

	public WindowHolder(HWND parentWindow, WINDOWINFO info) {
		super();
		this.parentWindow = parentWindow;
		this.info = info;
		this.rect = info.rcWindow;
		this.clientRect = info.rcClient;
	}

	public HWND getParentWindow() {
		return parentWindow;
	}

	public Rectangle getRect() {
		return rect.toRectangle();
	}

	public Rectangle getClientRect() {
		return clientRect.toRectangle();
	}

	public WINDOWINFO getInfo() {
		return info;
	}

}
