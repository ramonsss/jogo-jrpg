import java.util.Random;
import java.util.Scanner;
import console.*;

public class Batalha {
    Scanner scanner = new Scanner(System.in);

    PauseConsole pause = new PauseConsole();
    ClearConsole clear = new ClearConsole();
    VerificacaoInput escolhaInput = new VerificacaoInput();
    Pocao pocao = new Pocao();

    // alterando dados do inimigo
    public void initialBattle(Inimigo inimigo) {
        Random whoEnemy = new Random();
        int qualInimigo = whoEnemy.nextInt(3);

        if (qualInimigo == 0) {
            clear.clearConsole();
            inimigo.setNome("Isaac Newton");
            inimigo.setPve(50);
            inimigo.setDefesa(10);
            inimigo.setAgilidade(10);
            inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                    inimigo.getAgilidade(), inimigo.getDano());
            pause.pauseConsole();
            clear.clearConsole();
        }

        else if (qualInimigo == 1) {
            clear.clearConsole();
            inimigo.setNome("Pablo Picasso");
            inimigo.setPve(75);
            inimigo.setDefesa(15);
            inimigo.setAgilidade(3);
            inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                    inimigo.getAgilidade(), inimigo.getDano());
            pause.pauseConsole();
            clear.clearConsole();
        }

        else if (qualInimigo == 2) {
            clear.clearConsole();
            inimigo.setNome("Vincent van Gogh");
            inimigo.setPve(85);
            inimigo.setDefesa(10);
            inimigo.setAgilidade(6);
            inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                    inimigo.getAgilidade(), inimigo.getDano());
            pause.pauseConsole();
            clear.clearConsole();
        }
    }

    public void combateBattle(Personagem personagem, Inimigo inimigo, Arma arma, Armadura armadura, Mana mana,
            Pocao pocao) {

        int escolha;
        boolean turno = true;
        boolean defesaInimigo = false;
        boolean defesa = false;
        int quantidadePocao;

        if (inimigo.getAgilidade() >= personagem.getAgilidade()) {
            App app = new App();
            Random random = new Random();
            int escolhaInimigo = random.nextInt(5);
            personagem.setPv(personagem.getPv() - inimigo.getDano());
            clear.clearConsole();
            System.out.println("o inimigo lhe atacou");
            pause.pauseConsole();
            clear.clearConsole();
            app.showStats(personagem, armadura, arma, mana);
            pause.pauseConsole();
            clear.clearConsole();
            turno = true;
        }

        else if (personagem.getAgilidade() > inimigo.getAgilidade()) {
            System.out.println("1- Atacar");
            System.out.println("2- Defender");
            System.out.println("3- Poção");
            escolha = escolhaInput.LerNumero("->", 3);

            if (escolha == 1) {
                inimigo.setPve(inimigo.getPve() - arma.getArma());
                pause.pauseConsole();
                clear.clearConsole();
                inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                        inimigo.getAgilidade(), inimigo.getDano());
                pause.pauseConsole();
                clear.clearConsole();
            }

            else if (escolha == 2) {
                pause.pauseConsole();
                System.out.println("Voce se defendeu...");
                pause.pauseConsole();
                defesa = true;
            }

            else if (escolha == 3) {
                pocao.pocao(personagem);
                if (pocao.getQuantidadePocao() <= 0) {
                    pocao.setQuantidadePocao(0);
                }

                pause.pauseConsole();
                clear.clearConsole();
                App.showStats(personagem, armadura, arma, mana);
                pause.pauseConsole();
                clear.clearConsole();
            }

            turno = false;
        }

        while (inimigo.getPve() > 0 && personagem.getPv() > 0) {
            if (turno) {
                System.out.println("1- Atacar");
                System.out.println("2- Defender");
                System.out.println("3- Poção");
                escolha = escolhaInput.LerNumero("->", 3);

                if (escolha == 1) {
                    if (defesaInimigo) {
                        System.out.println("Inimigo se defendeu");
                        inimigo.setDefesa(inimigo.getDefesa() - arma.getArma());

                        if (inimigo.getDefesa() <= 0) {
                            System.out.println("Inimigo se defendeu, porem nao tem mais escudo\nDano efetivo!");
                            inimigo.setPve(inimigo.getPve() - arma.getArma());
                        }

                        if (inimigo.getDefesa() <= 0) {
                            inimigo.setDefesa(0);
                        }
                        pause.pauseConsole();
                        clear.clearConsole();
                        defesaInimigo = false;
                    } else if (!defesaInimigo) {
                        inimigo.setPve(inimigo.getPve() - arma.getArma());
                        if (inimigo.getPve() <= 0) {
                            inimigo.setPve(0);
                        }
                        defesaInimigo = false;
                    }
                    pause.pauseConsole();
                    clear.clearConsole();
                    inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                            inimigo.getAgilidade(), inimigo.getDano());
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                else if (escolha == 2) {
                    defesa = true;
                }

                else if (escolha == 3) {

                    pocao.pocao(personagem);
                    if (pocao.getQuantidadePocao() <= 0) {
                        pocao.setQuantidadePocao(0);
                    }

                    pause.pauseConsole();
                    clear.clearConsole();
                    App.showStats(personagem, armadura, arma, mana);
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                turno = false;
            }

            // ataque do inimigo
            else if (turno == false) {
                Random random = new Random();
                int escolhaInimigo = random.nextInt(5);
                App app = new App();

                if (escolhaInimigo == 0) {
                    if (defesa) {
                        clear.clearConsole();
                        pause.pauseConsole();
                        System.out.println("Voce se defendeu");
                        pause.pauseConsole();
                        double danoEfetivo = Math.max(2, inimigo.getDano() - armadura.getArmadura());
                        personagem.setPv(personagem.getPv() - danoEfetivo);
                        pause.pauseConsole();
                        clear.clearConsole();
                        if (personagem.getPv() <= 0) {
                            personagem.setPv(0);
                        }
                        defesa = false;
                    } else if (!defesa) {
                        clear.clearConsole();
                        System.out.println("Inimigo atacou");
                        personagem.setPv(personagem.getPv() - inimigo.getDano());

                        if (personagem.getPv() <= 0) {
                            personagem.setPv(0);
                        }
                        pause.pauseConsole();
                        clear.clearConsole();
                        defesa = false;
                    }

                    pause.pauseConsole();
                    clear.clearConsole();
                    app.showStats(personagem, armadura, arma, mana);
                    pause.pauseConsole();
                    clear.clearConsole();

                }

                else if (escolhaInimigo == 1) {
                    System.out.println("inimigo se defende");
                    defesaInimigo = true;
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                else if (escolhaInimigo == 2 || escolhaInimigo == 3 || escolhaInimigo == 4) {
                    clear.clearConsole();
                    System.out.println("Inimigo se curou");
                    inimigo.setPve(inimigo.getPve() + 5);
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                turno = true;
            }

        }

        if (inimigo.getPve() <= 0) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você foi derrotado!");
        }
    }

    // batalha 2
    public void initialBattle2(Inimigo inimigo, Personagem personagem) {
        Random whoEnemy = new Random();
        int qualInimigo = whoEnemy.nextInt(2);

        if (qualInimigo == 0) {
            clear.clearConsole();
            inimigo.setNome("John Dalton");
            inimigo.setPve(200);
            inimigo.setDefesa(25);
            inimigo.setAgilidade(10);
            inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                    inimigo.getAgilidade(), inimigo.getDano());
            pause.pauseConsole();
            clear.clearConsole();
        }

        else if (qualInimigo == 1) {
            clear.clearConsole();
            inimigo.setNome("Cadu da Zenith");
            inimigo.setPve(250);
            inimigo.setDefesa(30);
            inimigo.setAgilidade(3);
            inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                    inimigo.getAgilidade(), inimigo.getDano());
            pause.pauseConsole();
            clear.clearConsole();
        }
    }

    public void combateBattle2(Personagem personagem, Inimigo inimigo, Arma arma, Armadura armadura, Mana mana,
            Pocao pocao) {

        int escolha;
        boolean turno = true;
        boolean defesaInimigo = false;
        boolean defesa = false;
        boolean curaInimigo = false;

        if (personagem.getName() == "Mago Giras") {
            // LOGICA DA BATALHA COM MANA
            personagem.pvAnterior = personagem.getPv();
            if (inimigo.getAgilidade() >= personagem.getAgilidade()) {
                App app = new App();
                Random random = new Random();
                int escolhaInimigo = random.nextInt(5);
                personagem.setPv(personagem.getPv() - inimigo.getDano());
                clear.clearConsole();
                System.out.println("o inimigo lhe atacou");
                pause.pauseConsole();
                clear.clearConsole();
                app.showStats(personagem, armadura, arma, mana);
                pause.pauseConsole();
                clear.clearConsole();
                turno = true;
            }

            else if (personagem.getAgilidade() > inimigo.getAgilidade()) {
                System.out.println("1- Atacar");
                System.out.println("2- Defender");
                System.out.println("3- Poção");
                escolha = escolhaInput.LerNumero("->", 3);

                if (escolha == 1) {
                    inimigo.setPve(inimigo.getPve() - arma.getArma());
                    pause.pauseConsole();
                    clear.clearConsole();
                    inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                            inimigo.getAgilidade(), inimigo.getDano());
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                else if (escolha == 2) {
                    defesa = true;
                    System.out.println("Voce se defendeu...");

                }

                else if (escolha == 3) {
                    pocao.pocao(personagem);
                    if (pocao.getQuantidadePocao() <= 0) {
                        pocao.setQuantidadePocao(0);
                    }

                    pause.pauseConsole();
                    clear.clearConsole();
                    App.showStats(personagem, armadura, arma, mana);
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                turno = false;
            }
        }

        else {
            personagem.pvAnterior = personagem.getPv();
            if (inimigo.getAgilidade() >= personagem.getAgilidade()) {
                App app = new App();
                Random random = new Random();
                int escolhaInimigo = random.nextInt(5);
                personagem.setPv(personagem.getPv() - inimigo.getDano());
                clear.clearConsole();
                System.out.println("o inimigo lhe atacou");
                pause.pauseConsole();
                clear.clearConsole();
                app.showStats(personagem, armadura, arma, mana);
                pause.pauseConsole();
                clear.clearConsole();
                turno = true;
            }

            else if (personagem.getAgilidade() > inimigo.getAgilidade()) {
                System.out.println("1- Atacar");
                System.out.println("2- Defender");
                System.out.println("3- Poção");
                escolha = escolhaInput.LerNumero("->", 3);

                if (escolha == 1) {
                    inimigo.setPve(inimigo.getPve() - arma.getArma());
                    pause.pauseConsole();
                    clear.clearConsole();
                    inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                            inimigo.getAgilidade(), inimigo.getDano());
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                else if (escolha == 2) {
                    System.out.println("Voce se defendeu...");
                    defesa = true;
                }

                else if (escolha == 3) {
                    pocao.pocao(personagem);
                    
                    if (pocao.getQuantidadePocao() <= 0) {
                        pocao.setQuantidadePocao(0);
                    }

                    pause.pauseConsole();
                    clear.clearConsole();
                    App.showStats(personagem, armadura, arma, mana);
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                turno = false;
            }
        }
        while (inimigo.getPve() > 0 && personagem.getPv() > 0) {
            if (personagem.getName() == "Mago Giras") {
                personagem.pvAnterior = personagem.getPv();

                // **************************
                // LOGICA DA BATALHA COM MANA
                // **************************

                // ELE NAO TA ENTRANDO AQUI
                if (turno) {

                    System.out.println("1- Atacar");
                    System.out.println("2- Defender");
                    System.out.println("3- Poção");
                    escolha = escolhaInput.LerNumero("->", 3);

                    if (escolha == 1) {
                        if (defesaInimigo) {
                            System.out.println("Inimigo se defendeu");
                            inimigo.setDefesa(inimigo.getDefesa() - arma.getArma());

                            if (inimigo.getDefesa() <= 0) {
                                System.out.println("Inimigo se defendeu, porem nao tem mais escudo\nDano efetivo!");
                                inimigo.setPve(inimigo.getPve() - arma.getArma());
                            }

                            if (inimigo.getDefesa() <= 0) {
                                inimigo.setDefesa(0);
                            }
                            pause.pauseConsole();
                            clear.clearConsole();
                            defesaInimigo = false;
                        } else if (!defesaInimigo) {
                            inimigo.setPve(inimigo.getPve() - arma.getArma());
                            if (curaInimigo) {
                                Random random = new Random();
                                int efetivo = random.nextInt(6);
                                System.out.println("Inimigo se curou, porém voce lancou um feitiço nele e o envenenou");
                                System.out.println("\nPara ser efetivo, ira ser sorteado um dado de 6");
                                System.out.println("Se cair 4 pra cima, ira ser efetivo");
                                if (efetivo >= 4) {
                                    System.out.println("Dado: " + efetivo);
                                    System.out.println("Voce acertou o feitiço..\n");
                                    inimigo.setPve(inimigo.getPve() - 35);
                                    inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                                            inimigo.getAgilidade(), inimigo.getDano());
                                    System.out.println("\n Inimigo perdeu 35 de vida");
                                    pause.pauseConsole();
                                    clear.clearConsole();
                                } else {
                                    System.out.println("Dado: " + efetivo);
                                    System.out.println("Voce errou o feitiço");
                                    pause.pauseConsole();
                                    clear.clearConsole();
                                }
                            }
                            if (inimigo.getPve() <= 0) {
                                inimigo.setPve(0);
                            }
                            curaInimigo = false;
                            defesaInimigo = false;
                        }
                        pause.pauseConsole();
                        clear.clearConsole();
                        inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                                inimigo.getAgilidade(), inimigo.getDano());
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolha == 2) {
                        defesa = true;
                    }

                    else if (escolha == 3) {
                        pocao.pocao(personagem);
                        
                        if (pocao.getQuantidadePocao() <= 0) {
                            pocao.setQuantidadePocao(0);
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        App.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    turno = false;
                }

                // ataque do inimigo
                else if (turno == false) {
                    Random random = new Random();
                    int escolhaInimigo = random.nextInt(9);
                    App app = new App();

                    if (escolhaInimigo == 0 || escolhaInimigo == 1 || escolhaInimigo == 2 || escolhaInimigo == 3
                            || escolhaInimigo == 4 || escolhaInimigo == 5) {
                        // if (defesa) {
                        // clear.clearConsole();
                        // pause.pauseConsole();
                        // System.out.println("Voce se defendeu");
                        // pause.pauseConsole();
                        // double danoEfetivo = Math.max(0, inimigo.getDano() - armadura.getArmadura());
                        // personagem.setPv(personagem.getPv() - danoEfetivo);
                        // pause.pauseConsole();
                        // clear.clearConsole();
                        // if (personagem.getPv() <= 0) {
                        // personagem.setPv(0);
                        // }
                        // defesa = false;
                        // } else if (!defesa) {
                        // clear.clearConsole();
                        // System.out.println("Inimigo atacou");
                        // personagem.setPv(personagem.getPv() - inimigo.getDano());

                        // if (personagem.getPv() <= 0) {
                        // personagem.setPv(0);
                        // }
                        // pause.pauseConsole();
                        // clear.clearConsole();
                        // defesa = false;
                        // }

                        // pause.pauseConsole();
                        // clear.clearConsole();
                        // app.showStats(personagem, armadura, arma, mana);
                        // pause.pauseConsole();
                        // clear.clearConsole();

                        if (defesa) {
                            clear.clearConsole();
                            pause.pauseConsole();
                            System.out.println("Voce se defendeu");
                            pause.pauseConsole();
                            double danoEfetivo = Math.max(2, inimigo.getDano() - armadura.getArmadura());

                            personagem.setPv(personagem.getPv() - danoEfetivo);
                            pause.pauseConsole();
                            clear.clearConsole();
                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            defesa = false;
                        } else if (!defesa) {
                            clear.clearConsole();
                            System.out.println("Inimigo atacou");
                            personagem.setPv(personagem.getPv() - inimigo.getDano());

                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            pause.pauseConsole();
                            clear.clearConsole();
                            defesa = false;
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        app.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();

                    }

                    else if (escolhaInimigo == 6 || escolhaInimigo == 7) {
                        System.out.println("inimigo se defende");
                        defesaInimigo = true;
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolhaInimigo == 8) {
                        clear.clearConsole();
                        System.out.println("Inimigo se curou");
                        inimigo.setPve(inimigo.getPve() + 5);
                        pause.pauseConsole();
                        clear.clearConsole();
                        curaInimigo = true;
                    }

                    turno = true;
                }
            }

            else {
                personagem.pvAnterior = personagem.getPv();
                if (turno) {

                    System.out.println("1- Atacar");
                    System.out.println("2- Defender");
                    System.out.println("3- Poção");
                    escolha = escolhaInput.LerNumero("->", 3);

                    if (escolha == 1) {
                        if (defesaInimigo) {
                            System.out.println("Inimigo se defendeu");
                            inimigo.setDefesa(inimigo.getDefesa() - arma.getArma());

                            if (inimigo.getDefesa() <= 0) {
                                System.out.println("Inimigo se defendeu, porem nao tem mais escudo\nDano efetivo!");
                                inimigo.setPve(inimigo.getPve() - arma.getArma());
                            }

                            if (inimigo.getDefesa() <= 0) {
                                inimigo.setDefesa(0);
                            }
                            pause.pauseConsole();
                            clear.clearConsole();
                            defesaInimigo = false;
                        } else if (!defesaInimigo) {
                            inimigo.setPve(inimigo.getPve() - arma.getArma());
                            if (inimigo.getPve() <= 0) {
                                inimigo.setPve(0);
                            }
                            defesaInimigo = false;
                        }
                        pause.pauseConsole();
                        clear.clearConsole();
                        inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                                inimigo.getAgilidade(), inimigo.getDano());
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolha == 2) {
                        defesa = true;
                    }

                    else if (escolha == 3) {
                        pocao.pocao(personagem);
                        
                        if (pocao.getQuantidadePocao() <= 0) {
                            pocao.setQuantidadePocao(0);
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        App.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    turno = false;
                }

                // ataque do inimigo
                else if (turno == false) {
                    Random random = new Random();
                    int escolhaInimigo = random.nextInt(9);
                    App app = new App();

                    if ((escolhaInimigo == 0 || escolhaInimigo == 1 || escolhaInimigo == 2 || escolhaInimigo == 3
                            || escolhaInimigo == 4 || escolhaInimigo == 5)) {
                        // if (defesa) {
                        // clear.clearConsole();
                        // pause.pauseConsole();
                        // System.out.println("Voce se defendeu");
                        // pause.pauseConsole();
                        // double danoEfetivo = Math.max(0, inimigo.getDano() - armadura.getArmadura());
                        // personagem.setPv(personagem.getPv() - danoEfetivo);

                        // if (personagem.getPv() <= 0) {
                        // personagem.setPv(0);
                        // }
                        // defesa = false;
                        // } else if (!defesa) {
                        // clear.clearConsole();
                        // System.out.println("Inimigo atacou");
                        // personagem.setPv(personagem.getPv() - inimigo.getDano());

                        // if (personagem.getPv() <= 0) {
                        // personagem.setPv(0);
                        // }
                        // defesa = false;
                        // }

                        // pause.pauseConsole();
                        // clear.clearConsole();
                        // app.showStats(personagem, armadura, arma, mana);
                        // pause.pauseConsole();
                        // clear.clearConsole();

                        if (defesa) {
                            clear.clearConsole();
                            pause.pauseConsole();
                            System.out.println("Voce se defendeu");
                            pause.pauseConsole();
                            double danoEfetivo = Math.max(2, inimigo.getDano() - armadura.getArmadura());

                            personagem.setPv(personagem.getPv() - danoEfetivo);
                            pause.pauseConsole();
                            clear.clearConsole();
                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            defesa = false;
                        } else if (!defesa) {
                            clear.clearConsole();
                            System.out.println("Inimigo atacou");
                            personagem.setPv(personagem.getPv() - inimigo.getDano());

                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            pause.pauseConsole();
                            clear.clearConsole();
                            defesa = false;
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        app.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();

                    }

                    else if (escolhaInimigo == 6 || escolhaInimigo == 7) {
                        System.out.println("inimigo se defende");
                        defesaInimigo = true;
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolhaInimigo == 8) {
                        clear.clearConsole();
                        System.out.println("Inimigo se curou");
                        inimigo.setPve(inimigo.getPve() + 5);
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    turno = true;
                }

            }

        }

        if (inimigo.getPve() <= 0) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você foi derrotado!");
        }
    }

    public void initialBattle3(Inimigo inimigo, Personagem personagem) {
        clear.clearConsole();
        inimigo.setNome("Ramon o Descoloridor");
        inimigo.setPve(300);
        inimigo.setDefesa(55);
        inimigo.setAgilidade(80);
        inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                inimigo.getAgilidade(), inimigo.getDano());
        pause.pauseConsole();
        clear.clearConsole();
    }
    
//parte 3
    public void combateBattle3(Personagem personagem, Inimigo inimigo, Arma arma, Armadura armadura, Mana mana,
            Pocao pocao) {

        int escolha;
        boolean turno = true;
        boolean defesaInimigo = false;
        boolean defesa = false;
        boolean curaInimigo = false;

        if (personagem.getName() == "Mago Giras") {
            personagem.pvAnterior = personagem.getPv();
            // LOGICA DA BATALHA COM MANA
            System.out.println("Voce eh um mago");
            if (inimigo.getAgilidade() >= personagem.getAgilidade()) {
                App app = new App();
                Random random = new Random();
                int escolhaInimigo = random.nextInt(5);
                personagem.setPv(personagem.getPv() - inimigo.getDano());
                clear.clearConsole();
                System.out.println("o inimigo lhe atacou");
                pause.pauseConsole();
                clear.clearConsole();
                app.showStats(personagem, armadura, arma, mana);
                pause.pauseConsole();
                clear.clearConsole();
                turno = true;
            }

            else if (personagem.getAgilidade() > inimigo.getAgilidade()) {
                System.out.println("1- Atacar");
                System.out.println("2- Defender");
                System.out.println("3- Poção");
                escolha = escolhaInput.LerNumero("->", 3);

                if (escolha == 1) {
                    inimigo.setPve(inimigo.getPve() - arma.getArma());
                    pause.pauseConsole();
                    clear.clearConsole();
                    inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                            inimigo.getAgilidade(), inimigo.getDano());
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                else if (escolha == 2) {
                    System.out.println("Voce se defendeu...");
                    defesa = true;
                }

                else if (escolha == 3) {

                    pocao.pocao(personagem);
                    
                    if (pocao.getQuantidadePocao() <= 0) {
                        pocao.setQuantidadePocao(0);
                    }

                    pause.pauseConsole();
                    clear.clearConsole();
                    App.showStats(personagem, armadura, arma, mana);
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                turno = false;
            }
        }

        else {
            personagem.pvAnterior = personagem.getPv();
            if (inimigo.getAgilidade() >= personagem.getAgilidade()) {
                App app = new App();
                Random random = new Random();
                int escolhaInimigo = random.nextInt(5);
                personagem.setPv(personagem.getPv() - inimigo.getDano());
                clear.clearConsole();
                System.out.println("o inimigo lhe atacou");
                pause.pauseConsole();
                clear.clearConsole();
                app.showStats(personagem, armadura, arma, mana);
                pause.pauseConsole();
                clear.clearConsole();
                turno = true;
            }

            else if (personagem.getAgilidade() > inimigo.getAgilidade()) {
                System.out.println("1- Atacar");
                System.out.println("2- Defender");
                System.out.println("3- Poção");
                escolha = escolhaInput.LerNumero("->", 3);

                if (escolha == 1) {
                    inimigo.setPve(inimigo.getPve() - arma.getArma());
                    pause.pauseConsole();
                    clear.clearConsole();
                    inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                            inimigo.getAgilidade(), inimigo.getDano());
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                else if (escolha == 2) {
                    System.out.println("Voce se defendeu...");
                    defesa = true;
                }

                else if (escolha == 3) {
                    pocao.pocao(personagem);
                    
                    if (pocao.getQuantidadePocao() <= 0) {
                        pocao.setQuantidadePocao(0);
                    }

                    pause.pauseConsole();
                    clear.clearConsole();
                    App.showStats(personagem, armadura, arma, mana);
                    pause.pauseConsole();
                    clear.clearConsole();
                }

                turno = false;
            }
        }
        while (inimigo.getPve() > 0 && personagem.getPv() > 0) {
            if (personagem.getName() == "Mago Giras") {
                personagem.pvAnterior = personagem.getPv();
                // **************************
                // LOGICA DA BATALHA COM MANA
                // **************************

                // ELE NAO TA ENTRANDO AQUI
                if (turno) {

                    System.out.println("1- Atacar");
                    System.out.println("2- Defender");
                    System.out.println("3- Poção");
                    escolha = escolhaInput.LerNumero("->", 3);

                    if (escolha == 1) {
                        if (defesaInimigo) {
                            System.out.println("Inimigo se defendeu");
                            inimigo.setDefesa(inimigo.getDefesa() - arma.getArma());

                            if (inimigo.getDefesa() <= 0) {
                                System.out.println("Inimigo se defendeu, porem nao tem mais escudo\nDano efetivo!");
                                inimigo.setPve(inimigo.getPve() - arma.getArma());
                            }

                            if (inimigo.getDefesa() <= 0) {
                                inimigo.setDefesa(0);
                            }
                            pause.pauseConsole();
                            clear.clearConsole();
                            defesaInimigo = false;
                        } else if (!defesaInimigo) {
                            inimigo.setPve(inimigo.getPve() - arma.getArma());
                            if (curaInimigo) {
                                Random random = new Random();
                                int efetivo = random.nextInt(6);
                                System.out.println("Inimigo se curou, porém voce lancou um feitiço nele e o envenenou");
                                System.out.println("\nPara ser efetivo, ira ser sorteado um dado de 6");
                                System.out.println("Se cair 4 pra cima, ira ser efetivo");
                                if (efetivo >= 4) {
                                    System.out.println("Dado: " + efetivo);
                                    System.out.println("Voce acertou o feitiço..\n");
                                    inimigo.setPve(inimigo.getPve() - 35);
                                    inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                                            inimigo.getAgilidade(), inimigo.getDano());
                                    System.out.println("\n Inimigo perdeu 35 de vida");
                                    pause.pauseConsole();
                                    clear.clearConsole();
                                } else {
                                    System.out.println("Dado: " + efetivo);
                                    System.out.println("Voce errou o feitiço");
                                    pause.pauseConsole();
                                    clear.clearConsole();
                                }
                            }
                            if (inimigo.getPve() <= 0) {
                                inimigo.setPve(0);
                            }
                            curaInimigo = false;
                            defesaInimigo = false;
                        }
                        pause.pauseConsole();
                        clear.clearConsole();
                        inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                                inimigo.getAgilidade(), inimigo.getDano());
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolha == 2) {
                        defesa = true;
                    }

                    else if (escolha == 3) {
                        pocao.pocao(personagem);
                        
                        if (pocao.getQuantidadePocao() <= 0) {
                            pocao.setQuantidadePocao(0);
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        App.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    turno = false;
                }

                // ataque do inimigo
                else if (turno == false) {
                    Random random = new Random();
                    int escolhaInimigo = random.nextInt(9);
                    App app = new App();

                    if (escolhaInimigo == 0 || escolhaInimigo == 1 || escolhaInimigo == 2 || escolhaInimigo == 3
                            || escolhaInimigo == 4) {
                        // if (defesa) {
                        // clear.clearConsole();
                        // pause.pauseConsole();
                        // System.out.println("Voce se defendeu");
                        // pause.pauseConsole();
                        // double danoEfetivo = Math.max(0, inimigo.getDano() - armadura.getArmadura());
                        // personagem.setPv(personagem.getPv() - danoEfetivo);
                        // pause.pauseConsole();
                        // clear.clearConsole();
                        // if (personagem.getPv() <= 0) {
                        // personagem.setPv(0);
                        // }
                        // defesa = false;
                        // } else if (!defesa) {
                        // clear.clearConsole();
                        // System.out.println("Inimigo atacou");
                        // personagem.setPv(personagem.getPv() - inimigo.getDano());

                        // if (personagem.getPv() <= 0) {
                        // personagem.setPv(0);
                        // }
                        // pause.pauseConsole();
                        // clear.clearConsole();
                        // defesa = false;
                        // }

                        // pause.pauseConsole();
                        // clear.clearConsole();
                        // app.showStats(personagem, armadura, arma, mana);
                        // pause.pauseConsole();
                        // clear.clearConsole();

                        if (defesa) {
                            clear.clearConsole();
                            pause.pauseConsole();
                            System.out.println("Voce se defendeu");
                            pause.pauseConsole();
                            double danoEfetivo = Math.max(2, inimigo.getDano() - armadura.getArmadura());

                            personagem.setPv(personagem.getPv() - danoEfetivo);
                            pause.pauseConsole();
                            clear.clearConsole();
                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            defesa = false;
                        } else if (!defesa) {
                            clear.clearConsole();
                            System.out.println("Inimigo atacou");
                            personagem.setPv(personagem.getPv() - inimigo.getDano());

                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            pause.pauseConsole();
                            clear.clearConsole();
                            defesa = false;
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        app.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();

                    }

                    else if (escolhaInimigo == 5 || escolhaInimigo == 6 || escolhaInimigo == 7) {
                        System.out.println("inimigo se defende");
                        defesaInimigo = true;
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolhaInimigo == 8) {
                        clear.clearConsole();
                        System.out.println("Inimigo se curou");
                        inimigo.setPve(inimigo.getPve() + 5);
                        pause.pauseConsole();
                        clear.clearConsole();
                        curaInimigo = true;
                    }

                    turno = true;
                }
            }

            else {
                personagem.pvAnterior = personagem.getPv();
                if (turno) {

                    System.out.println("1- Atacar");
                    System.out.println("2- Defender");
                    System.out.println("3- Poção");
                    escolha = escolhaInput.LerNumero("->", 3);

                    if (escolha == 1) {
                        if (defesaInimigo) {
                            System.out.println("Inimigo se defendeu");
                            inimigo.setDefesa(inimigo.getDefesa() - arma.getArma());

                            if (inimigo.getDefesa() <= 0) {
                                System.out.println("Inimigo se defendeu, porem nao tem mais escudo\nDano efetivo!");
                                inimigo.setPve(inimigo.getPve() - arma.getArma());
                            }

                            if (inimigo.getDefesa() <= 0) {
                                inimigo.setDefesa(0);
                            }
                            pause.pauseConsole();
                            clear.clearConsole();
                            defesaInimigo = false;
                        } else if (!defesaInimigo) {
                            inimigo.setPve(inimigo.getPve() - arma.getArma());
                            if (inimigo.getPve() <= 0) {
                                inimigo.setPve(0);
                            }
                            defesaInimigo = false;
                        }
                        pause.pauseConsole();
                        clear.clearConsole();
                        inimigo.showStatsEnemy(inimigo.getNome(), inimigo.getPve(), inimigo.getDefesa(),
                                inimigo.getAgilidade(), inimigo.getDano());
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolha == 2) {
                        defesa = true;
                    }

                    else if (escolha == 3) {
                        pocao.pocao(personagem);
                        
                        if (pocao.getQuantidadePocao() <= 0) {
                            pocao.setQuantidadePocao(0);
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        App.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    turno = false;
                }

                // ataque do inimigo
                else if (turno == false) {
                    Random random = new Random();
                    int escolhaInimigo = random.nextInt(9);
                    App app = new App();

                    if ((escolhaInimigo == 0 || escolhaInimigo == 1 || escolhaInimigo == 2 || escolhaInimigo == 3
                            || escolhaInimigo == 4 || escolhaInimigo == 5)) {
                        if (defesa) {
                            clear.clearConsole();
                            pause.pauseConsole();
                            System.out.println("Voce se defendeu");
                            pause.pauseConsole();
                            double danoEfetivo = Math.max(2, inimigo.getDano() - armadura.getArmadura());

                            personagem.setPv(personagem.getPv() - danoEfetivo);

                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            defesa = false;
                        } else if (!defesa) {
                            clear.clearConsole();
                            System.out.println("Inimigo atacou");
                            personagem.setPv(personagem.getPv() - inimigo.getDano());

                            if (personagem.getPv() <= 0) {
                                personagem.setPv(0);
                            }
                            defesa = false;
                        }

                        pause.pauseConsole();
                        clear.clearConsole();
                        app.showStats(personagem, armadura, arma, mana);
                        pause.pauseConsole();
                        clear.clearConsole();

                    }

                    else if (escolhaInimigo == 6 || escolhaInimigo == 7) {
                        System.out.println("inimigo se defende");
                        defesaInimigo = true;
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    else if (escolhaInimigo == 8) {
                        clear.clearConsole();
                        System.out.println("Inimigo se curou");
                        inimigo.setPve(inimigo.getPve() + 5);
                        pause.pauseConsole();
                        clear.clearConsole();
                    }

                    turno = true;
                }

            }

        }

        if (inimigo.getPve() <= 0) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você foi derrotado!");
            personagem.resetStats();
        }
    }

}