import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {SignInComponent} from "./components/auth/sign-in/sign-in.component";
import {SignUpComponent} from "./components/auth/sign-up/sign-up.component";
import {CoursComponent} from "./components/Cours/cours/cours.component";
import {CoursListComponent} from "./components/Cours/cours-list/cours-list.component";
import {AddCoursComponent} from "./components/Cours/add-cours/add-cours.component";
import {ModifyCoursComponent} from "./components/Cours/modify-cours/modify-cours.component";
import {CoursDetailsComponent} from "./components/Cours/cours-details/cours-details.component";



const routes: Routes = [
  {path:'', component:HomeComponent},
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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
