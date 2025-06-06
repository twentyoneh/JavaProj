package ru.kalinin.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kalinin.school.models.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
