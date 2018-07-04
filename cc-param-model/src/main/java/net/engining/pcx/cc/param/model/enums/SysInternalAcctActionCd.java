package net.engining.pcx.cc.param.model.enums;

import net.engining.pg.support.meta.EnumInfo;

/**
 * 系统内部账户行为代码
 * @author yinxia
 *
 */
@EnumInfo({
	 
	"S001|放款",
	"S002|支付",
	"S003|存款",
	"S005|清算",
	"S006|利息计提(逾期)",
	"S007|利息计提冲减(逾期)",
	"S008|罚息计提(逾期)",
	"S009|罚息计提冲减(逾期)",
	"S010|利息计提(非应计)",
	"S011|利息计提冲减(非应计)",
	"S012|罚息计提(非应计)",
	"S013|罚息计提冲减(非应计)",
	"S014|利息计提(正常)",
	"S015|利息计提冲减(正常)",
	"S016|本行转入",
	"S017|本行转出",
	"S018|他行转入",
	"S019|他行转出",
	"S020|基金购买",
	"S021|基金赎回",
	"S022|基金赎回过渡",
	"S023|三方支付代收",
	"S024|三方支付代付",
	"S025|手续费(逾期)",
	"S026|手续费(非应计)",
	"S027|利息(逾期)",
	"S028|利息(非应计)",
	"S029|本金(逾期)",
	"S030|本金(非应计)"
})
public enum SysInternalAcctActionCd {
	/**
	 * 放款
	 */
	S001,
	/**
	 * 支付
	 */
	S002,
	/**
	 * 存款
	 */
	S003,
	/**
	 * 清算
	 */
	S005,
	/**
	 * 利息计提(逾期)
	 */
	S006,
	/**
	 * 利息计提冲减(逾期)
	 */
	S007,
	/**
	 * 罚息计提(逾期)
	 */
	S008,
	/**
	 * 罚息计提冲减(逾期)
	 */
	S009,
	/**
	 * 利息计提(非应计)
	 */
	S010,
	/**
	 * 利息计提冲减(非应计)
	 */
	S011,
	/**
	 * 罚息计提(非应计)
	 */
	S012,
	/**
	 * 罚息计提冲减(非应计)
	 */
	S013,
	/**
	 * 利息计提(正常)
	 */
	S014,
	/**
	 * 利息计提冲减(正常)
	 */
	S015,
	/**
	 * 本行转入
	 */
	S016,
	/**
	 * 本行转出
	 */
	S017,
	/**
	 * 他行转入
	 */
	S018,
	/**
	 * 他行转出
	 */
	S019,
	/**
	 * 基金购买
	 */
	S020,
	/**
	 * 基金赎回
	 */
	S021,
	/**
	 * 基金赎回过渡
	 */
	S022,
	/**
	 * 三方支付代收
	 */
	S023,
	/**
	 * 三方支付代付
	 */
	S024,
	/**
	 * 手续费(逾期)
	 */
	S025,
	/**
	 * 手续费(非应计)
	 */
	S026,
	/**
	 * 利息(逾期)
	 */
	S027,
	/**
	 * 利息(非应计)
	 */
	S028,
	/**
	 * 本金(逾期)
	 */
	S029,
	/**
	 * 本金(非应计)
	 */
	S030
}
