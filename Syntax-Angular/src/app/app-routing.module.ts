import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/Home/home.component";
import {SignInComponent} from "./components/auth/sign-in/sign-in.component";
import {SignUpComponent} from "./components/auth/sign-up/sign-up.component";
import {CoursComponent} from "./components/Cours/cours/cours.component";
import {CoursListComponent} from "./components/Cours/cours-list/cours-list.component";
import {AddCoursComponent} from "./components/Cours/add-cours/add-cours.component";
import {ModifyCoursComponent} from "./components/Cours/modify-cours/modify-cours.component";
import {CoursDetailsComponent} from "./components/Cours/cours-details/cours-details.component";
import {ModifyLeconComponent} from "./components/Lecons/modify-lecon/modify-lecon.component";
import {LeconsComponent} from "./components/Lecons/lecons/lecons.component";
import {AddLeconComponent} from "./components/Lecons/add-lecon/add-lecon.component";
import {ModifyContenuComponent} from "./components/Contenu/modify-contenu/modify-contenu.component";
import {AddContenuComponent} from "./components/Contenu/add-contenu/add-contenu.component";
import {DispalyQuestionsComponent} from "./components/Question/dispaly-questions/dispaly-questions.component";
import {AddQuestionComponent} from "./components/Question/add-question/add-question.component";
import {AddQuizComponent} from "./components/Quiz/add-quiz/add-quiz.component";
import {UserCoursListComponent} from "./components/Utlisateur/Cours/user-cours-list/user-cours-list.component";
import {UserCoursComponent} from "./components/Utlisateur/Cours/user-cours/user-cours.component";
import {UserCoursDetailsComponent} from "./components/Utlisateur/Cours/user-cours-details/user-cours-details.component";
import {LeconDetailsComponent} from "./components/Lecons/lecon-details/lecon-details.component";
import {ModifyQuestionComponent} from "./components/Question/modify-question/modify-question.component";
import {GenerateCertificatComponent} from "./components/Utlisateur/Certificat/generate-certificat/generate-certificat.component";
import {MyCertificatesComponent} from "./components/Utlisateur/Certificat/my-certificates/my-certificates.component";
import {DisplayQuizComponent} from "./components/Utlisateur/Quiz/display-quiz/display-quiz.component";
import {StartQuizComponent} from "./components/Utlisateur/Quiz/start-quiz/start-quiz.component";
import {QuizComponent} from "./components/Quiz/quiz/quiz.component";
import {QuizListComponent} from "./components/Quiz/quiz-list/quiz-list.component";
import {QuizDetailsComponent} from "./components/Quiz/quiz-details/quiz-details.component";
import {DisplayUsersComponent} from "./components/Users/display-users/display-users.component";
import {UsersComponent} from "./components/Users/users/users.component";
import {CoursQuestionsComponent} from "./components/Question/cours-questions/cours-questions.component";
import {AdminDashbordComponent} from "./components/admin-dashbord/admin-dashbord.component";
import {UserHomeComponent} from "./components/Utlisateur/user-home/user-home.component";
import {ForbiddenComponent} from "./components/forbidden/forbidden.component";
import {authGuardGuard} from "./Guard/auth.guard";



const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'dashbord', component:AdminDashbordComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
  {path:'sign-in', component:SignInComponent},
  {path:'sign-up', component:SignUpComponent},
  {path:'courses',
  component:CoursComponent,
    children:[
      {path:'', component:CoursListComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'add', component:AddCoursComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'modify/:id', component:ModifyCoursComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'cours/:id', component:CoursDetailsComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
    ]
  },
  {path:'lecons',
    component:LeconsComponent,
    children:[
      {path:'modify/:id', component:ModifyLeconComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'add/:id', component:AddLeconComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
    ]
  },
  {path:'contenu',
    component:LeconsComponent,
    children:[
      {path:'modify/:id', component:ModifyContenuComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'add/:id', component:AddContenuComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:':id', component:LeconDetailsComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
    ]
  },
  {path:'question',
    component:LeconsComponent,
    children:[
      {path:'all', component:CoursQuestionsComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
        {path:':id', component:DispalyQuestionsComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'add/:id', component:AddQuestionComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'modify/:id', component:ModifyQuestionComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
    ]
  },
  {path:'quiz',
    component:QuizComponent,
    children:[
      {path:'add', component:AddQuizComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:'', component: QuizListComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
      {path:':id', component: QuizDetailsComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}}
    ]
  },
  {path:'utilisateurs',
    component:UsersComponent,
    canActivate:[authGuardGuard],data:{role:'ADMIN'},
    children:[
      {path:'', component:DisplayUsersComponent, canActivate:[authGuardGuard],data:{role:'ADMIN'}},
    ]
  },
  {
    path: 'syntax',
    component: UserCoursComponent,
    canActivate:[authGuardGuard],
    data:{role:'UTILISATEUR'},
    children: [
      {path: 'home', component: UserHomeComponent,data:{role:'UTILISATEUR'}},
      { path: 'courses', component: UserCoursListComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
      { path: 'courses/cours/:id', component: UserCoursDetailsComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
      { path: 'lecon/:id/:leconId', component: UserCoursDetailsComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
      { path: 'quiz', component: DisplayQuizComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
      { path: 'lecon/:id/:leconId', component: UserCoursDetailsComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
      {path:'my-certificates', component:MyCertificatesComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
    ]
  },
  { path: 'syntax/quiz/:id', component: StartQuizComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
  {path:'certificat/:userId/:coursId', component:GenerateCertificatComponent, canActivate:[authGuardGuard],data:{role:'UTILISATEUR'}},
  {path:'unauthorized', component:ForbiddenComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
