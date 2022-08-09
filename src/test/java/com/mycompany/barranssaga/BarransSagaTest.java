/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.barranssaga;

import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Robi Goh
 */
public class BarransSagaTest {
    
    public BarransSagaTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of main method, of class BarransSaga.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        ArrayList <Long> yearList = new ArrayList<>();
        BarransSaga barrans = new BarransSaga();
        
        yearList.add(Long.valueOf(12 - 10));
        yearList.add(Long.valueOf(17 - 13));
        assertEquals(new BigDecimal(4.5), barrans.calculateAvg(yearList));
        
        yearList.add(Long.valueOf(120 - 100));
        yearList.add(Long.valueOf(170 - 130));
        assertEquals(new BigDecimal(51.5), barrans.calculateAvg(yearList));
        
        yearList.add(Long.valueOf(10 - 100));
        assertEquals(new BigDecimal(-1), barrans.calculateAvg(yearList));
        
        yearList.add(Long.valueOf(10000 - 1000));
        yearList.add(Long.valueOf(10000000 - 100000));
        assertEquals(new BigDecimal(19558412), barrans.calculateAvg(yearList));
    }
    
}
