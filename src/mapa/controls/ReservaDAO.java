package mapa.controls;

import java.util.List;
import mapa.entities.Hospede;
import mapa.entities.Reserva;
import mapa.entities.Suite;
import mapa.exceptions.ElementoNaoEncontradoException;
import mapa.exceptions.ReservaInvalidaException;

public interface ReservaDAO {

    Suite procurarCodigoSuite(List<Reserva> lista, int codigo) throws ReservaInvalidaException;

    void verificarCapacidade(Reserva reserva, int capacidade) throws ReservaInvalidaException;

    void adicionarReserva(List<Reserva> lista, Reserva reserva);

    boolean verificarReserva(List<Reserva> lista, Suite suite) throws ElementoNaoEncontradoException;

    List<Hospede> mostrarHospedeSuite(List<Reserva> reserva, Suite suite) throws ElementoNaoEncontradoException;

    void mostrarReserva(List<Reserva> lista, Suite suite) throws ElementoNaoEncontradoException;
}
