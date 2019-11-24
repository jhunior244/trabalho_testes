package com.trabalho_testes.trabalho_testes.servico;

import com.trabalho_testes.trabalho_testes.dto.AcaoJogadorDto;
import com.trabalho_testes.trabalho_testes.entidade.Acao;
import com.trabalho_testes.trabalho_testes.repositorio.AcaoJogadorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AcaoJogadorServico implements IAcaoJogadorServico {

    @Autowired
    private AcaoJogadorJpaRepository acaoJogadorJpaRepository;

    @Override
    public AcaoJogadorDto cria(AcaoJogadorDto acaoJogadorDto) {

        return AcaoJogadorDto.paraDto(acaoJogadorJpaRepository.save(AcaoJogadorDto.doDto(acaoJogadorDto)));
    }

    @Override
    public AcaoJogadorDto obtem(Long id) {
        return AcaoJogadorDto.paraDto(acaoJogadorJpaRepository.findById(id.longValue()));
    }

    @Override
    public List<AcaoJogadorDto> listaPorJogadorEMesDoAno(Long idJogador, Integer mes, Integer ano){
        return AcaoJogadorDto.paraDto(acaoJogadorJpaRepository.listaPorJogadorEMesDoAno(idJogador, mes, ano));
    }
}
