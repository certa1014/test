package com.example.bookbuddyproject.repository;

import com.example.bookbuddyproject.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // 특정 방의 메시지를 시간순으로 조회
    List<Message> findByRoomIdOrderBySentAtAsc(String roomId);
}