import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastraPagamentoComponent } from './cadastra-pagamento.component';

describe('CadastraPagamentoComponent', () => {
  let component: CadastraPagamentoComponent;
  let fixture: ComponentFixture<CadastraPagamentoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastraPagamentoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastraPagamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
