import { Component, OnInit } from '@angular/core';
import { AlternateConf } from 'src/app/models/alternate-conf';
import { Configuration } from 'src/app/models/configuration';
import { Customer } from 'src/app/models/customer';
import { ConfigurationService } from 'src/app/services/configuration.service';
import { CustomerService } from 'src/app/services/customer.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { VariantService } from 'src/app/services/variant.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  public allConfigurationsForVariant : Configuration[] = [];
  public selectedConfMap = new Map<string, AlternateConf>();
  public configured : string[] = [];
  public notConfigured : string[] = [];
  public finalPrice : number  = 0;
  public var_id : number = 0;
  public customer : Customer = new Customer(0,'','','','','','','','','','',0,'','','','','','','');
  constructor(private _invoiceService : InvoiceService,
    private _customerService : CustomerService,
    private _configurationService : ConfigurationService,
    private _variantService : VariantService) { }

  ngOnInit(): void {

    this.var_id = this._variantService.getVariantId();

    this.selectedConfMap = this._invoiceService.getSelectedConfMap();
    console.log(this.selectedConfMap);
    this.finalPrice = this._invoiceService.getInvoicePrice();

    this._customerService.getCustomerDetails().subscribe(
      (data)=>{
        this.customer = data;
        console.log(this.customer);
      }
    );

    this._configurationService.getAllConfigurationsByVarid(this.var_id).subscribe(
      (data) =>{
        this.allConfigurationsForVariant = data;
        console.log(this.allConfigurationsForVariant);
        this.sortAllFeatures();
      }
    );

    
    
  }

  sortAllFeatures(){

    this.allConfigurationsForVariant.forEach(element => {

      if (this.selectedConfMap.has(element.description))
      {
        let altDescription = this.selectedConfMap.get(element.description)?.alt_description;
        if (altDescription !== undefined)
          this.configured.push(altDescription);
      }
      else
      {
        this.notConfigured.push(element.description);
      }
      
    });

  }

}
