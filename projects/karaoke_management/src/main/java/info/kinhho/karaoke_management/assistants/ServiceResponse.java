package info.kinhho.karaoke_management.assistants;

import com.google.gson.JsonObject;

public class ServiceResponse {
	
	private int code;
	private String message;
	private String data;
	private String type;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		JsonObject obj = new JsonObject();
		obj.addProperty("code", code);
		obj.addProperty("message", message);
		obj.addProperty("data", data);
		obj.addProperty("type", type);
		return obj.toString();
	}
}
