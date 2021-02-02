import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { NgForm } from '@angular/forms';
import {RegistrationService} from '../registration.service'
import {User} from '../user.model';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  back:string="../../assets/images/Hospital.png";
  value:any;
  msg:any;
 
  user=new User();
  
   constructor(private registerService: RegistrationService,
    private  route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    let id=parseInt(this.route.snapshot.paramMap.get('id'));
    this.value=id;
  }


  registerUser():any{
  console.log(this.user.email+"  "+this.value);
  console.log(this.user.password);
  

  if(this.value==1){
    this.registerService.registerPatient(this.user).subscribe(
    data=>{console.log("successful");
    this.router.navigate(['/login/1']);
       },
    error => {console.log("exception occured");
            this.msg="plz enter the correct data";            
  })
    }

  if(this.value==2){
  this.registerService.registerDoctor(this.user).subscribe(
  data=>{console.log("successful");
  this.router.navigate(['/login/2'])
 // this.router.navigate(['/loginsuccess'])
    },
  error => {console.log("exception occured");
             this.msg="plz enter the correct data";}
   )
  }

     if(this.value==3){
      this.registerService.loginAdmin(this.user).subscribe(
     data=>{console.log("successful");
           this.router.navigate(['/loginsuccess']) 
      },
      error => console.log("exception occured")
      )
    
      }

}
}


