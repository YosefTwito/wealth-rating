package com.example.wealthrating.rich;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RichServiceTest {

    @Mock private RichRepository richRepository;
    private RichService underTest;

    @BeforeEach
    void setUp(){
        underTest = new RichService(richRepository);
    }

    @Test
    void getAllRiches() {
        // when
        underTest.getRiches();
        // then
        verify(richRepository).findAll();
    }

    @Test
    void getRichByIdFinds() {
        Long id = 987654321L;
        Rich yos = new Rich(id, "Yossi", "Twito", 420L);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);

        try {
            underTest.getRichById(id);
        } catch (Exception e){}
        verify(richRepository).findByIdentity(argumentCaptor.capture());
    }

    @Test
    void getRichByIdThrows() {
        Long id = 987654321L;
        String expected = "No rich people with Id: " + id;
        String got = "";
        try {
            underTest.getRichById(id);
        } catch (Exception e){
            got = e.getMessage().toString();
        }
        assertEquals(expected, got);
    }

    @Test
    void postRichSucceeded() {
        Long id = 987654321L;
        Person p = new Person(id, "Yossi", "Twito", "New-Orleans", 420000000000L, 10);

        String got = underTest.postRich(p);
        String expected = "Rich: Yossi Twito is Rich";
        ArgumentCaptor<Rich> argumentCaptor = ArgumentCaptor.forClass(Rich.class);

        verify(richRepository).save(argumentCaptor.capture());
        assertEquals(expected, got);
    }

    @Test
    void postRichDidntPost() {
        Long id = 987654321L;
        Person p = new Person(id, "Yossi", "Twito", "New-Orleans", 420L, 10);

        String got = underTest.postRich(p);
        String expected = "Not-rich: Yossi Twito is not Rich";

        assertEquals(expected, got);
    }
}