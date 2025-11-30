package com.example.bookbuddyproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class ChatRoom {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    private String roomName;

    // 참여자 1 (발신자/구매자 등)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member1_id")
    private Member member1;

    // 참여자 2 (수신자/판매자 등)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member2_id")
    private Member member2;
    
    // 연관된 거래 (선택)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    // 연관된 도서 (선택 - 거래 전 문의 시 사용)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDateTime createdAt;

    // 생성 메서드
    public static ChatRoom createRoom(Member member1, Member member2, Book book) {
        ChatRoom room = new ChatRoom();
        room.member1 = member1;
        room.member2 = member2;
        room.book = book;
        room.createdAt = LocalDateTime.now();
        return room;
    }
}