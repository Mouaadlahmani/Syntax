import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lecon} from "../../classes/Lecon/lecon";

@Injectable({
  providedIn: 'root'
})
export class LeconService {

  private url = 'http://localhost:8081/api/lecon/';

  constructor(private httpClient: HttpClient) { }

  addLecon(id:number,lecon: Lecon):Observable<Object>{
    return this.httpClient.post(`${this.url}add/${id}`, lecon);
  }

  leconsOfCours(id:number):Observable<Lecon[]>{
    return this.httpClient.get<Lecon[]>(`${this.url}cours/${id}`)
  }

  modifyLecon(id:number, lecon: Lecon):Observable<Object>{
    return this.httpClient.put(`${this.url}edit/${id}`, lecon)
  }

  deleteLecon(id:number): Observable<Lecon>{
    return this.httpClient.delete<Lecon>(`${this.url}delete/${id}`)
  }

  getLeconById(id:number):Observable<Lecon>{
    return this.httpClient.get<Lecon>(`${this.url}${id}`)
  }
}
