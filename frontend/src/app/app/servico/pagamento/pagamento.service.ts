import { Injectable } from "@angular/core";
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { Pagamento, IPagamento } from './pagamento';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { IPagina } from '../pagina/pagina';

@Injectable()
export class PagamentoService {

    url = 'http://localhost:8080' + '/pagamento' ;
    httpHeader = new HttpHeaders();
    constructor(
        private httpCliente: HttpClient) {
        this.httpHeader = this.httpHeader.append('Content-Type', 'application/json');
    }

    public obtem(id: number): Observable<Pagamento>{

        let httpParams = new HttpParams();

        if (id) {
            httpParams = httpParams.append('id', id.toString());
        }

        return this.httpCliente.get<Pagamento>(this.url + '/obtem', { params: httpParams })
            .pipe(map((pagamento => Pagamento.doBackend(pagamento))));
    }

    public lista(mes: number, ano: number, numeroPagina: number, tamanhoPagina: number): Observable<IPagina<IPagamento, Pagamento>> {

        let httpParams = new HttpParams();

        if (mes) {
            httpParams = httpParams.append('mes', mes.toString());
        }

        if (ano) {
            httpParams = httpParams.append('ano', ano.toString());
        }

        httpParams = httpParams.append('numeroPagina', numeroPagina.toString());
        httpParams = httpParams.append('tamanhoPagina', tamanhoPagina.toString());


        return this.httpCliente.get<IPagina<IPagamento, Pagamento>>(this.url + '/lista', { params: httpParams })
            .pipe(map((pagina => this.obtemPagina(pagina))));
    }

    private obtemPagina(pagina: IPagina<IPagamento, Pagamento>): IPagina<IPagamento, Pagamento> {
        pagina.conteudo = Pagamento.listaDoBackend(pagina.content);
        return pagina;
    }

    public cria(idJogador: number, data: string): Observable<Pagamento> {

        let httpParams = new HttpParams();

        if (data) {
            httpParams = httpParams.append('data', data.toString());
        }

        if (idJogador) {
            httpParams = httpParams.append('idJogador', idJogador.toString());
        }
        return this.httpCliente.get<Pagamento>(this.url + '/cria', { params: httpParams })
            .pipe(map(pagamento => Pagamento.doBackend(pagamento) as Pagamento));

    }
}