package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tutorial;

/**
 * Интерфейс репозиторий, для работы с сущьностью {@link Tutorial}.
 * Наследуется от {@link JpaRepository} для предоставления CRUD функций.
 *
 * <p>Методы определённые в данном интерфейсе:</p>
 * <pre>
 * findByPublished(boolean published) 
 * findByTitleContaining(String title)
 * </pre>
 * 
 * <p>Методы которые доступны от {@link JpaRepository}</p>
 * <pre>
 * save(), findOne(), findById(), findAll(), count(), delete(), deleteById()
 * </pre>
 */
public interface TutorialReposutory extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
}
