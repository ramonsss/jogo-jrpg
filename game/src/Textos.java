import console.*;

public class Textos {
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

        ClearConsole clear = new ClearConsole();
        PauseConsole pause = new PauseConsole();
        Personagem personagem = new Personagem();

        public void history() {
                clear.clearConsole();
                System.out.println("A Floresta Cromática e o Destino das cores:\n");
                pause.pauseConsole();
                clear.clearConsole();
                System.out.println(
                                "Em um reino distante, cercado por montanhas e rios cintilantes, havia uma floresta mágica conhecida como a Floresta Cromática.");
                System.out.println(
                                "Diziam que essa floresta era tão colorida que até os arco-íris sentiam inveja de suas árvores, cujas folhas brilhavam em todos os tons ");
                System.out.println(
                                "possíveis e impossíveis. \nMas, ironicamente, os defensores escolhidos para proteger essa beleza natural tinham uma característica peculiar:");
                System.out.println("   ");
                System.out.println("eram todos daltônicos.");
                System.out.println("\n");
                pause.pauseConsole();
                clear.clearConsole();
                System.out.println(
                                "A missão desses guardiões era simples evitar que qualquer ameaça as cores belas da Floresta Cromática.");
                System.out.println(
                                "O problema era que, para eles, a distinção entre o desbotado e o vibrante não era lá muito claro.");
                System.out
                                .println("Vermelhos parecem verdes, azuis roxos, e o que quer que fosse dourado ou prateado….");
                System.out.println("\n");
                pause.pauseConsole();
                clear.clearConsole();
                System.out.println("Um dia, uma nova ameaça surgiu.");
                System.out.println(
                                "A lenda falava de um ser terrível chamado o Ramon O DESCOLORIDO, uma criatura que se alimentava das cores da natureza");
                System.out.println("deixando tudo cinza e sem vida.");
                System.out.println(
                                "Determinados a impedir essa tragédia, os guardiões daltônicos enviaram um guerreiro para salvar as cores.");
                System.out.println("\n");
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void textoInicial() {
                clear.clearConsole();
                System.out.println(RED + "---------------------------------" + RESET);
                System.out.println(GREEN + "Seja bem vindo ao mundo colorido" + RESET);
                System.out.println(BLUE + "---------------------------------" + RESET);
                System.out.println("\nIrei ser seu mentor nesta jornada");
                System.out
                                .println("\nMe chamo " + YELLOW + "QWERTY " + RESET
                                                + "cortela, espero que lembre de mim um dia...\n");
                System.out.println("              ,-----.");
                System.out.println("            W/,-. ,-\\.W");
                System.out.println("            ()>a   a<()");
                System.out.println("            (.--(_)--.)");
                System.out.println("          ,'/.-'\\_/`-\\.`,");
                System.out.println("        ,' /    `-'    \\ `.");
                System.out.println("       /   \\           /   \\");
                System.out.println("      /     `.       ,'     \\");
                System.out.println("     /    /   `-._.-'   \\    \\");
                System.out.println("   ,-`-._/|     |=|o    |\\_.-<");
                System.out.println("  <,--.)  |_____| |o____|  )_ \\");
                System.out.println("   `-)|    |//   _   \\\\|     )/");
                System.out.println("     ||    |'    |    `|");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    (    )|(    )");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |_.--.|.--._|");
                System.out.println("     ||     /'\"\"| |\"\"`\\");
                System.out.println("     []     `===' `==='  hjw");

                pause.pauseConsole();
                clear.clearConsole();
        }

        public void inimigo1() {
                clear.clearConsole();
                System.out.println("--------------------------------------------------\n");
                System.out.println(RED + "@@@@@@@@   @@@@@@    @@@@@@   @@@@@@@@       @@@");
                System.out.println("@@@@@@@@  @@@@@@@@  @@@@@@@   @@@@@@@@      @@@@");
                System.out.println("@@!       @@!  @@@  !@@       @@!          @@@!!");
                System.out.println("!@!       !@!  @!@  !@!       !@!            !@!");
                System.out.println("@!!!:!    @!@!@!@!  !!@@!!    @!!!:!         @!@");
                System.out.println("!!!!!:    !!!@!!!!   !!@!!!   !!!!!:         !@!");
                System.out.println("!!:       !!:  !!!       !:!  !!:            !!:");
                System.out.println(":!:       :!:  !:!      !:!   :!:            :!:");
                System.out.println(" ::       ::   :::  :::: ::    :: ::::       :::");
                System.out.println(" :         :   : :  :: : :    : :: ::         ::");
                System.out.println("--------------------------------------------------" + RESET);
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void inimigo2() {
                clear.clearConsole();
                System.out.println(BLUE + "@@@@@@@   @@@@@@    @@@@@@   @@@@@@@@      @@@@@@  ");
                System.out.println("@@@@@@@  @@@@@@@@  @@@@@@@   @@@@@@@@     @@@@@@@@ ");
                System.out.println("@@!       @@!  @@@  !@@       @@!               @@@ ");
                System.out.println("!@!       !@!  @!@  !@!       !@!              @!@  ");
                System.out.println("@!!!:!    @!@!@!@!  !!@@!!    @!!!:!          !!@   ");
                System.out.println("!!!!!:    !!!@!!!!   !!@!!!   !!!!!:         !!:    ");
                System.out.println("!!:       !!:  !!!       !:!  !!:           !:!     ");
                System.out.println(":!:       :!:  !:!      !:!   :!:          :!:      ");
                System.out.println(" ::       ::   :::  :::: ::    :: ::::     :: ::::: ");
                System.out.println(" :         :   : :  :: : :    : :: ::      :: : :::  " + RESET);
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void inimigo3() {
                clear.clearConsole();
                System.out.println(YELLOW + "@@@@@@@   @@@@@@    @@@@@@   @@@@@@@@     @@@@@@  ");
                System.out.println("@@@@@@@  @@@@@@@@  @@@@@@@   @@@@@@@@     @@@@@@@ ");
                System.out.println("@@!       @@!  @@@  !@@       @@!              @@@ ");
                System.out.println("!@!       !@!  @!@  !@!       !@!              @!@ ");
                System.out.println("@!!!:!    @!@!@!@!  !!@@!!    @!!!:!       @!@!!@  ");
                System.out.println("!!!!!:    !!!@!!!!   !!@!!!   !!!!!:       !!@!@!  ");
                System.out.println("!!:       !!:  !!!       !:!  !!:              !!: ");
                System.out.println(":!:       :!:  !:!      !:!   :!:              :!: ");
                System.out.println(" ::       ::   :::  :::: ::    :: ::::     :: :::: ");
                System.out.println(" :         :   : :  :: : :    : :: ::       : : :   " + RESET);
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void faceInimigo1() {
                System.out.println(GREEN + "                       __..._");
                System.out.println("                    ,-`      `',");
                System.out.println("                  ,'            \\");
                System.out.println("                 /               |");
                System.out.println("               ,'       ,        \\");
                System.out.println("             ,'       ,/-'`       \\");
                System.out.println("         _ ./     ,.'`/            \\");
                System.out.println("      .-` `^\\_,.'`   /              `\\__");
                System.out.println("      7     /       /   _,._,.,_,.-'.`  `\\");
                System.out.println("      \\A  __/   ,-```-``   `,   `,   `  ,`)");
                System.out.println("        ^-`    /      `                 ,/     ");
                System.out.println("               (        ,   ,_   ,-,_,<`       ");
                System.out.println("                \\__ T--` `''` ```    _,\\");
                System.out.println("                  \\_/|\\_         ,.-` | |");
                System.out.println("                  _/ | |T\\_   _,'Y    / +--,_");
                System.out.println("              <```   \\_\\/_/  `\\\\_/   /       `\\");
                System.out.println("              /  ,--   ` _,--,_`----`   _,,_   \\");
                System.out.println("             /  ` |     <_._._ >       `  \\ `  \\`");
                System.out.println("            |     |       ,   `           |     |");
                System.out.println("             V|   \\       |                |   |`");
                System.out.println("              \\    \\      /               /    /");
                System.out.println("               \\x   \\_   |             /-`    /");
                System.out.println("                 \\    `-,|        ,/--`     /`");
                System.out.println("                  \\x_    \\_  /--'`       , /");
                System.out.println("                     \\x_   ``        ,,/` `");
                System.out.println("                        `-,_,-'   ,'`");
                System.out.println("                         _|       |`\\");
                System.out.println("                        ( `-``/``/`_/");
                System.out.println("                         `-`-,.-.-`" + RESET);
                System.out.println("MUAHAHAHAHAHAHA");
                System.out.println(
                                "Voces realmente acham que podem se livrar de mim tão facilmente?, VENCEREI VOCE " + RED
                                                + "SO UM BITZINHO" + RESET);
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void faceInimigo2() {
                clear.clearConsole();

                System.out.println("              ,-----.");
                System.out.println("            W/,-. ,-\\.W");
                System.out.println("            ()>a   a<()");
                System.out.println("            (.--(_)--.)");
                System.out.println("          ,'/.-'\\_/`-\\.`,");
                System.out.println("        ,' /    `-'    \\ `.");
                System.out.println("       /   \\           /   \\");
                System.out.println("      /     `.       ,'     \\");
                System.out.println("     /    /   `-._.-'   \\    \\");
                System.out.println("   ,-`-._/|     |=|o    |\\_.-<");
                System.out.println("  <,--.)  |_____| |o____|  )_ \\");
                System.out.println("   `-)|    |//   _   \\\\|     )/");
                System.out.println("     ||    |'    |    `|");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    (    )|(    )");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |_.--.|.--._|");
                System.out.println("     ||     /'\"\"| |\"\"`\\");
                System.out.println("     []     `===' `==='  hjw");
                System.out.println("Pelo visto voce conseguiu derrotar aquele cara irritante...\n");
                System.out.println("Acho que voce feriu o ego do mestre dele...");
                pause.pauseConsole();
                clear.clearConsole();

                System.out.println("   :\\                  ");
                System.out.println("                                            ;\\\\                 ");
                System.out.println("                                            ; ;;  __            ");
                System.out.println("                                            :/ :-\",dP    _.ggp. ");
                System.out.println("                                            :     (*).-\"\" :$$$$;");
                System.out.println("                                            ;              T$$$;");
                System.out.println("                                           :     _,-        `TP ");
                System.out.println("                                           ;      `.  _      ;  ");
                System.out.println("                                           ;        \"\" \\    /   ");
                System.out.println("                                           ;            `-+'    ");
                System.out.println("                                            :            .-'     ");
                System.out.println("                                            ;      \\;   ;       ");
                System.out.println("                                            :       `--+'-.     ");
                System.out.println(" .---.                                       ;         ;`       ");
                System.out.println(":_    `.                                     :         ;        ");
                System.out.println("  \"-,,   ;                                   / \"-.      :        ");
                System.out.println("     ;  :                                .p\"\"\"-.  \"\"--..:        ");
                System.out.println("     ;  :                             .-T$$P   \"\"--..___l-,     ");
                System.out.println("     ;  :                          .-\"   \"\"            :\\()l    ");
                System.out.println("     ;  ;              _________.-\"         $$          ;`-'    ");
                System.out.println("     ;  ; bug     .--\"\"$$$$$$$P                         :       ");
                System.out.println("     ;  '._____.-\"_.   'T$$P^'                          :       ");
                System.out.println("     :         .-\"                                 \\    :       ");
                System.out.println("     '.___...-\"                                     ;   :       ");
                System.out.println("           /                                        ;   ;       ");
                System.out.println("          :                   .            /       /   /        ");
                System.out.println("          ;                 .J__          :       /  .'         ");
                System.out.println("          ;               .;    \"-.       ;      j.-\"           ");
                System.out.println("          :             .'/        \"-.    ;     : :             ");
                System.out.println("           ;          .' /            \"---:     ; ;             ");
                System.out.println("           :       .-\"  /                 :    : :              ");
                System.out.println("           ;    .-\"  .-\"                   ;   ; ;              ");
                System.out.println("          /   .'  .-\"                      :  : :               ");
                System.out.println("         /  .'  .'                         :  | ;               ");
                System.out.println("        :  /\\  :                           :  ;:                ");
                System.out.println("        ; :  ; ;                           : : ;                ");
                System.out.println("       :  ;  : :__                         ; | :                ");
                System.out.println("       ; _L__J   -`,                      :  : '--.             ");
                System.out.println("       :  l l l____l                       \\ _`-,-:             ");
                System.out.println("      ( l ;_:-'                            /  l |`;             ");
                System.out.println("       \"\"\"                                :_l :_;_l             ");
                System.out.println("                                             \"                   ");
                System.out.println(
                                "Vocês acham que podem me derrotar? Por favor, isso é tão sem graça quanto um filme em preto e branco!");
                System.out.println("SO UM BITZINHO e tudo será meu!\n" +
                                "O que você vai fazer? Pintar a floresta de cinza? SALSICHAA!!!!!");
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void faceInimigo3() {

                clear.clearConsole();

                System.out.println("              ,-----.");
                System.out.println("            W/,-. ,-\\.W");
                System.out.println("            ()>a   a<()");
                System.out.println("            (.--(_)--.)");
                System.out.println("          ,'/.-'\\_/`-\\.`,");
                System.out.println("        ,' /    `-'    \\ `.");
                System.out.println("       /   \\           /   \\");
                System.out.println("      /     `.       ,'     \\");
                System.out.println("     /    /   `-._.-'   \\    \\");
                System.out.println("   ,-`-._/|     |=|o    |\\_.-<");
                System.out.println("  <,--.)  |_____| |o____|  )_ \\");
                System.out.println("   `-)|    |//   _   \\\\|     )/");
                System.out.println("     ||    |'    |    `|");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    (    )|(    )");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |_.--.|.--._|");
                System.out.println("     ||     /'\"\"| |\"\"`\\");
                System.out.println("     []     `===' `==='  hjw");
                System.out.println("Pelo visto voce conseguiu derrotar o filho do Mestre...\n");
                System.out.println("Ele nao vai gostar nada disso, se prepare melhor para essa batalha...");
                pause.pauseConsole();

                clear.clearConsole();
                System.out.println("  +-------------+                     ___        |      |      |    ");
                System.out.println("  |             |                     \\ /]       |      |      |    ");
                System.out.println("  |             |        _           _(_)        |      |      |    ");
                System.out.println("  |             |     ___))         [  | \\___    |      |      |    ");
                System.out.println("  |             |     ) //o          | |     \\   |      |      |    ");
                System.out.println("  |             |  _ (_    >         | |      ]  |      |      |    ");
                System.out.println("  |          __ | (O)  \\__<          | | ____/   '------'------'    ");
                System.out.println("  |         /  o| [/] /   \\)        [__|/_                          ");
                System.out.println("  |             | [\\]|  ( \\         __/___\\_____                    ");
                System.out.println("  |             | [/]|   \\ \\__  ___|            |                   ");
                System.out.println("  |             | [\\]|    \\___E/%%/|____________|_____              ");
                System.out.println("  |             | [/]|=====__   (_____________________)             ");
                System.out.println("  |             | [\\] \\_____ \\    |                  |              ");
                System.out.println("  |             | [/========\\ |   |                  |              ");
                System.out.println("  |             | [\\]     []| |   |                  |              ");
                System.out.println("  |             | [/]     []| |_  |                  |              ");
                System.out.println("  |             | [\\]     []|___) |                  |    MEPH      ");
                System.out.println("====================================================================");
                System.out.println("Ahh então eh voce que esta derrotando meus Alunos, VOCE NAO SERA PÁREO PARA MIM");
                System.out.println("Eu domino todas as cores obscuras desse mundo");
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void finalFrase() {

                clear.clearConsole();

                System.out.println("              ,-----.");
                System.out.println("            W/,-. ,-\\.W");
                System.out.println("            ()>a   a<()");
                System.out.println("            (.--(_)--.)");
                System.out.println("          ,'/.-'\\_/`-\\.`,");
                System.out.println("        ,' /    `-'    \\ `.");
                System.out.println("       /   \\           /   \\");
                System.out.println("      /     `.       ,'     \\");
                System.out.println("     /    /   `-._.-'   \\    \\");
                System.out.println("   ,-`-._/|     |=|o    |\\_.-<");
                System.out.println("  <,--.)  |_____| |o____|  )_ \\");
                System.out.println("   `-)|    |//   _   \\\\|     )/");
                System.out.println("     ||    |'    |    `|");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    (    )|(    )");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |_.--.|.--._|");
                System.out.println("     ||     /'\"\"| |\"\"`\\");
                System.out.println("     []     `===' `==='  hjw");
                System.out.println("UAUUU voce conseguiu derrotar o Mestre...\n");
                System.out.println(
                                "\n\nFinalmente voce conseguiu seu oculos de volta, e podera salvar todos NESSE REINO CINZA");
                System.out.println("");
                pause.pauseConsole();

                clear.clearConsole();

                System.out.println(RED
                                + "                        ..++@@######################mm::                                ..++MM################@@++::"
                                + RESET);
                System.out.println(GREEN
                                + "                  MM########################################@@::                ::@@######################################mm"
                                + RESET);
                System.out.println(BLUE
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(MAGENTA
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(CYAN
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(WHITE
                                + "                  mm########################################################################################################.."
                                + RESET);
                System.out.println(YELLOW
                                + "                    ################################################        ################################################"
                                + RESET);
                System.out.println(BLACK
                                + "                    ################################################        ################################################"
                                + RESET);
                System.out.println(RED
                                + "                    ################################################        ##############################################.."
                                + RESET);
                System.out.println(GREEN
                                + "                    ++############################################          ##############################################"
                                + RESET);
                System.out.println(BLUE
                                + "                      ############################################            ############################################"
                                + RESET);
                System.out.println(MAGENTA
                                + "                      ##########################################--            ############################################"
                                + RESET);
                System.out.println(CYAN
                                + "                      ##########################################              --########################################::"
                                + RESET);
                System.out.println(WHITE
                                + "                      ::######################################--                ########################################"
                                + RESET);
                System.out.println(YELLOW
                                + "                        ######################################                  --######################################"
                                + RESET);
                System.out.println(BLACK
                                + "                        MM##################################                      @@##################################.."
                                + RESET);
                System.out.println(RED
                                + "                          ################################++                        ################################@@ "
                                + RESET);
                System.out.println(GREEN
                                + "                            ############################mm                            ##############################"
                                + RESET);
                System.out.println(BLUE
                                + "                              @@######################..                                MM######################++"
                                + RESET);
                System.out.println(MAGENTA
                                + "                                  --mm########@@++                                          ::MM########@@++.."
                                + RESET);

                System.out.println(
                                "MEU DEUSSSSS EU FINALMENTE ENXERGO DE NOVO AS CORES, AGORA EU RELEMBRO A TRIBO DO SO UM BITZINHO\n");
                System.out.println("MEU DEUS MINHAS MAGIAS SAO CORES DIFERENTES! muito obrigado CORTELA!!!");
                pause.pauseConsole();

                clear.clearConsole();

                System.out.println("              ,-----.");
                System.out.println("            W/,-. ,-\\.W");
                System.out.println("            ()>a   a<()");
                System.out.println("            (.--(_)--.)");
                System.out.println("          ,'/.-'\\_/`-\\.`,");
                System.out.println("        ,' /    `-'    \\ `.");
                System.out.println("       /   \\           /   \\");
                System.out.println("      /     `.       ,'     \\");
                System.out.println("     /    /   `-._.-'   \\    \\");
                System.out.println("   ,-`-._/|     |=|o    |\\_.-<");
                System.out.println("  <,--.)  |_____| |o____|  )_ \\");
                System.out.println("   `-)|    |//   _   \\\\|     )/");
                System.out.println("     ||    |'    |    `|");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    (    )|(    )");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |_.--.|.--._|");
                System.out.println("     ||     /'\"\"| |\"\"`\\");
                System.out.println("     []     `===' `==='  hjw");
                System.out.println("De nada meu filho, minha missao foi concluida...\n");

                pause.pauseConsole();
                clear.clearConsole();

                System.out.println(RED
                                + "                        ..++@@######################mm::                                ..++MM################@@++::"
                                + RESET);
                System.out.println(GREEN
                                + "                  MM########################################@@::                ::@@######################################mm"
                                + RESET);
                System.out.println(BLUE
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(MAGENTA
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(CYAN
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(WHITE
                                + "                  mm########################################################################################################.."
                                + RESET);
                System.out.println(YELLOW
                                + "                    ################################################        ################################################"
                                + RESET);
                System.out.println(BLACK
                                + "                    ################################################        ################################################"
                                + RESET);
                System.out.println(RED
                                + "                    ################################################        ##############################################.."
                                + RESET);
                System.out.println(GREEN
                                + "                    ++############################################          ##############################################"
                                + RESET);
                System.out.println(BLUE
                                + "                      ############################################            ############################################"
                                + RESET);
                System.out.println(MAGENTA
                                + "                      ##########################################--            ############################################"
                                + RESET);
                System.out.println(CYAN
                                + "                      ##########################################              --########################################::"
                                + RESET);
                System.out.println(WHITE
                                + "                      ::######################################--                ########################################"
                                + RESET);
                System.out.println(YELLOW
                                + "                        ######################################                  --######################################"
                                + RESET);
                System.out.println(BLACK
                                + "                        MM##################################                      @@##################################.."
                                + RESET);
                System.out.println(RED
                                + "                          ################################++                        ################################@@ "
                                + RESET);
                System.out.println(GREEN
                                + "                            ############################mm                            ##############################"
                                + RESET);
                System.out.println(BLUE
                                + "                              @@######################..                                MM######################++"
                                + RESET);
                System.out.println(MAGENTA
                                + "                                  --mm########@@++                                          ::MM########@@++.."
                                + RESET);

                System.out.println(
                                "FILHO? pera VOCE EH MEU PAI, MARIO SERGIO CORTELLA ALEMAOZINHO????????? MDSS... AGORA EU ME LEMBRO DE VOCE");
                System.out.println("\nPAI?...");
                pause.pauseConsole();
                clear.clearConsole();

                System.out.println("              ,-----.");
                System.out.println("            W/,-. ,-\\.W");
                System.out.println("            ()>x   x<()");
                System.out.println("            (.--(_)--.)");
                System.out.println("          ,'/.-'\\_/`-\\.`,");
                System.out.println("        ,' /    `-'    \\ `.");
                System.out.println("       /   \\           /   \\");
                System.out.println("      /     `.       ,'     \\");
                System.out.println("     /    /   `-._.-'   \\    \\");
                System.out.println("   ,-`-._/|     |=|o    |\\_.-<");
                System.out.println("  <,--.)  |_____| |o____|  )_ \\");
                System.out.println("   `-)|    |//   _   \\\\|     )/");
                System.out.println("     ||    |'    |    `|");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    (    )|(    )");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |     |     |");
                System.out.println("     ||    |_.--.|.--._|");
                System.out.println("     ||     /'\"\"| |\"\"`\\");
                System.out.println("     []     `===' `==='  hjw");

                pause.pauseConsole();
                clear.clearConsole();

                System.out.println(RED
                                + "                        ..++@@######################mm::                                ..++MM################@@++::"
                                + RESET);
                System.out.println(GREEN
                                + "                  MM########################################@@::                ::@@######################################mm"
                                + RESET);
                System.out.println(BLUE
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(MAGENTA
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(CYAN
                                + "                  ############################################################################################################"
                                + RESET);
                System.out.println(WHITE
                                + "                  mm########################################################################################################.."
                                + RESET);
                System.out.println(YELLOW
                                + "                    ################################################        ################################################"
                                + RESET);
                System.out.println(BLACK
                                + "                    ################################################        ################################################"
                                + RESET);
                System.out.println(RED
                                + "                    ################################################        ##############################################.."
                                + RESET);
                System.out.println(GREEN
                                + "                    ++############################################          ##############################################"
                                + RESET);
                System.out.println(BLUE
                                + "                      ############################################            ############################################"
                                + RESET);
                System.out.println(MAGENTA
                                + "                      ##########################################--            ############################################"
                                + RESET);
                System.out.println(CYAN
                                + "                      ##########################################              --########################################::"
                                + RESET);
                System.out.println(WHITE
                                + "                      ::######################################--                ########################################"
                                + RESET);
                System.out.println(YELLOW
                                + "                        ######################################                  --######################################"
                                + RESET);
                System.out.println(BLACK
                                + "                        MM##################################                      @@##################################.."
                                + RESET);
                System.out.println(RED
                                + "                          ################################++                        ################################@@ "
                                + RESET);
                System.out.println(GREEN
                                + "                            ############################mm                            ##############################"
                                + RESET);
                System.out.println(BLUE
                                + "                              @@######################..                                MM######################++"
                                + RESET);
                System.out.println(MAGENTA
                                + "                                  --mm########@@++                                          ::MM########@@++.."
                                + RESET);

                System.out.println("... Seu nome nunca sera esquecido" + RED + "PAPAI CORTELLA ALEMAOZINHO" + RESET);
                pause.pauseConsole();
                clear.clearConsole();

                System.out.println("PARABENS VOCE ZEROU O GAME...");
                pause.pauseConsole();
                clear.clearConsole();
        }

        public void textChangePerson() {
                System.out.println(
                                "Pelo visto voce passou da primeira fase, e consegue visualizar a porta atrás\n do corpo do inimigo!\n");
                System.out.println("Digite o código dela: (dica: espero que você lembre algum dia)");
        }
}
