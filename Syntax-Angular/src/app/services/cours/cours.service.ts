import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Cours} from "../../classes/Cours/cours";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CoursService {

  private url = "http://localhost:8081/api/cours/";

  constructor(private httpClient: HttpClient) { }

  addCours(cours: Cours):Observable<Object>{
    return this.httpClient.post(this.url + 'add', cours);
  }

  getCourses():Observable<Cours[]>{
    return this.httpClient.get<Cours[]>(this.url+'all');
  }

  getCoursById(id:number):Observable<Cours>{
    return this.httpClient.get<Cours>(`${this.url}${id}`)
  }

  getCoursByQuestionId(id:number):Observable<Cours>{
    return this.httpClient.get<Cours>(`${this.url}question/${id}`)
  }

  count(): Observable<number> {
    return this.httpClient.get<number>(`${this.url}count`);
  }

  modifyCours(id:number, cours: Cours):Observable<Object>{
    return this.httpClient.put(`${this.url}edit/${id}`, cours);
  }
  deleteCours(id:number):Observable<Cours>{
    return this.httpClient.delete<Cours>(`${this.url}delete/${id}`)
  }

}
