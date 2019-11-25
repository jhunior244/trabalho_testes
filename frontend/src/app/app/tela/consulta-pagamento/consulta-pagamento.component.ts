import { Component, OnInit, ViewChild } from '@angular/core';
import { IPagamento, Pagamento } from '../../servico/pagamento/pagamento';
import { PagamentoService } from '../../servico/pagamento/pagamento.service';
import { constanteRotas } from '../../configuracao';
import { FormGroup, FormBuilder } from '@angular/forms';
import { IPagina } from '../../servico/pagina/pagina';
import { MatSidenav } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-consulta-pagamento',
  templateUrl: './consulta-pagamento.component.html',
  styleUrls: ['./consulta-pagamento.component.scss']
})
export class ConsultaPagamentoComponent implements OnInit {

  public formGroup: FormGroup;

  public mes: number;
  public ano: number;

  rows = [];

  selected = [];

  page = {} as IPagina<IPagamento, Pagamento>;

  @ViewChild('filtro', { static: true }) filtro: MatSidenav;

  constructor(
    private formBuilder: FormBuilder,
    private pagamentoService: PagamentoService,
    private router: Router
  ) {
    this.page.offset = 0;
    this.page.size = 10;
    this.page.pageNumber = 0;
    this.page.totalElements = 0;
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      mes: [null],
      ano: [null]
    });

  }
  atualizaMes($event) {
    this.mes = $event.target.value;
  }

  atualizaAno($event) {
    this.ano = $event.target.value;
  }

  listaPagamento() {

    this.pagamentoService.lista(this.mes, this.ano, this.page.pageNumber, this.page.size).subscribe(paginaSalario => {
        this.filtro.toggle();
        this.page.pageNumber = paginaSalario.pageable.pageNumber;
        this.page.totalElements = paginaSalario.totalElements;
        this.page.totalPages = paginaSalario.totalPages;
        this.rows = paginaSalario.content;
        console.log(this.rows);
      }, erro => {
        console.log(erro);
      });
  }

  setPage($event): void {
    this.pagamentoService.lista(this.mes, this.ano, $event.offset, this.page.size)
      .subscribe(paginaSalario => {
        this.page.pageNumber = paginaSalario.pageable.pageNumber;
        this.page.totalElements = paginaSalario.totalElements;
        this.page.totalPages = paginaSalario.totalPages;
        this.rows = paginaSalario.content;
      
      }, erro => {
        console.log(erro);
      });
  }

  criaPagamento(){
    this.router.navigate([constanteRotas.rotaCadastraPagamento]);
 }

}
