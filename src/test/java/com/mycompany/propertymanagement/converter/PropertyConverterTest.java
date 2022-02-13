package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;

    @Test
    void testConvertDTOtoEntity_Success(){

        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy");
        dto.setPrice(12345.55);

        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(dto);

        Assertions.assertEquals(dto.getPrice(), propertyEntity.getPrice());
        Assertions.assertEquals(dto.getTitle(), propertyEntity.getTitle());

    }

    @Test
    void testConvertEntityToDTO_Success(){

        PropertyEntity entity = new PropertyEntity();
        entity.setTitle("Dummy");
        entity.setPrice(12345.55);

        PropertyDTO dto = propertyConverter.convertEntityToDTO(entity);

        Assertions.assertEquals(entity.getPrice(), dto.getPrice());
        Assertions.assertEquals(entity.getTitle(), dto.getTitle());

    }
}
