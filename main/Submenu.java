package quizmanagementsystem.main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import quizmanagementsystem.Exception.NoQuestionsFoundException;
import quizmanagementsystem.Exception.QuizNotFoundException;
import quizmanagementsystem.daoimpl.QuizDaoimpl;
import quizmanagementsystem.model.Quiz;
import quizmanagementsystem.model.User;

public class Submenu {

	int choice;
	Scanner sc = new Scanner(System.in);

	public void adminmenu() throws Exception {

		QuizDaoimpl qdao = new QuizDaoimpl();
		Set<Quiz> qset = new HashSet<>();
		do {
			System.out.println("\n===== ADMIN MENU =====");
			System.out.println("1. Create Quiz");
			System.out.println("2. List Quizzes");
			System.out.println("3. View Results");
			System.out.println("4. Delete Quiz ");
			System.out.println("5. Logout");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:

				try {
					System.out.println("Enter Quiz Title : ");

					String title = sc.next();

					sc.nextLine();
					System.out.println("Enter File Path : ");

					String path = sc.nextLine();
					
					if(!path.toLowerCase().endsWith(".csv")) {
					    System.out.println("Only CSV File Allowed");
					    return;
					}
					qdao.create_quiz(title, path);

				} catch (NoQuestionsFoundException e) {

					System.out.println("Error : " + e.getMessage());

				} catch (Exception e) {

					e.printStackTrace();
				}
			default:
				System.out.println("_________________________----_____________________");
				break;

			case 2:
				qset = qdao.listQuiz();

				for (Quiz q : qset) {
					System.out.println(q);
				}

				break;
				
			case 3:
				qdao.viewResults();
				break;
				
			case 4:
				try {
					System.out.println("Enter the Quize ID to Delete: ");
					int quizId = sc.nextInt();
					
					qdao.deleteQuiz(quizId);
					
					 System.out.println("Quiz Deleted Successfully");
				}catch(QuizNotFoundException e){
					System.out.println(e.getMessage());
					
				}
				
				break;

			case 5:
				System.out.println("Admin Logged Out Successfully");
				break;

			}
		} while (choice != 5);

	}
	
	public void studentmenu(User u) throws Exception{
		QuizDaoimpl qdao = new QuizDaoimpl();
		do {
			System.out.println("\n=========STUDENT MENU===========");
			System.out.println("1. View Quizzes");
			System.out.println("2. Attempt Quiz");
			System.out.println("3. View Score");
			System.out.println("4. Logout");
			
			System.out.println("Enter the choice: ");
			choice = sc.nextInt();
			
			
			switch(choice) {
			case 1:
				Set<Quiz> quizzes = qdao.listQuiz();
				
				for (Quiz q : quizzes) {
					System.out.println(q.getId()+ " " + q.getTitle());
				}
				break;
			case 2:
				try {
					
				QuizDaoimpl dao1 = new QuizDaoimpl();
				int student_id, quiz_id = 0;
				System.out.println("Enter Quiz Id: ");
				
				System.out.println("Quiz Id + " + quiz_id);
				quiz_id= sc.nextInt();
				dao1.attemptQuiz(u.getId(), quiz_id);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				default:
					System.out.println("invalid");
				break;
				
			case 3:
				 try {
					 qdao.viewScore(u.getId());
				 }
				 catch(Exception e) {
					 e.printStackTrace();
				 }
				 break;
			case 4:
				System.out.println("Student Logged Out Successfully");
				break;
			
			}
			
		}while(choice!=4);
	}
	
}