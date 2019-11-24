import { IAcaoJogador, AcaoJogador } from '../acao-jogador/acao-jogador';

export class IJogador {
    id: number;
    nome: string;
    numero: number;
    posicao: string;
    salario: number;
    listaAcaoJogador: IAcaoJogador[];
}

export class Jogador {
    id: number;
    nome: string;
    numero: number;
    posicao: string;
    salario: number;
    listaAcaoJogador: AcaoJogador[];

    static listaDoBackend(response: IJogador[]): Jogador[] {
        const listaJogador: Jogador[] = [];

        for (const JogadorJSON of response) {
            listaJogador.push(this.doBackend(JogadorJSON));
        }

        return listaJogador;
    }

    static doBackend(response: IJogador): Jogador {
        let jogador = Object.create(Jogador.prototype);

        jogador = Object.assign(jogador, response, {

        });
        return jogador;
    }

    paraBackend(): IJogador {
        const jogador = Object.assign(Object.create(Jogador.prototype), this, {

        });

        return jogador;
    }
}

