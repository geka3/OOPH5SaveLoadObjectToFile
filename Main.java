package net.ukr.geka3;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create students
		Student st1 = new Student("Vasya","Petechkin",12, true,  1, "IFF");
		Student st2 = new Student("Kolya","Petechkin",20, true,  1, "IFF");
		Student st3 = new Student("Kolya","Kuznec",15, true,  1, "IFF");
		Student st4 = new Student("Misha","Volkov",1, true,  1, "IFF");
		Student st5 = new Student("Misha","Volkov",67, true,  1, "IFF");
		Student st6 = new Student("Misha","Volkov",57, true,  1, "IFF");
		//create group
		Group grOne = new Group("Shulavka");
		//add students to group
		try {
			grOne.addStudent(st1);
			grOne.addStudent(st2);
			grOne.addStudent(st3);
			grOne.addStudent(st4);
			grOne.addStudent(st5);
			grOne.addStudent(st6);
			
			
		} catch (FullGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//grOne.saveToFile("gr1.txt");
		Group grTwo = Group.getGroupFromFile("gr1.txt");
		System.out.println(grTwo.getStudentsInfo());
		
		//delete student from group
		//System.out.println(grOne.deleteStudentBySurName("Kuznec"));
		
		
		
		//creating comparator for sorting
//		Comparator CompareStudentsAge = new ComparatorStudents(){
//			@Override
//			public int compare(Object o1, Object o2) {
//				
//				if(super.compare(o1, o2) != 0){
//					return super.compare(o1, o2);
//				}
//				if(o1.getClass() == Student.class && o2.getClass() == Student.class){
//					Student st1 = (Student) o1;
//					Student st2 = (Student) o2;
//					return st1.age - st2.age;
//				}
//				else {
//					System.out.println("not compatible class ");
//					return 0;
//				}	
//			}
//		};
		
//		Comparator CompareStudentsName = new ComparatorStudents(){
//			@Override
//			public int compare(Object o1, Object o2){
//				if(super.compare(o1, o2) != 0 ){
//					return super.compare(o1, o2);
//				}
//				if (o1.getClass() == Student.class && o2.getClass() == Student.class){
//					Student st1 = (Student) o1;
//					Student st2 = (Student) o2;
////					System.out.println("i am here sort Name " + st1.name.compareToIgnoreCase(st2.name));
//					return (st1.name.compareToIgnoreCase(st2.name));
//				}
//				System.out.println("not compatible class ");
//				
//				return 0;
//			}
//		};
		
//		Comparator CompareStudentsSurName = new ComparatorStudents(){
//			@Override
//			public int compare(Object o1, Object o2){
//				if(super.compare(o1, o2) != 0 ){
//					return super.compare(o1, o2);
//				}
//				if (o1.getClass() == Student.class && o2.getClass() == Student.class){
//					Student st1 = (Student) o1;
//					Student st2 = (Student) o2;
//					return (st1.surName.compareToIgnoreCase(st2.surName));
//				}
//				System.out.println("not compatible class ");
//				
//				return 0;
//			}
//		};
		
//		System.out.println("before comparing " + System.lineSeparator() + grOne.getStudentsInfo());
//		//sorting
//		grOne.sort(CompareStudentsSurName.thenComparing(CompareStudentsName).thenComparing(CompareStudentsAge));
//		
//		System.out.println("after comparing " + System.lineSeparator() + grOne.getStudentsInfo());
//		
//		//creating Voenkom ref
//		Voenkom armyOne = grOne;
		
//		//get army students
//		System.out.println("List of students compatible for army");
//		for ( Student student : armyOne.getForMilitaryService()) {
//			System.out.println(student.toString());
//		}
		
		
		
		
		
	}

}
