import java.util.Random;

public class Arma {
    private double arma;
    private double feitico;
    private Personagem personagem; 

    // import personagem
    public Arma(Personagem personagem) {
        this.personagem = personagem;
    }

    // logica da arma
    Random dado = new Random();

    public void armaChose(int escolha, double destreza, double forca) {
        double arma = 0;
        boolean armaEscolhida = false;

        double agilidade = personagem.getAgilidade();

        while (!armaEscolhida) {
            switch (escolha) {
                case 1:
                    // K + d6 + d6 + d4 + Des.;
                    arma = 1 + (dado.nextInt(5) + 1) + (dado.nextInt(5) + 1) + (dado.nextInt(3) + 1) + destreza;
                    System.out.println("Você escolheu a arma leve (Pistola)...");
                    armaEscolhida = true;
                    break;

                case 2:
                    // K + d6 + d6 + d4 + Des.;
                    arma = 3 + (dado.nextInt(5) + 1) + (dado.nextInt(5) + 1) + (dado.nextInt(3) + 1) + destreza;
                    agilidade -= 2;
                    System.out.println("Você escolheu a arma medio (Shotgun)...");
                    armaEscolhida = true;
                    break;

                case 3:
                    // // K + d12 + 1,5*For.;
                    arma = 6 + (dado.nextInt(11) + 1) + 1.5 * forca;
                    agilidade -= 4;
                    System.out.println("Você escolheu a arma Forte (Ak-47)...");
                    armaEscolhida = true;
                    break;

                default:
                    System.out.println("Selecione uma opção válida...");
                    break;
            }
        }
        personagem.setAgilidade(agilidade);
        setArma(arma);
    }

    public void feiticoChose(int escolha, double destreza, double forca, double mana) {
        double feitico = 0;
        boolean feiticoEscolhido = false;

        double agilidade = personagem.getAgilidade();

        while (!feiticoEscolhido) {
            switch (escolha) {
                case 1:
                    // K + d6 + d6 + d4 + Des.;
                    feitico = 4 + (dado.nextInt(5) + 1) + (dado.nextInt(5) + 1) + (dado.nextInt(3) + 1) + destreza;
                    mana -= 2;
                    System.out.println("Você escolheu o feitico marrom (leve)");
                    feiticoEscolhido = true;
                    break;
                    
                case 2:
                    // // K + d12 + 1,5*For.;
                    feitico = 10 + (dado.nextInt(11) + 1) + 1.5 * mana;
                    agilidade -= 2;
                    System.out.println("Você escolheu o feitico azul (FORTE)...");
                    feiticoEscolhido = true;
                    break;

                default:
                    System.out.println("Selecione uma opção válida...");
                    break;
            }
        }
        personagem.setAgilidade(agilidade);
        personagem.setMana(mana);
        setFeitico(feitico);
    }

    // getter e setter
    public double getArma() {
        return arma;
    }

    public void setArma(double arma) {
        this.arma = arma;
    }

    public double getFeitico() {
        return feitico;
    }

    public void setFeitico(double feitico) {
        this.feitico = feitico;
    }    
}