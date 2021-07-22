import { Component, OnInit } from '@angular/core';
import { AlternateConf } from 'src/app/models/alternate-conf';
import { Configuration } from 'src/app/models/configuration';
import { Variant } from 'src/app/models/variant';
import { AlternateService } from 'src/app/services/alternate.service';
import { ConfigurationService } from 'src/app/services/configuration.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { VariantService } from 'src/app/services/variant.service';

@Component({
  selector: 'app-interior',
  templateUrl: './interior.component.html',
  styleUrls: ['./interior.component.css']
})
export class InteriorComponent implements OnInit {

  constructor(private _alternateService : AlternateService,
    private _configurationService : ConfigurationService,
    private _variantService : VariantService,
    private _invoiceService : InvoiceService) { }

  public interiorConfigurations : Configuration[] = [];
  public configurableInteriorConfigurations : Configuration[] = [];
  public variant : Variant = new Variant(0,'',0,0,0,0,'');  
  public var_id : number = 0;
  public altMap = new Map<string,AlternateConf[]>();
  public currentPrice : number = 0;

  ngOnInit(): void {

    this.var_id = this._variantService.getVariantId();

    this._configurationService.getAllInteriorFeatures(this.var_id).subscribe((data)=>{
      this.interiorConfigurations =data;
      console.log(this.interiorConfigurations);
    }
  );

    this._variantService.getVariantByVarid(this.var_id).subscribe((data) => {
      this.variant = data;
      console.log(this.variant);
  });

    this._configurationService.getAllConfigurableInteriorFeatures(this.var_id).subscribe((data)=>{
      this.configurableInteriorConfigurations = data;
      console.log(this.configurableInteriorConfigurations);
      if (this.configurableInteriorConfigurations.length > 0)
          this.getAllAlternateConfigurations();
    });
  }

  getAllAlternateConfigurations(){
    this.configurableInteriorConfigurations.forEach(element => {
      console.log(element.conf_id);
      this._alternateService.getAlternateConfByConfid(element.conf_id).subscribe(
        (data)=>{
          this.altMap.set(element.description,data);
        }
      );   
    });
}

  managePrice(event : any, configure : string){

    let eventValue = ""+event.target.value;
    let basePrice = this.variant.base_price;
    let invoicePrice = this._invoiceService.getInvoicePrice();
    this.currentPrice = invoicePrice > basePrice ? invoicePrice : basePrice;
    let altId=0;
    console.log("managePrice : eventValue => "+eventValue+" currentPrice => "+this.currentPrice);
    let altPrice = this._invoiceService.getAlternateSelectedConf(configure)?.alt_price;
    if (altPrice !== undefined)
      this.currentPrice = this.currentPrice - altPrice;
    if (!eventValue.includes("DEFAULT"))
      {
        altId = event.target.value;
        this.altMap.get(configure)?.forEach(
          element => {
            if (element.alt_id == altId)
            {
              console.log("managePrice : NOT DEFAULT : "+element.alt_price);
              this._invoiceService.addAlternateSelectedConf(configure,element);
            }
          }
        );
      }
    else
      {
        console.log("managePrice : DEFAULT");
        this._invoiceService.addAlternateSelectedConf(configure,new AlternateConf(0,configure,0,0));
      }
    altPrice = this._invoiceService.getAlternateSelectedConf(configure)?.alt_price;
    if (altPrice !== undefined)
      this.currentPrice = this.currentPrice + altPrice;
    this._invoiceService.setInvoicePrice(this.currentPrice);  

  }
}
