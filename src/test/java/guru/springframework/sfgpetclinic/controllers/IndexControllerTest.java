package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test whether the correct view is being returned")
    @Test
    void index() {
        assertEquals("index", controller.index(), "Wrong view returned!");
    }

    @Test
    void oopsHandler() {
        assertThrows(NotFoundException.class, () -> controller.oopsHandler());
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("testTimeout()...");
        });

    }

    @Test
    void testPreemptTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(1000);
            System.out.println("testpreempt....");
        });
    }
}