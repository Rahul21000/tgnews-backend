package com.tgnews.tgnews_api.repository;

import com.tgnews.tgnews_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    boolean existsByTitle(String title);

}
