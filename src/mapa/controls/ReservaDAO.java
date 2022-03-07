package mapa.controls;

import java.util.List;
import mapa.entities.Hospede;
import mapa.entities.Reserva;
import mapa.entities.Suite;
import mapa.exceptions.ElementoNaoEncontradoException;
import mapa.exceptions.ReservaInvalidaException;

public interface ReservaDAO {

    Suite procurarCodigoSuite(List<Reserva> lista, int codigo) throws ReservaInvalidaException;

    boolean verificarCapacidade(List<Hospede> lista, int capacidade) throws ReservaInvalidaException;

    void adicionarReserva(List<Reserva> lista, Reserva reserva);

    boolean procurarReserva(List<Reserva> lista, int suite) throws ElementoNaoEncontradoException;

    void mostrarHospedeSuite(List<Reserva> reserva, int suite) throws ElementoNaoEncontradoException;

    void listarTodasAsReservas(List<Reserva> listaDeReservas);
    
    boolean verificarReservas(List<Reserva> reservas) throws ElementoNaoEncontradoException;

    void mostrarReserva(Reserva r) throws ElementoNaoEncontradoException;

    double calcularDiaria(Suite s, int diarias);

    double calcularTotalDeDiarias(List<Reserva> lista);

}
