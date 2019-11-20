import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatSidenav } from '@angular/material';
import { IJogador, Jogador } from '../../servico/jogador/jogador';
import { IPagina } from '../../servico/pagina/pagina';
import { JogadorService } from '../../servico/jogador/jogador.service';

@Component({
  selector: 'app-consulta-jogador',
  templateUrl: './consulta-jogador.component.html',
  styleUrls: ['./consulta-jogador.component.scss']
})
export class ConsultaJogadorComponent implements OnInit {

  public formGroup: FormGroup;

  public nome: string;
  public numero: number;

  rows = [];

  selected = [];

  page = {} as IPagina<IJogador, Jogador>;

  @ViewChild('filtro', { static: true }) filtro: MatSidenav;

  constructor(
    private formBuilder: FormBuilder,
    private jogadorService: JogadorService
  ) {
    this.page.offset = 0;
    this.page.size = 10;
    this.page.pageNumber = 0;
    this.page.totalElements = 0;
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      nome: [null],
      numero: [null]
    });
  }

  atualizaNome($event) {
    this.nome = $event.target.value;
    console.log(this.nome);
  }

  atualizaNumero($event) {
    this.numero = $event.target.value;
  }

  listaJogadores() {

    this.jogadorService.lista(this.page.pageNumber, this.page.size).subscribe(paginaEventoBack => {
        this.filtro.toggle();
        this.page.pageNumber = paginaEventoBack.pageable.pageNumber;
        this.page.totalElements = paginaEventoBack.totalElements;
        this.page.totalPages = paginaEventoBack.totalPages;
        this.rows = paginaEventoBack.content;
      }, erro => {
        console.log(erro);
      });
  }

  setPage($event): void {
    this.jogadorService.lista($event.offset, this.page.size)
      .subscribe(paginaEventoBack => {
        this.page.pageNumber = paginaEventoBack.pageable.pageNumber;
        this.page.totalElements = paginaEventoBack.totalElements;
        this.page.totalPages = paginaEventoBack.totalPages;
        this.rows = paginaEventoBack.content;
      }, erro => {
        console.log(erro);
      });
  }

}
