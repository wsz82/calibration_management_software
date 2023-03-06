package spio2023.cms.api.database.instrument;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;
import spio2023.cms.api.database.unit.Scope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class ReferenceScope implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Scope> scopes;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private AccuracyPattern accuracyPattern;

    public ReferenceScope(spio2023.cms.model.instrument.ReferenceScope model) {
        this.scopes = Arrays.stream(model.getScopes())
                .map(Scope::new)
                .collect(Collectors.toList());
        this.accuracyPattern = new AccuracyPattern(model.getAccuracyPattern());
    }

}
