/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.root.window;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

import org.diveintojee.poc.ui.unittesting.Constants;
import org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController;
import org.diveintojee.poc.ui.unittesting.root.window.view.MenuBar;
import org.diveintojee.poc.ui.unittesting.root.window.view.RootWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;

/**
 * @author louis.gueye@gmail.com
 * 
 */
@Component(RootWindowController.BEAN_ID)
public class RootWindowController implements ActionListener {

	public static final String BEAN_ID = "rootWindowController";

	private RootWindow view;

	@Autowired
	@Qualifier(Constants.MESSAGE_SOURCE_BEAN_ID)
	MessageSource messageSource;

	@Autowired
	@Qualifier(FindDealsByCriteriaController.BEAN_ID)
	private FindDealsByCriteriaController findDealsByCriteriaController;

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource().equals(
				((MenuBar) getView().getJMenuBar())
						.getFindDealsByCriteriaMenuItem()))
			onDealsMenuItemClick();

	}

	public void addInternalFrame(final JInternalFrame frame) {

		if (frame == null)
			return;

		if (containsInternalFrame(frame))
			return;

		((JDesktopPane) getView().getContentPane()).add(frame);

	}

	protected void addListeners() {

		((MenuBar) getView().getJMenuBar()).getFindDealsByCriteriaMenuItem()
				.addActionListener(this);

	}

	protected boolean containsInternalFrame(final JInternalFrame frame) {

		JDesktopPane desktop = (JDesktopPane) getView().getContentPane();

		if (desktop.getComponents() == null
				|| desktop.getComponents().length == 0)
			return false;

		return Arrays.asList(desktop.getComponents()).contains(frame);

	}

	private void createView() {

		try {
			UIManager.setLookAndFeel(PlasticXPLookAndFeel.class.getName());
		} catch (Throwable e) {
			e.printStackTrace();
			// How ugly
		}

		setView(new RootWindow());

		int initialWidth = Integer.valueOf(messageSource.getMessage(
				Constants.ROOT_WINDOW_INITIAL_WIDTH_KEY, null, null));

		int initialHeight = Integer.valueOf(messageSource.getMessage(
				Constants.ROOT_WINDOW_INITIAL_HEIGHT_KEY, null, null));

		getView().setPreferredSize(new Dimension(initialWidth, initialHeight));

		getView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getView().setResizable(true);

		getView().pack();
	}

	public RootWindow getView() {
		return view;
	}

	public void initialize() {

		createView();

		showView(true);

		addListeners();

	}

	protected void onDealsMenuItemClick() {
		findDealsByCriteriaController.initialize();
		JInternalFrame frame = findDealsByCriteriaController.getView();
		findDealsByCriteriaController.showView(true);

		addInternalFrame(frame);
		showInternalFrame(frame);
	}

	public void setView(final Object view) {
		this.view = (RootWindow) view;
	}

	public void showInternalFrame(final JInternalFrame frame) {

		if (frame == null)
			return;

		if (!containsInternalFrame(frame))
			return;

		frame.moveToFront();

	}

	public void showView(final boolean visibility) {

		if (getView() == null)
			throw new IllegalStateException("Consider initializing the view");

		getView().setVisible(true);

	}

}
