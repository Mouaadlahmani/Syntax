import { Component } from '@angular/core';
import {QuizService} from "../../../services/quiz/quiz.service";
import {Quiz} from "../../../classes/Quiz/quiz";


@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent {

  category: string = '';
  numQ: number = 0;
  title: string = '';

  successMessage: string = '';
  errorMessage: string = '';

  constructor(private quizService: QuizService) { }

  onSubmit() {
    if (this.category && this.numQ > 0 && this.title) {
      this.quizService.addQuiz(this.category, this.numQ, this.title).subscribe(
        (data) => {
          this.successMessage = 'Quiz added successfully!';
          this.errorMessage = '';
          this.clearForm();
        },
        (error) => {
          this.errorMessage = 'Failed to add quiz. Please try again.';
          this.successMessage = '';
        }
      );
    } else {
      this.errorMessage = 'Please fill out all fields correctly.';
      this.successMessage = '';
    }
  }

  clearForm() {
    this.category = '';
    this.numQ = 0;
    this.title = '';
  }
}
