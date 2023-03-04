package spio2023.cms.database.instrument;

import jakarta.persistence.Entity;
import lombok.*;
import spio2023.cms.database.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class AccuracyPattern extends BaseEntity {

    private double part;

    private double constant;

    public AccuracyPattern(spio2023.cms.model.instrument.AccuracyPattern model) {
        this.part = model.getPart();
        this.constant = model.getConstant();
    }
}
