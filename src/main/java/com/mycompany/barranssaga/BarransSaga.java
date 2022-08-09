/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.barranssaga;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Robi Goh
 */
public class BarransSaga {
    
    private static final BarransSaga Barrans = new BarransSaga();
    
    public static void main(String[] args) {
        ArrayList <Long> yearList = new ArrayList<>();
        
        System.out.print("Please select how many persons : ");
        Scanner scanner = new Scanner(System.in);
        String noOfPersons = scanner.nextLine();
        String name, age, year;
        Person p;
        boolean invalidInput = false;
        
        try {
            for (int i = 0; i < Integer.parseInt(noOfPersons); i++) {
                System.out.print("\nPlease input person name : ");
                name = scanner.nextLine();
                p = new Person();
                p.setName(name);

                System.out.print("Please input age of death : ");
                age = scanner.nextLine();
                if (Integer.parseInt(age) < 0) {
                    invalidInput = true;
                }
                p.setAgeOfDeath(Integer.parseInt(age));

                System.out.print("Please input year of death : ");
                year = scanner.nextLine();
                if (Integer.parseInt(year) < 0) {
                    invalidInput = true;
                }
                p.setYearOfDeath(Integer.parseInt(year));
                
                if ((p.getYearOfDeath() - p.getAgeOfDeath()) > 0) {
                    yearList.add (Long.valueOf(p.getYearOfDeath() - p.getAgeOfDeath()));
                } else {
                    System.out.println("Year of death must be greater than age of death");
                    i--;
                }
            }

            if (invalidInput) {
                System.out.print("\nAverage number of people the witch killed : -1");
            } else {
                System.out.print("\nAverage number of people the witch killed : " + Barrans.calculateAvg (yearList));
            }
        } catch (Exception e) {
            System.out.println("Wrong input, number of person, age and year can only accept integer value: " + e);
        }
    }
    
    public BigDecimal calculateAvg (ArrayList <Long> yearList) {
        long total = 0;
        for (long n : yearList) {
            if (n > 0) {
                total = total + getFibonacciSum(n);
            } else {
                yearList.clear();
                break;
            }
        }
        
        if (yearList.isEmpty()) {
            return new BigDecimal(-1);
        } else {
            return new BigDecimal(total).divide(new BigDecimal(yearList.size()));
        }
    }
    
    private long getFibonacciSum(long n) {
        n--;
        long a = 0, b = 1, c = 0, sum = 0;

        while (c < n) {
            c = a + b;
            a = b;
            sum += b;
            b = c;            
        }   
        sum += c;
        if (n == 0) {
            return 1;
        } else {
            return sum;
        }
    }
}
