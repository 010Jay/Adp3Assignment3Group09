package za.ac.cput.service.impl;
/*
    Veterinarian.java
    Veterinarian Entity with builder Pattern
    Author: Nonhlahla Hlungwani (218160658)
    Date: 02 August 2021
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.factory.VeterinarianFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class VeterinarianServiceTest {
    private static VeterinarianService service = new VeterinarianService();
    private static Veterinarian vet1 = new VeterinarianFactory().createVeterinarian("Busisiwe", "Hlungwani", 0550657357, "234567890@mycput.ac.za");
    private Veterinarian vet2 = new Veterinarian.Builder().copy(vet1).setName("Nonhlahla").setSurname("Hlungwani").setPhoneNumber(0734543256).setEmailAddress("nhlahla@gmail.com").build();




    @Test
    void read() {
        Veterinarian readVet =service.read(vet2.getVetId());
        assertNotEquals(vet2, readVet);

    }

    @Test
    void testRead() {
        Veterinarian createVet =service.create(vet2);
        assertNotEquals(createVet.getVetId(),vet2.getVetId());
    }

    @Test
    void update() {
        Veterinarian updateVet =service.update(vet1);
        int actual1 = service.getAll().size();
        int expected1 = 2;
        assertEquals(expected1, actual1);
        System.out.println( "What is expected = " + expected1+ "\n Actual = " + actual1+"\n");
    }

    @Test
    void testDelete() {
        service.delete(vet2.getVetId());
        int actual = service.getAll().size();
        int expected = 1;
        assertEquals(expected, actual);
        System.out.println( "What is expected = " + expected+ "\n Actual = " + actual+"\n");
    }


}