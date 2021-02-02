import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PatientService } from '../service/patient.service';

@Component({
  selector: 'papp-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  back:string="../../assets/images/Hospital.png";
  
  
  constructor(
    private  route:ActivatedRoute,
    private patientService:PatientService) { }

  ngOnInit(): void {
  
   

    // this.patientService.getPatientById(id).subscribe(
    //   data=>{console.log("patient data successfully arrived");
    //         this.msg='Welcome '+data.firstName;},
    //   err=>{console.log("error")});

}
}