import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HomeComponent} from "./components/home/home.component";
import { SignInComponent } from './components/auth/sign-in/sign-in.component';
import { SignUpComponent } from './components/auth/sign-up/sign-up.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CoursListComponent } from './components/Cours/cours-list/cours-list.component';
import {CoursComponent} from "./components/Cours/cours/cours.component";
import {AuthInterceptor} from "./Interceptor/auth.interceptor";
import {AddCoursComponent} from "./components/Cours/add-cours/add-cours.component";
import { ModifyCoursComponent } from './components/Cours/modify-cours/modify-cours.component';
import { CoursDetailsComponent } from './components/Cours/cours-details/cours-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignInComponent,
    SignUpComponent,
    SignInComponent,
    SignUpComponent,
    CoursComponent,
    CoursListComponent,
    AddCoursComponent,
    ModifyCoursComponent,
    CoursDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
