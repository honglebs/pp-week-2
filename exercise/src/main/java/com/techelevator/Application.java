package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    /**
     * The main entry point in the application
     * @param args
     */

    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    Map<String, Project> projects = new HashMap<>();

    Department department1 = new Department(1,"Marketing");
    Department department2 = new Department(2,"Sales");
    Department department3 = new Department(1,"Engineering");


    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {

        departments.add(department1);
        departments.add(department2);
        departments.add(department3);




    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).getName());

        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee employee1 = new Employee();

        employee1.setEmployeeId(1);
        employee1.setFirstName("Dean");
        employee1.setLastName("Johnson");
        employee1.setEmail("djohnson@teams.com");
        employee1.setDepartment(department3);
        employee1.setHireDate("08/21/2020");

        Employee employee2 = new Employee(2, "Angie", "Smith", "asmith@teams.com", department3, "08/21/2020");
        Employee employee3 = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", department1, "08/21/2020");

        employee2.raiseSalary(10);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getFullName() + " (" + employees.get(i).getSalary() + ") " + employees.get(i).getDepartment().getName());

        }

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {

        Project engineerTeam = new Project("TEams", "Project Management Software", "startDate: 10/10/2020", "11/10/2020");

        for (Employee employee : employees) {
            if(employee.getDepartment().getName().equals("Engineering")){
                engineerTeam.getTeamMembers().add(employee);
            }
        }
        //System.out.println(teams.getTeamMembers());

       projects.put(engineerTeam.getName(), engineerTeam);


    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

        Project marketTeam = new Project(" Marketing Landing Page", " Lead Capture Landing Page for Marketing", "startDate: 10/10/2020", "10/17/2020");

        for (Employee employee : employees) {
            if(employee.getDepartment().getName().equals("Marketing")){
                marketTeam.getTeamMembers().add(employee);
            }
        }

        projects.put(marketTeam.getName(), marketTeam);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(Map.Entry<String, Project> teamPair : projects.entrySet()){
            String key = teamPair.getKey();
            Project value = teamPair.getValue();
            System.out.println(key + ": " + value.getTeamMembers().size());
        }

    }

}
