import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { constanteRotas } from './app/configuracao';
import { CadastroJogadorComponent } from './app/tela/cadastro-jogador/cadastro-jogador.component';
import { ConsultaJogadorComponent } from './app/tela/consulta-jogador/consulta-jogador.component';
import { ConsultaPagamentoComponent } from './app/tela/consulta-pagamento/consulta-pagamento.component';
import { CadastraPagamentoComponent } from './app/tela/cadastra-pagamento/cadastra-pagamento.component';


const routes: Routes = [
  {path: constanteRotas.rotaConsultaJogador, component: ConsultaJogadorComponent },
  {path: constanteRotas.rotaEditaJogador, component: CadastroJogadorComponent },
  {path: constanteRotas.rotaEditaJogador + '/:' + constanteRotas.parametroId, component: CadastroJogadorComponent },

  {path: constanteRotas.rotaConsultaPagamento, component: ConsultaPagamentoComponent },
  {path: constanteRotas.rotaCadastraPagamento, component: CadastraPagamentoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
