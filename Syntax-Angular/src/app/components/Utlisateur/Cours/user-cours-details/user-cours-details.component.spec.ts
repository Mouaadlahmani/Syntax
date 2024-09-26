import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCoursDetailsComponent } from './user-cours-details.component';

describe('UserCoursDetailsComponent', () => {
  let component: UserCoursDetailsComponent;
  let fixture: ComponentFixture<UserCoursDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserCoursDetailsComponent]
    });
    fixture = TestBed.createComponent(UserCoursDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
