package com.parkjh.packetapi.service;

import com.parkjh.packetapi.entity.Packet;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PacketConsumerService {

    @KafkaListener(topics = "packet-topic", groupId = "packet-group")
    public void listen(List<Packet> packets) {
        log.info("Received Packets: {} packets received.", packets.size());

//        for (Packet packet : packets) {
//            log.info("Consumed message: {}", packet);
//        }
    }
}
