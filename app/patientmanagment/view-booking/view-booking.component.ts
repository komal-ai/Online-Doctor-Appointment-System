import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from '../service/patient.service';

@Component({
  selector: 'app-view-booking',
  templateUrl: './view-booking.component.html',
  styleUrls: ['./view-booking.component.css']
})
export class ViewBookingComponent implements OnInit {
  public patientId:any;
  public appointmentList:any=[];

  constructor(private patientService: PatientService, private  route:ActivatedRoute) { }

  ngOnInit(): void {
  
    var user=JSON.parse(localStorage.getItem("userr"));
    this.patientId=user.patientId;
   
    console.log(this.patientId);

    this.patientService.getAllAppointmentList(this.patientId).subscribe(
      data=>{console.log(" data arrived ");
      this.appointmentList=data; },
      err=>{console.log(" error ")}
    )

  }

}
