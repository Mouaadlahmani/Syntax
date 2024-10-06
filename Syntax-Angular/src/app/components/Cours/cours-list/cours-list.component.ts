import {Component, OnInit} from '@angular/core';
import {CoursService} from "../../../services/cours/cours.service";
import {Router} from "@angular/router";
import {Cours} from "../../../classes/Cours/cours";

@Component({
  selector: 'app-cours-list',
  templateUrl: './cours-list.component.html',
  styleUrls: ['./cours-list.component.css']
})
export class CoursListComponent implements OnInit{

  id!:number
  courses!: Cours[];

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

  modifyCours(id:number){
    this.router.navigate(['/courses/modify',id])
  }

  deleteCours(id:number){
    const confirmation = confirm("Are you sure you want to delete this course?");
    if (confirmation){
      this.service.deleteCours(id).subscribe(
        data=>{
          this.getCours();
        },
        error => {
          console.error("Error deleting course:", error);
        }
      )
    }

  }

  coursDetails(id:number){
    this.router.navigate(['courses/cours', id])
  }

  addCours(){
    this.router.navigate(['courses/add'])
  }

}
