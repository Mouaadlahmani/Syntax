import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HomeComponent} from "./components/Home/home.component";
import { SignInComponent } from './components/auth/sign-in/sign-in.component';
import { SignUpComponent } from './components/auth/sign-up/sign-up.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CoursListComponent } from './components/Cours/cours-list/cours-list.component';
import {CoursComponent} from "./components/Cours/cours/cours.component";
import {AuthInterceptor} from "./Interceptor/auth.interceptor";
import {AddCoursComponent} from "./components/Cours/add-cours/add-cours.component";
import { ModifyCoursComponent } from './components/Cours/modify-cours/modify-cours.component';
import { CoursDetailsComponent } from './components/Cours/cours-details/cours-details.component';
import {ModifyLeconComponent} from "./components/Lecons/modify-lecon/modify-lecon.component";
import {LeconsComponent} from "./components/Lecons/lecons/lecons.component";
import {AddLeconComponent} from "./components/Lecons/add-lecon/add-lecon.component";
import { ContenuComponent } from './components/Contenu/contenu/contenu.component';
import { AddContenuComponent } from './components/Contenu/add-contenu/add-contenu.component';
import { ModifyContenuComponent } from './components/Contenu/modify-contenu/modify-contenu.component';
import { QuestionComponent } from './components/Question/question/question.component';
import { AddQuestionComponent } from './components/Question/add-question/add-question.component';
import { ModifyQuestionComponent } from './components/Question/modify-question/modify-question.component';
import { DispalyQuestionsComponent } from './components/Question/dispaly-questions/dispaly-questions.component';
import { QuizComponent } from './components/Quiz/quiz/quiz.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatCardModule} from "@angular/material/card";
import { DashbordComponent } from './components/Dashbord/dashbord/dashbord.component';
import { UserCoursListComponent } from './components/Utlisateur/Cours/user-cours-list/user-cours-list.component';
import { UserCoursComponent } from './components/Utlisateur/Cours/user-cours/user-cours.component';
import { UserCoursDetailsComponent } from './components/Utlisateur/Cours/user-cours-details/user-cours-details.component';
import { NavBarComponent } from './components/Nav-bar/nav-bar/nav-bar.component';
import { LeconDetailsComponent } from './components/Lecons/lecon-details/lecon-details.component';
import {AddQuizComponent} from "./components/Quiz/add-quiz/add-quiz.component";
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
    LeconsComponent,
    ModifyLeconComponent,
    AddLeconComponent,
    ContenuComponent,
    AddContenuComponent,
    ModifyContenuComponent,
    QuestionComponent,
    AddQuestionComponent,
    ModifyQuestionComponent,
    DispalyQuestionsComponent,
    QuizComponent,
    AddQuizComponent,
    DashbordComponent,
    UserCoursListComponent,
    UserCoursComponent,
    UserCoursDetailsComponent,
    NavBarComponent,
    LeconDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
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
