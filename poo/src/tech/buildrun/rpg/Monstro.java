package tech.buildrun.rpg;
public class Monstro extends Personagem{
    public Monstro(String nome, int vida, int ataque, int defesa, int qtdRegeneracaoVida, String nomePoderEspecial, double multiplicadorDanoEspecial) {
        super(nome, vida, ataque, defesa);
        this.qtdRegeneracaoVida = qtdRegeneracaoVida;
        this.nomePoderEspecial = nomePoderEspecial;
        this.multiplicadorDanoEspecial = multiplicadorDanoEspecial;
    }

    private int qtdRegeneracaoVida;
    private String nomePoderEspecial;
    private double multiplicadorDanoEspecial;

    public void regenerarVida() {
        this.vida += qtdRegeneracaoVida;

        System.out.println(this.nome + " regenerou " + qtdRegeneracaoVida + " de vida!");

        if (this.vida > vidaMaxima) {
            this.vida = vidaMaxima;
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        boolean viraAtaqueEspecial = this.executarEspecial();
        if (viraAtaqueEspecial){
            this.usarAtaqueEspecial(alvo);
        } else {
            super.atacar(alvo);
        }
    }

    @Override
    public void monstrarApresentacao() {
        System.out.println(this.nome + "(Vida: " + this.vida + ", Ataque: " + this.ataque +
                ", Defesa: " + this.defesa + ", Regeneração de vida: "
                + this.qtdRegeneracaoVida + ", Poder Especial: " +
                this.nomePoderEspecial + ")");
    }
    @Override
    public void usarAtaqueEspecial(Personagem alvo) {
        boolean executarEspecial = this.executarEspecial();

        if (executarEspecial) {
            int danoEspecial = this.ataque +  ((int) (this.ataque * this.multiplicadorDanoEspecial));
            alvo.receberDano(danoEspecial);
            System.out.println(this.nome + ": Ataque especial [" + this.nomePoderEspecial + "] realizado! ");
        }else {
            System.out.println(this.nome + ": DROGA!!!");
        }
    }
}
