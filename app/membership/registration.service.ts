import { Injectable } from '@angular/core'; 
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import {Doctor} from '../doctor.model'
import {Patient} from '../patient.model';
import {User} from "./user.model";
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

   //baseUrl:'localhost:8080'
  constructor(private httpclient:HttpClient) { }
  
  public loginDoctor(doctor:User):Observable<any>
  {
    return this.httpclient.post<any>("http://localhost:8080/doctors/login",doctor);
  }
 
  public loginPatient(patient:User):Observable<any>
  {
    return this.httpclient.post<any>("http://localhost:8080/patients/login",patient);
  }

  public loginAdmin(admin:User):Observable<any>
  {
    return this.httpclient.post<any>("http://localhost:8080/admin/login",admin);
  }

  public registerDoctor(doctor:User):Observable<any>
  {
    return this.httpclient.post<any>("http://localhost:8080/doctors",doctor);
  }

  public registerPatient(patient:User):Observable<any>
  {
    return this.httpclient.post<any>("http://localhost:8080/patients",patient);
  }

}
