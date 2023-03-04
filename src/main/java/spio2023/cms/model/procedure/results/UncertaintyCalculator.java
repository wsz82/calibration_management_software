package spio2023.cms.model.procedure.results;

import spio2023.cms.model.unit.Prefix;

public interface UncertaintyCalculator {

    Results calculate(Prefix prefix, Inputs inputs);

}
