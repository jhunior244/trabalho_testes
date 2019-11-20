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
}