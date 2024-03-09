package exercicios;

/**
 * @author Manoel Campos
 */
public class Cidade {
    private String nome;
    private Estado estado;

    public Cidade(final String nome, final Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(final Estado estado) {
        this.estado = estado;
    }
}
