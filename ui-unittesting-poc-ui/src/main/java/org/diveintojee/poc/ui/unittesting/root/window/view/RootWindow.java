package org.diveintojee.poc.ui.unittesting.root.window.view;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class RootWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JDesktopPane jContentPane = null;

	/**
	 * This is the default constructor
	 */
	public RootWindow() {
		super();
		initialize();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JDesktopPane getJContentPane() {
		if (this.jContentPane == null) {
			this.jContentPane = new JDesktopPane();
			this.jContentPane.setLayout(new BorderLayout());
		}
		return this.jContentPane;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		// this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle(getClass().getName());
		setJMenuBar(new MenuBar());
	}

}
