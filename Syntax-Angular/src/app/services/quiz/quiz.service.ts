import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Quiz} from "../../classes/Quiz/quiz";
import {Reponse} from "../../classes/Reponse/reponse";



@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private url = 'http://localhost:8081/api/quiz/';

  constructor(private http: HttpClient) {}

  addQuiz(category: string, numQ: number, title: string): Observable<Quiz> {
    const params = { category, numQ: numQ.toString(), title };
    return this.http.post<Quiz>(`${this.url}add`, {}, { params });
  }

  submitQuiz(id: number, responses: { id: number; response: string }[]): Observable<number> {
    return this.http.post<number>(`${this.url}submit/${id}`, responses);
  }

  getAllQuizzes(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${this.url}all`);
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.url}count`);
  }

  getQuizById(id: number): Observable<Quiz> {
    return this.http.get<Quiz>(`${this.url}num/${id}`);
  }
  //
  // getQuizWithQuestions(id: number): Observable<QuestionWrapper[]> {
  //   return this.http.get<QuestionWrapper[]>(`${this.url}${id}`);
  // }

  deleteQuiz(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}delete/${id}`);
  }

}
