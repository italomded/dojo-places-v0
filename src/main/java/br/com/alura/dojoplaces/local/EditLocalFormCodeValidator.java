package br.com.alura.dojoplaces.local;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EditLocalFormCodeValidator implements Validator {
    private final LocalRepository localRepository;

    public EditLocalFormCodeValidator(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return EditLocalForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        final var form = (EditLocalForm) target;
        final boolean exists = localRepository.existsByCodeAndIdNot(form.getCode(), form.getId());

        if (exists) {
            errors.rejectValue("code", "editLocalForm.code.duplicated", "o código do local já existe");
        }
    }
}
