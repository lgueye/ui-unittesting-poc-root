/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.deals;

import static org.mockito.Matchers.any;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.diveintojee.poc.ui.unittesting.deals.model.FindDealByCriteriaResultsTableModel;
import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.diveintojee.poc.ui.unittesting.domain.services.DealService;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.diveintojee.poc.ui.unittesting.domain.services.ReferentialService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author louis.gueye@gmail.com
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class FindDealsByCriteriaControllerTest {

	@Mock
	private final ReferentialService referentialService = null;

	@Mock
	private final DealService dealService = null;

	@InjectMocks
	private final FindDealsByCriteriaController underTest = new FindDealsByCriteriaController();

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#createView()}
	 * .
	 */
	@Test
	public final void createViewShouldAlsoInitializeComponentModels() {

		// Given

		// When
		underTest.createView();

		// Then
		Assert.assertNotNull(underTest.getView());
		Assert.assertNotNull(underTest.getView().getResultsTable().getModel());
		Assert.assertTrue(underTest.getView().getResultsTable().getModel() instanceof FindDealByCriteriaResultsTableModel);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#loadReferentialData()}
	 * .
	 */
	@Test
	public final void loadReferentialDataShouldAddEntityItems() {
		underTest.createView();

		final List<Entity> entities = new ArrayList<Entity>();
		entities.add(new Entity());
		// Given
		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				entities);

		// When
		underTest.loadReferentialData();

		// Then
		Mockito.verify(referentialService, Mockito.times(1)).loadAllEntities();
		Assert.assertEquals(entities, underTest.getModel().getEntities());
		Assert.assertEquals((entities.size() + 1), underTest.getView()
				.getEntityComboBox().getItemCount());
		Assert.assertEquals(Entity.EMPTY, underTest.getView()
				.getEntityComboBox().getItemAt(0));

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#loadReferentialData()}
	 * .
	 */
	@Test
	public final void loadReferentialDataShouldAddProductTypeItems() {
		underTest.createView();

		final List<ProductType> productTypes = new ArrayList<ProductType>();
		productTypes.add(new ProductType());
		// Given
		BDDMockito.given(referentialService.loadAllProductTypes()).willReturn(
				productTypes);

		// When
		underTest.loadReferentialData();

		// Then
		Mockito.verify(referentialService, Mockito.times(1))
				.loadAllProductTypes();
		Assert.assertEquals(productTypes, underTest.getModel()
				.getProductTypes());
		Assert.assertEquals((productTypes.size() + 1), underTest.getView()
				.getProductTypeComboBox().getItemCount());
		Assert.assertEquals(ProductType.EMPTY, underTest.getView()
				.getProductTypeComboBox().getItemAt(0));

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#loadReferentialData()}
	 * .
	 */
	@Test
	public final void loadReferentialDataShouldInstanciateAModelIfNecessary() {
		underTest.createView();
		Assert.assertNull(underTest.getModel());
		underTest.loadReferentialData();
		Assert.assertNotNull(underTest.getModel());
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#loadReferentialData()}
	 * .
	 */
	@Test
	public final void loadReferentialDataShouldRemoveAllEntityItems() {
		underTest.createView();

		final List<Entity> nullEntities = null;
		// Given
		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				nullEntities);

		// When
		underTest.loadReferentialData();

		// Then
		Mockito.verify(referentialService, Mockito.times(1)).loadAllEntities();
		Assert.assertNull(underTest.getModel().getEntities());
		Assert.assertEquals(0, underTest.getView().getEntityComboBox()
				.getItemCount());

		Mockito.reset(referentialService);

		final List<Entity> emptyEntities = new ArrayList<Entity>();
		// Given
		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				emptyEntities);

		// When
		underTest.loadReferentialData();

		// Then
		Mockito.verify(referentialService, Mockito.times(1)).loadAllEntities();
		Assert.assertNotNull(underTest.getModel().getEntities());
		Assert.assertEquals(0, underTest.getView().getEntityComboBox()
				.getItemCount());

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#loadReferentialData()}
	 * .
	 */
	@Test
	public final void loadReferentialDataShouldRemoveAllProductTypeItems() {
		underTest.createView();

		final List<ProductType> nullProductTypes = null;
		// Given
		BDDMockito.given(referentialService.loadAllProductTypes()).willReturn(
				nullProductTypes);

		// When
		underTest.loadReferentialData();

		// Then
		Mockito.verify(referentialService, Mockito.times(1))
				.loadAllProductTypes();
		Assert.assertNull(underTest.getModel().getProductTypes());
		Assert.assertEquals(0, underTest.getView().getProductTypeComboBox()
				.getItemCount());

		Mockito.reset(referentialService);

		final List<ProductType> emptyProductTypes = new ArrayList<ProductType>();
		// Given
		BDDMockito.given(referentialService.loadAllProductTypes()).willReturn(
				emptyProductTypes);

		// When
		underTest.loadReferentialData();

		// Then
		Mockito.verify(referentialService, Mockito.times(1))
				.loadAllProductTypes();
		Assert.assertNotNull(underTest.getModel().getProductTypes());
		Assert.assertEquals(0, underTest.getView().getProductTypeComboBox()
				.getItemCount());
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#onClearButtonClick()}
	 * .
	 */
	@Test
	public final void onClearButtonClickShouldNullifyTheModel() {
		// Given
		underTest.initialize();
		ActionEvent e = new ActionEvent(underTest.getView().getClearButton(),
				0, "Clear");

		// When
		underTest.actionPerformed(e);

		// Then
		Assert.assertNull(underTest.getModel());
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#onEntitySelectionChange()}
	 * .
	 */
	@Test
	public final void onEntitySelectionChangeSetsModelEntity() {
		// Given
		final List<Entity> entities = new ArrayList<Entity>();

		Entity entity = new Entity();
		entities.add(entity);
		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				entities);

		// When
		underTest.initialize();
		underTest.getView().getEntityComboBox().setSelectedIndex(1);

		// Then
		Mockito.verify(referentialService, Mockito.times(1)).loadAllEntities();
		Assert.assertNotNull(underTest.getModel());
		Assert.assertEquals(entity, underTest.getModel().getCriteria()
				.getEntity());
		Assert.assertNull(underTest.getModel().getCriteria().getCurrencyCodes());
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#onEntitySelectionChange()}
	 * .
	 */
	@Test
	public final void onEntitySelectionChangeShouldInstanciateAModelIfNecessary() {
		// Given
		final List<Entity> entities = new ArrayList<Entity>();
		entities.add(new Entity());
		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				entities);

		// When
		underTest.initialize();
		underTest.getView().getEntityComboBox().setSelectedIndex(1);

		// Then
		Mockito.verify(referentialService, Mockito.times(1)).loadAllEntities();
		Assert.assertNotNull(underTest.getModel());
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#onOkButtonClick()}
	 * .
	 */
	@Test
	public final void onOkButtonClickWillSetModelResults() {
		// Given
		underTest.createView();

		final List<Entity> entities = new ArrayList<Entity>();
		Entity entity = new Entity();
		entities.add(entity);
		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				entities);
		final List<ProductType> productTypes = new ArrayList<ProductType>();
		ProductType productType = new ProductType();
		productTypes.add(productType);
		BDDMockito.given(referentialService.loadAllProductTypes()).willReturn(
				productTypes);

		final List<Deal> results = new ArrayList<Deal>();
		results.add(new Deal());
		BDDMockito.given(
				dealService.findByCriteria(any(DealsSearchCriteria.class)))
				.willReturn(results);

		underTest.initialize();

		// When
		ActionEvent e = new ActionEvent(underTest.getView().getOkButton(), 0,
				"Ok");
		underTest.actionPerformed(e);

		// Then
		Assert.assertEquals(results, underTest.getModel().getResults());
		Assert.assertEquals(results,
				((FindDealByCriteriaResultsTableModel) underTest.getView()
						.getResultsTable().getModel()).getRows());

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#addListeners()}
	 * .
	 */
	@Test
	public final void testAddListeners() {

		// Given

		// When
		underTest.createView();
		underTest.addListeners();

		// Then
		ActionListener[] okButtonActionListenersArray = underTest.getView()
				.getOkButton().getListeners(ActionListener.class);
		Assert.assertNotNull(okButtonActionListenersArray);
		Assert.assertTrue(okButtonActionListenersArray.length == 1);
		Assert.assertTrue(okButtonActionListenersArray[0] == underTest);

		ActionListener[] clearButtonActionListenersArray = underTest.getView()
				.getClearButton().getListeners(ActionListener.class);
		Assert.assertNotNull(clearButtonActionListenersArray);
		Assert.assertTrue(clearButtonActionListenersArray.length == 1);
		Assert.assertTrue(clearButtonActionListenersArray[0] == underTest);

		ActionListener[] entityComboBoxActionListenersArray = underTest
				.getView().getEntityComboBox()
				.getListeners(ActionListener.class);
		Assert.assertNotNull(entityComboBoxActionListenersArray);
		Assert.assertTrue(entityComboBoxActionListenersArray.length == 1);
		Assert.assertTrue(entityComboBoxActionListenersArray[0] == underTest);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#removeListeners()}
	 * .
	 */
	@Test
	public final void testRemoveListeners() {
		underTest.createView();
		underTest.addListeners();
		underTest.removeListeners();

		ActionListener[] okButtonActionListenersArray = underTest.getView()
				.getOkButton().getListeners(ActionListener.class);
		Assert.assertNotNull(okButtonActionListenersArray);
		Assert.assertTrue(okButtonActionListenersArray.length == 0);

		ActionListener[] clearButtonActionListenersArray = underTest.getView()
				.getClearButton().getListeners(ActionListener.class);
		Assert.assertNotNull(clearButtonActionListenersArray);
		Assert.assertTrue(clearButtonActionListenersArray.length == 0);

		ActionListener[] entityComboBoxActionListenersArray = underTest
				.getView().getEntityComboBox()
				.getListeners(ActionListener.class);
		Assert.assertNotNull(entityComboBoxActionListenersArray);
		Assert.assertTrue(entityComboBoxActionListenersArray.length == 0);
	}

	public final void updateModelFromViewSetsModelProperties() {

		// Given
		underTest.createView();// No listeners

		final List<Entity> entities = new ArrayList<Entity>();
		Entity entity = new Entity();
		List<String> currencyCodes = new ArrayList<String>();
		String selectedCurrency = Currency.getInstance(Locale.US)
				.getCurrencyCode();
		currencyCodes.add(selectedCurrency);
		currencyCodes
				.add(Currency.getInstance(Locale.FRANCE).getCurrencyCode());
		entities.add(entity);

		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				entities);
		final List<ProductType> productTypes = new ArrayList<ProductType>();
		ProductType productType = new ProductType();
		productTypes.add(productType);
		BDDMockito.given(referentialService.loadAllProductTypes()).willReturn(
				productTypes);
		underTest.loadReferentialData();

		Calendar startDateCalendar = Calendar.getInstance();
		startDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
		startDateCalendar.set(Calendar.MINUTE, 0);
		startDateCalendar.set(Calendar.SECOND, 0);
		startDateCalendar.set(Calendar.MILLISECOND, 0);

		Calendar endDateCalendar = Calendar.getInstance();
		endDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endDateCalendar.set(Calendar.MINUTE, 0);
		endDateCalendar.set(Calendar.SECOND, 0);
		endDateCalendar.set(Calendar.MILLISECOND, 0);
		endDateCalendar.add(Calendar.DAY_OF_MONTH, 20);

		// When
		underTest.getView().getStartDatePicker()
				.setDate(startDateCalendar.getTime());
		underTest.getView().getEndDatePicker()
				.setDate(endDateCalendar.getTime());
		underTest.getView().getEntityComboBox().setSelectedItem(entity);
		underTest.getView().getProductTypeComboBox()
				.setSelectedItem(productType);
		underTest.getView().getCurrencyList()
				.setSelectedValue(selectedCurrency, false);

		// Then
		Assert.assertEquals(underTest.getView().getStartDatePicker().getDate(),
				underTest.getModel().getCriteria().getStartDate());
		Assert.assertEquals(underTest.getView().getEndDatePicker().getDate(),
				underTest.getModel().getCriteria().getEndDate());
		Assert.assertEquals(underTest.getView().getEntityComboBox()
				.getSelectedItem(), underTest.getModel().getCriteria()
				.getEntity());
		Assert.assertEquals(underTest.getView().getProductTypeComboBox()
				.getSelectedItem(), underTest.getModel().getCriteria()
				.getProductType());
		Assert.assertEquals(
				Arrays.asList(underTest.getView().getCurrencyList()
						.getSelectedValues()), underTest.getModel()
						.getCriteria().getCurrencyCodes());

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#updateViewFromModel()}
	 * .
	 */
	@Test
	public final void updateViewFromModelResetsView() {
		// Given
		underTest.createView();

		// When
		underTest.updateViewFromModel();

		// Then
		Assert.assertNull(underTest.getView().getStartDatePicker().getDate());
		Assert.assertNull(underTest.getView().getEndDatePicker().getDate());
		Assert.assertEquals(-1, underTest.getView().getEntityComboBox()
				.getSelectedIndex());
		Assert.assertEquals(-1, underTest.getView().getProductTypeComboBox()
				.getSelectedIndex());
		Assert.assertEquals(0, underTest.getView().getCurrencyList().getModel()
				.getSize());
		Assert.assertEquals(0, underTest.getView().getResultsTable()
				.getRowCount());
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.deals.FindDealsByCriteriaController#updateViewFromModel()}
	 * .
	 */
	@Test
	public final void updateViewFromModelSetsViewComponents() {
		// Given
		underTest.createView();

		final List<Entity> entities = new ArrayList<Entity>();
		Entity entity = new Entity();
		entities.add(entity);
		BDDMockito.given(referentialService.loadAllEntities()).willReturn(
				entities);
		final List<ProductType> productTypes = new ArrayList<ProductType>();
		ProductType productType = new ProductType();
		productTypes.add(productType);
		BDDMockito.given(referentialService.loadAllProductTypes()).willReturn(
				productTypes);

		underTest.loadReferentialData();
		Calendar startDateCalendar = Calendar.getInstance();
		startDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
		startDateCalendar.set(Calendar.MINUTE, 0);
		startDateCalendar.set(Calendar.SECOND, 0);
		startDateCalendar.set(Calendar.MILLISECOND, 0);
		underTest.getModel().getCriteria()
				.setStartDate(startDateCalendar.getTime());

		Calendar endDateCalendar = Calendar.getInstance();
		endDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endDateCalendar.set(Calendar.MINUTE, 0);
		endDateCalendar.set(Calendar.SECOND, 0);
		endDateCalendar.set(Calendar.MILLISECOND, 0);
		underTest.getModel().getCriteria()
				.setEndDate(endDateCalendar.getTime());

		underTest.getModel().getCriteria().setProductType(productType);
		underTest.getModel().getCriteria().setEntity(entity);

		// When
		underTest.updateViewFromModel();

		// Then
		Assert.assertEquals(underTest.getModel().getCriteria().getStartDate(),
				underTest.getView().getStartDatePicker().getDate());
		Assert.assertEquals(underTest.getModel().getCriteria().getEndDate(),
				underTest.getView().getEndDatePicker().getDate());
		Assert.assertEquals(
				underTest.getModel().getCriteria().getProductType(), underTest
						.getView().getProductTypeComboBox().getSelectedItem());
		Assert.assertEquals(underTest.getModel().getCriteria().getEntity(),
				underTest.getView().getEntityComboBox().getSelectedItem());
		int expectedCurrenciesSize = underTest.getModel().getCriteria()
				.getCurrencyCodes() == null ? 0 : underTest.getModel()
				.getCriteria().getCurrencyCodes().size();
		Assert.assertEquals(expectedCurrenciesSize, underTest.getView()
				.getCurrencyList().getModel().getSize());
		int expectedResultsSize = underTest.getModel().getResults() == null ? 0
				: underTest.getModel().getResults().size();
		Assert.assertEquals(expectedResultsSize, underTest.getView()
				.getResultsTable().getRowCount());
	}

}
