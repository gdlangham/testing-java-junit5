package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

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

}