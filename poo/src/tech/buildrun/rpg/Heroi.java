package tech.buildrun.rpg;

public class Heroi extends Personagem {

    private String classe;
    private int qtdAtaqueEspecial;
    private  int qtdPocaoVida;
    private String nomeAtaque;

    public Heroi(String nome, int vida, int ataque, int defesa, String classe, int qtdAtaqueEspecial, int qtdPocaoVida, String nomeAtaque) {
        super(nome, vida, ataque, defesa);
        this.classe = classe;
        this.qtdAtaqueEspecial = qtdAtaqueEspecial;
        this.qtdPocaoVida = qtdPocaoVida;
        this.nomeAtaque = nomeAtaque;
    }

    public void usarPocaoVida() {
        if (qtdPocaoVida > 0) {
            this.vida += 50;
            this.qtdPocaoVida--;
            System.out.println(this.nome + " usou uma poção de vida!");
        } else {
            System.out.println(this.nome + " não tem poções de vida!");
        }
    }
    @Override
    public void monstrarApresentacao() {
        System.out.println(this.classe + " (Vida: " + this.vida + ", Ataque: " + this.ataque +
                ", Defesa: " + this.defesa + ", Especial: " +
                this.qtdAtaqueEspecial + ", Poção de Vida: " +
                this.qtdPocaoVida + ")");

    }

    @Override
    public void usarAtaqueEspecial(Personagem alvo) {

        // 1. Verifica se tem ataque especial disponível
        if (qtdAtaqueEspecial <= 0) {
            System.out.println(this.nome + ": Você não tem ataques especiais!");
            return;
        }

        // 2. Rola a chance de sucesso
        boolean executarJogadaEspecial = this.executarEspecial();

        // 3. Executa ou falha
        if (executarJogadaEspecial) {
            int danoEspecial = this.ataque + (int) (this.ataque * 0.1);
            alvo.receberDano(danoEspecial);
            this.qtdAtaqueEspecial--;
            System.out.println(this.nome + ": Ataque especial [" + this.nomeAtaque + "] realizado!");
        } else {
            System.out.println(this.nome + ": Arrgg!! Ataque especial falhou!");
        }
    }

}
