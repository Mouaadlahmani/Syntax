import {Component, OnInit} from '@angular/core';
import {Cours} from "../../../../classes/Cours/cours";
import {CoursService} from "../../../../services/cours/cours.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-cours-list',
  templateUrl: './user-cours-list.component.html',
  styleUrls: ['./user-cours-list.component.css']
})
export class UserCoursListComponent implements OnInit{

  id!:number
  courses!: Cours[];
  searchText!:string;

  constructor(private service: CoursService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getCours();
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
