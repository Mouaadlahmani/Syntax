import { Component, OnInit } from '@angular/core';
import { QuizService } from "../../../services/quiz/quiz.service";
import { CoursService } from "../../../services/cours/cours.service";
import { Cours } from "../../../classes/Cours/cours";

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {
  numQ: number = 0;
  title: string = '';
  successMessage: string = '';
  errorMessage: string = '';

  coursTitles: Cours[] = [];
  selectedCourse!: Cours; // Change the type to Cours

  constructor(private service: QuizService, private courService: CoursService) { }

  ngOnInit(): void {
    this.courService.getCourses().subscribe(data => {
      this.coursTitles = data;
    });
  }

  onCourseSelect(course: Cours) {
    this.selectedCourse = course; // Store the selected course
  }

  onSubmit() {
    // Ensure to pass selectedCourse details if needed
    if (this.selectedCourse && this.numQ > 0 && this.title) {
      this.service.addQuiz(this.selectedCourse.titre, this.numQ, this.title).subscribe(
        (data) => {
          console.log(data);
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
    this.numQ = 0;
    this.title = '';
  }
}
