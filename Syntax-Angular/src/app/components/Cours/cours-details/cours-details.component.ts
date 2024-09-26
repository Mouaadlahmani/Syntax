import { Component, OnInit } from '@angular/core';
import { CoursService } from "../../../services/cours/cours.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import { Cours } from "../../../classes/Cours/cours";
import { Lecon } from "../../../classes/Lecon/lecon";
import {LeconService} from "../../../services/lecon/lecon.service";

@Component({
  selector: 'app-cours-details',
  templateUrl: './cours-details.component.html',
  styleUrls: ['./cours-details.component.css']
})
export class CoursDetailsComponent implements OnInit {

  id!: number;
  cours: Cours = new Cours();
  Lecons: Lecon[]=[];

  constructor(private service: CoursService,
              private leconService:LeconService,
              private route: ActivatedRoute,
              private router:Router

  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getCoursById(this.id).subscribe(
      data => {
      this.Lecons = data.lecons;
      },
      error => console.error('Error fetching course', error)
    );
  }
  courses(){
    this.router.navigate(['courses'])
  }

  modifyLecon(id: number | undefined){
    this.router.navigate(['lecons/modify',id])
  }
  deleteLecon(id: number | undefined) {
    if (id) {
      this.leconService.deleteLecon(id).subscribe(
        () => {
          this.router.navigate(['courses/cours', this.id])
        },
        error => console.error('Error deleting leçon', error)
      );
    }
  }
  addLecon(id: number){
    this.router.navigate(['lecons/add',this.id])
  }

  LeconDetails(id:number){
    this.router.navigate(['contenu', id])
  }

}
