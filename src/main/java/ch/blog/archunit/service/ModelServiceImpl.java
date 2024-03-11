package ch.blog.archunit.service;

import ch.blog.archunit.ModelDto;
import ch.blog.archunit.ModelEntity;
import ch.blog.archunit.mapper.Mapper;

/**
 *
 */
public class ModelServiceImpl {

    // generate a method that takes dot and uses Mapper to map the model
    public ModelEntity save(ModelDto dto) {
        ModelEntity entity = Mapper.mapDtoToEntity(dto);
        // persistence logic
        return entity;
    }
}
