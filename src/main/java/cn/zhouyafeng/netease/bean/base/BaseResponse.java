package cn.zhouyafeng.netease.bean.base;

/**
 * 
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年8月17日 下午11:14:38
 * @version 1.0
 *
 */
public class BaseResponse {
	private Result result;
	private int code;
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
