package com.geeks.ds.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A company has a CEO and a hierarchy of employees. All employees have a unique ID, name and their reports.
 * Please implement the whoIsOurBoss() method to find the closest manager for two given employees
 * (i.e. the manager farthest from the CEO that both employees report up to).
 */
public class WhoIsYourBoss {

    public static void main(String[] args) {
        Employee samir = new Employee("samir");
        Employee dom = new Employee("dom");
        Employee michael = new Employee("michael");


        Employee peter = new Employee("peter");
        Employee porter = new Employee("porter");
        Employee bob = new Employee("bob");

        dom.reporters = Arrays.asList(bob, peter, porter);

        Employee milton = new Employee("milton");
        Employee nina = new Employee("nina");

        peter.reporters = Arrays.asList(milton, nina);

        Employee bill = new Employee("bill");
        bill.reporters = Arrays.asList(dom, samir, michael);

        System.out.println(closestCommonManager(bill, milton, nina));
        System.out.println(closestCommonManager(bill, nina, porter));
        System.out.println(closestCommonManager(bill, nina, samir));
        System.out.println(closestCommonManager(bill, peter, nina));
    }

    public static Employee closestCommonManager(final Employee ceo, final Employee firstEmployee, final Employee secondEmployee) {
        if (ceo == null || firstEmployee == null || secondEmployee == null) {
            return null;
        }
        if (!covers(ceo, firstEmployee) && covers(ceo, secondEmployee)) {
            return null;
        }

        final Queue<Employee> workingQueue = new LinkedList<>();
        workingQueue.offer(ceo);

        Employee closestKnownManager = null;
        while (!workingQueue.isEmpty()) {
            Employee employee = workingQueue.poll();
            if (covers(employee, firstEmployee) && covers(employee, secondEmployee)) {
                closestKnownManager = employee;
                for (Employee em : employee.reporters) {
                    workingQueue.offer(em);
                }
            }
        }
        return closestKnownManager;
    }

    public static boolean covers(final Employee manager, final Employee employee) {
        if (manager == null)
            return false;
        if (manager.name.equals(employee.name))
            return true;
        if (manager.reporters == null)
            return false;

        boolean covers = false;
        for (Employee em : manager.reporters) {
            covers = covers || covers(em, employee);
        }
        return covers;
    }

    static class Employee {
        final String name;
        List<Employee> reporters;

        public Employee(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" + "name='" + name + '\'' + '}';
        }
    }

}
