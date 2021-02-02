import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/patient.model';
import { PatientService } from '../service/patient.service';


@Component({
  selector: 'app-patient-deatail',
  templateUrl: './patient-deatail.component.html',
  styleUrls: ['./patient-deatail.component.css']
})
export class PatientDeatailComponent implements OnInit {
 
public id:any;
 public firstName:string;
 public lastName:string;
 public email:string;
 public password:string;
 public dob:Date;
 public address:string;
 public phone:string;
 public gender:string;


 
 constructor(private router:Router,private patientService:PatientService) { }

  ngOnInit(): void {
    var user=JSON.parse(localStorage.getItem("userr"));
    this.id=user.patientId;
    // this.firstName=user.firstName;
    // this.lastName=user.lastName;
    // this.email=user.email;
    // console.log(this.email+"  "+this.id);
    // this.dob=user.dob;
    // this.address=user.address;
    // this.phone=user.phone;
    // this.gender=user.gender;
    
    this.patientService.getPatientById(this.id).subscribe(
      data=>{console.log("getting patient data");
      this.id=data.patientId;
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
    console.log("update clicked in patient"+id);
    //go to update component
    this.router.navigate(["update",id]);
  }

}
