package ru.kalinin.school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kalinin.school.models.FullSchoolResponse;
import ru.kalinin.school.models.School;
import ru.kalinin.school.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
    }
}
