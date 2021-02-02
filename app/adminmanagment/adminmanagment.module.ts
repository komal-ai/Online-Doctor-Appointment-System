import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { DeleteComponent } from './delete/delete.component';
import { DoctorrequestComponent } from './doctorrequest/doctorrequest.component';
import { DoctorlistComponent } from './doctorlist/doctorlist.component';
import { PatientlistComponent } from './patientlist/patientlist.component';
import { RouterModule, Routes } from '@angular/router';
import { LogoutComponent } from './logout/logout.component';
import { SupervisorHubService } from './supervisor-hub.service';



const routes :Routes=
[
  
{path:'reqlist',component:DoctorrequestComponent},
 {path:'doctorlist',component:DoctorlistComponent},
 {path:'patientlist',component:PatientlistComponent},
 {path:'logout',component:LogoutComponent}

]

@NgModule({
  declarations: [HeaderComponent, DeleteComponent,
                DoctorrequestComponent, DoctorlistComponent,
                 PatientlistComponent,
                 LogoutComponent],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
   
  ],
  providers: [SupervisorHubService],
  exports:[HeaderComponent, DeleteComponent,
           DoctorrequestComponent, DoctorlistComponent,
           PatientlistComponent,LogoutComponent],
  
})
export class AdminmanagmentModule { }
