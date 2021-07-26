package za.ac.cput.factory;


/*
    VeterinarianFactoryTest.java
    Factory Test for the Veterinarian
    Author: Nonhlahla Hlungwani (218160658)
    Date: 05 June 2021
 */
import org.junit.jupiter.api.*;

import za.ac.cput.entity.Veterinarian;

import static org.junit.jupiter.api.Assertions.*;


class VeterinarianFactoryTest {

   Veterinarian vet, vet1, vet2;

    @BeforeEach
   public void setUp() {

        vet = new VeterinarianFactory().createVeterinarian("Nonhlahla", "Hlungwani", 0720657472, "218160658@mycput.ac.za");
        vet1 = new VeterinarianFactory().createVeterinarian("Busisiwe", "Hlungwani", 0550657357, "234567890@mycput.ac.za");
        vet2 = new VeterinarianFactory().createVeterinarian("Mandla", "Hlungwani", 277345632, "233767890@mycput.ac.za");


    }
    @Test
    public void testVeterinarianEquality() {
        System.out.println(vet.toString());
        System.out.println(vet1.toString());
        assertNotEquals(vet1, vet);
    }

    @Test
    void testVeterinarianIdentity() {
        System.out.println("Vet  an Vet 2 are not the same");
        assertNotSame(vet, vet1);
    }

    @Test
    @Timeout(1)
    void testTimeout() throws InterruptedException {

        System.out.println(vet2.toString());
        assertNotEquals(vet1, vet2);
    }

    @Test
    @Disabled
    void disableVet2() {
        System.out.println(vet2.toString());
    }

}