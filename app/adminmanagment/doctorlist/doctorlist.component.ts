import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/doctor.model';
import { SupervisorHubService } from '../supervisor-hub.service';

@Component({
  selector: 'app-doctorlist',
  templateUrl: './doctorlist.component.html',
  styleUrls: ['./doctorlist.component.css']
})
export class DoctorlistComponent implements OnInit {

  doctors:Doctor [];
  constructor(private adminservice:SupervisorHubService) { }


 
  ngOnInit(): void {

    this.adminservice.getValidDoctorList().subscribe(
      data=>{this.doctors=data;
        console.log("successful")},
      err=>{console.log(" error")}
      );
  }

}
