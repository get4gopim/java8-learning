package com.example.learning.builderpattern;

public class Computer {

	private int RAM;
	private int HDD;
	private String OS;

	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public int getHDD() {
		return HDD;
	}

	public void setHDD(int hDD) {
		HDD = hDD;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}


	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}


	public Computer(ComputerBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.OS = builder.OS;
		
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
	
	

	@Override
	public String toString() {
		return "Computer [RAM=" + RAM + ", HDD=" + HDD + ", OS=" + OS + ", isGraphicsCardEnabled="
				+ isGraphicsCardEnabled + ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}



	static class ComputerBuilder {
		private int RAM;
		private int HDD;
		private String OS;

		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		public int getRAM() {
			return RAM;
		}

		public void setRAM(int rAM) {
			RAM = rAM;
		}

		public int getHDD() {
			return HDD;
		}

		public void setHDD(int hDD) {
			HDD = hDD;
		}

		public String getOS() {
			return OS;
		}

		public void setOS(String oS) {
			OS = oS;
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
			this.HDD=hdd;
			this.RAM=ram;
		}
	}

}
