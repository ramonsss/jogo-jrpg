import java.util.Random;

public class Armadura {
    private double armadura;
    private Personagem personagem;
    
    private double armaduraFeitico;

    // import personagem
    public Armadura(Personagem personagem) {
        this.personagem = personagem;
    }


    // logica da armadura
    Random dado = new Random();

    public void armaduraChose(int escolha, double constituicao) {
        double armadura = 0;
        boolean armaduraEscolhida = false;

        double agilidade = personagem.getAgilidade();

        while(!armaduraEscolhida) {
            switch (escolha) {
                case 1:
                    armadura = 1 + 1.5 * constituicao;
                    System.out.println("Você escolheu a armadura leve...");
                    armaduraEscolhida = true;
                    break;
                
                case 2:
                    armadura = 2 + 1.5 * constituicao;
                    agilidade -= 2;
                    System.out.println("Você escolheu a armadura média...");
                    armaduraEscolhida = true;
                    break;
                
                case 3:
                    armadura = 3 + 1.5 * constituicao;
                    agilidade -= 4;
                    System.out.println("Você escolheu a armadura pesada...");
                    armaduraEscolhida = true;
                    break;
            
                default:
                    System.out.println("Escolha uma armadura válida...");
                    break;
            }
        }
        personagem.setAgilidade(agilidade);
        setArmadura(armadura);
    }

    public void armaduraFeiticoChose(int escolha, double destreza, double forca, double mana) {
        double armaduraFeitico = 0;
        boolean armaduraFeiticoEscolhido = false;

        double agilidade = personagem.getAgilidade();

        while (!armaduraFeiticoEscolhido) {
            switch (escolha) {
                case 2:
                    armadura = 2 + 1.5 * mana;
                    mana -= 2;
                    System.out.println("Você escolheu a armadura média...");
                    armaduraFeiticoEscolhido = true;
                    break;
                
                case 3:
                    armadura = 3 + 1.5 * mana;
                    agilidade -= 3;
                    System.out.println("Você escolheu a armadura pesada...");
                    armaduraFeiticoEscolhido = true;
                    break;
            
                default:
                    System.out.println("Escolha uma armadura válida...");
                    break;
            }
        }
        personagem.setAgilidade(agilidade);
        personagem.setMana(mana);
        setArmaduraFeitico(armaduraFeitico);
    }

    // getter e setter

    public double getArmaduraFeitico() {
        return armaduraFeitico;
    }

    public void setArmaduraFeitico(double armaduraFeitico) {
        this.armaduraFeitico = armaduraFeitico;
    }    

    public double getArmadura() {
        return armadura;
    }

    public void setArmadura(double armadura) {
        this.armadura = armadura;
    }
}