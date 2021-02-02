import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { NgForm } from '@angular/forms';
import {RegistrationService} from '../registration.service'
import {User} from '../user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  back:string="../../assets/images/Hospital.png";
 public user = new User();
 public value:any;  
 flag:any;
 msg:any;
 v:boolean=false;
  
 // constructor(private  route:ActivatedRoute) { }

  constructor(private registerService: RegistrationService,
    private  route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    let id=parseInt(this.route.snapshot.paramMap.get('id'));
    this.value=id;
    if(this.value==3)
    this.flag=false;
    else
     this.flag=true;
  }

loginUser()
 {   
    console.log(this.user.email+"  "+this.value);
    console.log(this.user.password);
    if(this.value==2){
             this.registerService.loginDoctor(this.user).subscribe(
             data=>{console.log("successful");
                   localStorage.setItem("doctor",JSON.stringify(data));
                   this.router.navigate(['/doctor']); },
             error => {console.log("exception occured");
                     this.msg="Please Enter the correct credentials";
             })
    }

    if(this.value==1){
              this.registerService.loginPatient(this.user).subscribe(
              data=>{console.log("successful");
                    localStorage.setItem("userr",JSON.stringify(data));
                    console.log(data.patientId+"  patient id");
                    this.router.navigate(['user'])},
              error => {console.log("exception occured");
                     this.msg="Please Enter the correct credentials";            
                })
      }

    if(this.value==3){
             this.registerService.loginAdmin(this.user).subscribe(
             data=>{console.log("successful");
                    this.router.navigate(['reqlist'])   },
             error => {console.log("exception occured");
                    this.msg="Please Enter the correct credentials";            
               })
      
       }

  }
}
