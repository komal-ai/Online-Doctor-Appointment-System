import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from '../service/doctor.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

 


public doctorId:any;
public appointmentList:any=[];



    
constructor( private  route:ActivatedRoute,
  private router:Router, private doctorService:DoctorService) { }
ngOnInit(): void {

  var doctor=JSON.parse(localStorage.getItem("doctor"));
  this.doctorId=doctor.doctorId;
 
  console.log(this.doctorId);

  this.doctorService.getPatientAppointmentList(this.doctorId).subscribe(
    data=>{console.log(" data arrived ");
    this.appointmentList=data; },
    err=>{console.log(" error ")}
  )

}

}
