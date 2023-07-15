package com.masai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PersonService {

	// Hint: Make use of Setter Injection to inject skillMap and personList.

	private Map<Person, Skill> skillMap; // inject 3 entries with valid details 
	private List<Person> personList = new ArrayList<>(); // inject List of 5 Person object

	public void setSkillMap(Map<Person, Skill> skillMap) {
		this.skillMap = skillMap;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public void printSkillMap() {
		// print all the person's and their skill details from the skillMap
		for (Map.Entry<Person, Skill> e : skillMap.entrySet()) {
			System.out.println(e.getKey().toString() + " " + e.getValue().toString());
		}
	}

	public void printPersonList() {
		// sort the List of Person according to the increasing order of the age
		// print all the sorted Person Details

		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {

				return o1.getAge() - o2.getAge();
			}

		});

		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}
}