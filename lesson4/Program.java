package lesson4;

import java.util.Arrays;

interface ISwimAble{
	 void swim();
 } 
abstract class Human implements Comparable<Human> {
	String fio;
	int year;
	public Human() {
		this("Anonim");
	}
	public Human(String fio) {
		super();
		this.fio = fio ;
	}
	void eat() { System.out.println("I'm eat");}
	abstract void display();
	@Override
	public int compareTo(Human h) {
		//Human h  = (Human)o;
		int yearCompare = this.year - h.year;
		if(yearCompare == 0)
		return this.fio.compareTo(h.fio);
		else return yearCompare;		
	}
}
class Abiturient extends Human{

	public Abiturient(String fio) {
		super(fio);
	}

	@Override
	void display() {		
	}
	
}
class Student extends Abiturient implements ISwimAble{	
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
	public void swim() {
		System.out.println("Student sweem");
	}
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
class Voin extends Human implements ISwimAble{
	int power;	
	void fight() {System.out.println("I'm fight");}
	@Override
	void display() {
		
		
	}
	public void swim() {
		System.out.println("Voin swim");
	}
}
class Dog implements ISwimAble{

	@Override
	public void swim() {
		System.out.println("Dog Swim");
		
	}
	
}
class SwimPool{
	public static void testSwim(ISwimAble sw) {
		sw.swim();
		if(sw instanceof Student) {
			System.out.println("Student!!!!!");			
		}		
	}
}
class Row{
	int[] row;
}
class Matrix{
	Row[] matrix;
}
class Cube{
	Matrix[] cube;
}
class HumanFactory extends AbstractHumanFactory{
	private final int TYPE_HUMAN = 4;
	@Override
	public Human RandHuman() {
		return GetHuman((int)(Math.random()*TYPE_HUMAN));
	}	
	@Override
	public Human GetHuman(int n) {		
		switch (n) {
		case 0: return new Student("Vasya", 1);
		case 1: return new StudentZao();
		case 2: return new Doctor();
		case 3: return new Voin();
		default:{
			System.out.println("Enter Human");
			return null;
		}			
		}		
	}
}
public class Program {
	public static void sortMasInt() {
		int[] mas = {2,3,54,6,5,4,6,4};
		Arrays.sort(mas);
		for (int i : mas) {
			System.out.println(i);
		}
		System.out.println(Arrays.toString(mas));
		int [][]m2 = null;
		System.out.println(Arrays.deepToString(m2));
		
	}
	public static void main(String[] args) {
		Human st1 = new Student("Vasya",1);
		Human doc1 = new Doctor();
		Human voin1 = new Voin();		
		Human [] masObj = new Human[4];
	//	masObj[0] = st1;
	//	masObj[1] = doc1;
	//	masObj[2] = voin1;
	//	masObj[3] = new StudentZao();
		AbstractHumanFactory hf = new HumanFactory();
		for (int i = 0; i < masObj.length; i++) {
			masObj[i] = hf.RandHuman();
			System.out.println(masObj[i]);
		}
		Arrays.sort(masObj);
		
		Student []  masStud = new Student[2];
		int countStud =-1;
		ISwimAble [] masSwim = new ISwimAble[5];
		int countSwim =-1;
		masSwim[++countSwim] = new Dog();
		masSwim[++countSwim] = new ISwimAble() {			
			@Override
			public void swim() {			
				System.out.println("Anonim swim");
			}
		}; 
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
			if(masObj[i] instanceof ISwimAble) {
				masSwim[++countSwim] = (ISwimAble) masObj[i];
			}
		}
		for (int i = 0; i < masStud.length; i++) {
			System.out.println(masStud[i]);
		}
		for (int i = 0; i < masSwim.length; i++) {
		//	if(masObj[i] instanceof ISwimAble)
				SwimPool.testSwim((ISwimAble)masSwim[i]);
		}
	}
 
}
