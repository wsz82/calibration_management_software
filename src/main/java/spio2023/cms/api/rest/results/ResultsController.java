package spio2023.cms.api.rest.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spio2023.cms.api.database.results.Results;
import spio2023.cms.api.repository.ResultsRepository;
import spio2023.cms.api.rest.SuperController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ResultsController extends SuperController<Results, ResultsController> {

    private static final String results = "results";
    private static final String result = "result";

    protected ResultsController(@Autowired ResultsRepository repository) {
        super(repository);
    }

    @GetMapping("/" + results)
    public CollectionModel<EntityModel<Results>> all() {
        return getAll();
    }

    @GetMapping("/" + results + "/{id}")
    public EntityModel<Results> one(@PathVariable Long id) {
        return getOne(id);
    }

    @Override
    protected Link[] additionalLinks(Results entity) {
        return new Link[]{
                linkTo(methodOn(InputsController.class).all()).withRel(collectionName())
        };
    }

    @Override
    protected ResultsController getController() {
        return methodOn(ResultsController.class);
    }

    @Override
    protected String collectionName() {
        return results;
    }

    @Override
    protected String entityName() {
        return result;
    }

}
