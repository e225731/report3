package jp.ac.uryukyu.ie.e225731;

public class Warrior extends LivingThing {

    public Warrior (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    public void attackWithWeponSkill(LivingThing opponent){
        if (this.dead == false){
        int damage = (int)(attack*150/100);
        System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        opponent.wounded(damage);

        }
    }
}
