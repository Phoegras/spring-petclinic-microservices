package org.springframework.samples.petclinic.vets.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VetRepositoryTests {

    @Autowired
    private VetRepository vetRepository;

    @Test
    void shouldSaveAndRetrieveVet() {
        String firstName = "John";
        String lastName = "Doe";
        Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);

        vetRepository.save(vet);

        List<Vet> vets = vetRepository.findAll();
        assertEquals(1, vets.size());

        Vet retrieved = vets.get(0);
        assertEquals(firstName, retrieved.getFirstName());
        assertEquals(lastName, retrieved.getLastName());
        assertNotNull(retrieved.getId());
    }

    @Test
    void shouldReturnEmptyWhenNoVets() {
        List<Vet> vets = vetRepository.findAll();
        assertTrue(vets.isEmpty());
    }
}
