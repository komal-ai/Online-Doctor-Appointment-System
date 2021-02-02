import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/patient.model';
import { SupervisorHubService } from '../supervisor-hub.service';

@Component({
  selector: 'app-patientlist',
  templateUrl: './patientlist.component.html',
  styleUrls: ['./patientlist.component.css']
})
export class PatientlistComponent implements OnInit {

  patients:Patient []=[];
  constructor(private adminservice:SupervisorHubService) { }


 
  ngOnInit(): void {
    this.adminservice.getAllPatientList().subscribe(
      data=>{this.patients=data;
        console.log("successful")},
      err=>{console.log(" error")}
      );
 
   }

}
