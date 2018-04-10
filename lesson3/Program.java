package lesson3;
 abstract class Human{
	String fio;
	public Human() {
		this("Anonim");
	}
	public Human(String fio) {
		super();
		this.fio = fio ;
	}
	void eat() { System.out.println("I'm eat");}
	abstract void display();
}
class Abiturient extends Human{

	public Abiturient(String fio) {
		super(fio);
	}

	@Override
	void display() {
		
		
	}
	
}
class Student extends Abiturient{	
	int idGroup;	
	public Student(String fio, int idGroup) {
		super(fio);
		this.idGroup = idGroup;
	}
	//@Override
	void eat() {
		System.out.println("I'm eat sausage");
	}
	void study() {System.out.println("I'm study");}
}
class StudentZao extends Student{
	public StudentZao() {
		super("Petya", 13);		
	}
	
}
class Doctor extends Human{	
	int idLicense;	
	void cure() {System.out.println("I'm cure");}
	@Override
	void display() {
		// TODO Auto-generated method stub
		
	}	
}
class VetDoctor extends Doctor{
	@Override
	void cure() {
		System.out.println("I'm cure animal");
	}
}
class Voin extends Human{
	int power;	
	void fight() {System.out.println("I'm fight");}
	@Override
	void display() {
		
		
	}
}
public class Program {

	public static void main(String[] args) {
		Human st1 = new Student("Vasya",1);
		Human doc1 = new Doctor();
		Human voin1 = new Voin();
		
		Human [] masObj = new Human[4];
		masObj[0] = st1;
		masObj[1] = doc1;
		masObj[2] = voin1;
		masObj[3] = new StudentZao();
		Student []  masStud = new Student[2];
		int countStud =-1;
		for (int i = 0; i < masObj.length; i++) {
			masObj[i].eat();
			masObj[i].display();
			if("prj3.Student".equals(masObj[i].getClass().getName()))
			{				
		//	}
		//	if(masObj[i] instanceof Student) {
			((Student)masObj[i]).eat();
			masStud[++countStud] = (Student) masObj[i];
			}
		}
		for (int i = 0; i < masStud.length; i++) {
			System.out.println(masStud[i]);
		}
	}

}
