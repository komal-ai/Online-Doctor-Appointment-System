import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorAvailability } from 'src/app/model/doctoravailability.model';
import { PatientService } from '../service/patient.service';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})

export class DoctorListComponent implements OnInit {
  slotdata:any;
  sdata:DoctorAvailability;
   @Input("doctors") public doctors:any;
  constructor(private router:Router,private patientService:PatientService) { }

  ngOnInit(): void {
    
  }

  getDoctorSlot(id:any){
   
   this.router.navigate(["slot",id]);
   }


    
  
}
