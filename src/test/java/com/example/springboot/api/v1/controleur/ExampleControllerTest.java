package com.example.springboot.api.v1.controleur;

import com.example.springboot.api.resources.ExampleRequestResource;
import com.example.springboot.api.resources.ItemResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Import(ControllerConfig.class)
class ExampleControllerTest {

    @Autowired private ExampleController exampleController;
    @Mock private HttpServletRequest httpServletRequest;

    @Test
    void doExample_ok() {
        ResponseEntity<Void> reponseEntity =
                exampleController.doExample(null, ExampleRequestResource.builder()
                        .items(Collections.singletonList(ItemResource.builder().build()))
                        .build(), httpServletRequest);
        assertEquals(HttpStatus.OK, reponseEntity.getStatusCode());
    }
}