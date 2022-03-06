package mapa.controls;

import java.util.List;
import mapa.entities.Reserva;
import mapa.entities.Suite;
import mapa.exceptions.ElementoNaoEncontradoException;
import mapa.exceptions.ReservaInvalidaException;

public interface ReservaDAO {

    Suite procurarCodigoSuite(List<Reserva> lista, int codigo) throws ReservaInvalidaException;

    void verificarCapacidade(Reserva reserva, int capacidade) throws ReservaInvalidaException;

    void adicionarReserva(List<Reserva> lista);
    
    Suite procurarSuite(List<Reserva> lista, Suite suite) throws ElementoNaoEncontradoException;
    
    void mostrarReserva(List<Reserva> lista, Suite suite) throws ElementoNaoEncontradoException;

}
