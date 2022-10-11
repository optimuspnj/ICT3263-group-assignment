package com.adbms.team1.HMS.repositories;

public class Summary {
    private double monthlyIncome;
    private int totalIncome;
    private int totalBookings;
    private int totalFoodOrders;
    private int totalFoodItems;
    private int totalCustomers;
    private int totalEmployees;
    private int totalMessages;

    public Summary(double monthlyIncome, int totalIncome, int totalBookings, int totalFoodOrders, int totalFoodItems, int totalCustomers, int totalEmployees, int totalMessages) {
        this.monthlyIncome = monthlyIncome;
        this.totalIncome = totalIncome;
        this.totalBookings = totalBookings;
        this.totalFoodOrders = totalFoodOrders;
        this.totalFoodItems = totalFoodItems;
        this.totalCustomers = totalCustomers;
        this.totalEmployees = totalEmployees;
        this.totalMessages = totalMessages;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(int totalBookings) {
        this.totalBookings = totalBookings;
    }

    public int getTotalFoodOrders() {
        return totalFoodOrders;
    }

    public void setTotalFoodOrders(int totalFoodOrders) {
        this.totalFoodOrders = totalFoodOrders;
    }

    public int getTotalFoodItems() {
        return totalFoodItems;
    }

    public void setTotalFoodItems(int totalFoodItems) {
        this.totalFoodItems = totalFoodItems;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public int getTotalMessages() {
        return totalMessages;
    }

    public void setTotalMessages(int totalMessages) {
        this.totalMessages = totalMessages;
    }
}
