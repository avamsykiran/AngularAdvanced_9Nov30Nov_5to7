import { BTUser } from "./btuser";

export interface AccountHolder extends BTUser {
    fullName:string;
	mobileNumber:string;
	mailId:string;
}
