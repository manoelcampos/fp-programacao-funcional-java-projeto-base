package exercicios;

/**
 * @author Manoel Campos
 */
public class Estado {
    private String nome;
    private String uf;

    public Estado(final String nome, final String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(final String uf) {
        this.uf = uf;
    }
}
