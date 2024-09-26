import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeconDetailsComponent } from './lecon-details.component';

describe('LeconDetailsComponent', () => {
  let component: LeconDetailsComponent;
  let fixture: ComponentFixture<LeconDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeconDetailsComponent]
    });
    fixture = TestBed.createComponent(LeconDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
