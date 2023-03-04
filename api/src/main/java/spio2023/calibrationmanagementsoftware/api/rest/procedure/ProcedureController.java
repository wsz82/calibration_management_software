package spio2023.calibrationmanagementsoftware.api.rest.procedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spio2023.calibrationmanagementsoftware.api.database.procedure.ProcedureData;
import spio2023.calibrationmanagementsoftware.api.database.procedure.ProcedureRepository;
import spio2023.calibrationmanagementsoftware.api.rest.SuperController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProcedureController extends SuperController<ProcedureData, ProcedureController> {

    private static final String procedures = "procedures";
    private static final String procedure = "procedure";

    public ProcedureController(@Autowired ProcedureRepository repository) {
        super(repository);
    }

    @GetMapping("/" + procedures)
    public CollectionModel<EntityModel<ProcedureData>> all() {
        return getAll();
    }

    @GetMapping("/" + procedures + "/{id}")
    public EntityModel<ProcedureData> one(@PathVariable Long id) {
        return getOne(id);
    }

    @Override
    public ProcedureController getController() {
        return methodOn(ProcedureController.class);
    }

    @Override
    public String collectionName() {
        return procedures;
    }

    @Override
    public String entityName() {
        return procedure;
    }

}