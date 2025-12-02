package br.com.alura.dojoplaces.local;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocalController {
    private final LocalService localService;
    private final CreateLocalFormCodeValidator createLocalFormCodeValidator;

    public LocalController(LocalService localService, CreateLocalFormCodeValidator createLocalFormCodeValidator) {
        this.localService = localService;
        this.createLocalFormCodeValidator = createLocalFormCodeValidator;
    }

    @InitBinder("createLocalForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(createLocalFormCodeValidator);
    }

    @GetMapping("local")
    public String listLocals(final Model model) {
        model.addAttribute("locals", localService.listLocals());
        return "/listLocals";
    }

    @GetMapping("local/cadastro")
    public String createLocal(final CreateLocalForm createLocalForm, final Model model) {
        model.addAttribute("createLocalForm", createLocalForm);
        return "/createLocal";
    }

    @PostMapping("local/cadastro")
    public String createLocal(
            @ModelAttribute("createLocalForm") @Valid final CreateLocalForm createLocalForm,
            final BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "/createLocal";
        }
        localService.createLocal(createLocalForm);
        return "redirect:/local";
    }

    @GetMapping("local/editar/{id}")
    public String editLocal(@PathVariable final Long id, final EditLocalForm editLocalForm, final Model model) {
        model.addAttribute("editLocalForm", (editLocalForm.isClear()) ? localService.getLocalForEdit(id) : editLocalForm);
        return "/editLocal";
    }

    @PostMapping("local/editar/{id}")
    public String editLocal(
            @PathVariable final Long id,
            @ModelAttribute("editLocalForm") @Valid final EditLocalForm editLocalForm,
            final BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "/editLocal";
        }
        localService.editLocal(id, editLocalForm);
        return "redirect:/local";
    }
}
