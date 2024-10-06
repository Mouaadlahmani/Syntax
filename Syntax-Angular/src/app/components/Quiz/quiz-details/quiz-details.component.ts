import {Component, OnInit} from '@angular/core';
import {QuizService} from "../../../services/quiz/quiz.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Quiz} from "../../../classes/Quiz/quiz";

@Component({
  selector: 'app-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.css']
})
export class QuizDetailsComponent implements OnInit{

  id!:number
  quiz: Quiz = new Quiz();

  constructor(private service:QuizService,
              private router:Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getQuizById();
  }

  getQuizById(){
    this.service.getQuizById(this.id).subscribe(
      data=>{
        this.quiz = data;
      }
    )
  }

}
