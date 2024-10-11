import {Component, OnInit} from '@angular/core';
import {Cours} from "../../../../classes/Cours/cours";
import {CoursService} from "../../../../services/cours/cours.service";
import {Router} from "@angular/router";
import {AuthService} from "../../../../services/auth/auth.service";

@Component({
  selector: 'app-user-cours-list',
  templateUrl: './user-cours-list.component.html',
  styleUrls: ['./user-cours-list.component.css']
})
export class UserCoursListComponent implements OnInit{

  id!:number
  courses!: Cours[];
  searchText!:string;
  userToken!:string | null

  constructor(private service: CoursService,
              private router: Router,
              private authService:AuthService) {
  }

  ngOnInit(): void {
    this.getCours();
    this.userToken = this.authService.getToken();
  }

  checkIfUserAuthenticated(){
    if (this.userToken===null){
      this.router.navigate(['sign-up'])
    }
  }

  getCours(){
    this.service.getCourses().subscribe(
      data=>{
        console.log(data);
        this.courses= data;
      }
    )
  }

  coursDetails(id:number){
    this.router.navigate(['syntax/courses/cours', id])
  }

  get filteredProjects() {
    if (!this.searchText || this.searchText.trim() === '') {
      return this.courses;
    } else {
      return this.courses.filter(cours =>
        cours.titre.toLowerCase().includes(this.searchText.toLowerCase()) ||
        cours.description.toLowerCase().includes(this.searchText.toLowerCase())
      );
    }
  }

}
