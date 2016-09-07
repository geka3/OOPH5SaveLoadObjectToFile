package net.ukr.geka3;

public interface AddDeleteStudents {
	void addStudent(Student st) throws FullGroupException;
	void deleteStudent(int i);
	int deleteStudentBySurName (String surName);
}
