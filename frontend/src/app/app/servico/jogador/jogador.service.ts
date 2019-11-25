import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jogador, IJogador } from './jogador';
import { map } from 'rxjs/operators';
import { IPagina } from '../pagina/pagina';

@Injectable()
export class JogadorService {

    url = 'http://localhost:8080' + '/jogador';
    httpHeader = new HttpHeaders();

    constructor(
        private httpCliente: HttpClient) {
        this.httpHeader = this.httpHeader.append('Content-Type', 'application/json');
    }

    public obtem(id: number): Observable<Jogador> {

        let httpParams = new HttpParams();

        if (id) {
            httpParams = httpParams.append('id', id.toString());
        }

        return this.httpCliente.get<Jogador>(this.url + '/obtem', { params: httpParams })
            .pipe(map((jogador => Jogador.doBackend(jogador))));
    }

    public lista(nome: string, numero: number, numeroPagina: number, tamanhoPagina: number): Observable<IPagina<IJogador, Jogador>> {

        let httpParams = new HttpParams();

        if (nome) {
            httpParams = httpParams.append('nome', nome);
        }
        if (numero) {
            httpParams = httpParams.append('numero', numero.toString());
        }
        if (numeroPagina) {
            httpParams = httpParams.append('numeroPagina', numeroPagina.toString());
        }
        if (tamanhoPagina) {
            httpParams = httpParams.append('tamanhoPagina', tamanhoPagina.toString());
        }


        return this.httpCliente.get<IPagina<IJogador, Jogador>>(this.url + '/lista', { params: httpParams })
            .pipe(map((pagina => this.obtemPagina(pagina))));
    }

    public listaTodos(): Observable<Jogador[]> {

        return this.httpCliente.get<IJogador[]>(this.url + '/listaTodos')
            .pipe(map(((lista: Jogador[]) => Jogador.listaDoBackend(lista))));
    }

    private obtemPagina(pagina: IPagina<IJogador, Jogador>): IPagina<IJogador, Jogador> {
        pagina.conteudo = Jogador.listaDoBackend(pagina.content);
        return pagina;
    }

    public cria(jogador: Jogador): Observable<Jogador> {
        return this.httpCliente.post<Jogador>(this.url + '/cria', jogador.paraBackend(), { headers: this.httpHeader })
            .pipe(map(jogadorRetornado => Jogador.doBackend(jogadorRetornado) as Jogador));

    }

    public atualiza(jogador: Jogador): Observable<Jogador> {
        return this.httpCliente.put<Jogador>(this.url + '/atualiza', jogador.paraBackend(), { headers: this.httpHeader })
            .pipe(map(jogadorRetornado => Jogador.doBackend(jogadorRetornado) as Jogador));

    }
}