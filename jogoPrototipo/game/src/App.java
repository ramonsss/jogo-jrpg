import java.util.Random;
import java.util.Scanner;
import console.*;

public class App {

    public static void main(String[] args) throws Exception {
        // atributos do java
        Scanner input = new Scanner(System.in);

        // atributos do jogo
        Personagem personagem = new Personagem();
        Armadura armadura = new Armadura(personagem);
        Arma arma = new Arma(personagem);
        Inimigo inimigo = new Inimigo();
        Batalha batalha = new Batalha();
        Textos textos = new Textos();
        Mana mana = new Mana();
        Pocao pocao = new Pocao();

        // console
        ClearConsole clear = new ClearConsole();
        PauseConsole pause = new PauseConsole();
        VerificacaoInput escolhaInput = new VerificacaoInput();

        while (true) {
            System.out.printf("\t1- Criar Personagem\n");
            System.out.printf("\t2- Jogar\n");
            System.out.printf("\t3- Tutorial\n");
            System.out.printf("\t4- Historia\n");
            System.out.printf("\t5- Sair\n");
            int escolha = escolhaInput.LerNumero("->", 6);

            if (escolha == 1) {
                if (personagem.pointUp == 15) {
                    // adicionando nome pro personagem
                    System.out.println("Digite o nome do seu personagem:");
                    String name = input.nextLine();
                    personagem.setName(name);

                    // distribuindo ponto pro personagem
                    distributePoints(personagem, armadura, arma, mana);
                    selectWeapon(personagem, armadura, arma, mana);
                    selectArmor(personagem, armadura, arma, mana);
                }

                else {
                    clear.clearConsole();
                    System.out.println("Você já criou um personagem");
                }
            }

            else if (escolha == 2) {
                if (personagem.pointUp == 0) {
                    // adicionando a vida
                    personagem.definePV();
                    personagem.saveStats();

                    showStats(personagem, armadura, arma, mana);
                    pause.pauseConsole();
                    clear.clearConsole();

                    System.out.println("Carregando jogo...");
                    textos.textoInicial();
                    textos.inimigo1();
                    textos.faceInimigo1();
                    batalha.initialBattle(inimigo);
                    if (personagem.getPv() > 0) {
                        batalha.combateBattle(personagem, inimigo, arma, armadura, mana, pocao);
                    }

                    System.out.println("Sua vida é " + personagem.getPv());

                    if (personagem.getPv() > 0) {
                        textos.textChangePerson();
                        String codigo = input.nextLine();
                        if (codigo.equals("qwerty") || codigo.equals("QWERTY") || codigo.equals("Qwerty")) {
                            personagem.changePerson(mana);
                            clear.clearConsole();
                            showStatsMago(personagem, armadura, arma, mana);
                            pause.pauseConsole();
                            clear.clearConsole();
                            System.out.println("Você descobriu quem realmente você é\n");
                            selectSpell(personagem, armadura, arma, mana);
                        } else {
                            System.out.println("Sua arma antiga quebrou... Escolha uma nova arma");
                            System.out.println("OBS: AS ARMAS FICARAM MAIS FORTES");
                            selectWeapon(personagem, armadura, arma, mana);
                            personagem.resetStats();
                        }
                    } else if (personagem.getPv() <= 0) {
                        clear.clearConsole();
                        showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    // continuação aqui
                    if (personagem.getPv() > 0) {
                        personagem.pointUp = 5;
                        System.out.println("Você subiu de level, você ganhou 5 pontos novos...");
                        pause.pauseConsole();
                        clear.clearConsole();
                        distributePoints(personagem, armadura, arma, mana);
                        arma.setArma(arma.getArma() + 7.5);
                        personagem.setPv(personagem.getPv() + personagem.getConstituicao());
                        clear.clearConsole();
                        showStats(personagem, armadura, arma, mana);

                        // initialBattle2
                        textos.inimigo2();
                        batalha.initialBattle2(inimigo, personagem);
                        batalha.combateBattle2(personagem, inimigo, arma, armadura, mana);
                    }

                    // fase 3
                    if (personagem.getName() == "Mago Giras") {
                        if (personagem.getPv() > 0) {
                            System.out.println("Após as badaladas brigas anteriores, voce finalmente"
                                    + " poderá recuperar sua vestimenta natural");
                            selectArmorMago(personagem, armadura, arma, mana);
                        } else if (personagem.getPv() <= 0) {
                            clear.clearConsole();
                            showStats(personagem, armadura, arma, mana);
                            pause.pauseConsole();
                            clear.clearConsole();
                        }
                    }

                    else {
                        if (personagem.getPv() > 0) {
                            System.out.println("Sua armadura antiga quebrou... Escolha uma nova armadura");
                            System.out.println("OBS: AS ARMADURAS FICARAM MAIS FORTES");
                            selectArmor(personagem, armadura, arma, mana);
                            personagem.resetStats();

                        } else if (personagem.getPv() <= 0) {
                            clear.clearConsole();
                            showStats(personagem, armadura, arma, mana);
                            pause.pauseConsole();
                            clear.clearConsole();
                        }
                    }

                    // continuação aqui
                    if (personagem.getPv() > 0) {
                        personagem.pointUp = 10;
                        System.out.println("Você subiu de level, você ganhou 10 pontos novos...");
                        pause.pauseConsole();
                        clear.clearConsole();
                        distributePoints(personagem, armadura, arma, mana);
                        armadura.setArmadura(armadura.getArmadura() + 7.5);
                        personagem.setPv(personagem.getPv() + personagem.getConstituicao());
                        clear.clearConsole();
                        showStats(personagem, armadura, arma, mana);

                        // initialBattle3
                        textos.inimigo3();
                        batalha.initialBattle3(inimigo, personagem);
                        batalha.combateBattle3(personagem, inimigo, arma, armadura, mana);
                    }
                }

                else {
                    clear.clearConsole();
                    System.out.println("É preciso criar um personagem primeiro...");
                }
            }

            else if (escolha == 3) {
                System.out.println("PARA COMEÇAR: ");
                System.out.println("para iniciar o jogo você deve inicialmente criar seu personagem jogavel,");
                System.out.println(
                        "você tera 15 pontos para destribuir entre força,agilidade,destreza e a constituição do seu personagem,");
                System.out.println(
                        "apos a a distribição dos pontos você podera escolher o porte da sua arma entre as opções : leve, media e pesada.");
                System.out.println(
                        "porem a escolha de arma pode alterar em seus pontos de habilidade(exeto as leves) como uma arma pesada pode reduzir seus pontos de agilidade");
                System.out.println("assim como as armas segue a logica das armaduras");
                System.out.println("  ");
                System.out.println("PARA BATALHAR:");
                System.out.println(
                        "após a criação do personagem e ao escolher a opção batalha(2) você iniciara a sua jornada ");
                System.out.println(" nessa aventura você tera 3 opções de ação : atacar , defender e opção poção.");
                System.out.println(
                        "as opções ataque e defesa são de carater intuitivo , ja a opção poção deve ser exclusiva para ser usada quando você tiver uma poção");
                System.out.println(
                        "você recebera uma poção a cada fim de fase como e quando você ira usala fica a seu criterio");
                System.out.println("a poção ira curar você apos uma longa batalha para que tenha força para proxima");
                System.out.println("agora você já pode começar essa aventura conhecendo esse");
            }

            else if (escolha == 4) {
                textos.history();
            }

            else if (escolha == 5) {
                System.exit(0);
            }

            else {
                clear.clearConsole();
                System.out.println("Escolha uma opção válida");
            }
        }

    }

    // visualizar os dados
    public static void showStats(Personagem personagem, Armadura armadura, Arma arma, Mana mana) {
        System.out.println("\n");
        System.out.println("Pontos restantes: " + personagem.pointUp);
        System.out.println("Name: " + personagem.getName());
        System.out.println("Vida: " + personagem.getPv());
        System.out.println("Força: " + personagem.getForca());
        System.out.println("Constituição: " + personagem.getConstituicao());
        if (personagem.getAgilidade() <= 0) {
            personagem.setAgilidade(0);
            System.out.println("Agilidade: " + personagem.getAgilidade());
        } else {
            System.out.println("Agilidade: " + personagem.getAgilidade());
        }
        System.out.println("Destreza: " + personagem.getDestreza());
        System.out.println("Mana: " + personagem.getMana());
        System.out.println("Armadura: " + armadura.getArmadura());
        System.out.println("Arma: " + arma.getArma());
    }

    public static void showStatsMago(Personagem personagem, Armadura armadura, Arma arma, Mana mana) {
        System.out.println("\n");
        System.out.println("Pontos restantes: " + personagem.pointUp);
        System.out.println("Name: " + personagem.getName());
        System.out.println("Vida: " + personagem.getPv());
        System.out.println("Força: " + personagem.getForca());
        System.out.println("Constituição: " + personagem.getConstituicao());
        if (personagem.getAgilidade() <= 0) {
            personagem.setAgilidade(0);
            System.out.println("Agilidade: " + personagem.getAgilidade());
        } else {
            System.out.println("Agilidade: " + personagem.getAgilidade());
        }
        System.out.println("Destreza: " + personagem.getDestreza());
        System.out.println("Mana: " + personagem.getMana());
        System.out.println("Armadura: " + armadura.getArmadura());
        System.out.println("Feitiço: " + arma.getFeitico());
    }

    // distribuição de pontos
    private static void distributePoints(Personagem personagem, Armadura armadura, Arma arma, Mana mana) {
        // console
        ClearConsole clear = new ClearConsole();
        PauseConsole pause = new PauseConsole();
        VerificacaoInput escolhaInput = new VerificacaoInput();

        // input
        Scanner input = new Scanner(System.in);

        while (personagem.pointUp > 0) {
            clear.clearConsole();
            System.out.println("Escolha um atributo para aumentar");
            System.out.println("1: Força");
            System.out.println("2: Constituição");
            System.out.println("3: Agilidade");
            System.out.println("4: Destreza");
            int choice = escolhaInput.LerNumero("->", 4);

            switch (choice) {
                case 1:
                    System.out.println("Voce adicionou um ponto em sua força...");
                    personagem.setForca(personagem.getForca() + 1);
                    personagem.pointUp--;
                    break;

                case 2:
                    System.out.println("Voce adicionou um ponto em sua constituição...");
                    personagem.setConstituicao(personagem.getConstituicao() + 1);
                    personagem.pointUp--;
                    break;

                case 3:
                    System.out.println("Voce adicionou um ponto em sua agilidade...");
                    personagem.setAgilidade(personagem.getAgilidade() + 1);
                    personagem.pointUp--;
                    break;

                case 4:
                    System.out.println("Voce adicionou um ponto em sua destreza...");
                    personagem.setDestreza(personagem.getDestreza() + 1);
                    personagem.pointUp--;
                    break;

                default:
                    System.out.println("Escolha um numero válido");
                    break;
            }

            pause.pauseConsole();
            clear.clearConsole();
            showStats(personagem, armadura, arma, mana);
            pause.pauseConsole();
            clear.clearConsole();

        }

    }

    // seleção da arma
    private static void selectWeapon(Personagem personagem, Armadura armadura, Arma arma, Mana mana) {
        // console
        PauseConsole pause = new PauseConsole();
        ClearConsole clear = new ClearConsole();
        VerificacaoInput escolhaInput = new VerificacaoInput();

        // verificação weapon
        int escolhaArma = 0;
        boolean armaValida = false;

        // jogo
        Scanner input = new Scanner(System.in);
        Random dado = new Random();

        while (!armaValida) {
            pause.pauseConsole();
            clear.clearConsole();
            System.out.println("Escolha o tipo de sua arma:");
            System.out.println("1: Arma Leve");
            System.out.println("2: Arma Media");
            System.out.println("3: Arma Pesada");
            escolhaArma = escolhaInput.LerNumero("->", 3);


            if (personagem.getArmasUsadas().contains(escolhaArma)) {
                System.out.println("Você já usou essa arma antes. Escolha outra.");
            } else {
                armaValida = true; // Arma é válida e não foi usada
                personagem.adicionarArmaUsada(escolhaArma); // Marca a arma como usada
            }
        }

        arma.armaChose(escolhaArma, personagem.getDestreza(), personagem.getForca());

        pause.pauseConsole();
        clear.clearConsole();
        showStats(personagem, armadura, arma, mana);
        pause.pauseConsole();
        clear.clearConsole();
    }

    // seleção da armadura
    private static void selectArmor(Personagem personagem, Armadura armadura, Arma arma, Mana mana) {
        // console
        PauseConsole pause = new PauseConsole();
        ClearConsole clear = new ClearConsole();
        VerificacaoInput escolhaInput = new VerificacaoInput();

        // verificação armor
        int escolhaArmadura = 0;
        boolean armaduraValida = false;

        // jogo
        Scanner input = new Scanner(System.in);
        Random dado = new Random();

        System.out.println("Escolha o tipo de sua armadura:");
        System.out.println("1: Armadura Leve");
        System.out.println("2: Armadura Media");
        System.out.println("3: Armadura Pesada");
        escolhaArmadura = escolhaInput.LerNumero("->", 3);

        if (personagem.getArmadurasUsadas().contains(escolhaArmadura)) {
            System.out.println("Você já usou essa arma antes. Escolha outra.");
        } else {
            armaduraValida = true; // Armadura é válida e não foi usada
            personagem.adicionarArmaduraUsada(escolhaArmadura); // Marca a armadura como usada
        }

        armadura.armaduraChose(escolhaArmadura, personagem.getConstituicao());
        pause.pauseConsole();
        clear.clearConsole();
        showStats(personagem, armadura, arma, mana);
        pause.pauseConsole();
        clear.clearConsole();
    }

    // escolhendo feitiço
    private static void selectSpell(Personagem personagem, Armadura armadura, Arma arma, Mana mana) {
        // console
        PauseConsole pause = new PauseConsole();
        ClearConsole clear = new ClearConsole();
        VerificacaoInput escolhaInput = new VerificacaoInput();

        // jogo
        Scanner input = new Scanner(System.in);
        Random dado = new Random();

        System.out.println("Disperte seu feitiço do Planeta dos Daltonicos:");
        System.out.println("1: Feitiço marrom");
        System.out.println("2: Feitiço azul");
        int escolhaFeitico = escolhaInput.LerNumero("->", 2);

        arma.feiticoChose(escolhaFeitico, personagem.getDestreza(), personagem.getForca(), mana.getMana());

        pause.pauseConsole();
        clear.clearConsole();
        showStatsMago(personagem, armadura, arma, mana);
        pause.pauseConsole();
        clear.clearConsole();
    }

    private static void selectArmorMago(Personagem personagem, Armadura armadura, Arma arma, Mana mana) {
        // console
        PauseConsole pause = new PauseConsole();
        ClearConsole clear = new ClearConsole();
        VerificacaoInput escolhaInput = new VerificacaoInput();

        // jogo
        Scanner input = new Scanner(System.in);
        Random dado = new Random();

        System.out.println("Disperte seu feitiço do Planeta dos Daltonicos:");
        System.out.println("1: Armadura com feitiçaria marrom");
        System.out.println("2: Armadura com feitiçaria azul");
        int escolhaFeitico = escolhaInput.LerNumero("->", 2);

        armadura.armaduraFeiticoChose(escolhaFeitico, personagem.getDestreza(), personagem.getForca(), mana.getMana());

        pause.pauseConsole();
        clear.clearConsole();
        showStatsMago(personagem, armadura, arma, mana);
        pause.pauseConsole();
        clear.clearConsole();
    }
}