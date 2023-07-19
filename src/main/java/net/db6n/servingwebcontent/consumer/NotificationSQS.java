package net.db6n.servingwebcontent.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.db6n.servingwebcontent.dto.NotificationDTO;
import net.db6n.servingwebcontent.entity.NotificationEntity;
import net.db6n.servingwebcontent.mapper.NotificationMapper;
import net.db6n.servingwebcontent.repository.NotificationRepository;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationSQS {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDTO message) {
        log.info("received notification: {}", message);
        NotificationEntity entity = notificationMapper.map(message);
        notificationRepository.save(entity).subscribe();
    }
}
