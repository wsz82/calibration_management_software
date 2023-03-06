package spio2023.cms.model.procedure;

import lombok.Data;

@Data
public class Settings {
    private final int measurementSeries;
    private final boolean referenceValuesFromControlPoint;
}
