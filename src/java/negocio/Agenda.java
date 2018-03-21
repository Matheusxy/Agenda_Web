package negocio;

import entidades.Contatos;

public class Agenda {

    private Contatos contatos[];
    private int quantidadeDeContatos;

    private void aumentarCapacidade() {
        // criar novo array com capacidade maior
        // copiar os elementos do array antigo
        // fazer contatos[] referenciar o novo array
        Contatos novoContato[] = new Contatos[contatos.length * 2];
        System.arraycopy(contatos, 0, novoContato, 0, quantidadeDeContatos);
        contatos = novoContato;
    }

    public Agenda() {
        contatos = new Contatos[2];
        quantidadeDeContatos = 0;
    }

    public void inserir(Contatos novoContato) {
        if (quantidadeDeContatos == contatos.length) {
            aumentarCapacidade();
        }
        contatos[quantidadeDeContatos] = novoContato;
        quantidadeDeContatos++;
        System.out.println(listar());
    }

    public Contatos buscar(String nome) {

        for (int i = 0; i < quantidadeDeContatos; ++i) {
            String n = contatos[i].getNome();
            if (nome.equals(n)) {
                return contatos[i];
            }
        }
        return null;
    }
    public boolean remover(String nome) {

		for (int i = 0; i < quantidadeDeContatos; ++i)
			if (nome.equals(contatos[i].getNome())) {
				if (i == quantidadeDeContatos - 1) {
					contatos[i] = null;
					quantidadeDeContatos--;
				} else {
					contatos[i] = contatos[quantidadeDeContatos - 1];
					contatos[quantidadeDeContatos - 1] = null;
					quantidadeDeContatos--;

				}
				return true;
			}
		return false;
    }
    
        
    

    public String listar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quantidadeDeContatos; ++i) {
            Contatos c = contatos[i];
            sb.append("\n");
            sb.append("Nome: ");
            sb.append(c.getNome());
            sb.append("\n");
            sb.append("Email: ");
            sb.append(c.getEmail());
            sb.append("\n");
            sb.append("Telefone: ");
            sb.append(c.getTel());
            sb.append("\n");
            sb.append("Endereço: ");
            sb.append(c.getEndereco());
            sb.append("\n");
        }
        return sb.toString();
    }

    int quantidade() {
        return quantidadeDeContatos;
    }

}
