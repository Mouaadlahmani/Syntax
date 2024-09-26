import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Contenu} from "../../../classes/Contenu/contenu";
import {ContenuService} from "../../../services/contenu/contenu.service";

@Component({
  selector: 'app-modify-contenu',
  templateUrl: './modify-contenu.component.html',
  styleUrls: ['./modify-contenu.component.css']
})
export class ModifyContenuComponent implements OnInit{

  id!:number;
  contenu: Contenu = new Contenu();
  constructor(private service: ContenuService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getCotenuById(this.id).subscribe(
      data=>{
        this.contenu = data;
      },
      error =>
        console.error('Error adding course', error)
    );
  }

  onSubmit(){
    this.service.modifyContenu(this.id, this.contenu).subscribe(
      data=>{
        this.router.navigate(['contenu', this.contenu.lecon?.id])
      }
    )
  }
}
