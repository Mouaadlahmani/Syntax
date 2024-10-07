import {Component, OnInit} from '@angular/core';
import {CertificatService} from "../../../../services/certificat/certificat.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Certificat} from "../../../../classes/Certificat/certificat";
import {AuthService} from "../../../../services/auth/auth.service";

@Component({
  selector: 'app-generate-certificat',
  templateUrl: './generate-certificat.component.html',
  styleUrls: ['./generate-certificat.component.css']
})
export class GenerateCertificatComponent implements OnInit {
  userId!: number | null;
  coursId!: number;
  certificate!: Certificat;
  message: string = '';
  messageType: 'success' | 'error' = 'success';
  showViewButton: boolean = false;

  constructor(
    private service: CertificatService,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const userIdFromStorage = localStorage.getItem('userId');
    this.userId = this.authService.getCurrentUserId();
    this.coursId = this.route.snapshot.params['coursId'];

    this.certificate = {
      dateObtention: new Date(),
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

    this.checkAndGenerateCertificate();
  }

  checkAndGenerateCertificate(): void {
    if (this.userId !== null && this.coursId) {
      this.service.checkCertificateExists(this.userId, this.coursId).subscribe(
        exists => {
          if (exists) {
            this.message = 'You already have this certificate!';
            this.messageType = 'success';
            this.showViewButton = true;
          } else {
            this.generateCertificate();
          }
        },
        error => {
          this.message = 'Error checking certificate status';
          this.messageType = 'error';
          console.error('Error checking certificate:', error);
        }
      );
    } else {
      this.message = 'Invalid user ID or course ID';
      this.messageType = 'error';
    }
  }

  generateCertificate(): void {
    if (this.userId !== null && this.coursId) {
      console.log("Certificate object:", this.certificate);
      this.service.generateCertificat(this.userId, this.coursId, this.certificate).subscribe(
        data => {
          this.message = 'Certificate generated successfully!';
          this.messageType = 'success';
          this.showViewButton = true;
          console.log('Certificate generated successfully', data);
        },
        error => {
          this.message = 'Error generating certificate';
          this.messageType = 'error';
          console.error('Error generating certificate:', error);
        }
      );
    }
  }

  viewCertificates(): void {
    this.router.navigate(['my-certificates']);
  }
}
