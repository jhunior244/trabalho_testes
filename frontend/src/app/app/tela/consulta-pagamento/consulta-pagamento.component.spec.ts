import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaPagamentoComponent } from './consulta-pagamento.component';

describe('ConsultaPagamentoComponent', () => {
  let component: ConsultaPagamentoComponent;
  let fixture: ComponentFixture<ConsultaPagamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaPagamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaPagamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
