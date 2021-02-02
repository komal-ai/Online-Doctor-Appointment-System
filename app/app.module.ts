import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import {RegistrationService} from './membership/registration.service';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component'
import {MembershipModule} from './membership/membership.module'
import { AdminmanagmentModule } from './adminmanagment/adminmanagment.module';
import { PatientmanagmentModule } from './patientmanagment/patientmanagment.module';
import { DoctormanagmentModule } from './doctormanagment/doctormanagment.module';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginsuccessComponent
  ],
  imports: [
            BrowserModule,
            FormsModule,
            AppRoutingModule,
            HttpClientModule,
            MembershipModule,
            AdminmanagmentModule,
            PatientmanagmentModule,
            DoctormanagmentModule,
            BsDatepickerModule.forRoot()
         

  ],
  providers: [RegistrationService],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
