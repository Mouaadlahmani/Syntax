import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Cours} from "../../classes/Cours/cours";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CoursService {

  private url = "http://localhost:8080/api/cours/";

  constructor(private httpClient: HttpClient) { }

  addCours(cours: Cours):Observable<Object>{
    return this.httpClient.post(this.url + 'add', cours);
  }

  getCourses():Observable<Cours[]>{
    return this.httpClient.get<Cours[]>(this.url+'all');
  }


}
