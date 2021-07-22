import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  public companyId : number =0;
  public loginFlag : boolean = false;
  public loggedInID = new Subject();

  constructor(private http : HttpClient) { }

  addCustomerDetails(register : Customer) : Observable<Customer[]>{
    return this.http.post<Customer[]>("http://localhost:8080/api/v1/register",register);
  }

  checkCredetials(loginid : string, password : string) : Observable<string>{
    return this.http.get<string>("http://localhost:8080/api/v1/check/"+loginid+"/"+password);
  }

  getCustomerDetails() : Observable<Customer>{
    return this.http.get<Customer>("http://localhost:8080/api/v1/customer/"+this.companyId); 
  }

  setCompanyId(companyid : number){
    this.companyId=companyid;
  }

  getCompanyId():number{
    return this.companyId;
  }

  setLoginFlag(flag : boolean){
    this.loginFlag = flag;
  }

  getLoginFlag() : boolean{
    return this.loginFlag;
  }

  emitEvent(flag : boolean){
    this.loggedInID.next(flag);
  }


}
