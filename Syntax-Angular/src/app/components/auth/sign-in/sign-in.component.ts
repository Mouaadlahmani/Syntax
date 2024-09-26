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
    this.role = localStorage.getItem('userRole');
  }

  submitForm(): void {
    if (this.loginForm.invalid) {
      return; // Prevent submission if the form is invalid
    }

    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe(
      (response: Jwt) => {
        const jwtToken = response.token;
        const userId = response.user.id;
        const userRole = response.user.role;

        localStorage.setItem('token', jwtToken);
        localStorage.setItem('userId', userId.toString());
        localStorage.setItem('userRole', userRole);

        // Navigate based on role
        if (userRole === 'ADMIN') {
          this.router.navigate(['courses']);
        } else {
          this.router.navigate(['syntax/courses']);
        }

        // Clear form
        this.loginForm.reset();
      },
      (error) => {
        this.errorMessage = 'Login failed. Please check your credentials.'; // Set error message
        console.error(error); // Log the error for debugging
      }
    );
  }

}
