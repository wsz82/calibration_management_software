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
public class Unit implements BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Unit(String model) {
        this.name = model;
    }

}
