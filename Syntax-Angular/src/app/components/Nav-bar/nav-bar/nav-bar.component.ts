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
  showNavButtons: boolean = true;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    this.role = localStorage.getItem('userRole');
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
    localStorage.removeItem('userId');
    localStorage.removeItem('userRole');
    this.router.navigate(['sign-in']);
  }

}
