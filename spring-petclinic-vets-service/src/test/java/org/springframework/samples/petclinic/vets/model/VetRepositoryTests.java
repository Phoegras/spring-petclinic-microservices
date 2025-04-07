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
        // Arrange
        Specialty specialty = new Specialty();
        specialty.setName("Dentistry");

        Vet vet = new Vet();
        vet.setFirstName("Emily");
        vet.setLastName("Clark");
        vet.addSpecialty(specialty);

        // Act
        vetRepository.save(vet);
        List<Vet> found = vetRepository.findAll();

        // Assert
        assertThat(found).hasSize(1);
        Vet retrieved = found.get(0);
        assertThat(retrieved.getFirstName()).isEqualTo("Emily");
        assertThat(retrieved.getSpecialties()).hasSize(1);
        assertThat(retrieved.getSpecialties().get(0).getName()).isEqualTo("Dentistry");
    }
}
