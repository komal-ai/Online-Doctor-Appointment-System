export class Patient{
   public patientId:any;
   public firstName:string;
   public lastName:string;
   public email:string;
   public password:string;
   public dob:Date;
   public address:string;
   public phone:string;
   public gender:string;
    //constructor(){}


    public constructor(patientId:any,firstName:string, lastName:string,email:string,password:string, dob:Date,address:string,phone:string,gender:string){
      this.patientId=patientId; 
      this.firstName=firstName;
      this.lastName=lastName;
      this.email=email;
      this.password=password;
      this.dob=dob;
      this.address=address;
      this.phone=phone;
      this.gender=gender;
         }


}