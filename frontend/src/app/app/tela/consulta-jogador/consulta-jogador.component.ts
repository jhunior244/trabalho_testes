import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatSidenav } from '@angular/material';
import { IJogador, Jogador } from '../../servico/jogador/jogador';
import { IPagina } from '../../servico/pagina/pagina';
import { JogadorService } from '../../servico/jogador/jogador.service';
import { Router } from '@angular/router';
import { constanteRotas } from '../../configuracao';

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
    private jogadorService: JogadorService,
    private router: Router
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
  }

  atualizaNumero($event) {
    this.numero = $event.target.value;
  }

  listaJogadores() {

    this.jogadorService.lista(this.nome, this.numero, this.page.pageNumber, this.page.size).subscribe(paginaJogadores => {
        this.filtro.toggle();
        this.page.pageNumber = paginaJogadores.pageable.pageNumber;
        this.page.totalElements = paginaJogadores.totalElements;
        this.page.totalPages = paginaJogadores.totalPages;
        this.rows = paginaJogadores.content;
        console.log(this.rows);
      }, erro => {
        console.log(erro);
      });
  }

  setPage($event): void {
    this.jogadorService.lista(this.nome, this.numero, $event.offset, this.page.size)
      .subscribe(paginaJogadores => {
        this.page.pageNumber = paginaJogadores.pageable.pageNumber;
        this.page.totalElements = paginaJogadores.totalElements;
        this.page.totalPages = paginaJogadores.totalPages;
        this.rows = paginaJogadores.content;
      }, erro => {
        console.log(erro);
      });
  }

  aoCliqueGrid({selected}){
    this.router.navigate([constanteRotas.rotaEditaJogador + '/' + selected[0].id ]);
  }

  criaEvento(){
    this.router.navigate([constanteRotas.rotaEditaJogador]);
 }

}
