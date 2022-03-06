package mapa.controls;

import mapa.exceptions.ValorIncorretoException;

public class HospedeImpl implements HospedeDAO {

    @Override
    public void verificarCodigo(int codigo) {
        if (codigo <= 0) {
            throw new ValorIncorretoException(msgErro());
        }
    }

    @Override
    public void verificarNome(String nome) {
        if (nome.isBlank()) {
            throw new ValorIncorretoException(msgErro());
        }
    }

    @Override
    public void verificarIdade(int idade) {
        if (idade <= 0) {
            throw new ValorIncorretoException(msgErro());
        }
    }

    public String msgErro() {
        return "\n** Erro! Valor inválido. Tente novamente ** \n";
    }
}
