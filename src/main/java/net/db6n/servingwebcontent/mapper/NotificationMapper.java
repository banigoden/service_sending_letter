package net.db6n.servingwebcontent.mapper;

import net.db6n.servingwebcontent.dto.NotificationDTO;
import net.db6n.servingwebcontent.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDTO map(NotificationEntity entity);
    @InheritInverseConfiguration
    NotificationEntity map(NotificationDTO dto);
}
