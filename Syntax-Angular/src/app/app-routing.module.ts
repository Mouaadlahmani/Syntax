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
import {DashbordComponent} from "./components/Dashbord/dashbord/dashbord.component";
import {UserCoursListComponent} from "./components/Utlisateur/Cours/user-cours-list/user-cours-list.component";
import {UserCoursComponent} from "./components/Utlisateur/Cours/user-cours/user-cours.component";
import {UserCoursDetailsComponent} from "./components/Utlisateur/Cours/user-cours-details/user-cours-details.component";
import {LeconDetailsComponent} from "./components/Lecons/lecon-details/lecon-details.component";
import {ModifyQuestionComponent} from "./components/Question/modify-question/modify-question.component";
import {GenerateCertificatComponent} from "./components/Utlisateur/Certificat/generate-certificat/generate-certificat.component";
import {MyCertificatesComponent} from "./components/Utlisateur/Certificat/my-certificates/my-certificates.component";
import {DisplayQuizComponent} from "./components/Utlisateur/Quiz/display-quiz/display-quiz.component";
import {UserQuizComponent} from "./components/Utlisateur/Quiz/user-quiz/user-quiz.component";
import {StartQuizComponent} from "./components/Utlisateur/Quiz/start-quiz/start-quiz.component";
import {QuizComponent} from "./components/Quiz/quiz/quiz.component";
import {QuizListComponent} from "./components/Quiz/quiz-list/quiz-list.component";
import {QuizDetailsComponent} from "./components/Quiz/quiz-details/quiz-details.component";
import {DisplayUsersComponent} from "./components/Users/display-users/display-users.component";
import {UsersComponent} from "./components/Users/users/users.component";
import {CoursQuestionsComponent} from "./components/Question/cours-questions/cours-questions.component";
import {UtilisateurInfoComponent} from "./components/Utlisateur/utilisateur-info/utilisateur-info.component";
import {authGuardGuard} from "./Guard/auth.guard";
import {AdminDashbordComponent} from "./components/admin-dashbord/admin-dashbord.component";
import {UserHomeComponent} from "./components/Utlisateur/user-home/user-home.component";



const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'dashbord', component:AdminDashbordComponent, canActivate:[authGuardGuard]},
  {path:'sign-in', component:SignInComponent},
  {path:'sign-up', component:SignUpComponent},
  {path:'courses',
  component:CoursComponent,
    children:[
      {path:'', component:CoursListComponent, canActivate:[authGuardGuard]},
      {path:'add', component:AddCoursComponent, canActivate:[authGuardGuard]},
      {path:'modify/:id', component:ModifyCoursComponent, canActivate:[authGuardGuard]},
      {path:'cours/:id', component:CoursDetailsComponent, canActivate:[authGuardGuard]},
    ]
  },
  {path:'lecons',
    component:LeconsComponent,
    children:[
      {path:'modify/:id', component:ModifyLeconComponent, canActivate:[authGuardGuard]},
      {path:'add/:id', component:AddLeconComponent, canActivate:[authGuardGuard]},
    ]
  },
  {path:'contenu',
    component:LeconsComponent,
    children:[
      {path:'modify/:id', component:ModifyContenuComponent, canActivate:[authGuardGuard]},
      {path:'add/:id', component:AddContenuComponent, canActivate:[authGuardGuard]},
      {path:':id', component:LeconDetailsComponent, canActivate:[authGuardGuard]},
    ]
  },
  {path:'question',
    component:LeconsComponent,
    children:[
      {path:'all', component:CoursQuestionsComponent, canActivate:[authGuardGuard]},
        {path:':id', component:DispalyQuestionsComponent, canActivate:[authGuardGuard]},
      {path:'add/:id', component:AddQuestionComponent, canActivate:[authGuardGuard]},
      {path:'modify/:id', component:ModifyQuestionComponent, canActivate:[authGuardGuard]},
    ]
  },
  {path:'quiz',
    component:QuizComponent,
    children:[
      {path:'add', component:AddQuizComponent, canActivate:[authGuardGuard]},
      {path:'', component: QuizListComponent, canActivate:[authGuardGuard]},
      {path:':id', component: QuizDetailsComponent, canActivate:[authGuardGuard]}
    ]
  },
  {path:'utilisateurs',
    component:UsersComponent,
    children:[
      {path:'', component:DisplayUsersComponent, canActivate:[authGuardGuard]},
    ]
  },
  {
    path: 'syntax',
    component: UserCoursComponent,
    children: [
      {path: 'home', component: UserHomeComponent},
      { path: 'courses', component: UserCoursListComponent, canActivate:[authGuardGuard]},
      { path: 'courses/cours/:id', component: UserCoursDetailsComponent, canActivate:[authGuardGuard]},
      { path: 'lecon/:id/:leconId', component: UserCoursDetailsComponent, canActivate:[authGuardGuard]},
      { path: 'quiz', component: DisplayQuizComponent, canActivate:[authGuardGuard]},
      { path: 'quiz/:id', component: StartQuizComponent, canActivate:[authGuardGuard]},
      { path: 'lecon/:id/:leconId', component: UserCoursDetailsComponent, canActivate:[authGuardGuard]},
      {path:'my-certificates', component:MyCertificatesComponent, canActivate:[authGuardGuard]},
    ]
  }
,
  {path:'certificat/:userId/:coursId', component:GenerateCertificatComponent, canActivate:[authGuardGuard]},
  {path:'settings/:id', component:UtilisateurInfoComponent, canActivate:[authGuardGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
