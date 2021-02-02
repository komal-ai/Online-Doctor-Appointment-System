import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from '../service/patient.service';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {
  appointmentId:any;
  patientId:any;
  appointmentList:any=[];
  flag=false;
  errmsg="";
  msg="";
  availabilityId:any;

  constructor(private patientService: PatientService, private  route:ActivatedRoute) { }


  ngOnInit(): void {
  
    var user=JSON.parse(localStorage.getItem("userr"));
    this.patientId=user.patientId;
   
    console.log(this.patientId);

    this.patientService.getAllAppointmentList(this.patientId).subscribe(
      data=>{console.log(" data arrived ");
      this.appointmentList=data;
 
       },
      err=>{console.log(" error ")}
    )
  }


  check(){
    this.flag =false;
    for(let app of this.appointmentList){
      if(this.appointmentId==app.appointmentId){
        console.log(app.appointmentId);
        this.flag =true;
       
        this.errmsg="";
         console.log("present");
         
    this.patientService.cancelAppointment(this.appointmentId).subscribe(
      data=>{console.log(" cancel successfully");
         this.msg="Your Appointment has been cancelled Successfully ... ";
        this.appointmentId=""},
      err=>{console.log(" error")}
      );
      }
      console.log(app.appointmentId);
      if( this.flag==false){
        console.log("wrong appoitnment id");
        this.errmsg="Incorrect Appointment Id ,Plz Enter Correct One"
      }
      
    }
  }








}
