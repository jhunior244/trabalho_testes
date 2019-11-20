import { IAcaoJogador, AcaoJogador } from '../acao-jogador/acao-jogador';

export class IAcao {
    id: number;
    total: number;
    listaAcaoJogador: IAcaoJogador[];
}

export class Acao {
    id: number;
    nome: string;
    pontos: number;
    listaAcaoJogador: AcaoJogador[];
}