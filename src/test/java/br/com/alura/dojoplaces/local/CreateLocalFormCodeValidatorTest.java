package br.com.alura.dojoplaces.local;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateLocalFormCodeValidatorTest {
    @Mock
    private LocalRepository localRepository;

    @InjectMocks
    private CreateLocalFormCodeValidator createLocalFormCodeValidator;

    @Test
    void validate__when_code_already_exists_should_reject() {
        final var errors = Mockito.mock(Errors.class);
        final var form = new CreateLocalForm();
        form.setCode("code");

        when(localRepository.existsByCode(anyString())).thenReturn(true);
        createLocalFormCodeValidator.validate(form, errors);

        verify(localRepository).existsByCode(anyString());
        verify(errors).rejectValue("code", "createLocal.code.duplicated", "o código do local já existe");
    }

    @Test
    void validate__when_code_not_exists_should_pass() {
        final var errors = Mockito.mock(Errors.class);
        final var form = new CreateLocalForm();
        form.setCode("code");

        when(localRepository.existsByCode(anyString())).thenReturn(false);
        createLocalFormCodeValidator.validate(form, errors);

        verify(localRepository).existsByCode(anyString());
        verify(errors, times(0)).rejectValue("code", "createLocal.code.duplicated", "o código do local já existe");
    }
}