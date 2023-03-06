package spio2023.cms.api.rest.calibration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spio2023.cms.api.database.calibration.Calibration;
import spio2023.cms.api.repository.CalibrationRepository;
import spio2023.cms.api.repository.ProcedureRepository;
import spio2023.cms.api.rest.EntityNotFoundException;
import spio2023.cms.api.rest.SuperController;
import spio2023.cms.api.rest.results.OutputController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CalibrationController extends SuperController<Calibration, CalibrationController> {

    private static final String calibrations = "calibrations";
    private static final String calibration = "calibration";
    private final ProcedureRepository procedureRepository;

    protected CalibrationController(
            @Autowired CalibrationRepository repository,
            @Autowired ProcedureRepository procedureRepository
    ) {
        super(repository);
        this.procedureRepository = procedureRepository;
    }

    @GetMapping("/" + calibrations)
    public CollectionModel<EntityModel<Calibration>> all() {
        return getAll();
    }

    @GetMapping("/" + calibrations + "/{id}")
    public EntityModel<Calibration> one(@PathVariable Long id) {
        return getOne(id);
    }

    @PostMapping("/" + calibrations + "/{procedureId}")
    public ResponseEntity<?> newEntity(@PathVariable Long procedureId) {
        var procedure = procedureRepository.findById(procedureId);
        if (procedure.isEmpty()) {
            throw new EntityNotFoundException("procedure", procedureId);
        }
        var entity = new Calibration();
        entity.setProcedureData(procedure.get());
        EntityModel<Calibration> entityModel = toModel(repository.save(entity));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @Override
    protected Link[] additionalLinks(Calibration entity) {
        var output = entity.getOutput();
        if (output != null) {
            return new Link[]{
                    linkTo(methodOn(OutputController.class).one(output.getId())).withRel(collectionName())
            };
        } else {
            return super.additionalLinks(entity);
        }
    }

    @Override
    protected CalibrationController getController() {
        return methodOn(CalibrationController.class);
    }

    @Override
    protected String collectionName() {
        return calibrations;
    }

    @Override
    protected String entityName() {
        return calibration;
    }

}
