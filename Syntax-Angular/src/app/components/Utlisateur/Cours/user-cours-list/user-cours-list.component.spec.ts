import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCoursListComponent } from './user-cours-list.component';

describe('UserCoursListComponent', () => {
  let component: UserCoursListComponent;
  let fixture: ComponentFixture<UserCoursListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserCoursListComponent]
    });
    fixture = TestBed.createComponent(UserCoursListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
