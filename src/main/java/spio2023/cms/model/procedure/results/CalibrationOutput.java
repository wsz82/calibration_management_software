package spio2023.cms.model.procedure.results;

import lombok.Data;
import spio2023.cms.model.unit.ControlPoint;
import spio2023.cms.model.unit.MeasurementType;

import java.util.Map;

@Data
public class CalibrationOutput {
    private final Map<MeasurementType, Map<ControlPoint, Results>> controlPointToResults;

    public boolean isPass() {
        return controlPointToResults.values().stream()
                .flatMap(f -> f.values().stream())
                .allMatch(Results::isPass);
    }

}
