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

  onSubmit(){
    this.service.modifyQuestion(this.id, this.question).subscribe(
      data=>{
        this.router.navigate(['courses'])
      }
    )
  }
}
