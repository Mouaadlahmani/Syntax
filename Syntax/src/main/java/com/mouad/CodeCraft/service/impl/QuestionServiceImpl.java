package com.mouad.CodeCraft.service.impl;

import com.mouad.CodeCraft.dto.QuestionDto;
import com.mouad.CodeCraft.mapper.QuestionMapper;
import com.mouad.CodeCraft.model.Question;
import com.mouad.CodeCraft.repository.QuestionRepository;
import com.mouad.CodeCraft.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        Question saved = questionRepository.save(question);
        return questionMapper.toDto(saved);
    }

    @Override
    public QuestionDto updateQuestion(Long id, QuestionDto questionDto) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            Question editedQuestion = question.get();
            editedQuestion.setId(id);
            editedQuestion.setQuestion(questionDto.getQuestion());
            editedQuestion.setQuiz(questionDto.getQuiz());
            editedQuestion.setReponses(questionDto.getReponses());

            Question edited = questionRepository.save(editedQuestion);
            return questionMapper.toDto(edited);
        }
        return null;
    }

    @Override
    public Optional<QuestionDto> getQuestionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.map(questionMapper::toDto);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
