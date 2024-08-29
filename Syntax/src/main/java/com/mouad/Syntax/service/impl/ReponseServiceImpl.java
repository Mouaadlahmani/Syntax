package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.dto.ReponseDto;
import com.mouad.Syntax.mapper.ReponseMapper;
import com.mouad.Syntax.model.Reponse;
import com.mouad.Syntax.repository.ReponseRepository;
import com.mouad.Syntax.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReponseServiceImpl implements ReponseService {

    @Autowired
    ReponseRepository reponseRepository;
    @Autowired
    ReponseMapper reponseMapper;

    @Override
    public ReponseDto addReponse(ReponseDto questionDto) {
        Reponse reponse = reponseMapper.toEntity(questionDto);
        Reponse saved = reponseRepository.save(reponse);
        return reponseMapper.toDto(saved);
    }

    @Override
    public List<ReponseDto> getAll() {
        List<Reponse> reponses = reponseRepository.findAll();
        return reponses.stream()
                .map(reponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReponseDto> ReponseById(Long id) {
        Optional<Reponse> reponseOptional = reponseRepository.findById(id);
        return reponseOptional.map(reponseMapper::toDto);
    }

    @Override
    public ReponseDto editReponse(Long id, ReponseDto questionDto) {
        Optional<Reponse> reponseOptional = reponseRepository.findById(id);
        if(reponseOptional.isPresent()){
            Reponse reponse = reponseOptional.get();
            reponse.setId(id);
            reponse.setQuestion(questionDto.getQuestion());
            reponse.setCorrect(questionDto.isCorrect());

            Reponse saved = reponseRepository.save(reponse);
            return reponseMapper.toDto(saved);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
    reponseRepository.deleteById(id);
    }
}
