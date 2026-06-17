package quizmanagementsystem.main;

import java.util.Scanner;

import javax.management.InvalidApplicationException;

import quizmanagementsystem.Exception.AuthenticationFaildException;
import quizmanagementsystem.Exception.InvalidInputException;
import quizmanagementsystem.daoimpl.userDaoimpl;
import quizmanagementsystem.model.Role;
import quizmanagementsystem.model.User;

public class Main {

	public static void main(String[] args) throws Exception  {

		Scanner sc = new Scanner(System.in);
		userDaoimpl udao = new userDaoimpl();
		Submenu smenu = new Submenu();
		User u = new User();

		int choice;

		do {

			System.out.println("\n===== QUIZ APP =====");
			System.out.println("1. Admin Login");
			System.out.println("2. Student Register");
			System.out.println("3. Student Login");
			System.out.println("4. Exit");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				try {
					System.out.print("Username : ");
					String email = sc.next();

					System.out.print("Password : ");
					String upass = sc.next();

					User u1 = udao.login(email, upass);
					System.out.println("succesfully ");
					if (u1.getRole() == Role.ADMIN) {
						smenu.adminmenu();
						
					}
					else {
						System.out.println("hhiii");
					}

				} catch (AuthenticationFaildException e5) {
					System.out.println(e5);

				} catch (Exception e6) {
					e6.printStackTrace();
				}
				break;

			case 2:
				try {
					System.out.print("Name : ");
					String name = sc.next();

					System.out.print("Email : ");
					sc.nextLine();
					String email = sc.next();

					System.out.print("Password : ");
					String password = sc.next();

					udao.Registration(name, email, password);

				}catch (InvalidInputException e2) {
					System.out.println(e2.getMessage());
			}catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:
				try {
					System.out.print("Username : ");
					String uname = sc.next();

					System.out.print("Password : ");
					String upass = sc.next();

					User u2 = udao.login(uname, upass);
					System.out.println("succesfully ");
					if (u2.getRole() == Role.STUDENT) {
						smenu.studentmenu(u2);
					}

				} catch (AuthenticationFaildException e7) {
					System.out.println(e7);


				} catch (Exception e1) {
					e1.printStackTrace();
				}

				break;

			case 4:
				System.out.print("THANK YOU FOR USING QUIZ APP");
				System.exit(0);
				break;
			}
			
		} while (choice != 4);

		sc.close();
	}
}