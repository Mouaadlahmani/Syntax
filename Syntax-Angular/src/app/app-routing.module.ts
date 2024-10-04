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
import {GenerateCertificatComponent} from "./components/Certificat/generate-certificat/generate-certificat.component";
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



const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'dashbord', component:DashbordComponent},
  {path:'sign-in', component:SignInComponent},
  {path:'sign-up', component:SignUpComponent},
  {path:'courses',
  component:CoursComponent,
    children:[
      {path:'', component:CoursListComponent},
      {path:'add', component:AddCoursComponent},
      {path:'modify/:id', component:ModifyCoursComponent},
      {path:'cours/:id', component:CoursDetailsComponent},
    ]
  },
  {path:'lecons',
    component:LeconsComponent,
    children:[
      {path:'modify/:id', component:ModifyLeconComponent},
      {path:'add/:id', component:AddLeconComponent},
    ]
  },
  {path:'contenu',
    component:LeconsComponent,
    children:[
      {path:'modify/:id', component:ModifyContenuComponent},
      {path:'add/:id', component:AddContenuComponent},
      {path:':id', component:LeconDetailsComponent},
    ]
  },
  {path:'question',
    component:LeconsComponent,
    children:[
      {path:'all', component:CoursQuestionsComponent},
        {path:':id', component:DispalyQuestionsComponent},
      {path:'add/:id', component:AddQuestionComponent},
      {path:'modify/:id', component:ModifyQuestionComponent},
    ]
  },
  {path:'quiz',
    component:QuizComponent,
    children:[
      {path:'add', component:AddQuizComponent},
      {path:'', component: QuizListComponent},
      {path:':id', component: QuizDetailsComponent}
    ]
  },
  {path:'utilisateurs',
    component:UsersComponent,
    children:[
      {path:'', component:DisplayUsersComponent},
    ]
  },
  {
    path: 'syntax/courses',
    component: UserCoursComponent,
    children: [
      { path: '', component: UserCoursListComponent },
      { path: 'cours/:id', component: UserCoursDetailsComponent },
      { path: 'lecon/:id/:leconId', component: UserCoursDetailsComponent },
    ]
  },{
    path: 'syntax/quiz',
    component: UserQuizComponent,
    children: [
      { path: '', component: DisplayQuizComponent },
      { path: ':id', component: StartQuizComponent },
      { path: 'lecon/:id/:leconId', component: UserCoursDetailsComponent },
    ]
  }
,
  {path:'certificat/:userId/:coursId', component:GenerateCertificatComponent},
  {path:'my-certificates', component:MyCertificatesComponent},
  {path:'settings/:id', component:UtilisateurInfoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
