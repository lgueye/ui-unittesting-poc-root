/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.deals.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.diveintojee.poc.ui.unittesting.Constants;
import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.Product;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class FindDealByCriteriaResultsTableModelTest {

	private FindDealByCriteriaResultsTableModel underTest;

	@Before
	public void before() {
		underTest = new FindDealByCriteriaResultsTableModel();
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getValueAt(int, int)}
	 * .
	 */
	@Test
	public final void getValueAtShouldReturnNullWhenColumnIndexExceedsColumnCount() {
		// Given
		String[] columns = new String[] { "a", "b" };
		underTest.setColumns(columns);
		int rowIndex = 0;
		int columnIndex = 2;
		// When
		Object value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertNull(value);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getValueAt(int, int)}
	 * .
	 */
	@Test
	public final void getValueAtShouldReturnNullWhenColumnIndexIsNegative() {
		// Given
		int rowIndex = 0;
		int columnIndex = -1;
		// When
		Object value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertNull(value);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getValueAt(int, int)}
	 * .
	 */
	@Test
	public final void getValueAtShouldReturnNullWhenRowIndexExceedsRowCount() {
		// Given
		List<Deal> rows = new ArrayList<Deal>();
		rows.add(new Deal());
		rows.add(new Deal());
		underTest.setRows(rows);
		int rowIndex = 6;
		int columnIndex = 0;
		// When
		Object value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertNull(value);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getValueAt(int, int)}
	 * .
	 */
	@Test
	public final void getValueAtShouldReturnNullWhenRowIndexIsNegative() {
		// Given
		int rowIndex = -1;
		int columnIndex = 0;
		// When
		Object value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertNull(value);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getColumnClass(int)}
	 * .
	 */
	@Test
	public final void testGetColumnClass() {

		int columnIndex = 0;
		Class<?> clazz = null;

		// Given
		columnIndex = 0;
		// When
		clazz = underTest.getColumnClass(columnIndex);
		// Then
		Assert.assertEquals(String.class, clazz);

		// Given
		columnIndex = 1;
		// When
		clazz = underTest.getColumnClass(columnIndex);
		// Then
		Assert.assertEquals(Entity.class, clazz);

		// Given
		columnIndex = 2;
		// When
		clazz = underTest.getColumnClass(columnIndex);
		// Then
		Assert.assertEquals(ProductType.class, clazz);

		// Given
		columnIndex = 3;
		// When
		clazz = underTest.getColumnClass(columnIndex);
		// Then
		Assert.assertEquals(BigDecimal.class, clazz);

		// Given
		columnIndex = 4;
		// When
		clazz = underTest.getColumnClass(columnIndex);
		// Then
		Assert.assertEquals(String.class, clazz);

		// Given
		columnIndex = -1;
		// When
		clazz = underTest.getColumnClass(columnIndex);
		// Then
		Assert.assertEquals(Object.class, clazz);

		// Given
		columnIndex = 20;
		// When
		clazz = underTest.getColumnClass(columnIndex);
		// Then
		Assert.assertEquals(Object.class, clazz);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getColumnCount()}
	 * .
	 */
	@Test
	public final void testGetColumnCount() {
		// Given
		int expected = ArrayUtils.isEmpty(underTest.getColumns()) ? 0
				: underTest.getColumns().length;
		// When
		int actual = underTest.getColumnCount();
		// Then
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getRowCount()}
	 * .
	 */
	@Test
	public final void testGetRowCount() {
		// Given
		int expected = CollectionUtils.isEmpty(underTest.getRows()) ? 0
				: underTest.getRows().size();
		// When
		int actual = underTest.getRowCount();
		// Then
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel#getValueAt(int, int)}
	 * .
	 */
	@Test
	public final void testGetValueAt() {
		// Given
		List<Deal> rows = new ArrayList<Deal>();
		Deal deal = new Deal();
		BigDecimal amount = BigDecimal.valueOf(153);
		deal.setAmount(amount);
		Date asOfDate = Calendar.getInstance().getTime();
		deal.setAsOfDate(asOfDate);
		String currencyCode = Currency.getInstance(Locale.US).getCurrencyCode();
		deal.setCurrencyCode(currencyCode);
		Entity entity = new Entity();
		String entityLabel = "Hong-Kong";
		entity.setLabel(entityLabel);
		deal.setEntity(entity);
		ProductType type = new ProductType();
		String productTypeLabel = "Bonds";
		type.setLabel(productTypeLabel);
		deal.setProduct(new Product());
		deal.getProduct().setType(type);
		rows.add(deal);
		underTest.setRows(rows);

		String[] columns = { "Date", "Entity", "Product type", "Amount",
				"Currency" };
		underTest.setColumns(columns);

		int rowIndex = 0;
		int columnIndex = 0;
		Object value = null;

		// Given
		columnIndex = 0;
		// When
		value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertEquals(Constants.DATE_FORMAT.format(deal.getAsOfDate()),
				value);

		// Given
		columnIndex = 1;
		// When
		value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertEquals(entity, value);

		// Given
		columnIndex = 2;
		// When
		value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertEquals(type, value);

		// Given
		columnIndex = 3;
		// When
		value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertEquals(deal.getAmount().setScale(Constants.AMOUNTS_SCALE),
				value);

		// Given
		columnIndex = 4;
		// When
		value = underTest.getValueAt(rowIndex, columnIndex);
		// Then
		Assert.assertEquals(deal.getCurrencyCode(), value);

	}

}
