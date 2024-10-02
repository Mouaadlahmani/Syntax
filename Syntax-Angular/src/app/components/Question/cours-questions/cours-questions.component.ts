import {Component, OnInit} from '@angular/core';
import {CoursService} from "../../../services/cours/cours.service";
import {Router} from "@angular/router";
import {Cours} from "../../../classes/Cours/cours";

@Component({
  selector: 'app-cours-questions',
  templateUrl: './cours-questions.component.html',
  styleUrls: ['./cours-questions.component.css']
})
export class CoursQuestionsComponent implements OnInit{

  courses:Cours[]=[];

  constructor(private service:CoursService,
              private router:Router) {
  }

  ngOnInit(): void {
    this.getCoursTitles();
  }

  getCoursTitles(){
    this.service.getCourses().subscribe(
      data=>{
        this.courses = data;
      }
    )
  }

  goToQuestions(id:number){
    this.router.navigate(['question', id])
  }

}
