package mapa.controls;

import mapa.exceptions.ValorIncorretoException;

public interface SuiteDAO {

    void inputNumero(int numero) throws ValorIncorretoException;

    void inputCapacidade(int capacidade) throws ValorIncorretoException;

    void inputValor(double valor) throws ValorIncorretoException;

}
