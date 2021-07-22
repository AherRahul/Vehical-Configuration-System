import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Manufacturer } from '../models/manufacturer';

@Injectable({
  providedIn: 'root'
})
export class ManufacturerService {

  constructor(private http : HttpClient) { }

  getAllManufacturers():Observable<Manufacturer[]>{
    return this.http.get<Manufacturer[]>("http://localhost:8080/api/v1/manufacturers");
  }
}
