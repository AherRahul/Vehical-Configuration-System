import { TestBed } from '@angular/core/testing';

import { AlternateService } from './alternate.service';

describe('AlternateService', () => {
  let service: AlternateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlternateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
