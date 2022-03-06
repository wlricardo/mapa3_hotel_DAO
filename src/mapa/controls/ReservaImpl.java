package mapa.controls;

import java.util.List;
import mapa.entities.Hospede;
import mapa.entities.Reserva;
import mapa.entities.Suite;
import mapa.exceptions.ElementoNaoEncontradoException;
import mapa.exceptions.ReservaInvalidaException;

public class ReservaImpl implements ReservaDAO {

    @Override
    public Suite procurarCodigoSuite(List<Reserva> lista, int codigo) {
        Suite s = null;
        for (Reserva r : lista) {
            if (r.getSuite().getNumero() == codigo) {
                s = r.getSuite();
            }
        }
        if (s != null) {
            return s;
        } else {
            throw new ElementoNaoEncontradoException(msgErro());
        }
    }

    @Override
    public void verificarCapacidade(Reserva reserva, int capacidade) {
        if (hospedesAcimaDoisAnos(reserva) > capacidade) {
            throw new ReservaInvalidaException("\n ** Erro! Total de hóspedes maior que a capaciade da suite **\n");
        }
    }

    @Override
    public void adicionarReserva(List<Reserva> lista, Reserva reserva) {
        lista.add(reserva);
    }

    @Override
    public boolean verificarReserva(List<Reserva> lista, Suite suite) {
        boolean achou = false;
        for (Reserva r : lista) {
            if (r.getSuite().getNumero().equals(suite.getNumero())) {
                achou = true;
            }
        }
        return achou;
    }

    @Override
    public List<Hospede> mostrarHospedeSuite(List<Reserva> lista, Suite suite) {
        List<Hospede> hospedes = null;
        if (verificarReserva(lista, suite)) {
            for (Reserva r : lista) {
                if (r.getSuite().equals(suite)) {
                    hospedes = r.getHospedes();
                }
            }
        } else {
            throw new ElementoNaoEncontradoException(msgErro());
        }
        return hospedes;
    }

    @Override
    public void mostrarReserva(List<Reserva> lista, Suite suite) {
        List<Hospede> h = null;
        if (verificarReserva(lista, suite)) {
            System.out.println("Dados da reserva:");
            System.out.println("----------------");
            System.out.println(suite.toString());

            h = mostrarHospedeSuite(lista, suite);
            for (Hospede hospede : h) {
                System.out.println(hospede.toString());
            }

        }
    }

    public int hospedesAcimaDoisAnos(Reserva reserva) {
        int total = 0;
        for (Hospede h : reserva.getHospedes()) {
            if (h.getIdade() > 2) {
                total++;
            }
        }
        return total;
    }

    public String msgErro() {
        return "\n** Elmento não encontrado **\n";
    }

}
