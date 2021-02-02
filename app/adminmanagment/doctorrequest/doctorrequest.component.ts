import { Component, OnInit } from '@angular/core';

import { Doctor } from '../../doctor.model'
import { SupervisorHubService } from '../supervisor-hub.service';
@Component({
  selector: 'app-doctorrequest',
  templateUrl: './doctorrequest.component.html',
  styleUrls: ['./doctorrequest.component.css']
})
export class DoctorrequestComponent implements OnInit {

  doctors:Doctor []=[];
  darr:Doctor []=[];
  parr:Doctor []=[];
  msg='';
  

  constructor(private adminservice:SupervisorHubService) { }

  ngOnInit(): void {

    this.adminservice.getDoctorRequestedList().subscribe(
      data=>{this.doctors=data;
        console.log("successful")},
      err=>{console.log(" error")}
      );

      // this.adminservice.getDoctorsList().subscribe(
      //   data=>{
      //     this.darr=data;
      //     console.log(this.darr.length);
      //     for(var v of this.darr){
      //       if(v.flag==true)
      //       this.drarr.push(v);
      //     }
      //     },
      //   err=>{console.log(" error")}
      //   );

       


  }

//   approvedUser(d:Doctor){

//     console.log(d.flag);
//     console.log(d.doctorId);
//     let obj=new Doctor(d.doctorId,d.firstName,d.lastName,d.email,d.password,d.dob,d.address,d.phone,d.gender,d.flag);
//     this.adminservice.approvedDoctor(obj).subscribe(
//     data=>{
//       console.log("successful");
//        },
//     err=>{console.log(" error")}
//     );
  
//  }



approvedUser(d:Doctor){
  this.msg="approved sucessfully";
  console.log(d.flag);
  console.log(d.doctorId);
  let obj=new Doctor(d.doctorId,d.firstName,d.lastName,d.email,d.password,d.dob,d.address,d.phone,d.gender,d.flag);
  this.adminservice.approvedDoctors(obj).subscribe(
  data=>{
    console.log("successful xxxx");
    this.doctors=[];
    this.doctors=data;
     
  
  //     this.darr=data;
  //     this.parr=[];
  //     this.doctors=[];
  //     console.log("previous length"+this.darr.length);
  //     for(var v of this.darr){
  //     if(v.flag==false)
  //     this.parr.push(v);
  //       }
  //     this.doctors=this.parr;
  //     console.log("after"+this.parr.length);
      
     },
  err=>{console.log(" error")}
  );

}




    }
