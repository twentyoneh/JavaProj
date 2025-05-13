package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialReposutory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * Контроллер REST API для управления сущностями Tutorial.
 * 
 * Предоставляет CRUD-операции и дополнительные методы поиска для работы с туториалами.
 * 
 * Основные эндпоинты:
 * <ul>
 *   <li>GET /api/tutorials - Получить список всех туториалов или отфильтрованных по названию</li>
 *   <li>GET /api/tutorials/{id} - Получить туториал по идентификатору</li>
 *   <li>POST /api/tutorials - Создать новый туториал</li>
 *   <li>PUT /api/tutorials/{id} - Обновить существующий туториал</li>
 *   <li>DELETE /api/tutorials/{id} - Удалить туториал по идентификатору</li>
 *   <li>DELETE /api/tutorials - Удалить все туториалы</li>
 *   <li>GET /api/tutorials/published - Получить все опубликованные туториалы</li>
 * </ul>
 * 
 * Кросс-доменные запросы разрешены с http://localhost:8081.
 * 
 * Использует TutorialRepository для доступа к данным.
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    TutorialReposutory tutorialRepository;

    @GetMapping("/tutorials") // Получаем все туторы
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();   // Создаем список туторов

            if(title == null)   // если пользователь не указал, какой именно тутор нужен - возвращаем все
                tutorialRepository.findAll().forEach(tutorials::add);   // внутри tutorialRepository найти всё, и доваить в список tutorials
            else 
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);    // если указал - найти туторы, которые содержат title и добавить их в список

            if(tutorials.isEmpty()){    // если после поиска нужного тутра - внутри списка tutorials ничего нет - вернуть 204
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);  // вернуть список туторов и статус 200
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<Tutorial>(), HttpStatus.INTERNAL_SERVER_ERROR);    // если что - то пошло не так - отправить ошибку 500 
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id){
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);   // найти тутор по id

        if(tutorialData.isPresent()){
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);   // если тутор найден - вернуть его и статус 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);    // если тутор не найден - вернуть ошибку 404
        }
    }
    
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {   // создать тутор
        try {
            Tutorial _tutorial = tutorialRepository
                .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));   // сохранить тутор в БД
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);   // вернуть созданный тутор и статус 201
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);    // если что - то пошло не так - отправить ошибку 500 
        }
    }
    
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if(tutorialData.isPresent()){
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);   // вернуть обновленный тутор и статус 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);    // если тутор не найден - вернуть ошибку 404
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id){
        try{
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   // вернуть статус 204
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);    // если что - то пошло не так - отправить ошибку 500 
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialRepository.deleteAll();   // удалить все туторы
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   // вернуть статус 204
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);    // если что - то пошло не так - отправить ошибку 500 
        }
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        try{
            List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

            if(tutorials.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);    // если что - то пошло не так - отправить ошибку 500 
        }
    }
    
}