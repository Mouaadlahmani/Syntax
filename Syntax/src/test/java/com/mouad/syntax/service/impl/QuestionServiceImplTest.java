package com.mouad.syntax.service.impl;

import com.mouad.syntax.dto.QuestionDto;
import com.mouad.syntax.mapper.QuestionMapper;
import com.mouad.syntax.model.Cours;
import com.mouad.syntax.model.Question;
import com.mouad.syntax.repository.CoursRepository;
import com.mouad.syntax.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private CoursRepository coursRepository;

    @Mock
    private QuestionMapper questionMapper;

    @InjectMocks
    private QuestionServiceImpl questionService;

    private Question question;
    private QuestionDto questionDto;
    private Cours cours;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup dummy data
        cours = new Cours();
        cours.setId(1L);
        cours.setTitre("Java Fundamentals");

        question = new Question();
        question.setId(1L);
        question.setQuestionTitle("What is Java?");
        question.setCours(cours); // Set the course for the question

        questionDto = new QuestionDto();
        questionDto.setId(1L);
        questionDto.setQuestionTitle("What is Java?");
    }

    @Test
    void addQuestion() {
        when(coursRepository.findById(1L)).thenReturn(Optional.of(cours));
        when(questionMapper.toEntity(questionDto)).thenReturn(question);
        when(questionRepository.save(question)).thenReturn(question);
        when(questionMapper.toDto(question)).thenReturn(questionDto);

        QuestionDto result = questionService.addQuestion(1L, questionDto);

        assertNotNull(result);
        assertEquals(questionDto.getId(), result.getId());
        assertEquals(questionDto.getQuestionTitle(), result.getQuestionTitle());
        verify(coursRepository).findById(1L);
        verify(questionRepository).save(question);
    }


    @Test
    void getAll() {
        when(questionRepository.findAll()).thenReturn(Arrays.asList(question));
        when(questionMapper.toDto(question)).thenReturn(questionDto);

        List<QuestionDto> result = questionService.getAll();

        assertEquals(1, result.size());
        assertEquals(questionDto.getId(), result.get(0).getId());
        assertEquals(questionDto.getQuestionTitle(), result.get(0).getQuestionTitle());
        verify(questionRepository).findAll();
    }

    @Test
    void questionById() {
        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));
        when(questionMapper.toDto(question)).thenReturn(questionDto);

        Optional<QuestionDto> result = questionService.questionById(1L);

        assertTrue(result.isPresent());
        assertEquals(questionDto.getId(), result.get().getId());
        verify(questionRepository).findById(1L);
    }

    @Test
    void questionById_NotFound() {
        when(questionRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<QuestionDto> result = questionService.questionById(1L);

        assertFalse(result.isPresent());
        verify(questionRepository).findById(1L);
    }

    @Test
    void findByCours() {
        when(coursRepository.findById(1L)).thenReturn(Optional.of(cours));
        when(questionRepository.findByCours(cours)).thenReturn(Arrays.asList(question));
        when(questionMapper.toDto(question)).thenReturn(questionDto);

        List<QuestionDto> result = questionService.findByCours(1L);

        assertEquals(1, result.size());
        assertEquals(questionDto.getId(), result.get(0).getId());
        verify(coursRepository).findById(1L);
        verify(questionRepository).findByCours(cours);
    }

    @Test
    void findByCours_CourseNotFound() {
        when(coursRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            questionService.findByCours(1L);
        });

        verify(coursRepository).findById(1L);
        verify(questionRepository, never()).findByCours(any(Cours.class));
    }

    @Test
    void editQuestion() {
        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));
        when(questionMapper.toEntity(questionDto)).thenReturn(question);
        when(questionRepository.save(question)).thenReturn(question);
        when(questionMapper.toDto(question)).thenReturn(questionDto);

        QuestionDto result = questionService.editQuestion(1L, questionDto);

        assertNotNull(result);
        assertEquals(questionDto.getId(), result.getId());
        assertEquals(questionDto.getQuestionTitle(), result.getQuestionTitle());
        verify(questionRepository).findById(1L);
        verify(questionRepository).save(question);
    }

    @Test
    void editQuestion_NotFound() {
        when(questionRepository.findById(1L)).thenReturn(Optional.empty());

        QuestionDto result = questionService.editQuestion(1L, questionDto);

        assertNull(result);
        verify(questionRepository).findById(1L);
        verify(questionRepository, never()).save(any(Question.class));
    }

    @Test
    void delete() {
        doNothing().when(questionRepository).deleteById(1L);

        questionService.delete(1L);

        verify(questionRepository).deleteById(1L);
    }
}
