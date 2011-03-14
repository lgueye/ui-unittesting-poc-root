/*
 * Created by JFormDesigner on Sat Feb 26 19:27:06 CET 2011
 */

package org.diveintojee.poc.ui.unittesting.deals.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.MessageFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.apache.commons.collections.CollectionUtils;
import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.jdesktop.swingx.JXDatePicker;

/**
 * @author louis.gueye@gmail.com
 */
public class FindDealsByCriteriaInternalFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String RESULTS_TITLE_PATTERN = "{0} occurences";

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JSplitPane splitPane;
	private JPanel leftPanel;
	private JLabel startDateLabel;
	private JXDatePicker startDatePicker;
	private JLabel endDateLabel;
	private JXDatePicker endDatePicker;
	private JLabel entityLabel;
	private JComboBox entityComboBox;
	private JLabel currencyLabel;
	private JScrollPane currencyScrollPane;
	private JList currencyList;
	private JLabel productFamilyLabel;
	private JComboBox productTypeComboBox;
	private JButton okButton;
	private JButton clearButton;
	private JPanel rightPanel;
	private JScrollPane resultsScrollPane;
	private JTable resultsTable;

	// JFormDesigner - End of variables declaration //GEN-END:variables
	public FindDealsByCriteriaInternalFrame() {
		initComponents();
	}

	/**
	 * @return the resetButton
	 */
	public JButton getClearButton() {
		return clearButton;
	}

	/**
	 * @return the currencyList
	 */
	public JList getCurrencyList() {
		return currencyList;
	}

	/**
	 * @return the endDatePicker
	 */
	public JXDatePicker getEndDatePicker() {
		return endDatePicker;
	}

	/**
	 * @return the entityComboBox
	 */
	public JComboBox getEntityComboBox() {
		return entityComboBox;
	}

	/**
	 * @return the okButton
	 */
	public JButton getOkButton() {
		return okButton;
	}

	/**
	 * @return the productTypeComboBox
	 */
	public JComboBox getProductTypeComboBox() {
		return productTypeComboBox;
	}

	public JScrollPane getResultsScrollPane() {
		return resultsScrollPane;
	}

	/**
	 * @return the resultsTable
	 */
	public JTable getResultsTable() {
		return resultsTable;
	}

	public JPanel getRightPanel() {
		return this.rightPanel;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	/**
	 * @return the startDatePicker
	 */
	public JXDatePicker getStartDatePicker() {
		return startDatePicker;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		splitPane = new JSplitPane();
		leftPanel = new JPanel();
		startDateLabel = new JLabel();
		startDatePicker = new JXDatePicker();
		endDateLabel = new JLabel();
		endDatePicker = new JXDatePicker();
		entityLabel = new JLabel();
		entityComboBox = new JComboBox();
		currencyLabel = new JLabel();
		currencyScrollPane = new JScrollPane();
		currencyList = new JList();
		productFamilyLabel = new JLabel();
		productTypeComboBox = new JComboBox();
		okButton = new JButton();
		clearButton = new JButton();
		rightPanel = new JPanel();
		resultsScrollPane = new JScrollPane();
		resultsTable = new JTable();

		// ======== this ========
		setVisible(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] {
				704, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 0, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				1.0, 1.0E-4 };

		// ======== splitPane ========
		{

			// ======== leftPanel ========
			{
				leftPanel.setBorder(new TitledBorder("Criteria"));
				leftPanel.setLayout(new GridBagLayout());
				((GridBagLayout) leftPanel.getLayout()).columnWidths = new int[] {
						0, 0, 0, 0 };
				((GridBagLayout) leftPanel.getLayout()).rowHeights = new int[] {
						0, 0, 29, 69, 0, 0, 0 };
				((GridBagLayout) leftPanel.getLayout()).columnWeights = new double[] {
						0.0, 0.0, 0.0, 1.0E-4 };
				((GridBagLayout) leftPanel.getLayout()).rowWeights = new double[] {
						0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

				// ---- startDateLabel ----
				startDateLabel.setText("Start date");
				leftPanel.add(startDateLabel, new GridBagConstraints(0, 0, 1,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 3), 0, 0));
				leftPanel.add(startDatePicker, new GridBagConstraints(1, 0, 2,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 0), 0, 0));

				// ---- endDateLabel ----
				endDateLabel.setText("End date");
				leftPanel.add(endDateLabel, new GridBagConstraints(0, 1, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 3), 0, 0));
				leftPanel.add(endDatePicker, new GridBagConstraints(1, 1, 2, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 0), 0, 0));

				// ---- entityLabel ----
				entityLabel.setText("Entity");
				leftPanel.add(entityLabel, new GridBagConstraints(0, 2, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 3), 0, 0));
				leftPanel.add(entityComboBox, new GridBagConstraints(1, 2, 2,
						1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 0), 0, 0));

				// ---- currencyLabel ----
				currencyLabel.setText("Currency");
				currencyLabel.setVerticalAlignment(SwingConstants.TOP);
				leftPanel.add(currencyLabel, new GridBagConstraints(0, 3, 1, 1,
						0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 3), 0, 0));

				// ======== currencyScrollPane ========
				{
					currencyScrollPane.setViewportBorder(new LineBorder(
							Color.black));

					// ---- currencyList ----
					currencyList.setVisibleRowCount(3);
					currencyScrollPane.setViewportView(currencyList);
				}
				leftPanel.add(currencyScrollPane, new GridBagConstraints(1, 3,
						2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 0), 0, 0));

				// ---- productFamilyLabel ----
				productFamilyLabel.setText("Product type");
				leftPanel.add(productFamilyLabel, new GridBagConstraints(0, 4,
						1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 3), 0, 0));
				leftPanel.add(productTypeComboBox, new GridBagConstraints(1, 4,
						2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 3, 0), 0, 0));

				// ---- okButton ----
				okButton.setText("ok");
				leftPanel.add(okButton, new GridBagConstraints(1, 5, 1, 1, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 3), 0, 0));

				// ---- clearButton ----
				clearButton.setText("clear");
				leftPanel.add(clearButton, new GridBagConstraints(2, 5, 1, 1,
						0.0, 0.0, GridBagConstraints.WEST,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			}
			splitPane.setLeftComponent(leftPanel);

			// ======== rightPanel ========
			{
				rightPanel.setBorder(new TitledBorder("0 occurences"));
				rightPanel.setLayout(new GridBagLayout());
				((GridBagLayout) rightPanel.getLayout()).columnWidths = new int[] {
						291, 0 };
				((GridBagLayout) rightPanel.getLayout()).rowHeights = new int[] {
						0, 0 };
				((GridBagLayout) rightPanel.getLayout()).columnWeights = new double[] {
						1.0, 1.0E-4 };
				((GridBagLayout) rightPanel.getLayout()).rowWeights = new double[] {
						1.0, 1.0E-4 };

				// ======== resultsScrollPane ========
				{
					resultsScrollPane.setViewportView(resultsTable);
				}
				rightPanel.add(resultsScrollPane, new GridBagConstraints(0, 0,
						1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			}
			splitPane.setRightComponent(rightPanel);
		}
		contentPane.add(splitPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 0, 0));
		// //GEN-END:initComponents
	}

	public void updateResultsTitle(final List<Deal> results) {

		int size = CollectionUtils.isEmpty(results) ? 0 : results.size();

		((TitledBorder) rightPanel.getBorder()).setTitle(MessageFormat.format(
				FindDealsByCriteriaInternalFrame.RESULTS_TITLE_PATTERN, size));
	}

}
