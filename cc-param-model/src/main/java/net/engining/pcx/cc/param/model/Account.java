package net.engining.pcx.cc.param.model;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import net.engining.gm.infrastructure.enums.AuthType;
import net.engining.gm.infrastructure.enums.BusinessType;
import net.engining.gm.infrastructure.enums.Interval;
import net.engining.pcx.cc.param.model.enums.*;
import net.engining.pg.parameter.HasEffectiveDate;
import net.engining.pg.support.meta.PropertyInfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 账户参数
 * 
 */
public class Account implements HasEffectiveDate, Serializable, Comparable<Account>{

	private static final long serialVersionUID = -5145883222989744588L;

//	基础参数-开始
	/**
	 * 账户属性ID
	 */
	@PropertyInfo(name="账户参数标识", length=30)
	public String paramId;

	/**
	 * 描述
	 */
	@PropertyInfo(name="描述", length=100)
	public String description;
	
	/**
	 * 是否有罚息 
	 * 
	 */
	@PropertyInfo(name="是否有罚息", length=2)
	public Boolean whetherPnit;
	
	/**
	 * 逾期计算罚息的基础额规则
	 * 
	 */
	@PropertyInfo(name="逾期计算罚息的基础额规则", length=2)
	public PnitType pnitType;

	/**
	 * 提前还款当期计息标准  M按结息周期	  D按日
	 */
	@PropertyInfo(name="提前还款计息标准", length=2)
	public PrePaySettlementType advanceType;

	/**
	 * 记账结转方式(D-逐期结转)；按科目记账时形态转移类型
	 */
	@PropertyInfo(name="记账结转方式，按科目记账时形态转移类型", length=2)
	public TransformType carryType;

	/**
	 * 业务类型
	 */
	@PropertyInfo(name="业务类型", length=2)
	public BusinessType businessType;

	/**
	 * 币种
	 */
	@PropertyInfo(name="币种", length=3)
	public String currencyCode;
	
	/**
     * 锁定码控制参数
     * key: BlockCode对象中的blockCode(锁定码)
     */
    public Map<String, BlockCodeControl> blockcode;
    
    /**
     * 余额成分计价参数
     * <p>key - 子账户类型key值{@link SubAcctType}</p>
     * value - 子账户参数key值 {@link SubAcct}
     */
    public Map<String, String> subAcctParam;
    
    @PropertyInfo(name="建账方式", length=1)
    public GenAcctMethod genAcctMethod;
    
    /**
     * 系统产生交易代码与入账交易代码对应
     * <p>key - 系统产生交易代码{@link SysTxnCd}</p>
     * value - 入账代码postCode的key值{@link String}
     */
    public Map<SysTxnCd, String> sysTxnCdMapping;

	/**
	 * 系统内部账户行为代码与内部账户入账交易代码映射
	 *     key - 系统内部账户行为代码
	 *     value - 内部账户入账代码
	 */
	public Map<SysInternalAcctActionCd, List<String>> internalAcctPostMapping;

//  基础参数-结束
    
    
//	循环信用贷款、消费分期、一次性授信贷款共有的参数-开始
	/**
	 * 固定每次还款日
	 */
	@PropertyInfo(name="是否固定每次还款日", length=1)
    public Boolean lockPaymentDay;
	
	/**
     * 到期还款固定日：对于每月固定日期的情况
     * 01 - 28 ： 固定日期 
     * 99 ： 月末
     */
    @PropertyInfo(name="到期还款固定日 ", length=2)
    public Integer fixedPmtDay;
	
    /**
     * 到期还款日天数：对于在账单日（结息日）之后若干天
     */
    @PropertyInfo(name="到期还款日天数", length=2)
    public Integer pmtDueDays;

    /**
     * 到期还款宽限天数
     */
    @PropertyInfo(name="到期还款宽限天数", length=2)
    public Integer pmtGracePrd;

    /**
     * 全额还款宽限计算方式：
     */
    @PropertyInfo(name="全额还款宽限计算方式", length=1)
    public DownpmtTolInd downpmtTolInd;

	/**
     * 全额还款宽限比例
     * 如果存放比例值，该值为允许少还的比例，如0.01允许少还1%
     */
    @PropertyInfo(name="全额还款宽限比例", length=7, precision=4)
    public BigDecimal downpmtTolPerc;
    
    /**
     * 全额还款宽限金额
     */
    @PropertyInfo(name="全额还款宽限金额", length=15, precision=2)
    public BigDecimal downpmtTol;

    /**
     * 账龄提升日类型
     */
    @PropertyInfo(name="账龄提升日", length=1)
    public DelqDayInd delqDayInd;

    /**
     * 账龄提升宽限方式
     */
    @PropertyInfo(name="账龄提升宽限方式", length=1)
    public DelqTolInd delqTolInd;

    /**
     * 账龄宽限金额
     */
    @PropertyInfo(name="账龄宽限金额", length=15, precision=2)
    public BigDecimal delqTol;

    /**
     * 账龄宽限比例
     */
    @PropertyInfo(name="账龄宽限比例",  length=7, precision=4)
    public BigDecimal delqTolPerc;

    /**
     * 滞纳金
     */
    @PropertyInfo(name="滞纳金参数")
    public LatePaymentCharge latePaymentCharge;
    
    /**
     * 超限费
     */
    @PropertyInfo(name="超限费参数")
    public OverlimitCharge overlimitCharge;
    
    /**
     * 冲销顺序
     * key-账龄
     */
    public Map<String, List<SubAcctType>> paymentHier;
    
    @PropertyInfo(name="默认授信额度", length=8)
    public Integer defaultLimit;
    
    @PropertyInfo(name="默认授信方式", length=1)
    public AuthType defaultAuthType;
    
    @PropertyInfo(name="还款类型", length=3)
    public PaymentMethod paymentMethod;
    
    /**
     * 计息头尾规则
     */
    public ComputInte4HeadTail computInte4HeadTail;
    
    /**
     * 按账期冲销顺序类型
     */
    public DepositSortType depositSortType;

	/**
	 * 分期本金除不尽的部分靠挡方向
	 */
	@PropertyInfo(name="分期本金除不尽的部分靠挡方向", length=1)
	public LeftAmtRemainderMethod loanPrincipalRemainderMethod;
    
//  循环信用贷款、消费分期、一次性授信贷款共有的参数-结束
    
//  循环信用贷款独有参数-开始
    /**
     * 免出账单溢缴款最小金额
     */
    @PropertyInfo(name="免出账单溢缴款最小金额", length=15, precision=2)
    public BigDecimal crMaxbalNoStmt;

    /**
     * 免出账单最小借方金额
     */
    @PropertyInfo(name="免出账单最小借方金额", length=15, precision=2)
    public BigDecimal stmtMinBal;

//  循环信用贷款独有参数-结束
    
//  消费分期独有参数-开始
    /**
	 * 分期手续费收取方式
	 */
	@PropertyInfo(name="贷款手续费收取方式", length=1)
	public LoanFeeMethod loanFeeMethod;

	/**
	 * 分期手续费计算方式
	 */
	@PropertyInfo(name="贷款手续费计算方式", length=1)
	public CalcMethod loanFeeCalcMethod;

	/**
	 * 分期手续费金额
	 */
	@PropertyInfo(name="贷款手续费金额", length=15, precision=2)
	public BigDecimal feeAmount;
	
	/**
	 * 分期手续费比例
	 */
	@PropertyInfo(name="贷款手续费比例", length=7, precision=4)
	public BigDecimal feeRate;

//  消费分期独有参数-结束
    
//  一次性授信贷款、消费分期、借记活期、借记定期、智能存款共有参数-开始
    /**
     * 结息周期起始日计算方式
     * P-从建账日期作为第一个结息周期的开始日; Y-自然月的1日开始
     */
    @PropertyInfo(name="结息周期起始日类型", length=1)
    public CycleStartDay intSettleStartMethod;

	/**
	 * 起息日延后天数
	 */
	@PropertyInfo(name="起息日延后天数", length=1)
	public Integer postponeDays;

	/**
     * 与结息周期乘数合并，形成结息周期长度
     * 如：6个月，intUnit = M, intUnitMult = 6
     */
    @PropertyInfo(name="结息周期计数单位", length=1)
    public Interval intUnit;
    
    /**
     * 与结息周期单位合并，形成结息周期长度
     * 如：每6个月期结一次息，intUnit = M, intUnitMult = 6
     */
    @PropertyInfo(name="结息周期计数乘数", length=4)
    public Integer intUnitMult;
    
    /**
     * 结息日，与结息周期乘数和单位配合使用。<br>
     * 1-28表示当前这个周期的某一天，其他值不合法；<br>
     * 例如：intSettleStartMethod = Y, intUnit = M, intUnitMult = 6, dIntSettleDay = 10 <br>
     *      表示每6个月固定10号结息，即6月10日、12月10日结息 <br>
     * 例如：intSettleStartMethod = P, intUnit = M, intUnitMult = 6, 当intSettleStartMethod等于P的时候dIntSettleDay不起作用；<br>
     *      计息日是2月15日开始，表示从2月15日开始，每6个月期结一次息。<br>
     */
    @PropertyInfo(name="结息日", length=2)
    public Integer dIntSettleDay;
    
    /**
     * 结息总期数，如果intSettleFrequency=-1表示总期数没有终止。
     */
    @PropertyInfo(name="结息总期数", length=3)
    public Integer intSettleFrequency;
    
    /**
     * 首期天数调整 <br>
     * 结息周期计数单位设置成"日"时，该参数生效 <br>
     * false：首次结息日  = 建账日期 + 结息周期乘数 - 1 <br>
     * true：首次结息日  = 建账日期 + 结息周期乘数 <br>
     * default : false
     */
    @PropertyInfo(name="首期天数是否调整", length=1)
    public Boolean intFirstPeriodAdj;

//  一次性授信贷款、借记活期、借记定期、智能存款共有参数-结束

// 	智能存款使用参数-开始
    /**
     * 智能存款起存金额
     */
    @PropertyInfo(name="起存金额", length=15, precision=0)
	public BigDecimal minAmount;
    
    /**
     * 计息方式
     */
    @PropertyInfo(name="计息方式", length=1)
	public AccrualType accrualType;
    
    /**
     * 计提利率类型
     */
    @PropertyInfo(name="计提利率类型", length=1)
	public AccrualInterestType accrualInterestType;
    
    /**
     * 是否代扣利息税
     */
    @PropertyInfo(name="代扣利息税", length=1)
	public Boolean withHoldingInt;
    
    /**
     * 利息税入账交易代码
     */
    @PropertyInfo(name="利息税交易代码", length=8)
	public String intTaxPostCode;
    /**
     * 销项税税率参数码
     */
    public String TaxCode;
    /**
     * 是否出账单
     */
    @PropertyInfo(name="出账单", length=1)
	public Boolean isStmt;
    
//  智能存款使用参数-结束
    
    /**
	 * 利率参数有效类型
	 */
	@PropertyInfo(name="利率参数有效类型", length=5)
	public ParamBaseType intParamBaseType;
    
	@PropertyInfo(name = "生效日期")
	public Date effectiveDate;

	@Override
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Override
	public int compareTo(Account o) {
		
		ComparisonChain chain = ComparisonChain.start()
				.compare(intUnit, o.intUnit)
				.compare(intUnitMult, o.intUnitMult)
				.compare(intSettleFrequency, o.intSettleFrequency)
				.compare(paymentMethod, o.paymentMethod)
				.compare(pmtGracePrd, o.pmtGracePrd)
				.compare(advanceType, o.advanceType)
				.compare(pnitType, o.pnitType);
		
		MapDifference<String, String> diffs= Maps.difference(subAcctParam, o.subAcctParam);
		if(!diffs.areEqual()){
			return 1;
		}
		else{
			return chain.result();
		}
	}
    
//    以下是废弃参数
//    /**
//     * 缺省授权允许超限比例
//     */
//    @PropertyInfo(name="默认允许超限比例", length=7, precision=4)
//    public BigDecimal ovrlmtRate;
//
//    /**
//     * 缺省账单日
//     */
//   	@PropertyInfo(name="缺省账单日", length=2)
//    public Integer dfltCycleDay;*/
//
//    /**
//	 * 到期还款日类型
//	 */
//	@PropertyInfo(name="到期还款日类型", length=1)
//    public PaymentDueDay paymentDueDay;
//
//	/**
//     * 到期还款固定日：对于每月固定日期的情况
//     * 01 - 28 ： 固定日期
//     * 99 ： 月末
//     */
//    @PropertyInfo(name="到期还款固定日 ", length=2)
//    public Integer pmtDueDate;
//
//    /**
//     * 到期还款短信/信函提前天数
//     */
//    @PropertyInfo(name="到期还款提醒提前天数", length=1)
//    public Integer pmtDueLtrPrd;
//
//    /**
//     * 约定还款日标识
//     */
//    @PropertyInfo(name="约定还款日标识", length=1)
//    public DirectDbIndicator directDbInd;
//
//    /**
//     * 约定还款提前天数
//     */
//    @PropertyInfo(name="约定还款提前天数", length=2)
//    public Integer directDbDays;
//
//    /**
//     * 约定还款固定日
//     */
//    @PropertyInfo(name="约定还款固定日", length=2)
//    public Integer directDbDate;
//
//    /**
//     * 拖欠短信/信函产生标识天数（拖欠之后第多少天产生）
//     * 00 - 98 ： 实际天数
//     * 99 ： 下个账单日产生
//     */
//    @PropertyInfo(name="拖欠通知延期天数", length=2)
//    public Integer delqLtrPrd;
//
//    /**
//     * 是否连续拖欠都输出信函
//     */
//    @PropertyInfo(name="连续拖欠输出信函", length=1)
//    public Boolean ltrOnContDlq;
//
//    /**
//     * 催收账龄阀值
//     */
//    @PropertyInfo(name="入催最小账龄", length=1)
//    public String collOnAge;
//
//    /**
//     * 超限催收标志
//     * Y/N
//     */
//    @PropertyInfo(name="超限入催", length=1)
//    public Boolean collOnOvrlmt;
//
//    /**
//     * 首次还款拖欠催收标志
//     * collect on first statment delinquncy
//     */
//    @PropertyInfo(name="首次还款拖欠入催", length=1)
//    public Boolean collOnFsDlq;
//
//    /**
//     * 入催最小金额阀值
//     */
//    @PropertyInfo(name="免催最大金额", length=15, precision=2)
//    public BigDecimal collMinpmt;
//
//    /**
//     * 账单周期乘数
//     * CYCLE_BASE_MULT为2，
//     * 表明每2个月组成一个账单周期
//     */
//    @PropertyInfo(name="账单周期乘数", length=1)
//    public Integer cycleBaseMult;
//
//    /**
//     * 临时额度失效提醒天数
//     */
//    @PropertyInfo(name="临时额度失效提醒天数", length=2)
//    public Integer tlExpPrmptPrd;
//
//    /**
//     * 缺省取现额度比例
//     */
//    @PropertyInfo(name="默认取现比例", length=7, precision=4)
//    public BigDecimal cashLimitRate;
//
//    /**
//     * 缺省额度内分期比例
//     */
//    @PropertyInfo(name="默认额度内分期比例", length=7, precision=4)
//    public BigDecimal loanLimitRate;
//
//	//信用卡业务的特定参数-开始
//	/**
//	 * 支持多币种共享账户额度
//	 */
//	@PropertyInfo(name="支持多币种共享账户额度", length=1)
//	public Boolean isMultiCurrency;
//
//	/**
//	 * 支持多卡一账户
//	 */
//	@PropertyInfo(name="支持多卡一账户", length=1)
//	public Boolean isMultiCard;
//	//信用卡业务的特定参数-结束
}