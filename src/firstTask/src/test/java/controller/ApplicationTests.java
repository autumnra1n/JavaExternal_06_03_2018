package controller;

import exceptions.DuplicateEquipmentException;
import model.dto.AbstractKnightAmmunition;
import model.dto.IncreaseAttackScore;
import model.dto.implementation.Knight;
import model.factories.AbstractAmmunitionFactory;
import model.factories.implementation.SwordFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import dao.Serializer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ApplicationTests {

    private Knight knight;
    private AbstractAmmunitionFactory swordFactory;
    AbstractKnightAmmunition sword;
    AbstractKnightAmmunition sword1;
    AbstractKnightAmmunition sword2;

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void init(){
        knight = new Knight("Vasya");
        swordFactory = new SwordFactory();
        sword = swordFactory.createNewInstance(12,23,34);
        sword1 = swordFactory.createNewInstance(14,21,13);
        sword2 = swordFactory.createNewInstance(14,21,115);
    }

    @Test
    public void barracksEquipTest(){
        IncreaseAttackScore increaseAttackScore = (IncreaseAttackScore)sword;
        increaseAttackScore.increaseAttackScore(knight);
        int actual = knight.getAttackScore();
        int expected = 12;
        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test(expected = DuplicateEquipmentException.class)
    public void findDuplicateAmmoTest() throws DuplicateEquipmentException{
        Barracks.findDuplicateAmmunition(sword,sword1);
    }

    @Test
    public void sortingTest(){
        boolean check = true;
       AbstractKnightAmmunition[] abstractKnightAmmunitions = new AbstractKnightAmmunition[3];
       abstractKnightAmmunitions[0] = sword;
       abstractKnightAmmunitions[1] = sword1;
       abstractKnightAmmunitions[2] = sword2;
       Barracks.sortAmmunition(abstractKnightAmmunitions);
       for(int i = 0; i<abstractKnightAmmunitions.length;i++){
           if(i==abstractKnightAmmunitions.length-1){
               break;
           }
           else if(abstractKnightAmmunitions[i].getWeight() > abstractKnightAmmunitions[i+1].getWeight()){
               check = false;
           }
       }
       Assert.assertEquals(check,true);
    }

    @Test
    public void findByPriceRangeTest(){
        boolean check = false;
        List <AbstractKnightAmmunition> abstractKnightAmmunitions = Barracks.findByPriceRange(10,14, sword, sword1, sword2);
            if(abstractKnightAmmunitions.get(0).getPrice()==13&&abstractKnightAmmunitions.size()==1){
                check = true;
            }
        Assert.assertEquals(check,true);
    }

    @Test
    public void writeResultTest() throws IOException{
        File file = folder.newFile("result.txt");
        Serializer.serialize(file.getAbsolutePath(), sword,sword1);
    }

    @Test
    public void readResultTest() throws IOException{
        File file = folder.newFile("result.txt");
        Serializer.serialize(file.getAbsolutePath(), sword,sword1);
        Serializer.deserialize(file.getAbsolutePath());
    }
}
