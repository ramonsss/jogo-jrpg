import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Personagem {

    // gerador de numero aleatorio
    private Random dado = new Random();

    public double pointUp = 15;

    // status basico
    private String name;
    private double pv;

    // atributos
    private double forca;
    private double constituicao;
    private double agilidade;
    private double destreza;
    private double mana;

    // save
    double pvAnterior;
    double forcaAnterior;
    double constituicaoAnterior;
    double agilidadeAnterior;
    double destrezaAnterior;

    public Personagem() {
        setAgilidade(0);
        setConstituicao(0);
        setDestreza(0);
        setForca(0);
        setName("");
        setPv(0);
        this.armasUsadas = new HashSet<>();
        this.armadurasUsadas = new HashSet<>();
    }

    public void saveStats() {
        pvAnterior = this.pv;
        forcaAnterior = this.forca;
        constituicaoAnterior = this.constituicao;
        agilidadeAnterior = this.agilidade;
        destrezaAnterior = this.destreza;
    }

    public void resetStats() {
        this.pv = pvAnterior;
        this.forca = forcaAnterior;
        this.constituicao = constituicaoAnterior;
        this.agilidade = agilidadeAnterior;
        this.destreza = destrezaAnterior;
    }

    // Adicionando a logica da quantidade da vida
    public void definePV() {
        pv = ((dado.nextInt(6) + 1) + (dado.nextInt(6) + 1) + (dado.nextInt(6) + 1)) + this.constituicao;
    }

    // se ele digitar o codigo certo
    public void changePerson(Mana mana) {
        setName("Mago Giras");
        setPv(50);
        setForca(15);
        setAgilidade(20);
        setConstituicao(18);
        setDestreza(20);
        setMana(10);
    }

    // verificação da arma antiga
    private Set<Integer> armasUsadas;

    public Set<Integer> getArmasUsadas() {
        return armasUsadas;
    }

    public void adicionarArmaUsada(int armaId) {
        armasUsadas.add(armaId);
    }

    // verificação da armadura antiga
    private Set<Integer> armadurasUsadas;

    public Set<Integer> getArmadurasUsadas() {
        return armasUsadas;
    }

    public void adicionarArmaduraUsada(int armaduraId) {
        armadurasUsadas.add(armaduraId);
    }

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPv() {
        return pv;
    }
    public void setPv(double pv) {
        this.pv = pv;
    }

    public double getForca() {
        return forca;
    }
    public void setForca(double forca) {
        this.forca = forca;
    }

    public double getConstituicao() {
        return constituicao;
    }
    public void setConstituicao(double constituicao) {
        this.constituicao = constituicao;
    }
    public double getAgilidade() {
        return agilidade;
    }
    public void setAgilidade(double agilidade) {
        this.agilidade = agilidade;
    }
    public double getDestreza() {
        return destreza;
    }
    public void setDestreza(double destreza) {
        this.destreza = destreza;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }    
}