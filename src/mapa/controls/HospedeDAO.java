package mapa.controls;

import mapa.exceptions.ValorIncorretoException;

public interface HospedeDAO {
    
    void verificarCodigo(int codigo) throws ValorIncorretoException;

    void verificarNome(String nome) throws ValorIncorretoException;

    void verificarIdade(int idade) throws ValorIncorretoException;

}
