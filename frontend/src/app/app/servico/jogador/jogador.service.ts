import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jogador, IJogador } from './jogador';
import { map } from 'rxjs/operators';
import { IPagina } from '../pagina/pagina';

@Injectable()
export class JogadorService {

    url = 'http://localhost:8080' + '/jogador' ;
    httpHeader = new HttpHeaders();

    constructor(
        private httpCliente: HttpClient) {
        this.httpHeader = this.httpHeader.append('Content-Type', 'application/json');
    }

    public obtem(id: number): Observable<Jogador>{

        let httpParams = new HttpParams();

        if (id) {
            httpParams = httpParams.append('id', id.toString());
        }

        return this.httpCliente.get<Jogador>(this.url + '/obtem', { params: httpParams })
            .pipe(map((evento => Jogador.doBackend(evento))));
    }

    public lista(numeroPagina: number, tamanhoPagina: number): Observable<IPagina<IJogador, Jogador>> {

        let httpParams = new HttpParams();

        httpParams = httpParams.append('numeroPagina', numeroPagina.toString());
        httpParams = httpParams.append('tamanhoPagina', tamanhoPagina.toString());


        return this.httpCliente.get<IPagina<IJogador, Jogador>>(this.url + '/lista', { params: httpParams })
            .pipe(map((pagina => this.obtemPagina(pagina))));
    }

    private obtemPagina(pagina: IPagina<IJogador, Jogador>): IPagina<IJogador, Jogador> {
        pagina.conteudo = Jogador.listaDoBackend(pagina.content);
        return pagina;
    }
}