import { Component, OnInit } from '@angular/core';
import { UtilisateursService } from '../../services/utilisateurs/utilisateurs.service';
import { CoursService } from '../../services/cours/cours.service';
import { QuizService } from '../../services/quiz/quiz.service';
import { CertificatService } from '../../services/certificat/certificat.service';

@Component({
  selector: 'app-admin-dashbord',
  templateUrl: './admin-dashbord.component.html',
  styleUrls: ['./admin-dashbord.component.css'],
})
export class AdminDashbordComponent implements OnInit {
  usersNumber!: number;
  coursesNumber!: number;
  quizzesNumber!: number;
  certifesNumber!: number;

  // Chart Data
  userChartData = [300, 500]; // Example data: active/inactive users
  userChartLabels = ['Active', 'Inactive'];

  courseChartData = [{ data: [10, 15, 20], label: 'Courses' }];
  courseChartLabels = ['Beginner', 'Intermediate', 'Advanced'];

  quizCertChartData = [
    { data: [5, 10, 15], label: 'Quizzes' },
    { data: [8, 12, 18], label: 'Certificates' },
  ];
  quizCertChartLabels = ['January', 'February', 'March'];

  constructor(
    private utilisateurService: UtilisateursService,
    private courService: CoursService,
    private quizService: QuizService,
    private certifeService: CertificatService
  ) {}

  ngOnInit() {
    this.countUsers();
    this.countCourses();
    this.countQuizzes();
    this.countCertifes();
  }

  countUsers() {
    this.utilisateurService.count().subscribe((data) => {
      this.usersNumber = data;
      this.userChartData = [data, 100 - data]; // Adjusting chart data
    });
  }

  countCourses() {
    this.courService.count().subscribe((data) => {
      this.coursesNumber = data;
      this.courseChartData[0].data = [data / 3, data / 3, data / 3]; // Example data split
    });
  }

  countQuizzes() {
    this.quizService.count().subscribe((data) => {
      this.quizzesNumber = data;
      this.quizCertChartData[0].data = [data, data + 5, data + 10]; // Example growth
    });
  }

  countCertifes() {
    this.certifeService.count().subscribe((data) => {
      this.certifesNumber = data;
      this.quizCertChartData[1].data = [data, data + 4, data + 8]; // Example growth
    });
  }
}
