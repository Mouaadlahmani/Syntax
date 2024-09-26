import {Component, OnInit} from '@angular/core';
import {Cours} from "../../../../classes/Cours/cours";
import {Lecon} from "../../../../classes/Lecon/lecon";
import {CoursService} from "../../../../services/cours/cours.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-user-cours-details',
  templateUrl: './user-cours-details.component.html',
  styleUrls: ['./user-cours-details.component.css']
})
export class UserCoursDetailsComponent implements OnInit {

  id!: number;
  cours: Cours = new Cours();
  selectedLecon!: Lecon;

  constructor(private service: CoursService,
              private route: ActivatedRoute,
              private router:Router

  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getCoursById(this.id).subscribe(
      data => {
        this.cours = data;
        if (this.cours.lecons.length > 0) {
          this.selectedLecon = this.cours.lecons[0];
        }
      },
      error => console.error('Error fetching course', error)
    );
  }
  courses(){
    this.router.navigate(['courses'])
  }

  selectLecon(lecon: Lecon): void {
    this.selectedLecon = lecon;
  }

}
