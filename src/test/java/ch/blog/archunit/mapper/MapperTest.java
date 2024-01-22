package ch.blog.archunit.mapper;

import ch.blog.archunit.ModelDto;
import ch.blog.archunit.ModelEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {

    @Test
    void testMappingFromDtoToEntity() {
        ModelDto dto = new ModelDto();
        dto.setField1("Value1");
        dto.setField2(42);

        ModelEntity entity = Mapper.mapDtoToEntity(dto);

        assertEquals(dto.getField1(), entity.getField1());
        assertEquals(dto.getField2(), entity.getField2());
    }

    @Test
    void testMappingFromEntityToDto() {
        ModelEntity entity = new ModelEntity();
        entity.setField1("Value2");
        entity.setField2(99);

        ModelDto dto = Mapper.mapEntityToDto(entity);

        assertEquals(entity.getField1(), dto.getField1());
        assertEquals(entity.getField2(), dto.getField2());
    }
}