package procedure.step;

import lombok.Data;
import procedure.Calibration;
import procedure.StepInterface;

@Data
public abstract class Step {
    protected Calibration state;
    protected StepInterface stepInterface;

    public abstract void show();

    public abstract void execute();

    public abstract StepType getStepType();

}