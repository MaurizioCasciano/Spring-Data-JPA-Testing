package org.testing.spring.data.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.testing.spring.data.jpa.repository.custom.CustomJPARepositoryImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = CustomJPARepositoryImpl.class)
public class RepositoryConfiguration {
}
