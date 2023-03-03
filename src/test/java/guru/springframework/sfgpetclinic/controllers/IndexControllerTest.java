package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


class IndexControllerTest implements ControllerTests {

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

    @Disabled
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("testTimeout()...");
        });

    }

    @Disabled
    @Test
    void testPreemptTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(1000);
            System.out.println("testpreempt....");
        });
    }
}