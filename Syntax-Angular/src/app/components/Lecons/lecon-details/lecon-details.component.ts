import { Component, OnInit } from '@angular/core';
import { LeconService } from "../../../services/lecon/lecon.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Contenu } from "../../../classes/Contenu/contenu";
import { Lecon } from "../../../classes/Lecon/lecon";
import { ContenuService } from "../../../services/contenu/contenu.service";
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'app-lecon-details',
  templateUrl: './lecon-details.component.html',
  styleUrls: ['./lecon-details.component.css']
})
export class LeconDetailsComponent implements OnInit {
  id!: number;
  content?: Contenu[] = [];

  // Declare sanitizer as a private property
  private readonly sanitizer: DomSanitizer;

  constructor(
    private service: LeconService,
    private contenuService: ContenuService,
    private route: ActivatedRoute,
    private router: Router,
    sanitizer: DomSanitizer  // Inject DomSanitizer
  ) {
    this.sanitizer = sanitizer; // Assign it to the class property
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getContenu();
  }

  getContenu() {
    this.contenuService.getContenuOfLecon(this.id).subscribe(
      data => {
        this.content = data;
      }
    );
  }

  addContenu() {
    this.router.navigate(['contenu/add', this.id]);
  }

  modifyContenu(id: number) {
    this.router.navigate(['contenu/modify', id]);
  }

  deleteContenu(id: number) {
    this.contenuService.deleteContenu(id).subscribe(
      data => {
        this.getContenu();
      }
    );
  }

  getSafeDescription(description: string): SafeHtml {
    if (!description) return '';

    const formattedContent = description
      .split('\n')
      .map(paragraph => paragraph.trim())
      .filter(paragraph => paragraph.length > 0)
      .map(paragraph => `<p>${paragraph}</p>`)
      .join('');

    return this.sanitizer.bypassSecurityTrustHtml(formattedContent);
  }
}
