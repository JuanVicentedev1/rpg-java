package tech.buildrun.rpg;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Heroi  guerreiro = criarGuerreiro();
        Heroi  mago = criarMago();
        Heroi arqueiro = criarArqueiro();

        monstrarApresentacoes(guerreiro, mago, arqueiro);


        System.out.println("Escolha um Herói: ");
        // selecionando heróis
        int menuOpcaoEscolhida = sc.nextInt();
        Heroi heroiSelecionado = selecionarHeroi(menuOpcaoEscolhida, guerreiro, mago, arqueiro);


        Monstro dragao = criarDragao();

        dragao.monstrarApresentacao();

        boolean jogoAcabou = false;
        do {
            realizarJogadaTurnoUsuario(sc, heroiSelecionado, dragao);

            jogoAcabou = verificarFimDeJogo(dragao, heroiSelecionado, jogoAcabou);

            mostrarVida(heroiSelecionado, dragao);

            //  executar turno
            turnoDragao(dragao, heroiSelecionado);

            mostrarVida(heroiSelecionado, dragao);

            jogoAcabou = verificarFimDeJogo(dragao, heroiSelecionado, jogoAcabou);


        }while (!jogoAcabou);

    }

    private static Monstro criarDragao() {
        return new Monstro("Dragão Infernal ",
                100,
                15,
                5,
                3,
                "Cuspida da fornalha",
                0.2
        );
    }

    private static Heroi criarArqueiro() {
        return new Heroi("marcus", 90,
                100,
                10,
                "arqueiro",
                3,
                1,
                "severumm!");
    }

    private static Heroi criarMago() {
        return new Heroi("ryze", 80,
                25,
                10,
                "mago",
                1,
                2,
                "ruinas magicas!");
    }

    private static Heroi criarGuerreiro() {
        return new Heroi("darius", 100,
                20,
                5,
                "berserker",
                1,
                1,
                "machado sangrento");
    }

    private static boolean verificarFimDeJogo(Monstro dragao, Heroi heroiSelecionado, boolean jogoAcabou) {
        if (dragao.estaMorto()){
            jogoAcabou = true;
            System.out.println("Você Acabou com o dragão, letgooo!");
        }

        if (heroiSelecionado.estaMorto()){
            jogoAcabou = true;
            System.out.println("Você Morreu!! :( ");
        }
        return jogoAcabou;
    }

    private static void turnoDragao(Monstro dragao, Heroi heroiSelecionado) {
        System.out.println("## TURNO DRAGÃO: ##");
        dragao.regenerarVida();
        dragao.atacar(heroiSelecionado);
    }

    private static void mostrarVida(Heroi heroiSelecionado, Monstro dragao) {
        System.out.println("");
        heroiSelecionado.mostrarVida();
        dragao.mostrarVida();
        System.out.println("");
    }

    private static void realizarJogadaTurnoUsuario(Scanner sc, Heroi heroiSelecionado, Monstro dragao) {
        System.out.println("\n## SEU TURNO: ##");
        System.out.println("1. Atacar / 2. Usar habilidade especial / 3. Beber poção de vida");

        int opcaoJogada = sc.nextInt();
        switch (opcaoJogada){
            case 1 -> heroiSelecionado.atacar(dragao);
            case 2 -> heroiSelecionado.usarAtaqueEspecial(dragao);
            case 3 -> heroiSelecionado.usarPocaoVida();
        }
    }


    private static Heroi selecionarHeroi(int menuOpcaoEscolhida,
                                         Heroi guerreiro,
                                         Heroi mago,
                                         Heroi arqueiro){
       return switch (menuOpcaoEscolhida) {
            case 1 -> {System.out.println(menuOpcaoEscolhida + " - Berserker");
            yield guerreiro;
            }

            case 2 ->  {System.out.println(menuOpcaoEscolhida + " - Mago");
            yield mago;
            }

            case 3 -> {System.out.println(menuOpcaoEscolhida + " - Arqueiro");
            yield arqueiro;
            }

           default -> {System.out.println("Escolha inválida!");
                yield null;
            }

        };
    }

    private static void monstrarApresentacoes(Heroi guerreiro, Heroi mago, Heroi arqueiro) {
        System.out.println("# HERÓIS DISPONÍVEIS: #");
        System.out.print("1 - ");
        guerreiro.monstrarApresentacao();

        System.out.print("2 - ");
        mago.monstrarApresentacao();

        System.out.print("3 - ");
        arqueiro.monstrarApresentacao();
    }
}

