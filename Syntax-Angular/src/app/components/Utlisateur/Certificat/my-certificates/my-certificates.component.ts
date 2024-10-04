import {Component, OnInit} from '@angular/core';
import {CertificatService} from "../../../../services/certificat/certificat.service";
import {ActivatedRoute} from "@angular/router";
import {Certificat} from "../../../../classes/Certificat/certificat";
import {AuthService} from "../../../../services/auth/auth.service";

@Component({
  selector: 'app-my-certificates',
  templateUrl: './my-certificates.component.html',
  styleUrls: ['./my-certificates.component.css']
})
export class MyCertificatesComponent implements OnInit{

  myCertificates:Certificat[]=[];
  userId!:number | null;

  constructor(private service:CertificatService,
              private authService:AuthService,
              private route:ActivatedRoute) {
  }

  ngOnInit(): void {
    this.userId = this.authService.getCurrentUserId();
    this.getMyCertificates();
  }

  getMyCertificates(){
    this.service.getUtilisateurCertificatList(this.userId).subscribe(
      data=>{
        this.myCertificates = data;
      }
    )
  }

}
