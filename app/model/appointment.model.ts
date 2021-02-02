import { Doctor } from "../doctor.model";
import { Patient } from "../patient.model";

export class Appointment{
    

	public  startTime:any;
	public endTime:any;
    public appointmentDate:any;
	public   appointmentStatus:any ;
    public feedback:any;
	public patient:Patient;
    public doctor:Doctor;
   
    public constructor(startTime:any,endTime:any,appointmentDate:any){
     this.startTime=startTime;
     this.endTime=endTime;
     this.appointmentDate=appointmentDate;
     this.doctor.doctorId="1";
     this.patient.patientId="3";

 }
     
}