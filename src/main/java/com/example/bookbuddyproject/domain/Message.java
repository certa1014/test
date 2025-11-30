package com.example.bookbuddyproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    // ChatRoom의 ID를 String으로 저장
    private String roomId; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Member sender; // 보낸 사람

    @Column(columnDefinition = "TEXT")
    private String content; // 메시지 내용

    private LocalDateTime sentAt; // 전송 시간

    // 생성 메서드
    public static Message createMessage(String roomId, Member sender, String content) {
        Message message = new Message();
        message.roomId = roomId;
        message.sender = sender;
        message.content = content;
        message.sentAt = LocalDateTime.now();
        return message;
    }
}