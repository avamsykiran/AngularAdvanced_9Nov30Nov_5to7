import { Injectable } from '@angular/core';
import { BTUser } from './models/btuser';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment.development';
import { Observable,map } from 'rxjs';
import { AccountHolder } from './models/account-holder';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  currentUser:BTUser|undefined;

  notifyUserChange:BehaviorSubject<BTUser|undefined>;

  api:string;

  constructor(private http:HttpClient,private jwtHelper:JwtHelperService) {
    this.api=environment.apiBaseUrl;
    
    let userData = localStorage.getItem("udt");

    if(userData){
      this.currentUser = JSON.parse(userData);
    }else{
      this.currentUser=undefined;
    }
  
    this.notifyUserChange=new BehaviorSubject<BTUser|undefined>(this.currentUser);
   }

   autenticate(userName:string,password:string) :Observable<boolean> {
    return this.http.post<any>(this.api+"authenticate",{userName,password}).pipe(
      map( data => {
        let isLoggedIn=true;

        if(!data){
          isLoggedIn=false;
          this.currentUser=undefined;
        }else{
          let decodedToken = this.jwtHelper.decodeToken(data.token);
          let role = decodedToken["role"];
          this.currentUser={userName:userName,role:role,token:data.token};
          localStorage.setItem("udt",JSON.stringify(this.currentUser));
        }
        this.notifyUserChange.next(this.currentUser);
        return isLoggedIn;
      })
    );
   }

   isLoggedIn():boolean{
    return this.currentUser!=null && this.currentUser!=undefined;
   }

   logOut():void{
    this.currentUser=undefined;
    localStorage.clear();
    this.notifyUserChange.next(undefined);
   }

   getUserName():string|undefined{
    return this.currentUser?.userName;    
   }

   getRole():string|undefined{
    return this.currentUser?.role;
   }

   getToken():string|undefined{
    return this.currentUser?.token;
   }

   register(accountHolder:AccountHolder) : Observable<AccountHolder>{
    return this.http.post<AccountHolder>(this.api+"register",accountHolder);
   }
}
