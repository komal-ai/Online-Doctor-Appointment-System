import { Doctor } from "../doctor.model";

export class DoctorAvailability{
    
	public doctor_availability_id:any; 
    public  day:any;
    public startTime:Date ;
    public endTime:Date ;
	public minutePerPatient:any;
	public doctor:Doctor;
     public constructor(){}
}