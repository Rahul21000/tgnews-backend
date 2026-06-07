package com.tgnews.tgnews_api.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "articles")
@Data
public class Article {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String content;
        private String author;
}
