package jp.ac.uryukyu.ie.e225731;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**ヒーローの名前を返します。
     * @return String　を返します。
     */
    public String getName(){
        return name;
    }


    /**ヒーローのHPを返します。
     * @return int を返します。
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**ヒーローの攻撃力を返します。
     * @return int を返します。
     */  
    public int getAttack(){
        return attack;
    }

    /**ヒーローの生死を返します。
     * @return　boolean を返す。
     */
    public boolean getDead(){
        return dead;
    }

    /**ヒーローの名前を設定する。
     * @param n 
     */
    public void setName(String n){
        this.name = n;
    }

    /**ヒーローのHPを設定する。
     * @param h
     */
    public void setHitPoint(int h){
        this.hitPoint = h;
    }

    /**ヒーローの攻撃力を設定する。
     * @param a
     */
    public void setAttack(int a){
        this.attack = a;
    }

    /**ヒーローの生死を設定する。
     * @param d
     */ 
    public void setDead(boolean d){
        this.dead = d;
    }

    

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
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
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.getName(), damage);
        e.wounded(damage);
        
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
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}