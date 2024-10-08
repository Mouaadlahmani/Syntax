package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.QuestionDto;
import com.mouad.Syntax.mapper.QuestionMapper;
import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Question;
import com.mouad.Syntax.repository.CoursRepository;
import com.mouad.Syntax.repository.QuestionRepository;
import com.mouad.Syntax.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final CoursRepository coursRepository;

    private final QuestionMapper questionMapper;


    @Override
    public QuestionDto addQuestion(Long id, QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        Cours cours = coursRepository.findById(id).orElseThrow();
        question.setCours(cours);
        Question saved = questionRepository.save(question);
        return questionMapper.toDto(saved);
    }

    @Override
    public List<QuestionDto> getAll() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionDto> questionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.map(questionMapper::toDto);
    }

    @Override
    public List<QuestionDto> findByCours(Long id) {
        Cours cours = coursRepository.findById(id).orElseThrow();
        List<Question> questions = questionRepository.findByCours(cours);
        return questions.stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto editQuestion(Long id, QuestionDto questionDto) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            question.setId(id);
            question.setQuizzes(questionDto.getQuizzes());
            question.setQuestionTitle(questionDto.getQuestionTitle());
            question.setOption1(questionDto.getOption1());
            question.setOption2(question.getOption2());
            question.setOption3(question.getOption3());
            question.setDifficultyLevel(questionDto.getDifficultyLevel());
            question.setCours(questionDto.getCours());
            question.setRightAnswer(questionDto.getRightAnswer());

            Question saved = questionRepository.save(question);
            return questionMapper.toDto(saved);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
