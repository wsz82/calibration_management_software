package spio2023.cms.api.database.unit;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class Scope implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Parameter minimumIncluded;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Parameter maximumExcluded;

    public Scope(spio2023.cms.model.scope.Scope model) {
        this.minimumIncluded = new Parameter(model.getMinimumIncluded());
        this.maximumExcluded = new Parameter(model.getMaximumExcluded());
    }

}
