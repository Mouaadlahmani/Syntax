import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Lecon} from "../../../classes/Lecon/lecon";
import {LeconService} from "../../../services/lecon/lecon.service";

@Component({
  selector: 'app-modify-lecon',
  templateUrl: './modify-lecon.component.html',
  styleUrls: ['./modify-lecon.component.css']
})
export class ModifyLeconComponent implements OnInit{

  id!:number;
  lecon: Lecon = new Lecon();
  constructor(private service: LeconService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getLeconById(this.id).subscribe(
      data=>{
        this.lecon = data;
      },
      error =>
        console.error('Error adding course', error)
    );
  }

  onSubmit(){
    this.service.modifyLecon(this.id, this.lecon).subscribe(
      data=>{
        this.router.navigate(['courses/cours', this.lecon.courses.id]);
      }
    )
  }

  deleteLecon(id:number){
    this.service.deleteLecon(id).subscribe(
      data=>{
        this.router.navigate(['courses/cours', this.lecon.courses.id]);
      }
    );
  }
}
