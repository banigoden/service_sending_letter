package net.db6n.servingwebcontent.repository;

import net.db6n.servingwebcontent.entity.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository  extends R2dbcRepository<NotificationEntity, String> {
}
