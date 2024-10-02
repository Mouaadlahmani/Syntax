import {Component, OnInit} from '@angular/core';
import {Quiz} from "../../../classes/Quiz/quiz";
import {QuizService} from "../../../services/quiz/quiz.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent implements OnInit{

  id!:number;
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

  Details(id:number){
    this.router.navigate(['quiz',id])
  }

  createQuiz(){
    this.router.navigate(['quiz/add'])
  }

  deleteQuiz(id: number) {
    const confirmation = confirm("Are you sure you want to delete this quiz?");
    if (confirmation) {
      this.service.deleteQuiz(id).subscribe(
        data => {
          this.getQuizList();
        },
        error => {
          console.error("Error deleting quiz:", error);
        }
      );
    }
  }

}
