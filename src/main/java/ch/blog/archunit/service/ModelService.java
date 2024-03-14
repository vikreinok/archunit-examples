package ch.blog.archunit.service;

import ch.blog.archunit.ModelDto;
import ch.blog.archunit.ModelEntity;

/**
 *
 */
public interface ModelService {
    // generate a method that takes dot and uses Mapper to map the model
    ModelEntity save(ModelDto dto);
}
