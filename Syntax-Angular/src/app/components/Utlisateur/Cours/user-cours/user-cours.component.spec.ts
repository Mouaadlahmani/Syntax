import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCoursComponent } from './user-cours.component';

describe('UserCoursComponent', () => {
  let component: UserCoursComponent;
  let fixture: ComponentFixture<UserCoursComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserCoursComponent]
    });
    fixture = TestBed.createComponent(UserCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
