package project.ui;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import project.colors.ConsoleColors;
import project.dao.BuyerDAO;
import project.dao.BuyerDAOImpl;
import project.dao.StaticVar;
import project.dto.BuyerDTO;
import project.dto.BuyerDTOImpl;
import project.dto.ProductDTO;
import project.exception.NoRecordFoundException;
import project.exception.SomethingWentWrongException;

public class BuyerUi {
	static void displayBuyerMenu() {
		System.out.println();
		System.out.println(ConsoleColors.YELLOW_BOLD + "		Buyer Menu" + ConsoleColors.RESET);
		System.out.println("	1. View All Products");
		System.out.println("	2. Purchase a Product");
		System.out.println("	3. Check Purchase History");
		System.out.println("	4. Refund Product");
		System.out.println("	5. View Ongoing Auction");
		System.out.println("	6. Bid for Auction");
		System.out.println("	7. Check Auction History");
		System.out.println("	8. Update Personal Detail");
		System.out.println("	9. Delete Account");
		System.out.println("	0. Logout");
		System.out.print(ConsoleColors.CYAN + "		Enter Selection : " + ConsoleColors.RESET);
	}

	static void refundProduct(Scanner sc) {
		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.refundProduct(sc);
		} catch (SomethingWentWrongException | NoRecordFoundException ex) {
			System.out
					.println(ConsoleColors.RED_BOLD + "		You Not Have Any Purchase Product" + ConsoleColors.RESET);
		}
	}

	static void forgatPassword(Scanner sc) {

		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.forgatPassword(sc);
		} catch (SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ConsoleColors.RED_BOLD + "		UserName Not Found" + ConsoleColors.RESET);
		}

	}

	static void auctionHistory() {
		BuyerDAO dao = new BuyerDAOImpl();

		try {
			dao.auctionHistory();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ConsoleColors.RED_BOLD + "		Auction Not Available" + ConsoleColors.RESET);
		}
	}

	static void createBid(Scanner sc) {
		BuyerDAO dao = new BuyerDAOImpl();

		try {
			dao.createBid();
			System.out.println();
			System.out.print(ConsoleColors.CYAN + "		Press 1 for Bid else 0 : " + ConsoleColors.RESET);
			String x = sc.next();

			if (x.equals("1")) {
				dao.updateBid(sc);
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ConsoleColors.RED_BOLD + "		Auction Not Available" + ConsoleColors.RESET);
		}
	}

	static void auctionDetails() {
		BuyerDAO dao = new BuyerDAOImpl();

		try {
			dao.viewAuction();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ConsoleColors.RED_BOLD + "		Auction Not Available" + ConsoleColors.RESET);
		}
	}

	static void viewHistory(Scanner sc) {
		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.viewHistory();
			System.out.print(
					ConsoleColors.CYAN + "		Press 1 for View Refund History else 0 : " + ConsoleColors.RESET);
			int x = sc.nextInt();
			if (x == 1) {
				dao.viewRefundHistory();
			}
		} catch (SomethingWentWrongException | NoRecordFoundException ex) {
			System.out
					.println(ConsoleColors.RED_BOLD + "		You Not Have Any Purchase Product" + ConsoleColors.RESET);
		}
	}

	static void purchaseProduct(Scanner sc) {

		System.out.print("	Enter Product Id : ");
		int id = sc.nextInt();

		BuyerDAO dao = new BuyerDAOImpl();
		int quantity = 0;
		try {
			quantity = dao.checkQuantity(id);
			System.out.print("	Enter Quantity : ");
			int q = sc.nextInt();
			String temp = "xyz";

			if (quantity == 0) {
				System.out.println(ConsoleColors.RED_BOLD
						+ "		Unfortunately, the following items from your order are out of stock."
						+ ConsoleColors.RESET);
			} else if (quantity < q) {
				System.out.println(ConsoleColors.RED_BOLD + "		Only " + quantity
						+ " Product available in the stock." + ConsoleColors.RESET);
				System.out.print(ConsoleColors.CYAN + "		Press 1 for continue this quantity else type 0 for Exit : "
						+ ConsoleColors.RESET);
				temp = sc.next();
				if (temp.equals("1")) {
					q = quantity;
				}
			} else {
				temp = "1";
			}

			if (temp.equals("1")) {
				try {
					List<ProductDTO> list = dao.purchaseProduct(id, q);
					System.out.println(
							ConsoleColors.GREEN + "		Your Order has been received" + ConsoleColors.RESET);

					try {
						Thread.sleep(1000);
						System.out.println(ConsoleColors.YELLOW_BOLD + "		Sales Invoice");
						System.out.println("	Product Name  : " + list.get(0).getName());
						System.out.println("	Product Price : " + list.get(0).getPrice());
						double amount = 0;
						if (list.get(0).getQuantity() == 5) {
							amount = list.get(0).getPrice() * 0.05;
						} else if (list.get(0).getQuantity() == 7) {
							amount = list.get(0).getPrice() * 0.07;
						} else if (list.get(0).getQuantity() == 9) {
							amount = list.get(0).getPrice() * 0.09;
						} else if (list.get(0).getQuantity() == 12) {
							amount = list.get(0).getPrice() * 0.12;
						}
						DecimalFormat decfor = new DecimalFormat("0.00");
						System.out.println("	GST " + decfor.format(list.get(0).getQuantity()) + "%    : "
								+ decfor.format(amount));
						double total = list.get(0).getPrice() + amount;
						System.out.println("	Total Amount  : " + decfor.format(total) + ConsoleColors.RESET);

						System.out.print(ConsoleColors.CYAN + "		Processing.");
						Thread.sleep(1000);
						System.out.print(".");
						Thread.sleep(1000);
						System.out.print(".");
						Thread.sleep(1000);
						System.out.print(".");
						Thread.sleep(1000);
						System.out.println("." + ConsoleColors.RESET);
						Thread.sleep(1000);
						System.out.println(ConsoleColors.GREEN + "		Congratulation! Your order has been placed."
								+ ConsoleColors.RESET);

						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (SomethingWentWrongException | NoRecordFoundException ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ConsoleColors.RED_BOLD + "		Product Not Found" + ConsoleColors.RESET);
		}

	}

	static void viewProduct() {

		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.viewProduct();
		} catch (SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ConsoleColors.RED_BOLD + "		Product Not Found" + ConsoleColors.RESET);
		}

	}

	static void registerBuyer(Scanner sc) {
		sc.nextLine();
		System.out.print("	Enter Your Name : ");
		String name = sc.nextLine();
		System.out.print("	Enter Your Address : ");
		String address = sc.nextLine();
		System.out.print("	Enter Your Mobile Number : ");
		String mobile = sc.nextLine();
		System.out.print("	Enter Your UserName : ");
		String username = sc.nextLine();
		System.out.print("	Enter Your Password : ");
		String password = sc.nextLine();

		BuyerDTO dto = new BuyerDTOImpl(name, address, mobile, username, password);
		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.registerBuyer(dto);
			System.out.println(ConsoleColors.GREEN + "		Registration Successfull" + ConsoleColors.RESET);
		} catch (SomethingWentWrongException ex) {
			System.out.println(ConsoleColors.RED_BOLD + "		Unable to Add Details" + ConsoleColors.RESET);
		}

	}

	static void updatePersonal(Scanner sc) {
		sc.nextLine();
		System.out.print("	Enter Your Name : ");
		String name = sc.nextLine();
		System.out.print("	Enter Your Address : ");
		String address = sc.nextLine();
		System.out.print("	Enter Your Mobile Number : ");
		String mobile = sc.nextLine();
		System.out.print("	Enter Your UserName : ");
		String username = sc.nextLine();
		System.out.print("	Enter Your Password : ");
		String password = sc.nextLine();

		BuyerDTO dto = new BuyerDTOImpl(name, address, mobile, username, password);
		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.updatePersonal(dto);
			System.out.println(ConsoleColors.GREEN + "		Details Updated Successfull" + ConsoleColors.RESET);
		} catch (SomethingWentWrongException ex) {
			System.out.println(ConsoleColors.RED_BOLD + "		Unable to Update Details" + ConsoleColors.RESET);
		}
	}

	static void deleteAccount() {
		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.deleteAccount();
			System.out.println(ConsoleColors.GREEN + "		Account Deleted Successfull" + ConsoleColors.RESET);
		} catch (SomethingWentWrongException ex) {
			System.out.println(ConsoleColors.RED_BOLD + "		Unable to Delete Account" + ConsoleColors.RESET);
		}
	}

	static void buyerLogin(Scanner sc) {
		if (!login(sc))
			return;

		String choice = "0";
		do {
			displayBuyerMenu();
			choice = sc.next();
			switch (choice) {
			case "1":
				viewProduct();
				break;
			case "2":
				purchaseProduct(sc);
				break;
			case "3":
				viewHistory(sc);
				break;
			case "4":
				refundProduct(sc);
				break;
			case "5":
				auctionDetails();
				break;
			case "6":
				createBid(sc);
				break;
			case "7":
				auctionHistory();
				break;
			case "8":
				updatePersonal(sc);
				break;
			case "9":
				deleteAccount();
				choice = "0";
				break;
			case "0":
				logout();
				System.out.println(ConsoleColors.GREEN_BOLD + "		Logout Successful" + ConsoleColors.RESET);
				break;
			default:
				System.out
						.println(ConsoleColors.RED_BOLD + "		Invalid Selection, try again" + ConsoleColors.RESET);
			}
		} while (!choice.equals("0"));
	}

	static boolean login(Scanner sc) {
		System.out.print("	Enter username : ");
		String username = sc.next();
		System.out.print("	Enter password : ");
		String password = sc.next();
		BuyerDAO dao = new BuyerDAOImpl();
		try {
			dao.login(username, password);
			System.out.println(
					ConsoleColors.GREEN_BOLD + "		Welcome " + StaticVar.LoggedInBuyerName + ConsoleColors.RESET);
		} catch (SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ConsoleColors.RED + "		Invalid username or password" + ConsoleColors.RESET);
			return false;
		}
		return true;
	}

	static void logout() {
		BuyerDAO userDAO = new BuyerDAOImpl();
		userDAO.logout();
	}
}
