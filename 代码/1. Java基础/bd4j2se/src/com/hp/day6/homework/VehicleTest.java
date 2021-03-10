package com.hp.day6.homework;

/**
 * （2）创建主类：
	在主类中创建两个机动车对象。
	创建第一个时调用无参数的构造方法，调用成员方法使其车牌为“辽
	A9752”，并让其加速。
	创建第二个时调用有参数的构造方法，使其车牌为“辽B5086”,车速为150,
	载重为200，并让其减速。
	输出两辆车的所有信息

 * @author McGradyXYZ
 *
 */
public class VehicleTest {

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle();
		v1.updateNumber("辽A9752");
		v1.speedUp();
		Vehicle v2 = new Vehicle("辽B5086", 150, 200);
		v2.speedDown();
		System.out.println(v1.number+" "+v1.speed+" "+v1.weight);
		System.out.println(v2.number+" "+v2.speed+" "+v2.weight);
		
	}

}
