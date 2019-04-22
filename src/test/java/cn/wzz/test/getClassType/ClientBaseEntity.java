package cn.wzz.test.getClassType;


import java.util.Date;

import lombok.Data;

/**
 * ClientBase entity
 * 
 * @author code-generator
 */
@Data
public class ClientBaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 数据ID
	 */
	private String id;
	/**
	 * 待分配ID
	 */
	private String originId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 所在省
	 */
	private String province;
	/**
	 * 所在市
	 */
	private String city;
	/**
	 * 工作城市
	 */
	private String workCity;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 身份证号
	 */
	private String idNo;
	/**
	 * 来源
	 */
	private String fromType;
	/**
	 * 渠道商(合作伙伴)
	 */
	private String partner;
	/**
	 * 门店ID
	 */
	private String organId;
	/**
	 * 客户经理
	 */
	private String salesmanId;
	/**
	 * 线索阶段
	 */
	private String stage;
	/**
	 * 分配人
	 */
	private String assinger;
	/**
	 * 分配日期
	 */
	private Date assignDate;
	/**
	 * 首次邀约日期
	 */
	private Date firstCallDate;
	/**
	 * 首次到店日期
	 */
	private Date firstComeDate;
	/**
	 * 录单日期
	 */
	private Date inputDate;
	/**
	 * 风控审批日期
	 */
	private Date doRiskDate;
	/**
	 * 风控审批结果
	 */
	private String doRiskResult;
	/**
	 * 风控拒绝原因
	 */
	private String riskRefuseReason;
	/**
	 * 预定日期
	 */
	private Date bookDate;
	/**
	 * 预定车型
	 */
	private String bookCar;
	/**
	 * 签约日期
	 */
	private Date signDate;
	/**
	 * 请款日期
	 */
	private Date loanApplyDate;
	/**
	 * 放款日期
	 */
	private Date loanDate;
	/**
	 * 交车日期
	 */
	private Date getCarDate;
	/**
	 * 失败关闭日期
	 */
	private Date failDate;
	/**
	 * 失败原因
	 */
	private String failReason;
	/**
	 * 提交状态
	 */
	private String submitStatus;
	/**
	 * 线索状态
	 */
	private String status;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 更新人
	 */
	private String updateUser;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 录单编号
	 */
	private String applicationNo;
	/**
	 * 业务类型
	 */
	private String busiType;
	/**
	 * 合同编号
	 */
	private String contractNo;
	/**
	 * 采购类型
	 */
	private String purchaseType;
	/**
	 * 意向车型
	 */
	private String aimCar;
	/**
	 * 线索等级
	 */
	private String clientRank;
	/**
	 * 导入批次
	 */
	private String batch;
	/**
	 * 推送ERP
	 */
	private String toERP;
	/**
	 * 定金
	 */
	private Double deposit;
	/**
	 * 手机端标记
	 */
	private String mobileMark;
    /**
     * 成交车型
     */
    private String dealCar;
    /**
     * 活动
     */
    private String activity;
    /**
     * 追踪状态
     */
    private String traceStage;
    /**
     * 追踪状态分类
     */
    private String traceStageType;
    /**
     * 追踪状态详情
     */
    private String traceStageDetail;
    /**
     * 意向业务类型
     */
    private String aimBusiType;
    /**
     * 线索进入方式
     */
    private String entryMode;
    /**
     * 线索分类
     */
    private String clientClassify;
    /**
     * 下次追踪日期
     */
    private Date planNextDate;
}