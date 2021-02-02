export class Doctor{
    public doctorId:any;
    public   firstName:string; 
    public  lastName:string;
    public  email:string;
	  public password:string;
    public  dob:Date;
    public  address:string;
	  public phone:string;
    public  gender:string;
    public  flag:boolean;
    //  constructor(){}
  
   
    public constructor(id:any,firstName:string, lastName:string,email:string,password:string, dob:Date,address:string,phone:string,gender:string,flag:boolean){
        this.doctorId=id; 
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.dob=dob;
        this.address=address;
        this.phone=phone;
        this.gender=gender;
        this.flag=flag;    }


	//private double fees;
} 