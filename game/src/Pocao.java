public class Pocao {
    private double valorPocao = 5;
    public int quantidadePocao = 9;

    public void pocao(Personagem personagem) {
        System.out.println("Quantidade de pocao: " + quantidadePocao);
            if (quantidadePocao > 0) {
                personagem.setPv(personagem.getPv() + valorPocao);
            } else if (quantidadePocao <= 0) {
                System.out.println("Voce nao tem pocao");
            }
            quantidadePocao--;
        
    }

    
    public int getQuantidadePocao() {
        return quantidadePocao;
    }

    public void setQuantidadePocao(int quantidadePocao) {
        this.quantidadePocao = quantidadePocao;
    }
}
