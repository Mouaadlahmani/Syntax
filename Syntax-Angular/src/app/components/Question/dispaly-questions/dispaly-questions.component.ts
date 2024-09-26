import {Component, OnInit} from '@angular/core';
import {Question} from "../../../classes/Question/question";
import {QuestionService} from "../../../services/question/question.service";

@Component({
  selector: 'app-dispaly-questions',
  templateUrl: './dispaly-questions.component.html',
  styleUrls: ['./dispaly-questions.component.css']
})
export class DispalyQuestionsComponent implements OnInit{

  questions:Question[]=[];

  constructor(private service: QuestionService) {
  }

  ngOnInit(): void {
    this.getGuestions();
  }
  getGuestions(){
    this.service.getAllQuestions().subscribe(
      data=>{
        this.questions = data;
        console.log(data)
      }
    )
  }

}
