import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroJogadorComponent } from './app/tela/cadastro-jogador/cadastro-jogador.component';
import { ConsultaJogadorComponent } from './app/tela/consulta-jogador/consulta-jogador.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list'; 
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule
} from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { JogadorService } from './app/servico/jogador/jogador.service';
import { HttpClientModule } from '@angular/common/http';
import { ConsultaPagamentoComponent } from './app/tela/consulta-pagamento/consulta-pagamento.component';
import { PagamentoService } from './app/servico/pagamento/pagamento.service';
import { CadastraPagamentoComponent } from './app/tela/cadastra-pagamento/cadastra-pagamento.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroJogadorComponent,
    ConsultaJogadorComponent,
    ConsultaPagamentoComponent,
    CadastraPagamentoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    NgxDatatableModule,
    MatInputModule,
    HttpClientModule,
    MatSelectModule,
    FlexLayoutModule,
    MatButtonModule
  ],
  providers: [JogadorService, PagamentoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
