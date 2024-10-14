import { Component, OnInit } from '@angular/core';
import { QuizService } from "../../../../services/quiz/quiz.service";
import { Reponse } from "../../../../classes/Reponse/reponse";
import {ActivatedRoute, Router} from "@angular/router";
import { Question } from "../../../../classes/Question/question";
import {AuthService} from "../../../../services/auth/auth.service";
import {CoursService} from "../../../../services/cours/cours.service";
import {Quiz} from "../../../../classes/Quiz/quiz";

@Component({
  selector: 'app-start-quiz',
  templateUrl: './start-quiz.component.html',
  styleUrls: ['./start-quiz.component.css']
})
export class StartQuizComponent implements OnInit {

  id!: number;
  showStartModal = true;
  courseId!: number;
  userId!:number | null;
  quizQuestions: Question[] = [];
  responseList: Reponse[] = [];
  currentResponse: string = '';
  currentQuestionIndex: number = 0;
  isLoading: boolean = true;
  quizFinished: boolean = false;
  score: number = 0; // Track the score

  constructor(
    private service: QuizService,
    private authService:AuthService,
    private coursService:CoursService,
    private route: ActivatedRoute,
    private router:Router,
  ) {}

  ngOnInit(): void {
    this.userId = this.authService.getCurrentUserId();
    this.id = this.route.snapshot.params['id'];
    this.loadQuiz();
  }

  loadQuiz(): void {
    this.isLoading = true;
    this.service.getQuizById(this.id).subscribe({
      next: (data: Quiz) => {
        this.quizQuestions = data.questions;
        if (this.quizQuestions.length > 0) {
          const firstQuestionId = this.quizQuestions[0].id;
          this.coursService.getCoursByQuestionId(firstQuestionId).subscribe({
            next: (courseData) => {
              this.courseId = courseData.id;
              console.log('Course ID:', this.courseId);
            },
            error: (error) => {
              console.error('Error loading course:', error);
            }
          });
        }
        this.isLoading = false;
        console.log('Quiz loaded:', data);
        console.log('Questions:', this.quizQuestions);
      },
      error: (error) => {
        console.error('Error loading quiz:', error);
        this.isLoading = false;
      }
    });
  }

  next(): void {
    const currentQuestion = this.quizQuestions[this.currentQuestionIndex];

    // Check if the current response is correct
    if (currentQuestion.rightAnswer === this.currentResponse) {
      this.score++; // Increment score for correct answer
    }

    const response: Reponse = { id: currentQuestion.id, response: this.currentResponse };
    this.responseList.push(response);

    console.log(this.responseList);

    if (this.currentQuestionIndex < this.quizQuestions.length - 1) {
      this.currentQuestionIndex++;
      this.currentResponse = '';
    } else {
      this.finishQuiz();
    }
  }

  finishQuiz(): void {
    this.quizFinished = true;
    console.log(`Votre score est: ${this.score}`);
    // Call onSubmit to send the responses after finishing
    this.onSubmit();
  }

  toQuiz(){
    this.router.navigate(['syntax/quiz'])
  }

  onSubmit(): void {
    this.service.submitQuiz(this.id, this.responseList).subscribe(
      data => {
        this.score = data;
        console.log('Résultat du quiz soumis avec succès : ', data);

        // Calculate the passing threshold (80% of total questions)
        const passingThreshold = Math.ceil(this.quizQuestions.length * 0.8);

        if (this.score >= passingThreshold) {
          console.log('Quiz passed! Score is higher than 80%');
          this.router.navigate(['certificat', this.userId, this.courseId]);
        } else {
          console.log('Quiz not passed. Score is lower than 80%');
        }
      },
      error => {
        console.error('Erreur lors de la soumission du quiz', error);
      }
    );
  }
}
