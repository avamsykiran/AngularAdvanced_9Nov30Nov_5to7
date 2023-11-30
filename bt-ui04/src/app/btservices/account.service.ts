import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Account } from './models/account';
import { HttpClient } from '@angular/common/http';
import { Txn } from './models/txn';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  api:string;

  constructor(private http:HttpClient) {
    this.api=environment.apiBaseUrl + "accounts";
  }

  getAllAccounts():Observable<Account[]>{
    return this.http.get<Account[]>(this.api);
  }
  
  getAccount(accountNumber:number):Observable<Account>{
    return this.http.get<Account>(this.api + "/" + accountNumber);
  }

  getAllTxnsForAccount(accountNumber:number):Observable<Txn[]>{
    return this.http.get<Txn[]>(this.api + "/" + accountNumber + "/txns");
  }

  addAccount(account:Account):Observable<Account>{
    return this.http.post<Account>(this.api,account);
  }

  updateAccount(account:Account):Observable<Account>{
    return this.http.put<Account>(this.api,account);
  }


}
