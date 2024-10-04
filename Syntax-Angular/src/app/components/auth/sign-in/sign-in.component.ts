import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AuthService } from "../../../services/auth/auth.service";
import { Router } from "@angular/router";
import { Jwt } from "../../../classes/Jwt/jwt";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  loginForm!: FormGroup;
  role!: string | null;
  hidePassword: boolean = true;
  errorMessage: string | null = null;

  constructor(private service: AuthService,
              private fb: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  submitForm(): void {
    if (this.loginForm.invalid) {
      return; // Prevent submission if the form is invalid
    }
    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe(
      response=>{
        const role = this.service.getCurrentUserRole();
        if(role){
          console.log(response);
          this.redirectUsers(role);
        }else{
          this.router.navigate(['/sign-in'])
        }
      },
      error =>{
        this.errorMessage = "invalid email or password.";
        console.log("Failed to log in", JSON.stringify(error));
      }
    );
  }

  redirectUsers(role : string){
    switch(role){
      case 'ADMIN' :
        this.router.navigate(['courses']);
        break;

      case 'UTILISATEUR' :
        this.router.navigate(['syntax/courses']);
        break;

      default : this.router.navigate(['/sign-in']);

    }
  }

}
