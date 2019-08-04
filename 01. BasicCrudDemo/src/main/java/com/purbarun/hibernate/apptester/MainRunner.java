package com.purbarun.hibernate.apptester;

import java.util.Scanner;

import com.purbarun.hibernate.dao.UserDao;
import com.purbarun.hibernate.dto.User;

public class MainRunner {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		System.out.println("1----> CREATE OPERATION");
		System.out.println("2----> READ OPERATION");
		System.out.println("3----> UPDATE OPERATION");
		System.out.println("4----> DELETE OPERATION");

		while (true) {
			System.out.println("Enter what you want to perform: ");
			ch = sc.nextInt();

			if (ch == 1) {
				while (true) {
					System.out.println("Enter User Id:");
					int userId = sc.nextInt();
					System.out.println("Enter Name:");
					String name = sc.next();
					User user = new User(userId, name);
					dao.createNewUser(user);
					System.out.println("Do you want to create more user?");
					String op1 = sc.next();
					if (op1.equalsIgnoreCase("NO")) {
						break;
					}
				}
			}

			if (ch == 2) {
				while (true) {
					System.out.println("Enter User Id:");
					int userIdToRead = sc.nextInt();
					try {
						User user = dao.findUserById(userIdToRead);
						System.out.println("Id: " + user.getId());
						System.out.println("Name: " + user.getName());
					} catch (NullPointerException e) {
						System.out.println("No user present with this id!!");
					}
					System.out.println("Do you want to read more records?");
					String op1 = sc.next();
					if (op1.equalsIgnoreCase("NO")) {
						break;
					}
				}
			}

			if (ch == 3) {
				while (true) {
					System.out.println("Enter User Id:");
					int userIdToUpdate = sc.nextInt();
					System.out.println("Enter new Name:");
					String newName = sc.next();
					dao.updateUserById(userIdToUpdate, newName);
					System.out.println("Do you want to update more records?");
					String op1 = sc.next();
					if (op1.equalsIgnoreCase("NO")) {
						break;
					}
				}
			}
			if (ch == 4) {
				while (true) {
					System.out.println("Enter User Id:");
					int userIdToDelete = sc.nextInt();
					dao.deleteUserById(userIdToDelete);
					System.out.println("Do you want to delete more records?");
					String op1 = sc.next();
					if (op1.equalsIgnoreCase("NO")) {
						break;
					}
				}
			}
			System.out.println("Do you want to perform more operations?");
			String op = sc.next();
			if (op.equalsIgnoreCase("NO")) {
				break;
			}
		}
		sc.close();
	}
}
