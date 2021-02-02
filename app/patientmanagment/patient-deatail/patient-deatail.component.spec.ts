import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientDeatailComponent } from './patient-deatail.component';

describe('PatientDeatailComponent', () => {
  let component: PatientDeatailComponent;
  let fixture: ComponentFixture<PatientDeatailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientDeatailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientDeatailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
