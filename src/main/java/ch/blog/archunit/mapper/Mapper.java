package ch.blog.archunit.mapper;

import ch.blog.archunit.ModelDto;
import ch.blog.archunit.ModelEntity;

/**
 *
 */
public final class Mapper {

    private Mapper() {
        // prevent instantiation
    }

    public static ModelEntity mapDtoToEntity(ModelDto dto) {
        ModelEntity entity = new ModelEntity();
        entity.setField1(dto.getField1());
        entity.setField2(dto.getField2());
        return entity;
    }

    public static ModelDto mapEntityToDto(ModelEntity entity) {
        ModelDto dto = new ModelDto();
        dto.setField1(entity.getField1());
        dto.setField2(entity.getField2());
        return dto;
    }

}
