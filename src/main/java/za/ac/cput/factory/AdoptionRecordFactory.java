package za.ac.cput.factory;

/*
    AdoptionRecordFactory.java
    AdoptionRecordFactory class for the AdoptionRecord entity
    Author: Siyanda Hlongwa (217091229)
    Date: 05 June 2021
 */


import za.ac.cput.entity.AdoptionRecord;

import java.util.Date;

public class AdoptionRecordFactory {//start of AdoptionRecordFactory class

    //private static int recordId = 0;

    public static AdoptionRecord createAdoptionRecord(int recordId,int dogId, int customerId, int staffId, Date date)
    {
        return new AdoptionRecord.Builder()
                .setAdoptionId(++ recordId)
                .setDogId(dogId)
                .setCustomerId(customerId)
                .setStaffId(staffId)
                .setDate(date)
                .build();
    }

}//end of AdoptionRecordFactory class
