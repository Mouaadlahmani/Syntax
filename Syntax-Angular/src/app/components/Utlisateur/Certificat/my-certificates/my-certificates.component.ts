import { Component, OnInit } from '@angular/core';
import { CertificatService } from "../../../../services/certificat/certificat.service";
import { ActivatedRoute } from "@angular/router";
import { Certificat } from "../../../../classes/Certificat/certificat";
import { AuthService } from "../../../../services/auth/auth.service";
import { jsPDF } from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-my-certificates',
  templateUrl: './my-certificates.component.html',
  styleUrls: ['./my-certificates.component.css']
})
export class MyCertificatesComponent implements OnInit {
  myCertificates: Certificat[] = [];
  userId!: number | null;

  constructor(
    private service: CertificatService,
    private authService: AuthService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.userId = this.authService.getCurrentUserId();
    this.getMyCertificates();
  }

  getMyCertificates() {
    this.service.getUtilisateurCertificatList(this.userId).subscribe(
      data => {
        this.myCertificates = data;
      }
    );
  }

  async downloadCertificate(index: number) {
    try {
      const certificateElement = document.getElementsByClassName('certificate-container')[index];

      const canvas = await html2canvas(certificateElement as HTMLElement, {
        scale: 2, // Higher scale for better quality
        useCORS: true,
        logging: false,
        backgroundColor: '#ffffff',
        onclone: (clonedDoc) => {
          const clonedElement = clonedDoc.getElementsByClassName('certificate-container')[index] as HTMLElement;
          if (clonedElement) {
            // Ensure proper dimensions and visibility
            clonedElement.style.padding = '40px';
            clonedElement.style.height = 'auto';
            clonedElement.style.position = 'relative';
            // Remove shadow for cleaner PDF
            clonedElement.style.boxShadow = 'none';
          }
        }
      });

      // Create PDF in landscape orientation (since certificates are typically wider than tall)
      const pdf = new jsPDF({
        orientation: 'landscape',
        unit: 'mm',
        format: 'a4'
      });

      const imgData = canvas.toDataURL('image/png', 1.0);

      // Calculate dimensions to fit on A4 landscape
      const pageWidth = pdf.internal.pageSize.getWidth();
      const pageHeight = pdf.internal.pageSize.getHeight();

      // Add the image to fit the page with margins
      pdf.addImage(imgData, 'PNG', 5, 5, pageWidth - 10, pageHeight - 10);

      // Save with course title
      pdf.save(`certificate-${this.myCertificates[index].courses.titre}.pdf`);

    } catch (error) {
      console.error('Error generating PDF:', error);
    }
  }
}
