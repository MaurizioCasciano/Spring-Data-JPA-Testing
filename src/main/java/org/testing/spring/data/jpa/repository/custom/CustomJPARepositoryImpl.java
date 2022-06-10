package org.testing.spring.data.jpa.repository.custom;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

@Repository
@Transactional(
        readOnly = true
)
public class CustomJPARepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomJPARepository<T, ID> {

    private Class<T> domainClass;
    private EntityManager entityManager;

    public CustomJPARepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);

        // This is the recommended method for accessing inherited class dependencies.
        this.domainClass = domainClass;
        this.entityManager = em;
    }

    @Override
    public <S extends T> S save(S entity) {
        Assert.notNull(entity, "Entity must not be null.");

        Field idField = Arrays.stream(this.domainClass.getFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .collect(Collectors.toSet()).stream().findFirst().orElse(null);

        if (idField != null) {
            try {
                ID id = (ID) idField.get(entity);

                if(id != null){
                    if(!this.entityManager.contains(entity)){
                        Session session = this.entityManager.unwrap(Session.class);
                        session.saveOrUpdate(entity);

                        return entity;
                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return super.save(entity);
    }
}
