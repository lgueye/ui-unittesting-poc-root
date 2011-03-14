package org.diveintojee.poc.ui.unittesting.root.window.view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenu dealsMenu = null;

	private JMenuItem findDealsByCriteriaMenuItem = null;

	/**
	 * This method initializes
	 * 
	 */
	public MenuBar() {
		super();
		initialize();
	}

	/**
	 * This method initializes dealsMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getDealsMenu() {
		if (dealsMenu == null) {
			dealsMenu = new JMenu("Deals");
			dealsMenu.setMnemonic(KeyEvent.VK_D);
			dealsMenu.add(getFindDealsByCriteriaMenuItem());
		}
		return dealsMenu;
	}

	/**
	 * This method initializes indicatorsMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getFindDealsByCriteriaMenuItem() {
		if (findDealsByCriteriaMenuItem == null) {
			findDealsByCriteriaMenuItem = new JMenuItem("Find by criteria");
			findDealsByCriteriaMenuItem.setMnemonic(KeyEvent.VK_F);
		}
		return findDealsByCriteriaMenuItem;
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(99, 25));

		this.add(getDealsMenu());
	}

} // @jve:decl-index=0:visual-constraint="10,10"
