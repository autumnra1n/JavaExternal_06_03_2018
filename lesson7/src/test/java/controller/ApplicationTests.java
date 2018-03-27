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
import utils.Serializer;

import java.io.File;
import java.io.IOException;

public class ApplicationTests {

    private Knight knight;
    private AbstractAmmunitionFactory swordFactory;
    AbstractKnightAmmunition sword;
    AbstractKnightAmmunition sword1;

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void init(){
        knight = new Knight("Vasya");
        swordFactory = new SwordFactory();
        sword = swordFactory.createNewInstance(12,23,34);
        sword1 = swordFactory.createNewInstance(14,21,13);
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
