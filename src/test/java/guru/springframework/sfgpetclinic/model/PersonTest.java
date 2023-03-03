package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        Person person = new Person(1L, "Bugs", "Bunny");

        assertAll("Test props set",
                () -> assertEquals("Bugs", person.getFirstName()),
                () -> assertEquals("Bunny", person.getLastName()));
    }

    @Test
    void groupedAssertionMsgs() {
        Person person = new Person(1l, "Bugs", "Bunny");
        assertAll("Test props set",
                () -> assertEquals("Bugs", person.getFirstName(), "First name failed"),
                () -> assertEquals("Bunny", person.getLastName(), "last name failed"));
    }

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} of {totalRepetitions}")
    @DisplayName("my repeated test")
    void myRepeatedTest() {

    }

    @RepeatedTest(5)
    void myRepeatedTestDI() {

    }

}