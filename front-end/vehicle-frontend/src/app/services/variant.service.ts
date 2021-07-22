import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Variant } from '../models/variant';

@Injectable({
  providedIn: 'root'
})
export class VariantService {

  public var_id : number = 0;

  constructor(private http : HttpClient) { }

  getAllVariantsBySegidAndManid(seg_id:number, man_id:number):Observable<Variant[]>{
    return this.http.get<Variant[]>("http://localhost:8080/api/v1/variants/"+seg_id+"/"+man_id);
  }

  setVariantId(varid : number){
    this.var_id = varid;
    console.log("Variant Service : "+this.var_id);
  }

  getVariantId() : number{
    return this.var_id;
  }

  getVariantByVarid(var_id : number) : Observable<Variant>{
    return this.http.get<Variant>("http://localhost:8080/api/v1/variants/"+var_id);
  }
}
