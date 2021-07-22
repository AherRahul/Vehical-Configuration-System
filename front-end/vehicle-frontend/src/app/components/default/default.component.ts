import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Configuration } from 'src/app/models/configuration';
import { Variant } from 'src/app/models/variant';
import { ConfigurationService } from 'src/app/services/configuration.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { VariantService } from 'src/app/services/variant.service';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.css']
})
export class DefaultComponent implements OnInit {

  constructor(private _variantService: VariantService,
    private _configurationService: ConfigurationService,
    private _invoiceService: InvoiceService,
    private _router: Router) { }

  var_id : number = 0;
  configurations : Configuration[] = [];
  defaultConfigurations : Configuration[] = [];  
  interiorConfigurations : Configuration[] = [];
  exteriorConfigurations : Configuration[] = [];
  accessoriesConfigurations : Configuration[] = [];
  variant : Variant = new Variant(0,'',0,0,0,0,'');

  ngOnInit(): void {

    this._invoiceService.setSelectedMapToNew();
    this.var_id = this._variantService.getVariantId();
    console.log(this.var_id);

    this._configurationService.getAllDefaultFeatures(this.var_id).subscribe((data)=>{
        this.defaultConfigurations =data;
        console.log(this.defaultConfigurations);
      }
    );
    this._configurationService.getAllInteriorFeatures(this.var_id).subscribe((data)=>{
        this.interiorConfigurations=data;
        console.log(this.interiorConfigurations);
    });
    this._configurationService.getAllExteriorFeatures(this.var_id).subscribe((data)=>{
        this.exteriorConfigurations=data;
        console.log(this.exteriorConfigurations);
    });
    this._configurationService.getAllAccessoriesFeatures(this.var_id).subscribe((data)=>{
        this.accessoriesConfigurations=data;
        console.log(this.accessoriesConfigurations);
    });
    
    this._variantService.getVariantByVarid(this.var_id).subscribe((data) => {
        this.variant = data;
        console.log(this.variant);
        this._invoiceService.setInvoicePrice(this.variant.base_price);
    });

  }

  listConfigurationsByVarid(){
    this._configurationService.getAllConfigurationsByVarid(this.var_id).subscribe(
      (data) =>{
        this.configurations = data;
        console.log(this.configurations.length);
      }
    );
  }

}
