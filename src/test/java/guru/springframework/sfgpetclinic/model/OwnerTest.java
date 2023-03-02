package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Bugs", "Bunny");
        owner.setCity("Atlanta");
        owner.setTelephone("1111111111");

        assertAll("Properties test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Bugs", owner.getFirstName(), "First name mismatch"),
                        () -> assertEquals("Bunny", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Atlanta", owner.getCity(), "City mismatch"),
                        () -> assertEquals("1111111111", owner.getTelephone())));
    }

}