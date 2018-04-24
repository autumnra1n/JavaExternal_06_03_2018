package service;

public class ServiceFactory {
    public Service getService(int type) {
        switch (type) {
            case 0: return new DOMService();
            case 1: return new SAXService();
            case 2: return new StAXService();
            default:{
                System.out.println("Enter correct Service number");

            }
        }
        return null;
    }
}
