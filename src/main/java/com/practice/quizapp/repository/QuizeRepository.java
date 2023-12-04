package com.practice.quizapp.repository;

import com.practice.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizeRepository extends JpaRepository<Quiz,Integer> {
}
