import {Component, OnInit} from '@angular/core';
import {Quiz} from "../../../../classes/Quiz/quiz";
import {QuizService} from "../../../../services/quiz/quiz.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-display-quiz',
  templateUrl: './display-quiz.component.html',
  styleUrls: ['./display-quiz.component.css']
})
export class DisplayQuizComponent implements OnInit{

  quizList:Quiz[]=[];

  constructor(private service: QuizService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getQuizList();
  }
  getQuizList(){
    this.service.getAllQuizzes().subscribe(
      data=>{
        this.quizList = data;
        console.log(this.quizList)
      }
    )
  }
  startQuiz(id:number){
    this.router.navigate(['syntax/quiz', id])
  }


}
