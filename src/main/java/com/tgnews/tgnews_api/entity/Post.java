package com.tgnews.tgnews_api.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "articles")
@Data
public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String content;
        private String imageUrl;
        private String author;
}
