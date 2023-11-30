import { Account } from "./account";

export interface Txn {
    txnId:number; 
    type:string;
    txnDate:string;
    amount:number;
	header:string;
    account:Account;
}
