package com.hp.day9.polymorphic;

public class TestInstrument {
	
	//制定乐器演奏
	public void tune(Instrument in) {
		in.play("music");
	}
//	public void tune(Piano in) {
//	in.play("music");
//	}
//	public void tune(Wind in) {
//	in.play("music");
//	}
	
	
	public static void main(String[] args) {
		Instrument in = new Piano();
		Instrument in2 = new Wind();
		
		TestInstrument ti = new TestInstrument();
		ti.tune(in);
		ti.tune(in2);
	}
}
