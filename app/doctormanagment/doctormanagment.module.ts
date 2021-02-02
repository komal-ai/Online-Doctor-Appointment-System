import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { LogoutComponent } from './logout/logout.component';
import { DoctorDetailsComponent } from './doctor-details/doctor-details.component';
import { RouterModule, Routes } from '@angular/router';
import { FeedbackComponent } from './feedback/feedback.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { UpdateComponent } from './update/update.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';


const routes :Routes=
[ 
  {path:"doctor",component:DoctorDetailsComponent},
   {path:"updateDr/:id",component:UpdateComponent},
  // {path:"book",component:BookAppointmentComponent},
  // {path:"cancel",component:CancelBookingComponent},
   {path:"viewappointment",component:PatientListComponent},
  {path:"drfeedback",component:FeedbackComponent},
  {path:"doctorlogout",component:LogoutComponent}

]


@NgModule({
  declarations: [HeaderComponent, LogoutComponent, DoctorDetailsComponent,FeedbackComponent, PatientListComponent, UpdateComponent],
  imports: [
    CommonModule,
    FormsModule,
    BrowserAnimationsModule,
    BsDatepickerModule.forRoot(),
    RouterModule.forRoot(routes)
   ],
  exports:[HeaderComponent, LogoutComponent, DoctorDetailsComponent,FeedbackComponent,UpdateComponent,PatientListComponent]
})
export class DoctormanagmentModule { }
