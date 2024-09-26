import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyContenuComponent } from './modify-contenu.component';

describe('ModifyContenuComponent', () => {
  let component: ModifyContenuComponent;
  let fixture: ComponentFixture<ModifyContenuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifyContenuComponent]
    });
    fixture = TestBed.createComponent(ModifyContenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
