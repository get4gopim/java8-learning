package com.example.learning.builderpattern;

public class Computer {

	private int ram;
	private int hdd;
	private String os;

	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public int getRAM() {
		return ram;
	}

	public void setRAM(int rAM) {
		ram = rAM;
	}

	public int getHDD() {
		return hdd;
	}

	public void setHDD(int hDD) {
		hdd = hDD;
	}

	public String getOS() {
		return os;
	}

	public void setOS(String oS) {
		os = oS;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}


	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}


	public Computer(ComputerBuilder builder) {
		this.hdd = builder.hdd;
		this.ram = builder.ram;
		this.os = builder.os;
		
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
	
	

	@Override
	public String toString() {
		return "Computer [RAM=" + ram + ", HDD=" + hdd + ", OS=" + os + ", isGraphicsCardEnabled="
				+ isGraphicsCardEnabled + ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}



	static class ComputerBuilder {
		private int ram;
		private int hdd;
		private String os;

		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		public int getRAM() {
			return ram;
		}

		public void setRAM(int rAM) {
			ram = rAM;
		}

		public int getHDD() {
			return hdd;
		}

		public void setHDD(int hDD) {
			hdd = hDD;
		}

		public String getOS() {
			return os;
		}

		public void setOS(String oS) {
			os = oS;
		}

		public boolean isGraphicsCardEnabled() {
			return isGraphicsCardEnabled;
		}

		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public boolean isBluetoothEnabled() {
			return isBluetoothEnabled;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
		
		public ComputerBuilder(int hdd, int ram){
			this.hdd=hdd;
			this.ram=ram;
		}
	}

}
