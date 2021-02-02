import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { PatientDeatailComponent } from './patient-deatail/patient-deatail.component';
import { UpdateComponent } from './update/update.component';
import { LogoutComponent } from './logout/logout.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { ViewBookingComponent } from './view-booking/view-booking.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { RouterModule, Routes } from '@angular/router';
import { PatientService } from './service/patient.service';
import { FormsModule } from '@angular/forms';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { SlotComponent } from './slot/slot.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



const routes :Routes=
[ 
  {path:"user",component:PatientDeatailComponent},
  {path:"update/:id",component:UpdateComponent},
  {path:"book",component:BookAppointmentComponent},
  {path:"cancel",component:CancelBookingComponent},
  {path:"view",component:ViewBookingComponent},
  {path:"feedback",component:FeedbackComponent},
  {path:"patientlogout",component:LogoutComponent},
  {path:"slot/:id",component:SlotComponent}
]

@NgModule({
  declarations: [HeaderComponent, PatientDeatailComponent,
                UpdateComponent, LogoutComponent, BookAppointmentComponent, 
                ViewBookingComponent, CancelBookingComponent, FeedbackComponent, 
                DoctorListComponent, SlotComponent],
  imports: [
    CommonModule,
    FormsModule,
    BrowserAnimationsModule,
    BsDatepickerModule.forRoot(),
    RouterModule.forRoot(routes)
  ],
  providers:[ PatientService],
  exports:[HeaderComponent, PatientDeatailComponent, 
           UpdateComponent, LogoutComponent, BookAppointmentComponent,
            ViewBookingComponent, CancelBookingComponent, FeedbackComponent,
            DoctorListComponent,SlotComponent]
})
export class PatientmanagmentModule { }
