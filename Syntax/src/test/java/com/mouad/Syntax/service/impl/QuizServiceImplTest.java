//package com.mouad.Syntax.service.impl;
//
//import com.mouad.Syntax.dto.QuizDto;
//import com.mouad.Syntax.mapper.QuizMapper;
//import com.mouad.Syntax.model.Question;
//import com.mouad.Syntax.model.Quiz;
//import com.mouad.Syntax.dto.QuestionWrapper;
//import com.mouad.Syntax.dto.Reponse;
//import com.mouad.Syntax.repository.QuestionRepository;
//import com.mouad.Syntax.repository.QuizRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.ArgumentCaptor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class QuizServiceImplTest {
//
//    @Mock
//    private QuizRepository quizRepository;
//
//    @Mock
//    private QuestionRepository questionRepository;
//
//    @Mock
//    private QuizMapper quizMapper;
//
//    @InjectMocks
//    private QuizServiceImpl quizService;
//
//    private Quiz quiz;
//    private QuizDto quizDto;
//    private Question question;
//    private List<Question> questionList;
//    private List<Reponse> responses;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        // Setup dummy data
//        quiz = new Quiz();
//        quiz.setId(1L);
//        quiz.setTitre("Java Quiz");
//
//        question = new Question();
//        question.setId(1L);
//        question.setQuestionTitle("What is Java?");
//        question.setRightAnswer("A programming language");
//
//        questionList = new ArrayList<>();
//        questionList.add(question);
//
//        quiz.setQuestions(questionList);
//
//        quizDto = new QuizDto();
//        quizDto.setId(1L);
//        quizDto.setTitre("Java Quiz");
//
//        // Use setters if Reponse constructor doesn't accept arguments
//        Reponse response = new Reponse();
//        response.setId(1L);
//        response.setResponse("A programming language");
//
//        responses = new ArrayList<>();
//        responses.add(response);
//    }
//
//    @Test
//    void ajouterQuiz() {
//        // Arrange
//        List<Question> questionList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Question question = new Question();
//            question.setId((long) i);
//            question.setQuestionTitle("Sample Question " + i);
//            questionList.add(question);
//        }
//
//        when(questionRepository.findRandomQuestionByCours("Java", 5)).thenReturn(questionList);
//        when(quizMapper.toDto(any(Quiz.class))).thenReturn(quizDto);
//
//        // Act
//        QuizDto result = quizService.ajouterQuiz("Java", 5, "Java Quiz");
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(quizDto.getId(), result.getId());
//        assertEquals("Java Quiz", result.getTitre());
//
//        // Verify the save method was called and check the questions
//        ArgumentCaptor<Quiz> argumentCaptor = ArgumentCaptor.forClass(Quiz.class);
//        verify(quizRepository).save(argumentCaptor.capture());
//
//        Quiz savedQuiz = argumentCaptor.getValue();
//        assertEquals("Java Quiz", savedQuiz.getTitre());
//        assertEquals(5, savedQuiz.getQuestions().size()); // Now this should pass
//    }
//
//    @Test
//    void calculateResult() {
//        when(quizRepository.findById(1L)).thenReturn(Optional.of(quiz));
//
//        int score = quizService.calculateResult(1L, responses);
//
//        assertEquals(1, score);  // Assuming 1 correct answer
//        verify(quizRepository).findById(1L);
//    }
//
//    @Test
//    void getQuiz() {
//        when(quizRepository.findById(1L)).thenReturn(Optional.of(quiz));
//        when(quizMapper.toDto(quiz)).thenReturn(quizDto);
//
//        Optional<QuizDto> result = quizService.getQuiz(1L);
//
//        assertTrue(result.isPresent());
//        assertEquals(quizDto.getId(), result.get().getId());
//        verify(quizRepository).findById(1L);
//    }
//
//    @Test
//    void getQuizWithQuestions() {
//        when(quizRepository.findById(1L)).thenReturn(Optional.of(quiz));
//
//        List<QuestionWrapper> result = quizService.getQuizWithQuestions(1L);
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals(question.getId(), result.get(0).getId());
//        verify(quizRepository).findById(1L);
//    }
//
//    @Test
//    void getAllQuizzes() {
//        List<Quiz> quizList = new ArrayList<>();
//        quizList.add(quiz);
//
//        when(quizRepository.findAll()).thenReturn(quizList);
//        when(quizMapper.toDto(quiz)).thenReturn(quizDto);
//
//        List<QuizDto> result = quizService.getAllQuizzes();
//
//        assertEquals(1, result.size());
//        assertEquals(quizDto.getId(), result.get(0).getId());
//        verify(quizRepository).findAll();
//    }
//
//    @Test
//    void deleteQuiz() {
//        doNothing().when(quizRepository).deleteById(1L);
//
//        quizService.deleteQuiz(1L);
//
//        verify(quizRepository).deleteById(1L);
//    }
//
//    @Test
//    void demarrerQuiz() {
//    }
//}
