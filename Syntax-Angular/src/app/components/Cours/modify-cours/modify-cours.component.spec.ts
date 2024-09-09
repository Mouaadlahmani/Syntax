import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyCoursComponent } from './modify-cours.component';

describe('ModifyCoursComponent', () => {
  let component: ModifyCoursComponent;
  let fixture: ComponentFixture<ModifyCoursComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifyCoursComponent]
    });
    fixture = TestBed.createComponent(ModifyCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
