package com.example.wealthrating.rich;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RichRepositoryTest {

    @Autowired
    private RichRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void findByIdentity() {
        // given
        Long id = 987654321L;
        Rich yos = new Rich(id, "Yossi", "Twito", 420L);
        underTest.save(yos);

        // when
        Rich found = underTest.findByIdentity(id).get();

        // then
        assertEquals(yos.getLastName(), found.getLastName());
        assertEquals(yos.getIdentity(), found.getIdentity());
    }

    @Test
    void findByIdentityFailed() {
        // given
        Long id = 987654321L;
        // when
        Optional<Rich> found = underTest.findByIdentity(id);
        boolean exist = found.isPresent();
        // then
        assertThat(exist).isFalse();
    }
}