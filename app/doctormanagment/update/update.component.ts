import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/doctor.model';
import { NgForm } from '@angular/forms';
import { DoctorService } from '../service/doctor.service';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})




export class UpdateComponent implements OnInit {
  id:any;
  msg:any;
   public firstName:string;
   public lastName:string;
   public email:string;
   public password:string;
   public dob:Date;
   public address:string;
   public phone:string;
   public gender:string;
   public flag:any;
  
    
  constructor( private  route:ActivatedRoute,
              private router:Router, private doctorService:DoctorService) { }
  
   ngOnInit(): void {
  
    let id=parseInt(this.route.snapshot.paramMap.get('id'));
      
   this.doctorService.getDoctorById(id).subscribe(
     data=>{console.log("getting doctor data");
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
     this.flag=data.flag;
           },
     err=>{console.log("error")}
     );
    }
  
   save(){
     console.log(this.firstName);
     let doctor=new Doctor(this.id, this.firstName, this.lastName, this.email, this.password,this.dob, this.address, this.phone, this.gender,this.flag );
     this.doctorService.updateDoctorDetails(doctor).subscribe(
       data=>{console.log("updated successfully");
       this.msg="Your data updated successfully"},
       err=>{console.log("error")}
     );
  
   }
  
    previousPage(){
      this.router.navigate(["doctor"]);
    }
  
    onSubmit(){
    this.save();
  }
  
  }
