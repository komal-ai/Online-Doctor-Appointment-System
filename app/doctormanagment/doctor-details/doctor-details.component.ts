import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorService } from '../service/doctor.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {
 
  
 

public id:any;
 public firstName:string;
 public lastName:string;
 public email:string;
 public password:string;
 public dob:Date;
 public address:string;
 public phone:string;
 public gender:string;


 
 constructor(private router:Router,private doctorService:DoctorService) { }

  ngOnInit(): void {
    var doctor=JSON.parse(localStorage.getItem("doctor"));
    this.id=doctor.doctorId;
    
    
    this.doctorService.getDoctorById(this.id).subscribe(
      data=>{console.log("getting patient data");
      this.id=data.doctorId;
      this.firstName=data.firstName;
      this.lastName=data.lastName;
      this.email=data.email;
      console.log(this.email+"  "+this.id);
      this.password=data.password;
      this.dob=data.dob;
      this.address=data.address;
      this.phone=data.phone;
      this.gender=data.gender;
            },
      err=>{console.log("error")}
      );
     }
   
  updatedDetails(id:any){
    console.log("in  updatedDetails method "+id);
    //go to update component
   this.router.navigate(["updateDr",id]);
  }

}

