package spio2023.cms.api.database.results;

import jakarta.persistence.*;
import lombok.*;
import spio2023.cms.api.database.BaseEntity;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
public class Output implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Results> results;

}
