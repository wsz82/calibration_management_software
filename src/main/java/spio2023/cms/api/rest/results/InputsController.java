package spio2023.cms.api.rest.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spio2023.cms.api.database.results.Inputs;
import spio2023.cms.api.repository.InputsRepository;
import spio2023.cms.api.rest.SuperController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class InputsController extends SuperController<Inputs, InputsController> {

    private static final String inputs = "inputs";
    private static final String input = "input";

    protected InputsController(@Autowired InputsRepository repository) {
        super(repository);
    }

    @GetMapping("/" + inputs)
    public CollectionModel<EntityModel<Inputs>> all() {
        return getAll();
    }

    @GetMapping("/" + inputs + "/{id}")
    public EntityModel<Inputs> one(@PathVariable Long id) {
        return getOne(id);
    }

    @Override
    protected InputsController getController() {
        return methodOn(InputsController.class);
    }

    @Override
    protected String collectionName() {
        return inputs;
    }

    @Override
    protected String entityName() {
        return input;
    }

}
