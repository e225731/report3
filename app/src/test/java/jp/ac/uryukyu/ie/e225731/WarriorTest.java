package jp.ac.uryukyu.ie.e225731;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test void attackDamage(){
        int defaultSlimeHP = 100*150/100*3; //勇者の攻撃力３回分でスライムのHPが0になれば、150%になっているのがわかる。
        Warrior warrior = new Warrior("勇者",100,100);
        Enemy slime = new Enemy("スライムもどき", defaultSlimeHP, 100);
        for(int count=0; count<3; count++){
            warrior.attackWithWeponSkill(slime);
            }
            assertEquals(slime.hitPoint, 0);       
        }
}
    

