import {Component, OnInit} from '@angular/core';
import {CoursService} from "../../../services/cours/cours.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Cours} from "../../../classes/Cours/cours";

@Component({
  selector: 'app-modify-cours',
  templateUrl: './modify-cours.component.html',
  styleUrls: ['./modify-cours.component.css']
})
export class ModifyCoursComponent implements OnInit{

  id!:number;
  cours: Cours = new Cours();
  constructor(private service: CoursService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getCoursById(this.id).subscribe(
      data=>{
        this.cours = data;
      },
      error =>
        console.error('Error adding course', error)
    );
  }

  onSubmit(){
    this.service.modifyCours(this.id, this.cours).subscribe(
      data=>{
        this.router.navigate(['courses'])
      }
    )
  }
}
