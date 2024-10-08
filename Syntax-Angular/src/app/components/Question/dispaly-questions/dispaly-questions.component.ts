import {Component, OnInit} from '@angular/core';
import {Question} from "../../../classes/Question/question";
import {QuestionService} from "../../../services/question/question.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dispaly-questions',
  templateUrl: './dispaly-questions.component.html',
  styleUrls: ['./dispaly-questions.component.css']
})
export class DispalyQuestionsComponent implements OnInit{

  id!:number;
  questions:Question[]=[];

  constructor(private service: QuestionService,
              private route:ActivatedRoute,
              private router:Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getGuestions();
  }
  getGuestions(){
    this.service.getQuestionByCoursId(this.id).subscribe(
      data=>{
        this.questions = data;
        console.log(data)
      }
    )
  }

  toModify(id:number){
    this.router.navigate(['question/modify', id])
  }

  delete(id: number) {
    const confirmed = confirm('Are you sure you want to delete this question?');
    if (confirmed) {
      this.service.deleteQuestion(id).subscribe(
        data => {
          this.getGuestions();
        },
        error => {
          console.error('Error deleting question', error);
        }
      );
    }
  }

  addQuestion(){
    this.router.navigate(["question/add", this.id])
  }

}
