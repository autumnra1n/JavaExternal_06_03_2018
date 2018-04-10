package controller;

import exceptions.DuplicateEquipmentException;
import model.dto.AbstractKnightAmmunition;
import model.dto.IncreaseAttackScore;
import model.dto.IncreaseProtectionScore;
import model.dto.implementation.Hauberk;
import model.dto.implementation.Knight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Barracks {

    private static final int ZERO = 0;

    public static void equip(Knight knight, AbstractKnightAmmunition...abstractKnightAmmunition) {
        setScoreToZero(knight);
        try{
            findDuplicateAmmunition(abstractKnightAmmunition);
            for(AbstractKnightAmmunition knightAmmunition:abstractKnightAmmunition){
                if(IncreaseAttackScore.class.isAssignableFrom(knightAmmunition.getClass())){
                    IncreaseAttackScore increaseAttackScore = (IncreaseAttackScore)knightAmmunition;
                    increaseAttackScore.increaseAttackScore(knight);
                }
                if(IncreaseProtectionScore.class.isAssignableFrom(knightAmmunition.getClass())) {
                    IncreaseProtectionScore increaseProtectionScore = (IncreaseProtectionScore) knightAmmunition;
                    increaseProtectionScore.increaseProtectionScore(knight);
                }
            }
        }catch (DuplicateEquipmentException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("Check console");
        }
    }

    public static void sortAmmunition(AbstractKnightAmmunition...abstractKnightAmmunition){
        Arrays.sort(abstractKnightAmmunition, new Comparator<AbstractKnightAmmunition>() {
            @Override
            public int compare(AbstractKnightAmmunition o1, AbstractKnightAmmunition o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static ArrayList<AbstractKnightAmmunition> findByPriceRange(int min, int max, AbstractKnightAmmunition...abstractKnightAmmunition){
        ArrayList<AbstractKnightAmmunition> abstractKnightAmmunitions = new ArrayList<>();
        for(AbstractKnightAmmunition knightAmmunition:abstractKnightAmmunition){
            if(knightAmmunition.getPrice()>=min&&knightAmmunition.getPrice()<=max){
                abstractKnightAmmunitions.add(knightAmmunition);
            }
        }
        return abstractKnightAmmunitions;
    }

    public static void findDuplicateAmmunition(AbstractKnightAmmunition...abstractKnightAmmunition)throws DuplicateEquipmentException{
        int counter = 0;
        for (int i = 0;i<abstractKnightAmmunition.length;i++){
            for (int j = 0;j<abstractKnightAmmunition.length;j++){
                if(abstractKnightAmmunition[i].equals(abstractKnightAmmunition[j]))
                    counter++;
            }
            if(counter>1){
                throw new DuplicateEquipmentException();
            }
            counter = 0;
        }
    }

    public static void setScoreToZero(Knight knight){
        knight.setAttackScore(ZERO);
        knight.setProtectionScore(ZERO);
    }
}
