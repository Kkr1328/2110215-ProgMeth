package main;

import logic.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exception.EmptyGuildNameException;
import exception.DuplicateGuildNameException;

public class Main {
	public static GuildDatabase myDatabase;
	private static Scanner kb = new Scanner(System.in);

	public static boolean addDepartment(String newName) {
		// TODO: Does one of three things, depends on the inputed name.

		// TODO: If newName is blank, then throw EmptyGuildNameException
		// to warn the user the department name cannot be blank and return false.

		// TODO: If newName duplicates with an existing department, then throw
		// DuplicateGuildNameException
		// to warn the user that the department name cannot be duplicate and return
		// false.
		try {
			if (newName.isBlank()) {
				throw new EmptyGuildNameException();
			}
			if (myDatabase.isExists(newName)) {
				throw new DuplicateGuildNameException();
			} else {
				myDatabase.createDepartment(newName);
				System.out.println(newName + " Department Created!");
				return true;
			}
		} catch (EmptyGuildNameException e) {
			System.out.println(e);
			return false;
		} catch (DuplicateGuildNameException e) {
			System.out.println(e);
			return false;
		}

		// HINT: createDepartment from GuildDatabase returns a boolean
		// for a good reason.

		// HINT2: use try/catch so that the program can continue running when an
		// exception is thrown.
		// Don't put throws DuplicateGuildNameException in the method name or the
		// program will break!

		// TODO: If it's not blank and not a duplicate,
		// create the department normally, print a message
		// that the department has been created, and return true.
	}

	public static void removeDepartmentFromDatabase(int index) {
		// TODO: Remove a department at a given index from the database.

		// TODO: Put all the members from the removed department in the "Unassigned"
		// department.
		// "Unassigned" department can be called with getUnassignedDepartment()

		ArrayList<GuildMember> kickedMembers = myDatabase.removeDepartment(index);
		getUnassignedDepartment().addMultipleMembers(kickedMembers);
		System.out
				.println("Department removed. " + kickedMembers.size() + " member(s) added to Unassigned Department.");

		// HINT: removeDepartment returns an ArrayList<GuildMember> for a good reason.

		// TODO: Print a message that the department is removed and that all members are
		// moved to the unassigned department.
	}

	// ------------------------------------------
	// ---do not edit anything below this line---
	// ----but feel free to look at the code!----
	// ------------------------------------------

	public static void main(String args[]) {
		initializeDatabase();
		System.out.println("===== Welcome to the Guild Member Database! =====");
		while (true) {
			try {
				System.out.println("===== MAIN MENU =====");
				System.out.println("0) View Departments and Members");
				System.out.println("1) New Department");
				System.out.println("2) Remove Department");
				System.out.println("3) New Member");
				System.out.println("4) Remove Member");
				System.out.println("5) Exit");

				String choice = kb.nextLine();
				int choiceNumber = Integer.parseInt(choice);

				System.out.println("====================");
				switch (choiceNumber) {
				case 0:
					navigateGuildDatabase();
					System.out.println("====================");
					break;
				case 1:
					System.out.println("Choose a new department name: ");
					String newName = kb.nextLine();
					boolean createSuccess = addDepartment(newName);
					if (!createSuccess)
						System.out.println("Failed to create department. Returning to Main Menu.");
					System.out.println("====================");
					break;
				case 2:
					removeDepartment();
					System.out.println("====================");
					break;
				case 3:
					addMember();
					System.out.println("====================");
					break;
				case 4:
					removeMember();
					System.out.println("====================");
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Not a valid command. Please input again.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error detected! Returning to main menu.");
			}
		}
	}

	public static void navigateGuildDatabase() {
		while (true) {
			System.out.println("Choose a Department:");
			myDatabase.printDepartments();
			System.out.println(myDatabase.departmentCount() + ") Exit");

			String choice = kb.nextLine();
			int choiceNumber = Integer.parseInt(choice);

			if (choiceNumber == myDatabase.departmentCount())
				return;
			else if (choiceNumber > myDatabase.departmentCount() || choiceNumber < 0) {
				System.out.println("There is no such department! Please choose again.");
				System.out.println("====================");
			} else {
				System.out.println("===== " + myDatabase.getDepartment(choiceNumber) + " =====");
				myDatabase.getDepartment(choiceNumber).printMembers();
				System.out.println("====================");
			}
		}
	}

	public static void removeDepartment() {
		while (true) {
			System.out.println("Choose a department to remove: ");
			myDatabase.printDepartments();
			System.out.println(myDatabase.departmentCount() + ") Cancel");

			String choice = kb.nextLine();
			int choiceNumber = Integer.parseInt(choice);

			if (choiceNumber == myDatabase.departmentCount())
				return;

			else if (choiceNumber == 0)
				System.out.println("You cannot remove the Unassigned Department!");

			else if (choiceNumber > myDatabase.departmentCount() || choiceNumber < 0) {
				System.out.println("There is no such department! Please choose again.");
				System.out.println("====================");
			} else {
				System.out.println("===== " + myDatabase.getDepartment(choiceNumber) + " =====");
				myDatabase.getDepartment(choiceNumber).printMembers();
				System.out.println("====================");
				System.out.println(
						"Are you sure you want to remove this department? All members will be moved to Unassigned Department. (y/n)");
				if (decideYesNo()) {
					// method below part
					removeDepartmentFromDatabase(choiceNumber);
					return;
				} else {
					System.out.println("Transaction cancelled. Returning to Main Menu.");
					return;
				}
			}
		}
	}

	public static void addMember() {
		System.out.println("Please input name: ");
		String name = kb.nextLine();
		System.out.println("Please input job title: ");
		String jobTitle = kb.nextLine();
		System.out.println("Please input salary: ");
		String salary = kb.nextLine();
		int salaryAsInt = Integer.parseInt(salary);

		GuildMember newMember = new GuildMember(name, jobTitle, salaryAsInt);

		int department = 0;
		while (true) {
			System.out.println("Choose a department: ");
			myDatabase.printDepartments();
			String choice = kb.nextLine();
			int choiceNumber = Integer.parseInt(choice);
			if (choiceNumber < 0 || choiceNumber > myDatabase.departmentCount()) {
				System.out.println("There is no such department! Please choose again.");
			} else {
				department = choiceNumber;
				break;
			}
		}

		myDatabase.getDepartment(department).addMember(newMember);
		System.out.println(newMember + " added.");
	}

	public static void removeMember() {
		while (true) {
			System.out.println("Choose a department: ");
			myDatabase.printDepartments();
			System.out.println(myDatabase.departmentCount() + ") Cancel");

			String choice = kb.nextLine();
			int choiceNumber = Integer.parseInt(choice);

			if (choiceNumber == myDatabase.departmentCount())
				return;

			else if (choiceNumber > myDatabase.departmentCount() || choiceNumber < 0) {
				System.out.println("There is no such department! Please choose again.");
				System.out.println("====================");

			} else {
				Department chosenDept = myDatabase.getDepartment(choiceNumber);
				while (true) {
					System.out.println("===== " + chosenDept + " =====");
					System.out.println("Choose a member to remove:");

					chosenDept.printMembers();
					System.out.println(chosenDept.memberCount() + ") Back");

					String memberChoice = kb.nextLine();
					int memberChoiceNumber = Integer.parseInt(memberChoice);

					if (memberChoiceNumber == chosenDept.memberCount())
						break;
					else if (memberChoiceNumber > chosenDept.memberCount() || memberChoiceNumber < 0) {
						System.out.println("There is no such member! Please choose again.");
						System.out.println("====================");
					} else {
						System.out.println("Are you sure you want to remove this member? (y/n)");
						if (decideYesNo()) {
							chosenDept.removeMember(memberChoiceNumber);
							System.out.println("Member removed.");
							return;
						} else {
							System.out.println("Transaction cancelled. Returning to Main Menu.");
							return;
						}
					}
				}
			}
		}
	}

	public static boolean decideYesNo() {
		String choice = kb.nextLine();
		switch (choice.toLowerCase().charAt(0)) {
		case 'y':
			return true;
		case 'n':
			return false;
		default:
			throw new InputMismatchException();
		}
	}

	public static void initializeDatabase() {
		myDatabase = new GuildDatabase();
		myDatabase.createDepartment("Unassigned");
	}

	public static Department getUnassignedDepartment() {
		return myDatabase.getDepartment(0);
	}
}
