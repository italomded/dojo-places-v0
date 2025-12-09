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
class EditLocalFormCodeValidatorTest {
    @Mock
    private LocalRepository localRepository;

    @InjectMocks
    private EditLocalFormCodeValidator editLocalFormCodeValidator;

    @Test
    void validate__when_code_already_exists_should_reject() {
        final var errors = Mockito.mock(Errors.class);
        final var form = new EditLocalForm();
        form.setCode("code");
        form.setId(1L);

        when(localRepository.existsByCodeAndIdNot(anyString(), anyLong())).thenReturn(true);
        editLocalFormCodeValidator.validate(form, errors);

        verify(localRepository).existsByCodeAndIdNot(anyString(), anyLong());
        verify(errors).rejectValue("code", "editLocalForm.code.duplicated", "o código do local já existe");
    }

    @Test
    void validate__when_code_not_exists_should_pass() {
        final var errors = Mockito.mock(Errors.class);
        final var form = new EditLocalForm();
        form.setCode("code");
        form.setId(1L);

        when(localRepository.existsByCodeAndIdNot(anyString(), anyLong())).thenReturn(false);
        editLocalFormCodeValidator.validate(form, errors);

        verify(localRepository).existsByCodeAndIdNot(anyString(), anyLong());
        verify(errors, times(0)).rejectValue("code", "editLocalForm.code.duplicated", "o código do local já existe");
    }
}