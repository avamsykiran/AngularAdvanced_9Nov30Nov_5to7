import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/btservices/authentication.service';
import { AccountHolder } from 'src/app/btservices/models/account-holder';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  userName:string;
  password:string;
  confirmPassword:string;
  fullName:string;
	mobileNumber:string;
	mailId:string;

  errMsg!:string;
  isReqInProgress!:boolean;

  constructor(private authenticationService:AuthenticationService,private router:Router){
    this.userName="";
    this.password="";
    this.confirmPassword="";
    this.fullName="";
    this.mobileNumber="";
    this.mailId="";
  }

  formSubmitted(){
    if(this.password===this.confirmPassword){
      let accountHolder:AccountHolder = {
        userName:this.userName,
        password:this.password,
        fullName:this.fullName,
        mobileNumber:this.mobileNumber,
        mailId:this.mailId
      };
      this.isReqInProgress=true;
      this.authenticationService.register(accountHolder).subscribe({
        next: data => {
          this.router.navigateByUrl("");
          this.isReqInProgress=false;
        } ,
        error: err => {
          console.log(err);
          this.errMsg="Unable to register the user! Please retry later!";
          this.isReqInProgress=false;
        }
      });
    }else{
      this.errMsg="Passwords Confirmation Mismatch";
    }
  }
}
