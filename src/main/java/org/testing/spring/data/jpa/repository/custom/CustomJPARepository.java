package org.testing.spring.data.jpa.repository.custom;

import org.springframework.data.jpa.repository.JpaRepository;


// https://docs.spring.io/spring-data/jpa/docs/1.6.0.RELEASE/reference/html/repositories.html#repositories.custom-behaviour-for-all-repositories
// https://docs.spring.io/spring-data/data-commons/docs/2.7.0/reference/html/#repositories.single-repository-behavior
public interface CustomJPARepository<T, ID> extends JpaRepository<T, ID> {
}