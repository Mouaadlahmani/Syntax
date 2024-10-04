import {Component, OnInit} from '@angular/core';
import {UtilisateursService} from "../../../services/utilisateurs/utilisateurs.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Utilisateur} from "../../../classes/Utilisateur/utilisateur";

@Component({
  selector: 'app-utilisateur-info',
  templateUrl: './utilisateur-info.component.html',
  styleUrls: ['./utilisateur-info.component.css']
})
export class UtilisateurInfoComponent implements OnInit{

  id!:number;
  utilisateur!:Utilisateur;
  hide: boolean = true;
  constructor(private service:UtilisateursService,
              protected router:Router,
              private route:ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getUtilisateurById(this.id).subscribe(
      data=>{
        console.log(data)
        this.utilisateur = data;
      }
    )
  }

  onSubmit(){
    this.service.editUtilisateur(this.id, this.utilisateur).subscribe(
      data=>{
        console.log(data);
      }
    )
  }

}
