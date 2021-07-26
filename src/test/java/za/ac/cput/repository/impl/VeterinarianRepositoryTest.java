package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.factory.VeterinarianFactory;
import za.ac.cput.repository.impl.VeterinarianRepository;

import static org.junit.jupiter.api.Assertions.*;
class VeterinarianRepositoryTest {


    private static VeterinarianRepository repository = new VeterinarianRepository();
    private static Veterinarian vet1 = new VeterinarianFactory().createVeterinarian("Busisiwe", "Hlungwani", 0550657357, "234567890@mycput.ac.za");
    private static Veterinarian vet2 = new VeterinarianFactory().createVeterinarian("Mandla", "Hlungwani", 277345632, "233767890@mycput.ac.za");


    @Test
    public void testCreate() {
        System.out.println(vet1.toString());
        System.out.println(vet2.toString());
        assertNotEquals(vet1, vet2);
    }

    @Test
    void testRead() {
        System.out.println("Vet1  an Vet 2 are not the same");
        assertNotSame(vet2, vet1);
    }

    void testUpdate() {
        System.out.println(vet2.toString());
        assertNotEquals(vet1, vet2);
    }

    void testDelete() {
        System.out.println(vet2.toString());
    }
}