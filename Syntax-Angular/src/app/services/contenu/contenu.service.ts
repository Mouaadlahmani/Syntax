import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contenu} from "../../classes/Contenu/contenu";
import {Observable} from "rxjs";
import {Cours} from "../../classes/Cours/cours";

@Injectable({
  providedIn: 'root'
})
export class ContenuService {

  private url = 'http://localhost:8081/api/contenu/';

  constructor(private httpClient: HttpClient) { }

  addContenu(id:number, contenu: Contenu):Observable<Object>{
    return this.httpClient.post(`${this.url}add/${id}`, contenu);
  }
  getCotenuById(id:number):Observable<Contenu>{
    return this.httpClient.get<Contenu>(`${this.url}${id}`)
  }

    getContenuOfLecon(id: number | undefined):Observable<Contenu[]>{
    return this.httpClient.get<Contenu[]>(`${this.url}lecon/${id}`);
  }

  modifyContenu(id:number, contenu: Contenu):Observable<Object>{
    return this.httpClient.put(`${this.url}edit/${id}`, contenu);
  }

  deleteContenu(id:number):Observable<Contenu>{
    return this.httpClient.delete<Contenu>(`${this.url}delete/${id}`)
  }
}
