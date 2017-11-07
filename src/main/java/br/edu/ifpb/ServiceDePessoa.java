package br.edu.ifpb;

import br.edu.ifpb.infra.PessoasJDBC;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/11/2017, 13:54:45
 */
public class ServiceDePessoa {

    private PessoasJDBC dao = new PessoasJDBC();

    public Iterable<Pessoa> todasAsPessoas() {
//        return Arrays
//                .asList(new Pessoa("Chaves"),
//                        new Pessoa("Kiko"),
//                        new Pessoa("Florinda"));
        return dao.todasAsPessoas();
    }
}
