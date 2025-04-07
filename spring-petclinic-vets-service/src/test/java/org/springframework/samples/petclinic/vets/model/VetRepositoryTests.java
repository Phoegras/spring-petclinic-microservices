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
    public void testSaveAndFindVet() {
        Vet vet = new Vet();
        vet.setFirstName("Lisa");
        vet.setLastName("Cuddy");

        vetRepository.save(vet);

        List<Vet> vets = vetRepository.findAll();
        assertThat(vets).extracting(Vet::getFirstName).contains("Lisa");
    }
}
