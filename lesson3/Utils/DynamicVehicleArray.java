package lesson3.Utils;

import lesson3.model.CVehicle;

import java.util.Arrays;

/**
 * Created by Михаил on 15.03.2018.
 */
public class DynamicVehicleArray {

    private final static double DEFAULT_LOADFACTOR = 0.75;
    private final static int DEFAULT_ADDITIONALSPACE = 10;
    private final static int DEFAULT_INITSPACE = 15;
    private double loadFactor;
    private int additionalSpace;
    private CVehicle[] dynamicArray;

    public DynamicVehicleArray(int capacity, int additionalSpace, int loadFactor) {
        checkInputs(capacity, additionalSpace, loadFactor);
    }

    public DynamicVehicleArray(){
        this.dynamicArray = new CVehicle[DEFAULT_INITSPACE];
        this.loadFactor = DEFAULT_LOADFACTOR;
        this.additionalSpace = DEFAULT_ADDITIONALSPACE;
    }

    public void add(CVehicle... vehicles){
        int count = 0;
        for(int i = 0; i<dynamicArray.length; i++){
            if(dynamicArray[i]!=null){
                count++;
            }
            else
                break;
        }
        if(vehicles.length>(dynamicArray.length-count)*this.loadFactor){
            if(dynamicArray[0]==null){
                while(vehicles.length>(dynamicArray.length-count)*this.loadFactor){
                    dynamicArray = new CVehicle[dynamicArray.length+this.additionalSpace];
                }
                this.arrayCopy(dynamicArray, vehicles, 0);
            }
            else{
                dynamicArray = this.newArrayInstance(dynamicArray, vehicles, count);
            }
        }
        else{
            if(dynamicArray[0]==null){
                this.arrayCopy(dynamicArray, vehicles, 0);
            }
            else{
                this.arrayCopy(dynamicArray, vehicles, count);
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= dynamicArray.length) {
            System.out.println("Wrong remove index");
        }
        else
            {
            int count = 0;
            for (int i = 0; i < dynamicArray.length; i++) {
                if (dynamicArray[i] != null) {
                    count++;
                } else
                    break;
            }
            CVehicle[] tempArray = new CVehicle[DEFAULT_INITSPACE];
            if (dynamicArray.length > DEFAULT_INITSPACE) {
                tempArray = new CVehicle[dynamicArray.length - 1];
            }
            for (int i = 0; i < index; i++) {
                tempArray[i] = dynamicArray[i];
            }
            if (index < count - 1) {
                for (int i = index + 1; i < count; i++) {
                    tempArray[i - 1] = dynamicArray[i];
                }
            }
            dynamicArray = tempArray;
        }
    }

    private void arrayCopy(CVehicle[] dynamicArray, CVehicle[] vehicles, int count){
        for(int i = 0; i<vehicles.length;i++){
            dynamicArray[count]=vehicles[i];
            count++;
        }
    }

    private CVehicle[] newArrayInstance(CVehicle[] dynamicArray, CVehicle[] vehicles, int count){
        CVehicle[] tempArray = new CVehicle[dynamicArray.length+this.additionalSpace];
        this.arrayCopy(tempArray, dynamicArray, 0);
        System.out.println(tempArray.length+" "+dynamicArray.length);
        if(tempArray.length<dynamicArray.length) {
            for (int i = 0; i < vehicles.length; i++) {
                tempArray[i] = vehicles[i];
                count++;
            }
        }
        return tempArray;
    }

    private void checkInputs(int capacity, int additionalSpace, int loadFactor){
        if(capacity>0&&capacity<10000)
            this.dynamicArray = new CVehicle[capacity];
        else
            this.dynamicArray = new CVehicle[DEFAULT_INITSPACE];
        if(additionalSpace>0&&additionalSpace<1000)
            this.additionalSpace = additionalSpace;
        else
            this.additionalSpace = DEFAULT_INITSPACE;
        if (loadFactor<1&&loadFactor>0)
            this.loadFactor = loadFactor;
        else
            this.loadFactor = DEFAULT_LOADFACTOR;
    }

    private CVehicle[] trimmedArray(){
        int count = 0;
        while (dynamicArray[count]!=null){
            count++;
        }
        CVehicle[] tempArray = new CVehicle[count];
        for (int i=0;i<count;i++){
            tempArray[i]=dynamicArray[i];
        }
        return tempArray;
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public int getAdditionalSpace() {
        return additionalSpace;
    }

    public void setAdditionalSpace(int additionalSpace) {
        this.additionalSpace = additionalSpace;
    }

    public CVehicle[] getDynamicArray() {
        return trimmedArray();
    }

    public void setDynamicArray(CVehicle[] dynamicArray) {
        this.dynamicArray = dynamicArray;
    }

    @Override
    public String toString() {
        return "dynamicArray = " + Arrays.toString(trimmedArray());
    }
}
