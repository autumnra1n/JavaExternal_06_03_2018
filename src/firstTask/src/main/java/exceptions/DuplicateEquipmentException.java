package exceptions;

public class DuplicateEquipmentException extends Exception{

    public DuplicateEquipmentException() {

    }

    public DuplicateEquipmentException(String message){
        super(message);
    }
}
