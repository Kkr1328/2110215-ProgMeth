package logic;

public class GuildMember {
	private String name;
	private String jobTitle;
	private String myDepartment = "Unassigned";
	private int salary;

	public GuildMember(String name, String jobTitle, int salary) {
		// TODO: Value constructor. Instantiates a member with the given values.
		setName(name);
		setJobTitle(jobTitle);
		setSalary(salary);
	}

	public String getName() {
		// TODO: Return member's name here.
		if (!name.isBlank()) {
			return name;
		}
		return null;
	}

	public void setName(String name) {
		// TODO: Set the member's name. If it's blank, set is as "Anon".
		if (name.isBlank()) {
			this.name = "Anon";
		} else {
			this.name = name;
		}
	}

	public String getJobTitle() {
		// TODO: Return the member's job title.
		if (!jobTitle.isBlank()) {
			return jobTitle;
		}
		return null;
	}

	public void setJobTitle(String jobTitle) {
		// TODO: Set the member's job title. If it's blank, set it as "Adventurer".
		if (jobTitle.isBlank()) {
			this.jobTitle = "Adventurer";
		} else {
			this.jobTitle = jobTitle;
		}
	}

	public String getMyDepartment() {
		// TODO: Return the member's department.
		if (!myDepartment.isBlank()) {
			return myDepartment;
		}
		return null;
	}

	public void setMyDepartment(String myDepartment) {
		// TODO: Set the member's department.
		if (myDepartment.isBlank()) {
			this.myDepartment = "Unassigned";
		} else {
			this.myDepartment = myDepartment;
		}
	}

	public int getSalary() {
		// TODO: Get the member's salary.
		if (salary != 0) {
			return salary;
		}
		return 0;
	}

	public void setSalary(int salary) {
		// TODO: Set the member's salary.
		// If it is less than 0, set is as 0.
		// If it is greater than 100000, set is as 100000.
		if (salary < 0) {
			this.salary = 0;
		} else if (salary > 100000) {
			this.salary = 100000;
		} else {
			this.salary = salary;
		}
	}

	// ------------------------------------------
	// ---do not edit anything below this line---
	// ----but feel free to look at the code!----
	// ------------------------------------------

	public String toString() {
		return name + " the " + jobTitle + " of the " + myDepartment + " Department (Salary: " + salary + ")";
	}
}
