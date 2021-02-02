import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Doctor } from 'src/app/doctor.model';
import { PatientService } from '../service/patient.service';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements OnInit {
 public spec:any;

 public doctors:Doctor[];
 public msg:any;
 public flag=false;
  constructor(private patientService:PatientService) { }

  ngOnInit(): void {
  }


  loginUser(){
    if(this.spec==undefined){
      this.msg=' * plz select specialization to search ';
    }else{
      this.msg=''
    this.flag=true;
    this.patientService.getDoctorsBySpecialization(this.spec).subscribe(
     data=>{ console.log("successfully data arrived");
                  this.doctors=data},
     err=>{console.log("sry error")}
   )
    }
  }

}
