public class Pocao {
    private double valorPocao = 5;
    public int quantidadePocao = 3;

    public void pocao(Personagem personagem) {
        System.out.println("Quantidade de pocao: " + quantidadePocao);
        if (personagem.getPv() < personagem.pvAnterior) {
            if (quantidadePocao > 0) {
                personagem.setPv(personagem.getPv() + valorPocao);
                if(personagem.getPv() > personagem.pvAnterior) {
                    personagem.setPv(personagem.pvAnterior);
                }
            } else if (quantidadePocao <= 0) {
                System.out.println("Voce nao tem pocao");
            }
            quantidadePocao--;
        } else {
            System.out.println("Voce esta com a vida cheia");
        }        
    }

    
    public int getQuantidadePocao() {
        return quantidadePocao;
    }

    public void setQuantidadePocao(int quantidadePocao) {
        this.quantidadePocao = quantidadePocao;
    }
}
