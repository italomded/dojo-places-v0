package br.com.alura.dojoplaces.local;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {
    private final LocalRepository localRepository;

    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Transactional
    void createLocal(final CreateLocalForm localForm) {
        final Local local = localForm.toModel();
        localRepository.save(local);
    }

    List<LocalDTO> listLocals() {
        return localRepository.findAll().stream().map(LocalDTO::new).toList();
    }

    public EditLocalForm getLocalForEdit(final Long id) {
        return new EditLocalForm(localRepository.findById(id).orElseThrow());
    }

    @Transactional
    public void editLocal(final Long id, final EditLocalForm editLocalForm) {
        Local local = localRepository.findById(id).orElseThrow();
        local.setName(editLocalForm.getName());
        local.setCode(editLocalForm.getCode());
        local.setDistrict(editLocalForm.getDistrict());
        local.setCity(editLocalForm.getCity());
    }
}
