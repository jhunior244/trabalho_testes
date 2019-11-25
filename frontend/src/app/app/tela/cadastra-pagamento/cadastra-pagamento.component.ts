import { Component, OnInit } from '@angular/core';
import { Jogador } from '../../servico/jogador/jogador';
import { PagamentoService } from '../../servico/pagamento/pagamento.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { JogadorService } from '../../servico/jogador/jogador.service';
import { Pagamento } from '../../servico/pagamento/pagamento';

@Component({
  selector: 'app-cadastra-pagamento',
  templateUrl: './cadastra-pagamento.component.html',
  styleUrls: ['./cadastra-pagamento.component.scss']
})
export class CadastraPagamentoComponent implements OnInit {

  public jogador = new Jogador();
  public pagamento = new Pagamento();
  public formGroup: FormGroup;
  public data: string;
  public $listaJogador: Observable<Jogador[]>;

  constructor(
    private formBuilder: FormBuilder,
    private jogadorService: JogadorService,
    private pagamentoService: PagamentoService
  ) {
    this.$listaJogador = this.jogadorService.listaTodos();
   }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      jogador: [null, Validators.required],
      data: [null, Validators.required]
    });
  }

  compareObjects(jogador: Jogador, jogadorSelect: Jogador): boolean {
    if (jogador && jogadorSelect) {
      return jogador.id === jogadorSelect.id;
    }
  }

  atualizaJogador(jogador: Jogador) {
    this.jogador = jogador;
  }

  salva() {
    this.pagamentoService.cria(this.jogador.id, this.data).subscribe(pagamento => {
      console.log(pagamento);
      this.pagamento = pagamento;
      this.data = this.pagamento.dataPagamento.toISOString();
    });
  }

}
