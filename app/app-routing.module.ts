import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component'
import { LoginComponent} from './membership/login/login.component'
import { RegisterComponent} from './membership/register/register.component'
import {LoginsuccessComponent} from './loginsuccess/loginsuccess.component'
import { DoctorrequestComponent } from './adminmanagment/doctorrequest/doctorrequest.component';
import { DoctorlistComponent } from './adminmanagment/doctorlist/doctorlist.component';
import { PatientlistComponent } from './adminmanagment/patientlist/patientlist.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path:'home' , component:HomeComponent},
  {path:'login/:id' , component:LoginComponent},
  {path:'register/:id' , component:RegisterComponent},
   {path:'loginsuccess' , component:LoginsuccessComponent},
     

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
