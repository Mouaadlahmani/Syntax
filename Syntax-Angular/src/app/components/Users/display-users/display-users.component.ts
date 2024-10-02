import {Component, OnInit} from '@angular/core';
import {UtilisateursService} from "../../../services/utilisateurs/utilisateurs.service";
import {Utilisateur} from "../../../classes/Utilisateur/utilisateur";

@Component({
  selector: 'app-display-users',
  templateUrl: './display-users.component.html',
  styleUrls: ['./display-users.component.css']
})
export class DisplayUsersComponent implements OnInit{

  utilisateurs:Utilisateur[]=[];

  constructor(private service: UtilisateursService) {
  }

  ngOnInit(): void {
    this.getUtilisateur();
  }

  getUtilisateur(){
    this.service.getAllUtilisateurs().subscribe(
      data=>{
        this.utilisateurs = data;
      }
    )
  }

}
