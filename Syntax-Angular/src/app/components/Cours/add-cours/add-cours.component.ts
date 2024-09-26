import {Component, OnInit} from '@angular/core';
import {CoursService} from "../../../services/cours/cours.service";
import {Cours} from "../../../classes/Cours/cours";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-cours',
  templateUrl: './add-cours.component.html',
  styleUrls: ['./add-cours.component.css']
})
export class AddCoursComponent implements OnInit{

  cours: Cours = new Cours();

  constructor(private service: CoursService,
              private router: Router) {
  }

  ngOnInit() {
  }

  addCours(){
    this.service.addCours(this.cours).subscribe(
      data=>{
        console.log(data);
        this.service.getCourses();
      },
      error => {
        console.error('Error adding course', error);
      }
    )


  }

  onSubmit(){
    this.addCours()
    this.router.navigate(['courses'])
    this.service.getCourses()
  }


}
