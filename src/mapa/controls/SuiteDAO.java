package mapa.controls;

import mapa.exceptions.ValorIncorretoException;

public interface SuiteDAO {

    void verificarNumero(int numero) throws ValorIncorretoException;

    void verificarCapacidade(int capacidade) throws ValorIncorretoException;

    void verificarValor(double valor) throws ValorIncorretoException;

}
