import { Injectable } from '@angular/core';
import { AlternateConf } from '../models/alternate-conf';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  public selectedConfigurationMap = new Map<string, AlternateConf>();
  public invoicePrice : number = 0;

  constructor() { }

  addAlternateSelectedConf(description :string, altConf : AlternateConf){
    this.selectedConfigurationMap.set(description,altConf);
    console.log(this.selectedConfigurationMap);
  }

  getAlternateSelectedConf(description : string) : AlternateConf | undefined{
    return this.selectedConfigurationMap.get(description);
  }

  getInvoicePrice() : number{
    return this.invoicePrice;
  }

  setInvoicePrice(price : number){
    this.invoicePrice = price;
  }

  setSelectedMapToNew(){
    this.selectedConfigurationMap = new Map<string, AlternateConf>();
  }

  getSelectedConfMap() : Map<string, AlternateConf>{
    return this.selectedConfigurationMap;
  }

}
