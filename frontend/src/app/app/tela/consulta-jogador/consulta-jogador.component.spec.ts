import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaJogadorComponent } from './consulta-jogador.component';

describe('ConsultaJogadorComponent', () => {
  let component: ConsultaJogadorComponent;
  let fixture: ComponentFixture<ConsultaJogadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaJogadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaJogadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
