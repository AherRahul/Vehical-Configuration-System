import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private _customerService : CustomerService, private _router : Router) { }

  loginid : string = '';
  password : string = '';
  loginalert : string = '';
  validatepassword : boolean = false;

  ngOnInit(): void {
  }

  onSubmit(){
    this._customerService.checkCredetials(this.loginid,this.password).subscribe(
      (data) =>{
        console.log(data);
        if (data != "0")
        {
          this._customerService.emitEvent(true);
          this._customerService.setLoginFlag(true);
          this._customerService.setCompanyId(parseInt(data));
          this._router.navigate(['/home']);
        }
        else
        {
          this._customerService.emitEvent(false);
          this._customerService.setCompanyId(0);
          this.loginalert = "please enter correct username or password";
          this.validatepassword = true;
        }

      }
    )

  }

}
