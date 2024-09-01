package com.mouad.Syntax.repository;

import com.mouad.Syntax.model.Cours;
import com.mouad.Syntax.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCours(Cours cours);

    @Query(value = "SELECT q.* FROM question q\n" +
            "INNER JOIN cours c ON q.cours = c.id\n" +
            "WHERE c.titre = :category\n" +
            "ORDER BY RANDOM()\n" +
            "LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCours(String category, int numQ);

}
