import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Jwt} from "../../classes/Jwt/jwt";
import {Utilisateur} from "../../classes/Utilisateur/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = "http://localhost:8080/api/auth/";

  constructor(private httpClient: HttpClient) { }

  login(loginRequest: any): Observable<Jwt>{
    return this.httpClient.post<Jwt>(this.url + 'authenticate', loginRequest)
  };

  register(utilisateur: Utilisateur): Observable<Object>{
    return this.httpClient.post(this.url + 'register/utilisateur', utilisateur)
  };

  registerAdmin(registerRequest: any): Observable<Jwt>{
    return this.httpClient.post<Jwt>(this.url + 'register/admin', registerRequest)
  };
}
