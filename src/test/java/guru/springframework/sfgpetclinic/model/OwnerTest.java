package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "AL,1,1",
            "TN,2,2"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println("State: " + stateName + ", val1: " + val1 + ", val2: " + val2);
    }

    @DisplayName("CSV From File Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFileTest(String stateName, int val1, int val2) {
        System.out.println("State: " + stateName + ", val1: " + val1 + ", val2: " + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getargs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println("State: " + stateName + ", val1: " + val1 + ", val2: " + val2);
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomTest(String stateName, int val1, int val2) {
        System.out.println("State: " + stateName + ", val1: " + val1 + ", val2: " + val2);
    }

    static Stream<Arguments> getargs() {
        return Stream.of(Arguments.of("AL", 1, 1),
                Arguments.of("WI",5,4),
                Arguments.of("NY", 3,8));
    }



}