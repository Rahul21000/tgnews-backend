package com.tgnews.tgnews_api.entity;

import com.tgnews.tgnews_api.enums.NewsCategory;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Data
public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Enumerated(EnumType.STRING)
        private NewsCategory category;
        private String title;
        private String content;
        private String imageUrl;
        private String author;

        @CreationTimestamp
        @Column(name = "created_at",updatable = false)
        private LocalDateTime createdAt;

        @UpdateTimestamp
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

}
