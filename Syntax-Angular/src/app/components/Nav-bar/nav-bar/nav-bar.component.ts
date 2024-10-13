import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit{
  role!:string | null;
  email!:string | null;
  firstName!:string | null;
  lastName!:string | null;
  showNavButtons: boolean = true;
  isNavbarOpen: boolean = false;

  constructor(private router: Router, private authService:AuthService) {
  }

  getrole(){
    this.email = this.authService.getCurrentUserEmail();
    this.role = this.authService.getCurrentUserRole();
    this.firstName = this.authService.getCurrentUserFirstName();
    this.lastName = this.authService.getCurrentUserLastName()
  }

  ngOnInit(): void {
    this.getrole();
    this.checkRole();
  }
  toCourses(){
    this.router.navigate(['courses'])
  }
  checkRole(){
    if(this.role == 'ADMIN'){
      this.showNavButtons=false;
    }
  }
  logout(){
    localStorage.removeItem('token');
    this.router.navigate(['sign-in']);
  }
  toggleNavbar() {
    this.isNavbarOpen = !this.isNavbarOpen;
  }
  toHome(){
    if(this.role==='ADMIN'){
      this.router.navigate(['dashbord']);
    }else if(this.role==='UTILISATEUR'){
      this.router.navigate(['syntax/home']);
    }else {
      this.router.navigate([''])
    }
  }

}
