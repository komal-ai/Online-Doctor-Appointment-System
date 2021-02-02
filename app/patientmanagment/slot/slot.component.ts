
import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Appointment } from 'src/app/model/appointment.model';

import { PatientService } from '../service/patient.service';


@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {



  public enabledDates = []  ;
  public selectedDate:Date;
  public id:any;
  public timeList:any=[];
   public patientId:any;
   public doctorId:any;
   public flag=false;
   public flag1=true;
   public startTime:Time;
  public endTime:Time;
  public message='';
  public status=false;
  
// bsValue = new Date();
//   public sdata:any=[];
//  public slotdate:any;
// public nodata='';
// public appdate:Date;
// public spec:any;
 
// public flag=true;
// public message='';
// bsRangeValue: Date[];
// maxDate = new Date();
// minDate = new Date();
// public newVar:any;
// public time:any;
//  public dateOfBirth:Date;
//  publicvalue:any;
//  startTime:Time;
//  endTime:Time;


  constructor(private patientService: PatientService,
    private  route:ActivatedRoute
) { }




  ngOnInit(): void {
    var user=JSON.parse(localStorage.getItem("userr"));
    this.patientId=user.patientId;

    // this.minDate.setDate(this.minDate.getDate() + 1),
    // this.maxDate.setDate(this.maxDate.getDate() + 10),
    // this.bsRangeValue = [this.bsValue, this.maxDate]
    let id=parseInt(this.route.snapshot.paramMap.get('id'));
    this.doctorId=id;
   
    //show all enables Dates
   this.patientService.getAllDatesByDoctorId(id).subscribe(
    data=>{console.log("dates arrived");
    
    for(var d of data){
    console.log(d);
   this.enabledDates.push(new Date(d))}},
    err=>{console.log("dates err");}
   );

   


    //  console.log(id+"on click ");
    // this.patientService.getSlotDetails(id).subscribe(
    //   data=>{console.log("all data arrived");
    //       if(data==null){
    //          this.nodata='No time available now dr is bzy ';
         
    //         }
    //        this.sdata=data; 
    //        },
    //   err=>{console.log("error in getDoctorSlot");}
    // )
}



changeFlag(id:any){
this.patientService.changeFlag(id).subscribe(
  data=>{console.log("flag changed")},
  err=>{console.log("error flag change")}
)}


saveData(appointmentId:any){
  var appData={
    "pid":this.patientId,
    "flag":true,
    "appointmentId":appointmentId
  }
  localStorage.setItem("appData",JSON.stringify(appData));

}


onClick(){
  console.log("selected date"+this.selectedDate);
  this.selectedDate.setDate(this.selectedDate.getDate() + 1);
  console.log("selected date"+this.selectedDate);
  
  let date={
    "date":this.selectedDate,
    "doctorId":this.doctorId
   }
  
   this.patientService.availableTimeListOnDate(date).subscribe(
    data=>{console.log("OKKKKK");
    this.flag=true;
       this.timeList=data;
      for(var v of data){
     console.log(v.doctorAvailabilityId);
      }},
    err=>{console.log(" NOT OKKKKK")}
  )
}


onSubmit(){
  console.log("on submit method");
  console.log(this.selectedDate+" appointment  date");
  console.log(this.id+" doctot availability  id");

  for(var s of this.timeList){
        if(this.id==s.doctorAvailabilityId){
          this.startTime=s.startTime;
         this.endTime=s.endTime;
        }
      }
 console.log(this.startTime+" start time");
 console.log(this.endTime+" end time");


var app={
    
  "startTime": this.startTime,
  "endTime": this.endTime,
  "appointmentDate":this.selectedDate,
  "appointmentStatus": "CONFIRM",
  "feedback": "good",
  "patient": {
      "patientId": this.patientId
      
  },
  "doctor": {
      "doctorId": this.doctorId
  }
}

this.changeFlag(this.id);
this.patientService.addApointmentDetails(app).subscribe(
     data=>{console.log("successfull added app")  
    this.flag=false; 
     this.flag1=false;
    this.status=true;
   this.message=data.appointmentId;
   this.saveData(data.appointmentId);
  },
   err=>{console.log("error in appointment ")}
);

}




// onSubmit(){

//   console.log(this.appdate+" appointment  date");
//   console.log(this.time+" appointment time");
//   this.changeFlag(this.time);
//   for(var s of this.sdata){
//     if(this.time==s.doctorAvailabilityId){
//       this.startTime=s.startTime;
//      this.endTime=s.endTime;
//     }
//   }
//   console.log(this.startTime+" start time");
//   console.log(this.endTime+" end time");
  
//  //let appointment=new Appointment(this.startTime,this.endTime,this.appdate);
// //  appointment.doctor.doctorId=2;
// //  appointment.patient.patientId=2;
// //console.log(appointment.doctor.doctorId);


// var app={
    
//   "startTime": this.startTime,
//   "endTime": this.endTime,
//   "appointmentDate":this.appdate,
//   "appointmentStatus": "CONFIRM",
//   "feedback": "good",
//   "patient": {
//       "patientId": this.pid
      
//   },
//   "doctor": {
//       "doctorId": this.did
//   }
// }


//  this.patientService.addApointmentDetails(app).subscribe(
//   data=>{console.log("successfull added app")  
//   this.flag=false; 
//  this.message=data.appointmentId},
// err=>{console.log("error in appointment ")}

// )

// }

}








