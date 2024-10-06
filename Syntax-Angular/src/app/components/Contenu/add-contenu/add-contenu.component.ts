import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Contenu} from "../../../classes/Contenu/contenu";
import {ContenuService} from "../../../services/contenu/contenu.service";

@Component({
  selector: 'app-add-contenu',
  templateUrl: './add-contenu.component.html',
  styleUrls: ['./add-contenu.component.css']
})
export class AddContenuComponent implements OnInit{
  id!: number;
  contenu:Contenu = new Contenu();

  constructor(private service: ContenuService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id)
    this.service.getCotenuById(this.id).subscribe(
      data=>{
        console.log(data);
      }
    );

  }
  onSubmit(){
    this.service.addContenu(this.id,this.contenu).subscribe(
      data=>{
        this.router.navigate(['contenu', this.id]).then(()=>{
          console.log("Redirected successfully")
        });
      }
    )
  }

}
