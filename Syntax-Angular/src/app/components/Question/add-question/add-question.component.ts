import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../../../services/question/question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Question} from "../../../classes/Question/question";
import {CoursService} from "../../../services/cours/cours.service";
import {Cours} from "../../../classes/Cours/cours";

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit{

  id!:number;
  question: Question = new Question();
  coursTitles:Cours[]=[];
  selectedCourse!: Cours;
  errorMessage: string = '';

  constructor(private service: QuestionService,
              private router: Router,
              private courService:CoursService,
              private route: ActivatedRoute
              ) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.courService.getCourses().subscribe(
      data=>{
        this.coursTitles=data;
      }
    );
  }

  onCourseSelect(course: Cours) {
    this.selectedCourse = course;
  }


  onSubmit() {
    if (
      this.question.rightAnswer !== this.question.option1 &&
      this.question.rightAnswer !== this.question.option2 &&
      this.question.rightAnswer !== this.question.option3
    ) {
      this.errorMessage = 'The correct answer must be one of the provided options!';
      return;
    }
    this.errorMessage = '';
    this.service.addQuestion(this.id, this.question).subscribe(data => {
      console.log(data);
    });

    this.router.navigate(['question', this.id]).then();
  }

}
