import {Component, OnInit} from '@angular/core';
import {Utilisateur} from "../../../classes/Utilisateur/utilisateur";
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit{

  utilisateur: Utilisateur = new Utilisateur();

  constructor(private service: AuthService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  addUser(){
    this.service.register(this.utilisateur).subscribe(
      data=>{
        console.log(data);
      }
    )
  }

  onSubmit(){
    console.log(this.utilisateur.nom)
    this.addUser();
    this.router.navigate(['courses'])
  }

}
