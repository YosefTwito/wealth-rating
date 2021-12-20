package com.example.wealthrating.rich;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(RichController.class)
class RichControllerTest {

    @MockBean
    private RichService richService;
    private RichController underTest;

    private central_bank_controller controller;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws Exception{
        underTest = new RichController(richService);
        controller = new central_bank_controller();
    }

    @Test
    void getAll() throws Exception {
        underTest.getAll();
        verify(richService).getRiches();
    }

    @Test
    void getByID() {
        Long id = 987654321L;
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        Person p = new Person(id, "Yossi", "Twito", "New-Orleans", 420000000000L, 10);
        richService.postRich(p);

        System.out.println(p.toString());
        Rich r = underTest.getByID(id);
        System.out.println(r.toString());
        verify(richService).getRichById(argumentCaptor.capture());
    }

    @Test
    void saveRich() throws Exception {
        Long id = 987654321L;
        ArgumentCaptor<Person> argumentCaptor = ArgumentCaptor.forClass(Person.class);
        Person p = new Person(id, "Yossi", "Twito", "Bikini Bottom", 420000000000L, 10);
        underTest.saveRich(p);
//        List<Rich> = underTest.getAll();

//        verify(richService).postRich(argumentCaptor.capture());

        Rich r = underTest.getByID(1L);
        System.out.println(r);
//        assertEquals(9000000L, result.getResponse());
    }
}