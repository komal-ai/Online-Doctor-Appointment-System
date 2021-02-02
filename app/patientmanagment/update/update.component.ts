import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/patient.model';
import { NgForm } from '@angular/forms';
import { PatientService } from '../service/patient.service';

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


  
constructor( private  route:ActivatedRoute,
            private router:Router,private patientService:PatientService) { }

 ngOnInit(): void {

  let id=parseInt(this.route.snapshot.paramMap.get('id'));
    
 this.patientService.getPatientById(id).subscribe(
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

 save(){
   console.log(this.firstName);
   let patient=new Patient(this.id, this.firstName, this.lastName, this.email, this.password,this.dob, this.address, this.phone, this.gender );
   this.patientService.updatePatientDetails(patient).subscribe(
     data=>{console.log("updated successfully");
     this.msg="Your data updated successfully"},
     err=>{console.log("error")}
   );

 }

  previousPage(){
    this.router.navigate(["user"]);
  }

  onSubmit(){
  this.save();
}

}
