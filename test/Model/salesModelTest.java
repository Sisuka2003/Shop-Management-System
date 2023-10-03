/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.DefaultTableModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class salesModelTest {
    
    public salesModelTest() {
    }
    
    /**
     * Test of loadInvoiceTabledup method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTabledup() {
        System.out.println("loadInvoiceTabledup");
        String string = "12";
        DefaultTableModel dtm = null;
        salesModel instance = new salesModel();
        instance.loadInvoiceTabledup(string, dtm);
    }

    /**
     * Test of loadInvoiceTable method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTable() {
        System.out.println("loadInvoiceTable");
        String string = "12 / 07 / 2021";
        DefaultTableModel dtm = null;
        salesModel instance = new salesModel();
        instance.loadInvoiceTable(string, dtm);
    }

    /**
     * Test of loadInvoiceTableDate method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTableDate() {
        System.out.println("loadInvoiceTableDate");
        String keyword = "12 / 07 / 2021";
        salesModel instance = new salesModel();
        String expResult = "12 / 07 / 2021";
        String result = instance.loadInvoiceTableDate(keyword);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadInvoiceTableMonth method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTableMonth_String() {
        System.out.println("loadInvoiceTableMonth");
        String keyword = "july";
        salesModel instance = new salesModel();
        String expResult = "12 / 07 / 2021";
        String result = instance.loadInvoiceTableMonth(keyword);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadInvoiceTableSales method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTableSales() {
        System.out.println("loadInvoiceTableSales");
        String keyword = "12 / 07 / 2021";
        salesModel instance = new salesModel();
        String expResult = "70600";
        String result = instance.loadInvoiceTableSales(keyword);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadInvoiceTableSales2 method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTableSales2() {
        System.out.println("loadInvoiceTableSales2");
        String keyword2 = "july";
        String year = "12 / 07 / 2021";
        salesModel instance = new salesModel();
        String expResult = "70600";
        String result = instance.loadInvoiceTableSales2(keyword2, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadInvoiceItemTable method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceItemTable() {
        System.out.println("loadInvoiceItemTable");
        String string = "12";
        DefaultTableModel dtm4 = null;
        salesModel instance = new salesModel();
        instance.loadInvoiceItemTable(string, dtm4);
    }

    /**
     * Test of loadInvoiceTableYear method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTableYear() {
        System.out.println("loadInvoiceTableYear");
        String year = "12 / 07 / 2021";
        salesModel instance = new salesModel();
        String expResult = "12 / 07 / 2021";
        String result = instance.loadInvoiceTableYear(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadInvoiceTableYear2 method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTableYear2() {
        System.out.println("loadInvoiceTableYear2");
        String year = "";
        salesModel instance = new salesModel();
        String expResult = "";
        String result = instance.loadInvoiceTableYear2(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadsalesYear method, of class salesModel.
     */
    @Test
    public void testLoadsalesYear() {
        System.out.println("loadsalesYear");
        String string = "";
        DefaultTableModel dtm = null;
        salesModel instance = new salesModel();
        instance.loadsalesYear(string, dtm);
    }

    /**
     * Test of loadInvoiceTableMonth method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceTableMonth_String_DefaultTableModel() {
        System.out.println("loadInvoiceTableMonth");
        String month = "";
        DefaultTableModel dtm3 = null;
        salesModel instance = new salesModel();
        instance.loadInvoiceTableMonth(month, dtm3);
    }

    /**
     * Test of loadInvoiceYearSalesTable method, of class salesModel.
     */
    @Test
    public void testLoadInvoiceYearSalesTable() {
        System.out.println("loadInvoiceYearSalesTable");
        String year = "";
        salesModel instance = new salesModel();
        String expResult = "";
        String result = instance.loadInvoiceYearSalesTable(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonthlyProfitOrLoss method, of class salesModel.
     */
    @Test
    public void testGetMonthlyProfitOrLoss() {
        System.out.println("getMonthlyProfitOrLoss");
        String month = "";
        String year = "";
        salesModel instance = new salesModel();
        String expResult = "";
        String result = instance.getMonthlyProfitOrLoss(month, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of getYearlyProfitOrLoss method, of class salesModel.
     */
    @Test
    public void testGetYearlyProfitOrLoss() {
        System.out.println("getYearlyProfitOrLoss");
        String year = "";
        salesModel instance = new salesModel();
        String expResult = "";
        String result = instance.getYearlyProfitOrLoss(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateStaffExpenses method, of class salesModel.
     */
    @Test
    public void testCalculateStaffExpenses() {
        System.out.println("calculateStaffExpenses");
        String month = "June";
        String year = "2021";
        salesModel instance = new salesModel();
        String expResult = "30000";
        String result = instance.calculateStaffExpenses(month, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateElectricityExpenses method, of class salesModel.
     */
    @Test
    public void testCalculateElectricityExpenses() {
        System.out.println("calculateElectricityExpenses");
        String month = "June";
        String year = "2021";
        salesModel instance = new salesModel();
        String expResult = "9750";
        String result = instance.calculateElectricityExpenses(month, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateWaterExpenses method, of class salesModel.
     */
    @Test
    public void testCalculateWaterExpenses() {
        System.out.println("calculateWaterExpenses");
        String month = "June";
        String year = "2021";
        salesModel instance = new salesModel();
        String expResult = "4500";
        String result = instance.calculateWaterExpenses(month, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateProductsExpenses method, of class salesModel.
     */
    @Test
    public void testCalculateProductsExpenses() {
        System.out.println("calculateProductsExpenses");
        String month = "july";
        String year = "2021";
        salesModel instance = new salesModel();
        String expResult = "500";
        String result = instance.calculateProductsExpenses(month, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateIncome method, of class salesModel.
     */
    @Test
    public void testCalculateIncome() {
        System.out.println("calculateIncome");
        String month = "july";
        String year = "2021";
        salesModel instance = new salesModel();
        String expResult = "70600";
        String result = instance.calculateIncome(month, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateElectricityExpensesyearly method, of class salesModel.
     */
    @Test
    public void testCalculateElectricityExpensesyearly() {
        System.out.println("calculateElectricityExpensesyearly");
        String monthlyYear = "2021";
        salesModel instance = new salesModel();
        String expResult = "34750";
        String result = instance.calculateElectricityExpensesyearly(monthlyYear);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateWaterExpensesyearly method, of class salesModel.
     */
    @Test
    public void testCalculateWaterExpensesyearly() {
        System.out.println("calculateWaterExpensesyearly");
        String monthlyYear = "2021";
        salesModel instance = new salesModel();
        String expResult = "27500";
        String result = instance.calculateWaterExpensesyearly(monthlyYear);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateProductsExpensesyearly method, of class salesModel.
     */
    @Test
    public void testCalculateProductsExpensesyearly() {
        System.out.println("calculateProductsExpensesyearly");
        String monthlyYear = "14 / 07 / 2021";
        salesModel instance = new salesModel();
        String expResult = "500";
        String result = instance.calculateProductsExpensesyearly(monthlyYear);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateStaffExpensesyearly method, of class salesModel.
     */
    @Test
    public void testCalculateStaffExpensesyearly() {
        System.out.println("calculateStaffExpensesyearly");
        String monthlyYear = "2021";
        salesModel instance = new salesModel();
        String expResult = "115000";
        String result = instance.calculateStaffExpensesyearly(monthlyYear);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateIncomeyearly method, of class salesModel.
     */
    @Test
    public void testCalculateIncomeyearly() {
        System.out.println("calculateIncomeyearly");
        String monthlyYear = "12 / 07 / 2021";
        salesModel instance = new salesModel();
        String expResult = "70600";
        String result = instance.calculateIncomeyearly(monthlyYear);
        assertEquals(expResult, result);
    }
    
}
