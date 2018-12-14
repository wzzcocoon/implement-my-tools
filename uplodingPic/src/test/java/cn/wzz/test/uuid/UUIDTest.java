package cn.wzz.test.uuid;

import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(str);
		
		System.out.println(UUID.randomUUID());
	}
}
