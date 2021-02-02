import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from 'src/app/doctor.model';
import { DoctorAvailability } from 'src/app/model/doctoravailability.model';
import { Patient } from 'src/app/patient.model';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

   private baseUrl = 'http://localhost:8080';   
  constructor(private httpclient:HttpClient) { }


  getPatientById(id:any):Observable<any>{
    
     return this.httpclient.get<any>( "http://localhost:8080/patients/"+id);
  }

  // updatePatientDetails(patient:Patient){
  //      return this.httpclient.post<Patient>("http://localhost:8080/patients");
  // }
  public  updatePatientDetails(patient:Patient):Observable<any>
  {
    return this.httpclient.post<any>("http://localhost:8080/patients",patient);
  }

  public getDoctorsBySpecialization( specialization:any ):Observable<any>{
    return this.httpclient.get<any>("http://localhost:8080/doctors/"+specialization);
  
    }

    public getSlotDetails(id:any){
      return this.httpclient.get<DoctorAvailability>("http://localhost:8080/slot/"+id);
    }

    public addApointmentDetails(appointment:any){
      return this.httpclient.post<any>("http://localhost:8080/app",appointment);
    }
   
    public changeFlag(id:any){
      return this.httpclient.get<any>("http://localhost:8080/slot/flag/"+id);
    }

    public getAllDatesByDoctorId(id:any){
      return this.httpclient.get<any>("http://localhost:8080/slot/dates/"+id);
    }
          
    public availableTimeListOnDate(date:any){
         return this.httpclient.post<any>("http://localhost:8080/slot",date);
    }


    //get all appointmentlist by patientId : view-booking component
    public getAllAppointmentList(patientId:any){
      return this.httpclient.get<any>("http://localhost:8080/app/user/"+patientId);
    
    }

    //cancel appointment
    public cancelAppointment(appointmentId:any){
      return this.httpclient.get<any>("http://localhost:8080/app/cancel/"+appointmentId);
    
    }

}
