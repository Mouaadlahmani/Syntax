import {Component, OnInit} from '@angular/core';
import {Question} from "../../../classes/Question/question";
import {QuestionService} from "../../../services/question/question.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-modify-question',
  templateUrl: './modify-question.component.html',
  styleUrls: ['./modify-question.component.css']
})
export class ModifyQuestionComponent implements OnInit{

  id!:number;
  question: Question = new Question();
  errorMessage: string = '';
  constructor(private service: QuestionService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getQuestionById(this.id).subscribe(
      data=>{
        this.question = data;
      },
      error =>
        console.error('Error adding course', error)
    );
  }

  onSubmit(): void {
    // Validate that the correct answer is one of the three options
    if (this.question.rightAnswer !== this.question.option1 &&
      this.question.rightAnswer !== this.question.option2 &&
      this.question.rightAnswer !== this.question.option3) {
      this.errorMessage = 'The correct answer must match one of the provided options.';
      return;
    } else {
      this.errorMessage = '';
    }

    // Call service to modify the question if validation passes
    this.service.modifyQuestion(this.id, this.question).subscribe(
      data => {
        this.router.navigate(['question', this.question.cours.id]);
      },
      error => console.error('Error modifying question', error)
    );
  }
}
