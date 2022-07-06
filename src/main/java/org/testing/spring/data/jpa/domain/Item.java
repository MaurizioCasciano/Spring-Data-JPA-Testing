package org.testing.spring.data.jpa.domain;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Item implements Persistable<UUID> {
    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(optional = false)
    private Container container;

    @Override
    public boolean isNew() {
        return false;
    }
}
