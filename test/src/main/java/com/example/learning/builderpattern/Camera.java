package com.example.learning.builderpattern;

public class Camera {

	private final int shutturSpeed;
	private final float aperture;
	private final int iso;

	static class Builder {
		// Mandatory fields
		private final int shutturSpeed;
		private final float aperture;

		// Optional fields
		private int iso;

		public Builder(int shutterSpeed, float aperture) {
			this.shutturSpeed = shutterSpeed;
			this.aperture = aperture;
		}

		public Builder setIso(int iso) {
			this.iso = iso;
			return this;
		}

		public Camera build() {
			return new Camera(this);
		}
	}

	public Camera(Builder builder) {
		this.shutturSpeed = builder.shutturSpeed;
		this.aperture = builder.aperture;
		this.iso = builder.iso;
	}

	@Override
	public String toString() {
		return "Camera [shutturSpeed=" + shutturSpeed + ", aperture=" + aperture + "f, iso=" + iso + "]";
	}
	
}
