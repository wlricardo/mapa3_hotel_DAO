package mapa.controls;

import mapa.exceptions.ValorIncorretoException;

public class SuiteImpl implements SuiteDAO {
    
    @Override
    public void inputNumero(int numero) {
        if (numero <= 0) {
            throw new ValorIncorretoException(msgErro());
        }
    }

    @Override
    public void inputCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new ValorIncorretoException(msgErro());
        }
    }

    @Override
    public void inputValor(double valor) {
        if (valor <= 0) {
            throw new ValorIncorretoException(msgErro());
        }
    }

    public String msgErro() {
        return "\n** Erro! Valor inválido. Tente novamente **\n";
    }
}
