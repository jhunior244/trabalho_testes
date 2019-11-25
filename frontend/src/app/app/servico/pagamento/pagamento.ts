import * as moment from 'moment';
import { Jogador, IJogador } from '../jogador/jogador';

export class IPagamento {
    id: number;
    valorPago: number;
    dataPagamento: moment.Moment;
    jogador: IJogador;
}

export class Pagamento {
    id: number;
    valorPago: number;
    dataPagamento: moment.Moment;
    jogador: Jogador;

    static listaDoBackend(response: IPagamento[]): Pagamento[] {
        const listaPagamento: Pagamento[] = [];

        for (const EventoJSON of response) {
            listaPagamento.push(this.doBackend(EventoJSON));
        }

        return listaPagamento;
    }

    static doBackend(response: IPagamento): Pagamento {
        let pagamento = Object.create(Pagamento.prototype);

        pagamento = Object.assign(pagamento, response, {
            jogador: (response.jogador) ? Jogador.doBackend(response.jogador) : null,
            dataPagamento: (response.dataPagamento) ? moment(response.dataPagamento) : null
        });

        return pagamento;
    }

    paraBackend(): IPagamento {
        const evento = Object.assign(Object.create(Pagamento.prototype), this, {
            jogador: (this.jogador) ? this.jogador.paraBackend() : null,
            dataPagamento: (this.dataPagamento) ? moment(this.dataPagamento).toDate().toISOString() : null,
        });

        return evento;
    }
}