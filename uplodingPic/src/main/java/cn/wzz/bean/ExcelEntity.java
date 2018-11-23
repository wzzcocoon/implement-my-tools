package cn.wzz.bean;

import lombok.Data;
import java.io.Serializable;
import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;

@Data
@ExcelSheet
public class ExcelEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 数据ID
	 */
	private String id;

	/**
	 * 工作城市
	 */
	@ExcelField(name = "工作城市")
	private String workCity;
	
	/**
	 * 姓名
	 */
	@ExcelField(name = "客户姓名")
	private String name;

	/**
	 * 手机
	 */
	@ExcelField(name = "手机号")
	private String mobile;


	/**
	 * 备注
	 */
	@ExcelField(name = "备注")
	private String remark;
}
