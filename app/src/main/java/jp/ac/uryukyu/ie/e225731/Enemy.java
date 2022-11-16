package jp.ac.uryukyu.ie.e225731;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {

    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**敵の名前を返します。
     * @return String　を返します。
     */
    public String getName(){
        return name;
    }

    /**敵のHPを返します。
     * @return int を返します。
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**敵の攻撃力を返します。
     * @return int を返します。
     */
    public int getAttack(){
        return attack;
    }

    /**敵の生死を返します。
     * @return　boolean を返す。
     */
    public boolean getDead(){
        return dead;
    }

    /**敵の名前を設定する。
     * @param n
     */
    public void setName(String n){
        this.name = n;
    }

    /**敵のHPを設定する。
     * @param h
     */
    public void setHitPoint(int h){
        this.hitPoint = h;
    }

    /**敵の攻撃力を設定する。
     * @param a
     */
    public void setAttack(int a){
        this.attack = a;
    }

    /**敵の生死を設定する。
     * @param d
     */
    public void setDead(boolean d){
        this.dead = d;
    }


    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        setName(name);
        //this.name = name;
        setHitPoint(maximumHP);
        //hitPoint = maximumHP;
        setAttack(attack);
        //this.attack = attack;
        setDead(false);
        //dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if (this.dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);            
            hero.wounded(damage);
        }  
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }
}