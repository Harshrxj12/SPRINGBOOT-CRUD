package com.app.product.exception;

public class ResourceNotFoundException extends RuntimeException {
	private long fieldValue;
	private String resourceName;
	private String fieldName;
	public ResourceNotFoundException(long fieldValue, String resourceName, String fieldName) {
		super(String.format("%s not found wuth %s : %s",resourceName,fieldName,fieldValue));
		this.fieldValue = fieldValue;
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
