package test;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		User user1 = inputUser();
		printStatus(user1);

		user1.levelUp();
		printStatus(user1);
	}

	static User inputUser(){
		Scanner sc = new Scanner(System.in);
		System.out.println("ユーザーを作成します");
		System.out.print("名前：");
		String userName = sc.next();
		System.out.print("職業(1⇒戦士,2⇒魔法使い,3⇒盗賊)：");
		int kariType = sc.nextInt();
		UserType userType = null;
		switch (kariType){
		case 1:
			userType = UserType.WARRIOR;
			break;
		case 2:
			userType = UserType.WIZARD;
			break;
		case 3:
			userType = UserType.THIEF;
			break;
		default:
			userType = UserType.NEET;
		}
		System.out.print("攻撃力：");
		String str = sc.next();
		System.out.print("素早さ：");
		String agi = sc.next();
		System.out.print("HP：");
		String hp = sc.next();
		System.out.println();
		User user = createUser(userName,userType,str,agi,hp);
		sc.close();
		return user;
	}

	static User createUser(
			String userName,
			UserType userType,
			String str,
			String agi,
			String hp){

		switch (userType){
		case WARRIOR:
			return new UserWAR(userName,userType,str,agi,hp);
		case WIZARD:
			return new UserWIZ(userName,userType,str,agi,hp);
		case THIEF:
			return new UserTHI(userName,userType,str,agi,hp);
		}
		return new UserNEE(userName,userType,str,agi,hp);
	}

	static void printStatus(User user){
		StringBuilder sb1 = new StringBuilder();
		sb1.append("■").append(user.getUserName()).append("のステータス");
		System.out.println(sb1);
		sb1.append("通り名:").append(user.getUserType()).append(user.getUserName());
		StringBuilder sb2 = new StringBuilder();
		System.out.println(sb2);
		System.out.println("HP：" + user.getHp());
		System.out.println("攻撃力：" + user.getStr());
		System.out.println("素早さ：" + user.getAgi());
		System.out.println();
	}
}