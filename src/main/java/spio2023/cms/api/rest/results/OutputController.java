package spio2023.cms.api.rest.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spio2023.cms.api.database.calibration.ControlPointToInputs;
import spio2023.cms.api.database.results.DoubleValue;
import spio2023.cms.api.database.results.Output;
import spio2023.cms.api.database.results.Results;
import spio2023.cms.api.database.unit.ControlPoint;
import spio2023.cms.api.repository.CalibrationRepository;
import spio2023.cms.api.repository.OutputRepository;
import spio2023.cms.api.rest.EntityNotFoundException;
import spio2023.cms.api.rest.SuperController;
import spio2023.cms.model.engine.DefaultCalibrationEngine;
import spio2023.cms.model.procedure.DefaultStepInterface;
import spio2023.cms.model.sample.SampleData_BC06;

import java.util.Stack;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class OutputController extends SuperController<Output, OutputController> {

    private static final String outputs = "outputs";
    private static final String output = "output";
    private final CalibrationRepository calibrationRepository;

    protected OutputController(
            @Autowired OutputRepository repository,
            @Autowired CalibrationRepository calibrationRepository
    ) {
        super(repository);
        this.calibrationRepository = calibrationRepository;
    }

    @GetMapping("/" + outputs)
    public CollectionModel<EntityModel<Output>> all() {
        return getAll();
    }

    @GetMapping("/" + outputs + "/{calibrationId}")
    public EntityModel<Output> one(@PathVariable Long calibrationId) {
        var optionalCalibration = calibrationRepository.findById(calibrationId);
        if (optionalCalibration.isEmpty()) {
            throw new EntityNotFoundException("calibration", calibrationId);
        }
        var calibration = optionalCalibration.get();
        var inputs = calibration.getControlPointToInputs().stream()
                .map(ControlPointToInputs::getInputs)
                .toList();
        var referenceInputs = new Stack<Double>();
        var testInputs = new Stack<Double>();
        inputs.forEach(item -> {
            var reference = item.getReferenceDoubleValues().stream()
                    .map(DoubleValue::getInternalValue)
                    .toList();
            referenceInputs.addAll(reference);
            var test = item.getTestDoubleValues().stream()
                    .map(DoubleValue::getInternalValue)
                    .toList();
            testInputs.addAll(test);
        });
        var modelProcedure = SampleData_BC06.procedure();
        var engine = new DefaultCalibrationEngine(new DefaultStepInterface(modelProcedure.getSettings(), referenceInputs, testInputs));
        var calibrationOutput = engine.runCalibration(
                modelProcedure,
                SampleData_BC06.thermometer_P755()
        );
        var controlPointToResults = calibrationOutput.getControlPointToResults();
        var collect = controlPointToResults.values().stream()
                .flatMap(entry -> entry.entrySet().stream())
                .map(entry -> {
                    var modelResults = entry.getValue();
                    return new Results(new ControlPoint(entry.getKey()), modelResults);
                })
                .toList();
        var output = new Output();
        output.setResults(collect);
        return EntityModel.of(output);
    }

    @Override
    protected OutputController getController() {
        return methodOn(OutputController.class);
    }

    @Override
    protected String collectionName() {
        return outputs;
    }

    @Override
    protected String entityName() {
        return output;
    }

}
