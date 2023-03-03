package guru.springframework.sfgpetclinic;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) throws Exception {
        return Stream.of(Arguments.of("FL", 1, 1),
                Arguments.of("DE",5,4),
                Arguments.of("WA", 3,8));
    }
}
