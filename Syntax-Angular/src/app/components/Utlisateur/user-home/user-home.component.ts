import {Component, OnInit} from '@angular/core';
import {UtilisateursService} from "../../../services/utilisateurs/utilisateurs.service";
import {CoursService} from "../../../services/cours/cours.service";
import {QuizService} from "../../../services/quiz/quiz.service";
import {CertificatService} from "../../../services/certificat/certificat.service";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit{

  usersNumber!:number;
  coursesNumber!:number;
  quizzesNumber!:number;
  certifesNumber!:number;
  userName!:string;

  constructor(private utilisateurService:UtilisateursService,
              private courService:CoursService,
              private quizService:QuizService,
              private certifeService:CertificatService,
              private authService:AuthService) {
  }

  ngOnInit() {
    this.countUsers();
    this.countCourses();
    this.countCertifes();
    this.countQuizzes();
    this.getUserName();
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

  getUserName(){
    const firstName = this.authService.getCurrentUserFirstName();
    const lastName = this.authService.getCurrentUserLastName();
    this.userName = `${firstName} ${lastName}`;
  }


}
