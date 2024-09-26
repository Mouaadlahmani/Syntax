import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DispalyQuestionsComponent } from './dispaly-questions.component';

describe('DispalyQuestionsComponent', () => {
  let component: DispalyQuestionsComponent;
  let fixture: ComponentFixture<DispalyQuestionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DispalyQuestionsComponent]
    });
    fixture = TestBed.createComponent(DispalyQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
