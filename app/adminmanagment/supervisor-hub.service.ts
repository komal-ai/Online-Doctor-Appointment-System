import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import {Subject} from "rxjs";
import { Doctor } from '../doctor.model';
import { Patient } from '../patient.model';

@Injectable({
  providedIn: 'root'
})
export class SupervisorHubService {
  
  private baseUrl = 'http://localhost:8080';   
  constructor(private httpclient:HttpClient) { }
   
  // return all the doctors who are not approved to login  
  getDoctorRequestedList() {  
    return this.httpclient.get<Doctor[]>(this.baseUrl+"/doctors/list");  
  }  

  //return all the doctor which are approved to login
  getValidDoctorList(){
    return this.httpclient.get<Doctor[]>(this.baseUrl+"/doctors/doctorlist");  
  }

  getPatientList(){
    return this.httpclient.get<Patient []>(this.baseUrl+"/patients");  
  }

  //return all the doctors 
  getDoctorsList(){
    return this.httpclient.get<Doctor[]>(this.baseUrl+"/doctors");  
  }
  
 public approvedDoctor(doctor : Doctor):Observable<any>{
  return this.httpclient.post<any>(this.baseUrl+"/email/doctor",doctor);

  }

  //send mail approve doctor and return doctor list 
 public approvedDoctors(doctor : Doctor):Observable<Doctor[]>{
  var subject = new Subject<Doctor[]>();
   this.httpclient.post<any>(this.baseUrl+"/email/doctor",doctor).subscribe(
     data=>{console.log("DoctorAdded");
    

 this.httpclient.get<Doctor[]>(this.baseUrl+"/doctors/list").subscribe(
    data=>{console.log("DoctorAdded");
    subject.next(data);},
    err=>{console.log("exception occur in approved method");}
    );
    
      });
return subject.asObservable();  
}


getAllPatientList():Observable<Patient[]>{
  return this.httpclient.get<Patient []>(this.baseUrl+"/patients"); 
}






}