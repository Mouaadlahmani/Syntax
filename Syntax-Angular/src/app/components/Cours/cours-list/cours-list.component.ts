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

  courses!: Cours[];

  constructor(private service: CoursService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getCours()
  }

  getCours(){
    this.service.getCourses().subscribe(
      data=>{
        console.log(data);
        this.courses= data;
      }
    )
  }

}
