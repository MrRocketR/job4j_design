package ru.job4j.io.serialization.json;

import ru.job4j.io.serialization.Contact;

import java.util.Arrays;

public class Student {

   private boolean isPreset;
   private int grade;
   private String last;
   private Contact contact;
   private String[] subjects;

    public Student(boolean isPreset, int grade, String last, Contact contact, String[] subjects) {
        this.isPreset = isPreset;
        this.grade = grade;
        this.last = last;
        this.contact = contact;
        this.subjects = subjects;
    }

    public boolean isPreset() {
        return isPreset;
    }

    public void setPreset(boolean preset) {
        isPreset = preset;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" + "isPreset="
                + isPreset + ", grade="
                + grade + ", last='"
                + last + '\'' + ", contact="
                + contact + ", subjects="
                + Arrays.toString(subjects) + '}';
    }
}
