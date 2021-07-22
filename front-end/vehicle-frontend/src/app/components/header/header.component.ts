import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loggedInFlag : any = false;

  constructor(private _customerService : CustomerService) { }

  ngOnInit(): void {
    this._customerService.loggedInID.subscribe((data) => 
    {
      console.log(data);
      this.loggedInFlag = data
    });
  }

  onLogout(){
    this._customerService.emitEvent(false);
    this._customerService.setCompanyId(0);
    this._customerService.setLoginFlag(false);
  }

}
