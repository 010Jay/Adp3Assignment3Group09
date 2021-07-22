package za.ac.cput.factory;
/*
    AdoptionRecordFactoryTest.java
    Test Case for the AdoptionRecordTestFactory
    Author: Siyanda Hlongwa (217091229)
    Date: 05 June 2021
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.AdoptionRecord;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionRecordFactoryTest {//start of AdoptionRecordFactoryTest class

    //Attributes
    private AdoptionRecord aRecord1;
    private AdoptionRecord aRecord2;
    private AdoptionRecord aRecord3;
    private final Date date = new Date();

    @BeforeEach
    void setUp()
    {
        aRecord1 = new AdoptionRecord();
        aRecord2 = new AdoptionRecord();
        aRecord3 = aRecord2;
    }

    @Test
    public void createAdoptionRecord(){

        aRecord1 = AdoptionRecordFactory.createAdoptionRecord(1001, 123456, 987654, date);
        aRecord2 = AdoptionRecordFactory.createAdoptionRecord(1002, 258085, 794613, date);
        System.out.println(aRecord1);
        System.out.println(aRecord2);
}

    @Test
    void testEquality()
    {
        assertEquals(aRecord2, aRecord3);
        System.out.println("Equal.");
    }

    @Test
    void testIdentity()
    {
        if (aRecord3.equals(aRecord2))
        assertSame(aRecord3, aRecord2);
        System.out.println("Same identity");
    }

    @Test
    @Timeout(6)
    void testTimeout() throws InterruptedException
    {
        Thread.sleep(600);
        System.out.println("Test will be passed through stipulated time");
    }

    @Test
    @Disabled
    void testDisabled()
    {
        if (aRecord3 != aRecord1)
        System.out.println("If statement successful.");
    }

}//end of AdoptionRecordFactoryTest class