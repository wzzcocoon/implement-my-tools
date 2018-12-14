package cn.wzz.otherTools;
/*package cn.wzz.utils;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// 保证序列化json的时候,如果是null的对象,key也会消失
public class ResultDTO<T> implements Serializable {

	private int status;// 状态码 0代表true，1代表false
	private String msg;// 返回的信息
	private T data; // 返回的数据

	private ResultDTO(int status) {
		this.status = status;
	}

	private ResultDTO(int status, T data) {
		this.status = status;
		this.data = data;
	}

	private ResultDTO(int status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	private ResultDTO(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	
	 * 判断是否成功
	 
	@JsonIgnore
	// 使之不在json序列化结果当中
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}

	public int getStatus() {
		return status;
	}

	public T getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}

	
	 * 成功不返回数据和信息
	 
	public static <T> ResultDTO<T> createBySuccess() {
		return new ResultDTO<T>(ResponseCode.SUCCESS.getCode());
	}

	
	 * 成功返回信息，不返回数据
	 
	public static <T> ResultDTO<T> createBySuccessMessage(String msg) {
		return new ResultDTO<T>(ResponseCode.SUCCESS.getCode(), msg);
	}

	
	 * 成功返回数据，不返回信息
	 
	public static <T> ResultDTO<T> createBySuccess(T data) {
		return new ResultDTO<T>(ResponseCode.SUCCESS.getCode(), data);
	}

	
	 * 成功返回数据，返回信息
	 
	public static <T> ResultDTO<T> createBySuccess(String msg, T data) {
		return new ResultDTO<T>(ResponseCode.SUCCESS.getCode(), msg, data);
	}
	
	 * 失败不返回错误信息
	 

	public static <T> ResultDTO<T> createByError() {
		return new ResultDTO<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}

	
	 * 失败返回错误信息
	 
	public static <T> ResultDTO<T> createByErrorMessage(String errorMessage) {
		return new ResultDTO<T>(ResponseCode.ERROR.getCode(), errorMessage);
	}

	
	 * 根据传入的errorCode返回错误信息
	 
	public static <T> ResultDTO<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
		return new ResultDTO<T>(errorCode, errorMessage);
	}

}*/