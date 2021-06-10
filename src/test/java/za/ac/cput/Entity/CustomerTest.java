/*CustomerTest.java
Test for the Customer
Author:Andy William Hine (219259038)
Date:07 June 2021
 */

package za.ac.cput.Entity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest
{
    //Attributes
    private Customer c1,c2,c3;

    @BeforeEach
    void setUp() {
        //These are the objects that will be tested
        c1 = new Customer();
        c2 = new Customer();
        c3 = c1;
    }

    // This code checks if the students are equal with the assertEquals method.
    @Test
    void testEquality() {
        c3 = c1;
        assertEquals(c3, c1);
        System.out.println("They are equal.");
    }
    @Test
    void testIdentity() {

        if (c1 == c2)
        {
            System.out.println("Customer 1 and Customer 2 DO NOT have the same identity.");
        }
        else if (c1 == c3)
        {
            assertSame(c1, c3);
            System.out.println("Customer 1 and Customer 3 DO have the same identity.");
        }
        else
        {
            System.out.println("Can not find the Customer's identity");
        }
    }

    @Timeout(1)
    @Test
    public void testMultiply() throws InterruptedException
    {
        int result = c1.multiply(15, 15);
        assertEquals(50, result);
        TimeUnit.SECONDS.sleep(10);
    }

    @Ignore
    @Test
    void temporarilyDisabledTest( )
    {
        String c1 = "Gene";
        System.out.println(c1);
    }

}