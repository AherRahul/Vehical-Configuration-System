import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private _customerService : CustomerService, private _router : Router) { }

  registrationdata : Customer = new Customer(0,'','','','','','','','','','',0,'','','','','','','');
  submitted : boolean = false;
  confirmpassword : string = '';
  validatepassword : boolean = true;

  ngOnInit(): void {
  }

  onSubmit(frm:any){

    this.submitted = true;
    console.log(frm.valid);
    if (!frm.valid)
      return;
    console.log(this.registrationdata);
    this._router.navigate(['/login']);
    this._customerService.addCustomerDetails(this.registrationdata).subscribe(
      (data) =>{
        console.log(data);
        this._router.navigate(['/login']);
      }
    );

  }

  validate(){
    console.log(this.confirmpassword);
    if (this.registrationdata.password == this.confirmpassword)
      this.validatepassword = false;
    else 
      this.validatepassword = true;

  }

}
