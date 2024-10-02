import {Component, OnInit} from '@angular/core';
import {QuizService} from "../../../../services/quiz/quiz.service";
import {Reponse} from "../../../../classes/Reponse/reponse";
import {ActivatedRoute} from "@angular/router";
import {Quiz} from "../../../../classes/Quiz/quiz";

@Component({
  selector: 'app-start-quiz',
  templateUrl: './start-quiz.component.html',
  styleUrls: ['./start-quiz.component.css']
})
export class StartQuizComponent implements OnInit{

  quizId!:number;
  quiz!:Quiz | null;
  responseList:Reponse[]=[];
  respone!:Reponse;

  constructor(private service:QuizService,
              private route:ActivatedRoute) {
  }

  ngOnInit(): void {
    this.quizId = this.route.snapshot.params['quizId'];
    this.service.getQuizById(this.quizId).subscribe(
      data=>{
        this.quiz =data;
        console.log(this.quiz)
      }
    )
  }

  next(){
    this.responseList.push(this.respone);
  }

  onSumit(){
    this.service.submitQuiz(this.quizId, this.responseList).subscribe(
      data=>{
        console.log(data)
      }
    )
  }

}
