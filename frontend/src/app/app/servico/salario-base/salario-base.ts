import * as moment from 'moment';
import { Jogador, IJogador } from '../jogador/jogador';

export class ISalarioBase {
    id: number;
    salario: number;
    jogador: IJogador;
}

export class SalarioBase {
    id: number;
    salario: number;
    jogador: IJogador;
}