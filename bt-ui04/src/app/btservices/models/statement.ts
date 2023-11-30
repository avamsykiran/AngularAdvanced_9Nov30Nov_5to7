import { Account } from "./account";
import { Txn } from "./txn";

export interface Statement {
    account:Account;
	startDate:string;
	endDate:string;
	txns:Txn[];
	totalCredit:number;
	totalDebit:number;
	statementBalance:number;
}
