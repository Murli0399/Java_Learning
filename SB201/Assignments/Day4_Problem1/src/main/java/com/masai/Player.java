package com.masai;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Pid;
	private String Name;
	private String SportName;
	private int Age;

	public Player() {
		super();
	}

	public Player(String name, String sportName, int age) {
		super();
		Name = name;
		SportName = sportName;
		Age = age;
	}

	public Player(int pid, String name, String sportName, int age) {
		super();
		Pid = pid;
		Name = name;
		SportName = sportName;
		Age = age;
	}

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSportName() {
		return SportName;
	}

	public void setSportName(String sportName) {
		SportName = sportName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	@Override
	public String toString() {
		return "Player Id: " + Pid + ", Name: " + Name + ", SportName: " + SportName + ", Age: " + Age;
	}

}








