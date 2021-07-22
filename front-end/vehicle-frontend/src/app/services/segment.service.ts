import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Segment } from '../models/segment';

@Injectable({
  providedIn: 'root'
})
export class SegmentService {

  constructor(private http : HttpClient) { }

  getAllSegments():Observable<Segment[]>{
    return this.http.get<Segment[]>("http://localhost:8080/api/v1/segments");
  }

}
