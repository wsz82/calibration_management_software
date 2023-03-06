package spio2023.cms.api.database.unit;

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
public class Parameter implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String prefix;

    private double internalValue;

    public Parameter(spio2023.cms.model.unit.Parameter model) {
        this.prefix = model.getPrefix().name();
        this.internalValue = model.getValue();
    }

}
