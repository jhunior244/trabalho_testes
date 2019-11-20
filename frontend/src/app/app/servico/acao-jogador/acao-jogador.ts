import { IJogador, Jogador } from '../jogador/jogador';

export class IAcaoJogador {
    id: number;
    total: number;
    jogador: IJogador;
}

export class AcaoJogador {
    id: number;
    total: number;
    jogador: Jogador;
}