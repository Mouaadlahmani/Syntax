import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Question} from "../../classes/Question/question";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private url = 'http://localhost:8081/api/question/';

  constructor(private httpClient: HttpClient) { }

  addQuestion(id:number,question: Question):Observable<Object>{
    return this.httpClient.post(`${this.url}create/${id}`, question);
  }

  modifyQuestion(id:number, question: Question):Observable<Object>{
    return this.httpClient.put(`${this.url}edit/${id}`, question)
  }

  deleteQuestion(id:number): Observable<Question>{
    return this.httpClient.delete<Question>(`${this.url}delete/${id}`)
  }

  getAllQuestions():Observable<Question[]>{
    return this.httpClient.get<Question[]>(`${this.url}all`)
  }

  getQuestionById(id:number):Observable<Question>{
    return this.httpClient.get<Question>(`${this.url}${id}`)
  }

  getQuestionByCoursId(id:number):Observable<Question[]>{
    return this.httpClient.get<Question[]>(`${this.url}cours/${id}`)
  }


}
