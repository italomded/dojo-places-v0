package br.com.alura.dojoplaces.local;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CreateLocalFormCodeValidator implements Validator {
    private final LocalRepository localRepository;

    public CreateLocalFormCodeValidator(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return CreateLocalForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        final var form = (CreateLocalForm) target;
        final boolean exists = localRepository.existsByCode(form.getCode());

        if (exists) {
            errors.rejectValue("code", "createLocal.code.duplicated", "o código do local já existe");
        }
    }
}
