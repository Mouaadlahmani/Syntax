import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursQuestionsComponent } from './cours-questions.component';

describe('CoursQuestionsComponent', () => {
  let component: CoursQuestionsComponent;
  let fixture: ComponentFixture<CoursQuestionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CoursQuestionsComponent]
    });
    fixture = TestBed.createComponent(CoursQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
