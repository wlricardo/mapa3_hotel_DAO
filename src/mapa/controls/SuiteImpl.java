package mapa.controls;

import mapa.dialogs.Mensagem;
import mapa.exceptions.ValorIncorretoException;

public class SuiteImpl implements SuiteDAO {

    @Override
    public void verificarNumero(int numero) {
        if (numero <= 0) {
            throw new ValorIncorretoException(Mensagem.erroNumerico());
        }
    }

    @Override
    public void verificarCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new ValorIncorretoException(Mensagem.erroNumerico());
        }
    }

    @Override
    public void verificarValor(double valor) {
        if (valor <= 0.0) {
            throw new ValorIncorretoException(Mensagem.erroNumerico());
        }
    }
}
