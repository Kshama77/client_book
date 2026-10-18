package com.clientbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Client> clients = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("================================");
        System.out.println("       Welcome to ClientBook");
        System.out.println("================================");

        while (running) {
            showMenu();
            String choice = readText("Choose an option: ");

            switch (choice) {
                case "1":
                    addClient();
                    break;
                case "2":
                    viewClients();
                    break;
                case "3":
                    searchClients();
                    break;
                case "4":
                    updateClient();
                    break;
                case "5":
                    deleteClient();
                    break;
                case "0":
                    running = false;
                    System.out.println("Thank you for using ClientBook!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0-5.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n----------- MENU -----------");
        System.out.println("1. Add client");
        System.out.println("2. View all clients");
        System.out.println("3. Search clients");
        System.out.println("4. Update client");
        System.out.println("5. Delete client");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
    }

    private static void addClient() {
        System.out.println("\n--- Add Client ---");
        String name = readRequired("Client name: ");
        String phone = readRequired("Phone: ");
        String email = readRequired("Email: ");
        String company = readRequired("Company: ");

        Client client = new Client(nextId++, name, phone, email, company);
        clients.add(client);
        System.out.println("Client added successfully. Client ID: " + client.getId());
    }

    private static void viewClients() {
        System.out.println("\n--- All Clients ---");
        if (clients.isEmpty()) {
            System.out.println("No clients found. Add a client first.");
            return;
        }

        for (Client client : clients) {
            System.out.println("----------------------------");
            System.out.println(client);
        }
        System.out.println("----------------------------");
        System.out.println("Total clients: " + clients.size());
    }

    private static void searchClients() {
        System.out.println("\n--- Search Clients ---");
        if (clients.isEmpty()) {
            System.out.println("No clients available to search.");
            return;
        }

        String keyword = readRequired("Enter a name or company to search: ").toLowerCase();
        boolean found = false;

        for (Client client : clients) {
            if (client.getName().toLowerCase().contains(keyword)
                    || client.getCompany().toLowerCase().contains(keyword)) {
                System.out.println("----------------------------");
                System.out.println(client);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching clients found.");
        }
    }

    private static void updateClient() {
        System.out.println("\n--- Update Client ---");
        Client client = findClientById();
        if (client == null) {
            return;
        }

        System.out.println("Press Enter to keep the current value.");
        String name = readText("Name [" + client.getName() + "]: ");
        String phone = readText("Phone [" + client.getPhone() + "]: ");
        String email = readText("Email [" + client.getEmail() + "]: ");
        String company = readText("Company [" + client.getCompany() + "]: ");

        if (!name.trim().isEmpty()) client.setName(name.trim());
        if (!phone.trim().isEmpty()) client.setPhone(phone.trim());
        if (!email.trim().isEmpty()) client.setEmail(email.trim());
        if (!company.trim().isEmpty()) client.setCompany(company.trim());

        System.out.println("Client updated successfully.");
    }

    private static void deleteClient() {
        System.out.println("\n--- Delete Client ---");
        Client client = findClientById();
        if (client == null) {
            return;
        }

        String confirmation = readText("Delete " + client.getName() + "? (y/n): ");
        if (confirmation.equalsIgnoreCase("y")) {
            clients.remove(client);
            System.out.println("Client deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    private static Client findClientById() {
        if (clients.isEmpty()) {
            System.out.println("No clients available.");
            return null;
        }

        int id;
        try {
            id = Integer.parseInt(readRequired("Enter client ID: "));
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a valid numeric ID.");
            return null;
        }

        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }

        System.out.println("Client ID not found.");
        return null;
    }

    private static String readRequired(String prompt) {
        while (true) {
            String value = readText(prompt).trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
