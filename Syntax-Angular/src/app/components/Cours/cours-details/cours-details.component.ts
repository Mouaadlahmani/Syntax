import { Component, OnInit } from '@angular/core';
import { CoursService } from "../../../services/cours/cours.service";
import { ActivatedRoute } from "@angular/router";
import { Cours } from "../../../classes/Cours/cours";
import { Lecon } from "../../../classes/Lecon/lecon";

@Component({
  selector: 'app-cours-details',
  templateUrl: './cours-details.component.html',
  styleUrls: ['./cours-details.component.css']
})
export class CoursDetailsComponent implements OnInit {

  id!: number;
  cours: Cours = new Cours();
  selectedLecon: Lecon | null = null;

  constructor(private service: CoursService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getCoursById(this.id).subscribe(
      data => {
        this.cours = data;
      },
      error => console.error('Error fetching course', error)
    );
  }

  selectLecon(lecon: Lecon): void {
    this.selectedLecon = lecon;
  }

}
