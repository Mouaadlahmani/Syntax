import {Component, OnInit} from '@angular/core';
import {UtilisateursService} from "../../services/utilisateurs/utilisateurs.service";
import {CoursService} from "../../services/cours/cours.service";
import {QuizService} from "../../services/quiz/quiz.service";
import {CertificatService} from "../../services/certificat/certificat.service";

@Component({
  selector: 'app-admin-dashbord',
  templateUrl: './admin-dashbord.component.html',
  styleUrls: ['./admin-dashbord.component.css']
})
export class AdminDashbordComponent implements OnInit{

  usersNumber!:number;
  coursesNumber!:number;
  quizzesNumber!:number;
  certifesNumber!:number;

  constructor(private utilisateurService:UtilisateursService,
              private courService:CoursService,
              private quizService:QuizService,
              private certifeService:CertificatService) {
  }

  ngOnInit() {
    this.countUsers();
    this.countCourses();
    this.countCertifes();
    this.countQuizzes();
  }

  countUsers(){
    this.utilisateurService.count().subscribe(
      data=>{
        this.usersNumber = data;
      }
    )
  }

  countCourses(){
    this.courService.count().subscribe(
      data=>{
        this.coursesNumber = data;
      }
    )
  }

  countQuizzes(){
    this.quizService.count().subscribe(
      data=>{
        this.quizzesNumber = data;
      }
    )
  }

  countCertifes(){
    this.certifeService.count().subscribe(
      data=>{
        this.certifesNumber = data;
      }
    )
  }

}
