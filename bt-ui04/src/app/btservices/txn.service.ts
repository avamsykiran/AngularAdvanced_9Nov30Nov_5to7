import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Txn } from './models/txn';

@Injectable({
  providedIn: 'root'
})
export class TxnService {

  api:string;

  constructor(private http:HttpClient) {
    this.api=environment.apiBaseUrl+"txns";
  }

  getById(txnId:number):Observable<Txn>{
    return this.http.get<Txn>(this.api + "/" + txnId)
  }

  deleteById(txnId:number):Observable<void>{
    return this.http.delete<void>(this.api + "/" + txnId)
  }

  addTxn(txn:Txn):Observable<Txn>{
    return this.http.post<Txn>(this.api,txn);
  }

  updateTxn(txn:Txn):Observable<Txn>{
    return this.http.put<Txn>(this.api,txn);
  }
}
