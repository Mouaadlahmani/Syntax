import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../../../services/question/question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Question} from "../../../classes/Question/question";

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit{

  id!:number;
  question: Question = new Question();

  constructor(private service: QuestionService,
              private router: Router,
              private route: ActivatedRoute
              ) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
  }


  onSubmit(){
    this.service.addQuestion(this.id,this.question).subscribe(
      data=>{
        console.log(data);
      }
    )
    this.router.navigate(['questions']);
  }

}
