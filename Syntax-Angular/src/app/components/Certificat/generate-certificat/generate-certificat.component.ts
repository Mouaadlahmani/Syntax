import {Component, OnInit} from '@angular/core';
import {CertificatService} from "../../../services/certificat/certificat.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Certificat} from "../../../classes/Certificat/certificat";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-generate-certificat',
  templateUrl: './generate-certificat.component.html',
  styleUrls: ['./generate-certificat.component.css']
})
export class GenerateCertificatComponent implements OnInit{

  userId!:number | null;
  coursId!:number;
  certificate!:Certificat;

  constructor(private service: CertificatService,
              private authService:AuthService,
              private router:Router,
              private route: ActivatedRoute) {
  }
  ngOnInit(): void {
    const userIdFromStorage = localStorage.getItem('userId');
    this.userId = this.authService.getCurrentUserId();
    this.coursId = this.route.snapshot.params['coursId'];
    console.log(this.coursId)
    console.log(this.userId);
    this.certificate = {
      dateObtention: new Date(), // Set the current date
      utilisateur: {},
      courses: {
        id: this.coursId,
        titre: '',
        description: '',
        certificat: [],
        lecons: [],
        questions: [],
      }
    };
    console.log(this.certificate)
    this.generateCertificate();
    this.certificate = this.certificate;
  }

  generateCertificate(): void {
    if (this.userId !== null && this.coursId) {
      console.log("Certificate object:", this.certificate);

      this.service.generateCertificat(this.userId, this.coursId, this.certificate).subscribe(
        data => {
          console.log('Certificate generated successfully', data);
        },
        error => {
          console.error('Error generating certificate:', error);
        }
      );
    } else {
      console.error('Invalid user ID or course ID');
    }
  }


}
