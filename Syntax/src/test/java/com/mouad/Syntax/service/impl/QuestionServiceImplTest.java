package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.QuestionDto;
import com.mouad.Syntax.mapper.QuestionMapper;
import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Question;
import com.mouad.Syntax.repository.CoursRepository;
import com.mouad.Syntax.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
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
    void editQuestion() {
        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));
        when(questionRepository.save(question)).thenReturn(question);
        when(questionMapper.toDto(question)).thenReturn(questionDto);

        QuestionDto result = questionService.editQuestion(1L, questionDto);

        assertNotNull(result);
        assertEquals(questionDto.getId(), result.getId());
        verify(questionRepository).findById(1L);
        verify(questionRepository).save(question);
    }

    @Test
    void delete() {
        doNothing().when(questionRepository).deleteById(1L);

        questionService.delete(1L);

        verify(questionRepository).deleteById(1L);
    }
}
