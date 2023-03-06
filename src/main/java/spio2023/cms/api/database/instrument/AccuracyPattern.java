package spio2023.cms.api.database.instrument;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class AccuracyPattern implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private double part;

    private double constant;

    public AccuracyPattern(spio2023.cms.model.instrument.AccuracyPattern model) {
        this.part = model.getPart();
        this.constant = model.getConstant();
    }
}
