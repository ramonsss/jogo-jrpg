import java.util.Random;

// O P.V. do adversário, defesa e agilidade são valores constantes decididos
// pelo programador. O dano do adversário pode ser um valor constante ou um valor
// aleatório, essa decisão e esses valores ficam a critério do desenvolvedor.

public class Inimigo {
    Random random = new Random();

    private String nome;
    private double pve;
    private double dano;
    private double defesa;
    private double agilidade;

    public Inimigo(){
        setNome("");
        setAgilidade(0);
        setPve(0);
        setDano(2 + random.nextInt(12) + random.nextInt(3));
        setDefesa(0);
        setAgilidade(0);
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public double getDano() {
        return dano;
    }

    public void setDano(double dano) {
        this.dano = dano;
    }

    public double getPve() {
        return pve;
    }

    public void setPve(double pve) {
        this.pve = pve;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(double agilidade) {
        this.agilidade = agilidade;
    }    
    
    public void showStatsEnemy(String name, double pv, double defesa, double agilidade, double dano) {
        System.out.println("Nome do inimigo: " + name);
        System.out.println("Vida do inimigo: " + pv);
        System.out.println("Defesa do inimigo: " + defesa);
        System.out.println("Agilidade do inimigo: " + agilidade);
        System.out.println("Dano do inimigo: " + dano);
    }
}