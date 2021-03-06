import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CargoDetailsComponent } from './cargo-details.component';

describe('CargoDetailsComponent', () => {
  let component: CargoDetailsComponent;
  let fixture: ComponentFixture<CargoDetailsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CargoDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CargoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
