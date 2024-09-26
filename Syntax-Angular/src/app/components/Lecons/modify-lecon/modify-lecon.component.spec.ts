import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyLeconComponent } from './modify-lecon.component';

describe('ModifyLeconComponent', () => {
  let component: ModifyLeconComponent;
  let fixture: ComponentFixture<ModifyLeconComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifyLeconComponent]
    });
    fixture = TestBed.createComponent(ModifyLeconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
