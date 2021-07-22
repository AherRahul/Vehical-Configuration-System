import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manufacturer } from 'src/app/models/manufacturer';
import { Segment } from 'src/app/models/segment';
import { Variant } from 'src/app/models/variant';
import { ManufacturerService } from 'src/app/services/manufacturer.service';
import { SegmentService } from 'src/app/services/segment.service';
import { VariantService } from 'src/app/services/variant.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public segments: Segment[] = [];
  public manufacturers: Manufacturer[] = [];
  public variants: Variant[] = [];

  private seg_id: number = 0;
  private man_id: number = 0;
  private var_id: number = 0;
  public min_qty: number = 0;
  public varFound: boolean = false;

  constructor(private _segmentService: SegmentService,
    private _manufacturerService: ManufacturerService,
    private _variantService: VariantService,
    private _router: Router) { }

  ngOnInit(): void {

    this.listSegments();
  }

  listSegments(){
    this._segmentService.getAllSegments().subscribe(
      (data) => this.segments = data
    );
  }

  listManufacturers(){
    this._manufacturerService.getAllManufacturers().subscribe(
      (data) => this.manufacturers = data
    );
  }

  listVariants(){
    this._variantService.getAllVariantsBySegidAndManid(this.seg_id,this.man_id).subscribe(
      (data) =>
      {
        this.variants = data
        console.log(this.variants.length);
        if (this.variants.length == 0)
            this.varFound = true;
        else
            this.varFound = false;    
      } 
    );
  }

  onChangeSegment(event:any){
    this.seg_id = event.target.value;
    console.log(this.seg_id);
    this.listManufacturers();
  }

  onChangeManufacturers(event:any){
    this.man_id = event.target.value;
    console.log(this.man_id);
    this.listVariants();
    
  }

  sendVarid(event:any, v:Variant[]){
    console.log(event.target.value);
    this.var_id = event.target.value;
    console.log(v);
    for (const variant of v) {
      console.log(variant);
      if (variant.var_id == this.var_id)
        this.min_qty = variant.min_qty;
      
    }
    this._variantService.setVariantId(this.var_id);
  }

  nextPage()
  {
    this._router.navigate(['/default']);
  }

}
