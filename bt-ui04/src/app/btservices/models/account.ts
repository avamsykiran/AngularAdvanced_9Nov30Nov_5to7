import { AccountHolder } from "./account-holder";

export interface Account {
    accountNumber:number;
	currentBalance:number;
	accountHolder:AccountHolder;
}
