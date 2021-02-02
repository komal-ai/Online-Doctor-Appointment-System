import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from 'src/app/doctor.model';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  
  private baseUrl = 'http://localhost:8080/doctors';   
  constructor(private httpclient:HttpClient) { }


  getDoctorById(doctorId:any):Observable<any>{
       return this.httpclient.get<any>( "http://localhost:8080/doctors/id/"+doctorId);
  }


  
    public  updateDoctorDetails(doctor:Doctor):Observable<any>
    {
      return this.httpclient.post<any>("http://localhost:8080/doctors",doctor);
    }

    public getPatientAppointmentList(doctorId:any){
      return this.httpclient.get<any>("http://localhost:8080/app/patientlist/"+doctorId);
    
    }



  
}
