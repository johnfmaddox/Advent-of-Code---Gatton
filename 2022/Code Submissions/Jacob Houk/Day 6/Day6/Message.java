package Day6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Message {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input6"));
		
		String str = input.nextLine();
		int idx = 0;
		
		for (int i = 13; i < str.length(); i++) {
			char ch1 = str.charAt(i - 13);
			char ch2 = str.charAt(i - 12);
			char ch3 = str.charAt(i - 11);
			char ch4 = str.charAt(i - 10);
			char ch5 = str.charAt(i - 9);
			char ch6 = str.charAt(i - 8);
			char ch7 = str.charAt(i - 7);
			char ch8 = str.charAt(i - 6);
			char ch9 = str.charAt(i - 5);
			char ch10 = str.charAt(i - 4);
			char ch11 = str.charAt(i - 3);
			char ch12 = str.charAt(i - 2);
			char ch13 = str.charAt(i - 1);
			char ch14 = str.charAt(i);
			
			if (ch1 != ch2 && ch1 != ch3 && ch1 != ch4 && ch1 != ch5 && ch1 != ch6 && ch1 != ch7 && ch1 != ch8 && ch1 != ch9 && ch1 != ch10 && ch1 != ch11 && ch1 != ch12 && ch1 != ch13 && ch1 != ch14) {
				if (ch2 != ch3 && ch2 != ch4 && ch2 != ch5 && ch2 != ch6 && ch2 != ch7 && ch2 != ch8 && ch2 != ch9 && ch2 != ch10 && ch2 != ch11 && ch2 != ch12 && ch2 != ch13 && ch2 != ch14) {
					if (ch3 != ch4 && ch3 != ch5 && ch3 != ch6 && ch3 != ch7 && ch3 != ch8 && ch3 != ch9 && ch3 != ch10 && ch3 != ch11 && ch3 != ch12 && ch3 != ch13 && ch3 != ch14) {
						if (ch4 != ch5 && ch4 != ch6 && ch4 != ch7 && ch4 != ch8 && ch4 != ch9 && ch4 != ch10 && ch4 != ch11 && ch4 != ch12 && ch4 != ch13 && ch4 != ch14) {
							if (ch5 != ch6 && ch5 != ch7 && ch5 != ch8 && ch5 != ch9 && ch5 != ch10 && ch5 != ch11 && ch5 != ch12 && ch5 != ch13 && ch5 != ch14) {
								if (ch6 != ch7 && ch6 != ch8 && ch6 != ch9 && ch6 != ch10 && ch6 != ch11 && ch6 != ch12 && ch6 != ch13 && ch6 != ch14) {
									if (ch7 != ch8 && ch7 != ch9 && ch7 != ch10 && ch7 != ch11 && ch7 != ch12 && ch7 != ch13 && ch7 != ch14) {
										if (ch8 != ch9 && ch8 != ch10 && ch8 != ch11 && ch8 != ch12 && ch8 != ch13 && ch8 != ch14) {
											if (ch9 != ch10 && ch9 != ch11 && ch9 != ch12 && ch9 != ch13 && ch9 != ch14) {
												if (ch10 != ch11 && ch10 != ch12 && ch10 != ch13 && ch10 != ch14) {
													if (ch11 != ch12 && ch11 != ch13 && ch11 != ch14) {
														if (ch12 != ch13 && ch12 != ch14) {
															if (ch13 != ch14) {
																idx = i + 1;
															} else {
																continue;
															}
														} else {
															continue;
														}
													} else {
														continue;
													}
												} else {
													continue;
												}
											} else {
												continue;
											}
										} else {
											continue;
										}
									} else {
										continue;
									}
								} else {
									continue;
								}
							} else {
								continue;
							}
						} else {
							continue;
						}
					} else {
						continue;
					}
				} else {
					continue;
				}
			} else {
				continue;
			}
		}
		
		System.out.println(idx);
	}
}
