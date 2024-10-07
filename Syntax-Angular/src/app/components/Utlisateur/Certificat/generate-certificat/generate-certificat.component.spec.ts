import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateCertificatComponent } from './generate-certificat.component';

describe('GenerateCertificatComponent', () => {
  let component: GenerateCertificatComponent;
  let fixture: ComponentFixture<GenerateCertificatComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GenerateCertificatComponent]
    });
    fixture = TestBed.createComponent(GenerateCertificatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
