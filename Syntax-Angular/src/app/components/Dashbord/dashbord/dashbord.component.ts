import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-dashbord',
  templateUrl: './dashbord.component.html',
  styleUrls: ['./dashbord.component.css']
})
export class DashbordComponent implements OnInit{
  role!:string | null;
  showNavButtons: boolean = true;

  constructor(private router: Router, private authService:AuthService) {
  }

  getrole(){
    this.role = this.authService.getCurrentUserRole();
  }

  ngOnInit(): void {
    this.getrole();
    this.checkRole();
  }
  checkRole(){
    if(this.role == 'UTILISATEUR'){
      this.showNavButtons=false;
    }
  }

}
