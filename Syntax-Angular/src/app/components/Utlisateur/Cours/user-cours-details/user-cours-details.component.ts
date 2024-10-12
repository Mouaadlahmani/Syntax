import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { Lecon } from "../../../../classes/Lecon/lecon";
import { Contenu } from "../../../../classes/Contenu/contenu";
import { ContenuService } from "../../../../services/contenu/contenu.service";
import { LeconService } from "../../../../services/lecon/lecon.service";
import {DomSanitizer, SafeHtml} from "@angular/platform-browser";

@Component({
  selector: 'app-user-cours-details',
  templateUrl: './user-cours-details.component.html',
  styleUrls: ['./user-cours-details.component.css']
})
export class UserCoursDetailsComponent implements OnInit {

  id!: number;
  leconId?: number; // ID de la leçon sélectionnée
  leconList: Lecon[] = []; // Liste des leçons du cours
  contenuList: Contenu[] = []; // Liste des contenus de la leçon sélectionnée
  selectedLecon!: Lecon; // Leçon actuellement sélectionnée

  constructor(
    private service: LeconService,
    private contenuService: ContenuService,
    private route: ActivatedRoute,
    private router: Router,
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.service.leconsOfCours(this.id).subscribe(
      data => {
        this.leconList = data;
        if (this.leconList.length > 0) {
          this.selectLecon(this.leconList[0], this.leconList[0].id);
        }
      },
      error => {
        console.error("Erreur lors de la récupération des leçons :", error);
      }
    );

    // Écouter les changements de paramètres de route pour récupérer leconId
    this.route.params.subscribe(params => {
      this.leconId = params['leconId'];

      // Si un leconId est présent, récupérer le contenu de la leçon
      if (this.leconId) {
        this.loadContenuForLecon(this.leconId);
      }
    });
  }

  isSidebarOpen: boolean = true;

  toggleSidebar() {
    if (window.innerWidth < 768) { // Only allow toggling for desktop view
      this.isSidebarOpen = !this.isSidebarOpen;
      const mainContent = document.querySelector('.main-content') as HTMLElement;

      if (this.isSidebarOpen) {
        mainContent.style.marginLeft = '250px';
      } else {
        mainContent.style.marginLeft = '0';
      }
    }
  }


  /**
   * Méthode pour naviguer vers la liste des cours
   */
  courses() {
    this.router.navigate(['courses']);
  }

  /**
   * Méthode appelée lors de la sélection d'une leçon
   * @param lecon - Objet Lecon sélectionné
   * @param leconId - ID de la leçon sélectionnée
   */
  selectLecon(lecon: Lecon, leconId: number): void {
    this.selectedLecon = lecon;
    this.leconId = leconId;

    // Naviguer vers la route avec les paramètres du cours et de la leçon
    this.router.navigate(['syntax/courses/lecon', this.id, this.leconId]);

    // Charger le contenu de la leçon sélectionnée
    this.loadContenuForLecon(this.leconId);
  }

  private loadContenuForLecon(leconId: number): void {
    this.contenuService.getContenuOfLecon(leconId).subscribe(
      data => {
        this.contenuList = data; // Mettre à jour la liste des contenus
        console.log("Contenus récupérés :", this.contenuList);
      },
      error => {
        console.error("Erreur lors de la récupération des contenus :", error);
      }
    );
  }
  getSafeDescription(description: string): SafeHtml {
    if (!description) return '';

    // Replace spaces with non-breaking spaces and preserve line breaks
    const formattedContent = description
      .split('\n')
      .map(line => line.replace(/ {2,}/g, match => '&nbsp;'.repeat(match.length))) // Replace multiple spaces with &nbsp;
      .join('<br>'); // Use <br> for line breaks

    return this.sanitizer.bypassSecurityTrustHtml(formattedContent);
  }
}
