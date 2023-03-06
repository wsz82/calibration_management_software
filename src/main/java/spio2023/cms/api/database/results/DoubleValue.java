package spio2023.cms.api.database.results;

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
public class DoubleValue implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private double internalValue;

    public DoubleValue(double model) {
        this.internalValue = model;
    }

}
