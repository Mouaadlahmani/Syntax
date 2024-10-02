import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Utilisateur} from "../../classes/Utilisateur/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class UtilisateursService {

  private apiUrl = 'http://localhost:8081/api/utilisateur/';

  constructor(private http: HttpClient) { }

  getAllUtilisateurs(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(`${this.apiUrl}all`);
  }

  getUtilisateurById(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${this.apiUrl}${id}`);
  }
}
