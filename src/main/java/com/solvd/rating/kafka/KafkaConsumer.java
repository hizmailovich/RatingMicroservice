package com.solvd.rating.kafka;

import com.solvd.rating.service.RatingService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOffset;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final KafkaReceiver<String, Long> kafkaReceiver;
    private final RatingService ratingService;

    @PostConstruct
    private void receive() {
        kafkaReceiver.receive()
                .subscribe(record -> {
                    ReceiverOffset offset = record.receiverOffset();
                    log.info("Received id: " + record.value());
                    ratingService.deleteByMovieId(record.value());
                    offset.acknowledge();
                });
    }

}
