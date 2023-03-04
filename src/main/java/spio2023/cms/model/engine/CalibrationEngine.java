package spio2023.cms.model.engine;

import spio2023.cms.model.instrument.ReferenceInstrument;
import spio2023.cms.model.procedure.Procedure;
import spio2023.cms.model.procedure.results.CalibrationOutput;

public interface CalibrationEngine {

    CalibrationOutput runCalibration(Procedure procedure, ReferenceInstrument instrument);

}
