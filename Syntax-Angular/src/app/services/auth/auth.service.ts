import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {Jwt} from "../../classes/Jwt/jwt";
import {Utilisateur} from "../../classes/Utilisateur/utilisateur";
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = "http://localhost:8081/api/auth/";
  private jwt = new JwtHelperService();
  constructor(private httpClient: HttpClient) { }

  login(loginRequest: any): Observable<Jwt>{
    return this.httpClient.post<Jwt>(this.url + 'authenticate', loginRequest).pipe(
      tap(response => {
        localStorage.setItem('token', response.token);   })    );
  };

  register(utilisateur: Utilisateur): Observable<Object>{
    return this.httpClient.post(this.url + 'register/utilisateur', utilisateur)
  };


  getToken() : string | null{
    return localStorage.getItem('token');
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    return token != null && !this.jwt.isTokenExpired(token);
  }
  getCurrentUserRole(): string | null {
    const token = this.getToken();
    if (token) {
      const decodedToken = this.jwt.decodeToken(token);
      return decodedToken.role;
    }
    return null;
  }

  getCurrentUserFirstName(): string | null {
    const token = this.getToken();
    if (token) {
      const decodedToken = this.jwt.decodeToken(token);
      return decodedToken.firstname;
    }
    return null;
  }
  getCurrentUserLastName(): string | null {
    const token = this.getToken();
    if (token) {
      const decodedToken = this.jwt.decodeToken(token);
      return decodedToken.lastname;
    }
    return null;
  }

  getCurrentUserEmail(): string | null {
    const token = this.getToken();
    if (token) {
      const decodedToken = this.jwt.decodeToken(token);
      return decodedToken.email;
    }
    return null;
  }

  getCurrentUserId(): number | null {
    const token = this.getToken();
    if (token) {
      const decodedToken = this.jwt.decodeToken(token);
      return decodedToken.id;
    }
    return null;
  }
}
