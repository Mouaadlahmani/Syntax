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
  successMessage: string | null = null;
  errorMessage: string | null = null;
  isLoading: boolean = false;

  constructor(private service: AuthService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  addUser(){
    this.isLoading = true;
    this.errorMessage = null;
    this.successMessage = null;

    this.service.register(this.utilisateur).subscribe(
      data => {
        this.successMessage = "Registration successful! Redirecting to login...";
        setTimeout(() => {
          this.router.navigate(['sign-in']);
        }, 2000); // Redirect after 2 seconds
      },
      error => {
        this.errorMessage = "Registration failed. Please try again.";
        this.isLoading = false;
      }
    );
  }

  onSubmit() {
    if (!this.utilisateur.nom || !this.utilisateur.prenom || !this.utilisateur.email || !this.utilisateur.password) {
      this.errorMessage = "Please fill in all fields";
      return;
    }
    this.addUser();
  }

}
