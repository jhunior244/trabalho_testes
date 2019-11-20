import { IAcaoJogador, AcaoJogador } from '../acao-jogador/acao-jogador';
import * as moment from 'moment';
import { IResultado, Resultado } from '../resultado/resultado';

export class IJogo {
    id: number;
    total: number;
    data: moment.Moment;
    resultado: IResultado;
}

export class Jogo {
    id: number;
    adversario: string;
    data: moment.Moment;
    resultado: Resultado;
}