import {Component, OnInit} from '@angular/core';
import {LeconService} from "../../../services/lecon/lecon.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Contenu} from "../../../classes/Contenu/contenu";
import {Lecon} from "../../../classes/Lecon/lecon";
import {ContenuService} from "../../../services/contenu/contenu.service";

@Component({
  selector: 'app-lecon-details',
  templateUrl: './lecon-details.component.html',
  styleUrls: ['./lecon-details.component.css']
})
export class LeconDetailsComponent implements OnInit{

  id!:number;
  content?:Contenu[]=[];

  constructor(private service:LeconService,
              private contenuService:ContenuService,
              private route:ActivatedRoute,
              private router:Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getContenu();
  }

  getContenu(){
    this.contenuService.getContenuOfLecon(this.id).subscribe(
      data=>{
        this.content = data;
      }
    )
  }

  addContenu(){
    this.router.navigate(['contenu/add', this.id])
  }
  modifyContenu(id:number){
  this.router.navigate(['contenu/modify', id])
  }

  deleteContenu(id:number){
    this.contenuService.deleteContenu(id).subscribe(
      data=>{
       this.getContenu();
      }
    );
  }

}
