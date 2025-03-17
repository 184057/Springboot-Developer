package me.jeong.SpringbootDeveloper.repository;

import me.jeong.SpringbootDeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
