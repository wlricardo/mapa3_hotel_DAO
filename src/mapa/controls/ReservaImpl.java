package mapa.controls;

import java.util.List;
import mapa.entities.Reserva;
import mapa.entities.Suite;
import mapa.exceptions.ElementoNaoEncontradoException;

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
    public verificarCapacidade(Reserva reserva, int capacidade){
        for (Hospede h : reserva.getHospedes()) {
            if (r.getSuite().getCapacidade() >= capacidade) {
                
            }
        }
        
        
    }
    
    public int hospedesAcimaDoisAnos(List<Reserva> lista){
        for (Reserva r : lista) {
            if (r.g) {
                
            }
        }
    }

    public String msgErro() {
        return "\n** Elmento não encontrado **\n";
    }

}
