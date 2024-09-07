package com.parkjh.packetapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Packet {
    private String linkType;
    private PcapHeader pcapHeader;
    private EthernetPayload payload;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PcapHeader {
        private long tvSec;
        private long tvUsec;
        private int caplen;
        private int len;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class EthernetPayload {
        private Address dhost;
        private Address shost;
        private Integer ethertype;
        private Integer vlan;
        private IPv6Payload payload;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Address {
            private List<Integer> addr;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class IPv6Payload {
            private int version;
            private int trafficClass;
            private int flowLabel;
            private int payloadLength;
            private int nextHeader;
            private int hopLimit;
            private Address saddr;
            private Address daddr;
            private TcpPayload payload;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            @Builder
            public static class TcpPayload {
                private int sport;
                private int dport;
                private long seqno;
                private long ackno;
                private int headerLength;
                private TcpFlags flags;
                private int windowSize;
                private int checksum;
                private int urgentPointer;
                private TcpOptions options;
                private TcpData data;
                private int dataLength;

                @Data
                @NoArgsConstructor
                @AllArgsConstructor
                @Builder
                public static class TcpFlags {
                    private boolean nonce;
                    private boolean cwr;
                    private boolean ece;
                    private boolean urg;
                    private boolean ack;
                    private boolean psh;
                    private boolean rst;
                    private boolean syn;
                    private boolean fin;
                }

                @Data
                @NoArgsConstructor
                @AllArgsConstructor
                @Builder
                public static class TcpOptions {
                    private Integer mss;
                    private Integer windowScale;
                    private Boolean sackOk;
                    private List<Integer> sack;
                    private Long timestamp;
                    private Long echo;
                }

                @Data
                @NoArgsConstructor
                @AllArgsConstructor
                @Builder
                public static class TcpData {
                    private String type;
                    private List<Integer> data;
                }
            }
        }
    }
}
