import { Component, OnInit } from '@angular/core';
import { Jogador } from '../../servico/jogador/jogador';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { JogadorService } from '../../servico/jogador/jogador.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { constanteRotas } from '../../configuracao';

@Component({
  selector: 'app-cadastro-jogador',
  templateUrl: './cadastro-jogador.component.html',
  styleUrls: ['./cadastro-jogador.component.scss']
})
export class CadastroJogadorComponent implements OnInit {

  public minDate = new Date(2000, 0, 1);
  public maxDate = new Date(2050, 0, 1);
  public jogador = new Jogador();
  public formGroup: FormGroup;
  public id: number;

  public listaPosicoes = [
    'Goleiro',
    'Zagueiro',
    'Lateral',
    'Meio campo',
    'Volante',
    'Atacante'
  ];

  constructor(   
    private formBuilder: FormBuilder,
    private jogadorService: JogadorService,
    private activatedRoute: ActivatedRoute) {
      this.activatedRoute.params.subscribe(params => {
        this.id = params[constanteRotas.parametroId];
        if (this.id != null) {
          this.jogadorService.obtem(this.id).subscribe(jogadorRetornado => {
            this.jogador = jogadorRetornado;
          }, erro => {
            console.log(erro);
          });
        }
      });
     }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      nomeJogador: [null, Validators.required],
      numeroJogador: [null, Validators.required],
      posicaoJogador: [null, Validators.required],
      salarioJogador: [null, Validators.required],
    });
  }


  compareObjects(posicao1: string, posicao2: string): boolean {
    if (posicao1 && posicao2) {
      return posicao1 === posicao2;
    }
  }

  atualizaPosicao(posicao: string) {
    this.jogador.posicao = posicao;
  }

  salva() {
    if (this.jogador.id) {
      this.jogadorService.atualiza(this.jogador).subscribe(jogador => {
        this.jogador = jogador;
      }, (erro: HttpErrorResponse) => {
        console.log(erro);
      });
    } else {
      this.jogadorService.cria(this.jogador).subscribe(jogador => {
        this.jogador = jogador;
      }, (erro: HttpErrorResponse) => {
        console.log(erro);
      });
    }

  }

}
