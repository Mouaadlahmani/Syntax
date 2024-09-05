import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {SignInComponent} from "./components/auth/sign-in/sign-in.component";
import {SignUpComponent} from "./components/auth/sign-up/sign-up.component";
import {CoursComponent} from "./components/Cours/cours/cours.component";
import {CoursListComponent} from "./components/Cours/cours-list/cours-list.component";



const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'sign-in', component:SignInComponent},
  {path:'sign-up', component:SignUpComponent},
  {path:'courses',
  component:CoursComponent,
    children:[
      {path:'', component:CoursListComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
