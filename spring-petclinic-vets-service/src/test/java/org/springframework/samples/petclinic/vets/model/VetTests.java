package org.springframework.samples.petclinic.vets.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VetTests {

    @Test
    public void testAddAndGetSpecialties() {
        Vet vet = new Vet();
        Specialty s1 = new Specialty();
        s1.setName("surgery");

        Specialty s2 = new Specialty();
        s2.setName("dentistry");

        vet.addSpecialty(s1);
        vet.addSpecialty(s2);

        List<Specialty> specialties = vet.getSpecialties();

        assertEquals(2, specialties.size());
        assertTrue(specialties.stream().anyMatch(s -> "surgery".equals(s.getName())));
        assertTrue(specialties.stream().anyMatch(s -> "dentistry".equals(s.getName())));
    }

    @Test
    public void testSettersAndGetters() {
        Vet vet = new Vet();
        vet.setFirstName("John");
        vet.setLastName("Doe");
        vet.setId(1);

        assertEquals("John", vet.getFirstName());
        assertEquals("Doe", vet.getLastName());
        assertEquals(1, vet.getId());
    }
}
