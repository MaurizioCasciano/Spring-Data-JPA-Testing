package org.testing.spring.data.jpa.repository.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


// https://docs.spring.io/spring-data/jpa/docs/1.6.0.RELEASE/reference/html/repositories.html#repositories.custom-behaviour-for-all-repositories
// https://docs.spring.io/spring-data/data-commons/docs/2.7.0/reference/html/#repositories.single-repository-behavior
// https://www.baeldung.com/spring-data-jpa-method-in-all-repositories
@NoRepositoryBean
public interface CustomJPARepository<T, ID> extends JpaRepository<T, ID> {
}
