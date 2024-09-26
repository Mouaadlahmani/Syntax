import {Component, OnInit} from '@angular/core';
import {LeconService} from "../../../services/lecon/lecon.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {Lecon} from "../../../classes/Lecon/lecon";
import {Cours} from "../../../classes/Cours/cours";

@Component({
  selector: 'app-add-lecon',
  templateUrl: './add-lecon.component.html',
  styleUrls: ['./add-lecon.component.css']
})
export class AddLeconComponent implements OnInit{
  id!: number;
  lecon:Lecon = new Lecon();

  constructor(private service: LeconService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id)
  }
  onSubmit(){
    this.service.addLecon(this.id,this.lecon).subscribe(
      data=>{
        this.router.navigate(['courses/cours', this.id]);
      }
    )
  }

}
