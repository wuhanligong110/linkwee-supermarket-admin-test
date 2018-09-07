package com.linkwee.rbac;

/**
 * 权限标识配置类, <br>
 * 与 permission 权限表 中的 permission_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresPermissions(value = PermissionSign.USER_CREATE)
 * public String create() {
 *     return &quot;拥有user:create权限,能访问&quot;;
 * }
 * </pre>
 * 
 * @author Mignet
 * @since 2014年6月17日 下午3:58:51
 **/
public class PermissionSign {

	/**
	* 理财师信息概览
	*/
	public static final String CFP_DATAVIEW_READ = "cfp-dataview:read";
	/**
	* 理财师管理页面
	*/
	public static final String CFP_LIST_READ = "cfp-list:read";
	/**
	* 理财师详情
	*/
	public static final String CFP_DETAIL_READ = "cfp-detail:read";
	/**
	* 销售与管理收益
	*/
	public static final String CFP_SALE_READ = "cfp-sale:read";
	/**
	* 修改密码
	*/
	public static final String CFP_PWD_MODIFY = "cfp-pwd:modify";
	/**
	* 解绑银行卡
	*/
	public static final String CFP_BANKCARD_UNBIND = "cfp-bankcard:unbind";
	/**
	* 修改上级
	*/
	public static final String CFP_PARENT_MODIFY = "cfp-parent:modify";
	/**
	* 修改机构
	*/
	public static final String CFP_GROUP_MODIFY = "cfp-group:modify";
	/**
	* 取消理财师资格
	*/
	public static final String CFP_CFP_DELETE = "cfp-cfp:delete";
	/**
	* 禁止理财师登陆
	*/
	public static final String CFP_LOGIN_MODIFY = "cfp-login:modify";
	/**
	* 客户信息概览
	*/
	public static final String INVESTOR_DATEVIEW_READ = "investor-dateview:read";
	/**
	* 客户管理页面
	*/
	public static final String INVESTOR_LIST_READ = "investor-list:read";
	/**
	* 客户详情
	*/
	public static final String INVESTOR_DETAIL_READ = "investor-detail:read";
	/**
	* 客户投资与收益管理
	*/
	public static final String INVESTOR_SALE_READ = "investor-sale:read";
	/**
	* 修改密码
	*/
	public static final String INVESTOR_PWD_MODIFY = "investor-pwd:modify";
	/**
	* 解绑银行卡
	*/
	public static final String INVESTOR_BANKCARD_UNBIND = "investor-bankcard:unbind";
	/**
	* 变更理财师
	*/
	public static final String INVESTOR_PARENT_MODIFY = "investor-parent:modify";
	/**
	* 产品管理
	*/
	public static final String PRODUCT_LIST_READ = "product-list:read";
	/**
	* 销售明细
	*/
	public static final String PRODUCT_SALE_READ = "product-sale:read";
	/**
	* 新增/编辑产品
	*/
	public static final String PRODUCT_SALE_MODIFY = "product-sale:modify";
	/**
	* 发布产品
	*/
	public static final String PRODUCT_SALE_PUBLISH = "product-sale:publish";
	/**
	* 下架产品
	*/
	public static final String PRODUCT_SALE_BACK = "product-sale:back";
	/**
	* 灰度用户管理模块
	*/
	public static final String SYS_GRAYLIST_ALL = "sys-graylist:*";
	/**
	* 用户管理
	*/
	public static final String SYS_USER_CREATE = "sys-user:create";
	/**
	* 角色管理
	*/
	public static final String SYS_ROLE_CREATE = "sys-role:create";
	/**
	* 权限管理
	*/
	public static final String SYS_PERMISSION_ALL = "sys-permission:*";
	/**
	* 红包列表
	*/
	public static final String ACT_RED_LIST_READ = "act-red-list:read";
	/**
	* 红包每日数据
	*/
	public static final String ACT_RED_DATAVIEW_READ = "act-red-dataview:read";
	/**
	* 新增/编辑红包
	*/
	public static final String ACT_RED_MODIFY = "act-red:modify";
	/**
	* 正式发送红包
	*/
	public static final String ACT_RED_PUBLISH = "act-red:publish";
	/**
	* 资讯管理模块
	*/
	public static final String CMS_INFO_ALL = "cms-info:*";
	/**
	* 活动管理模块
	*/
	public static final String ACT_LIST_ALL = "act-list:*";
	/**
	* 公告消息管理模块
	*/
	public static final String CMS_MSG_ALL = "cms-msg:*";
	/**
	* 开屏广告
	*/
	public static final String BANNER_AD_READ = "banner-ad:read";
	/**
	* 首页轮播
	*/
	public static final String BANNER_FLIP_READ = "banner-flip:read";
	/**
	* 头像审核模块
	*/
	public static final String CMS_AVATOR_ALL = "cms-avator:*";
	/**
	 * 理财师业绩导出按钮
	 */
	public static final String LCS_ACHIEVEMENT_EXPORT = "lcs_achievement:export";
	/**
	 * 佣金最多的前100个理财师导出按钮
	 */
	public static final String FEE_MAX_TOP100_EXPORT = "fee_max_top100:export";
	/**
	 * 平均年化额最多的Top100
	 */
	public static final String INVEST_MAX_TOP100_EXPORT = "invest_max_top100:export";
	/**
	 * 产品销售数据导出
	 */
	public static final String PRODUCT_SALE_STATISTIC_EXPORT = "product_sale_statistic:export";
	/**
	 * 平台销售数据导出
	 */
	public static final String ORG_SALE_STATISTIC_EXPORT = "org_sale_statistic:export";
	/**
	 * 理财师职级修改
	 */
	public static final String LCS_LEVEL_UPDATE = "lcs_level:update";
	/**
	 * 近期回款导出
	 */
	public static final String RECENT_REPAYMENT_EXPORT = "recent_repayment:export";
	/**
	 * 产品批量审核
	 */
	public static final String PRODUCT_BATCH_CHECK = "product_batch:check";
	/**
	 * 产品分类添加编辑
	 */
	public static final String PRODUCT_CATE_EDIT = "product_cate:edit";
	/**
	 * 产品详情新增、编辑、删除
	 */
	public static final String PRODUCT_DETAIL_EDIT = "product_detail:edit";
	/**
	 * 机构新增编辑
	 */
	public static final String ORG_DETAIL_EDIT = "org_detail:edit";
	/**
	 * 机构收费模式
	 */
	public static final String ORG_FEE_MODEL_EDIT = "org_fee_model:edit";
	/**
	 * 机构佣金
	 */
	public static final String ORG_FEE_EDIT = "org_fee:edit";
	/**
	 * 消息推送新增删除
	 */
	public static final String MSG_PUSH_EDIT = "msg_push:edit";
	/**
	 * 提现审批审核通过
	 */
	public static final String WITHDRAW_PASS_CHECK = "withdraw_pass:check";
	/**
	 * 录入奖励
	 */
	public static final String REWARD_INPUT_EDIT = "reward_input:edit";
	/**
	 * 奖励发放
	 */
	public static final String REWARD_OUTPUT_EDIT = "reward_output:edit";
	/**
	 * 设置主推平台
	 */
	public static final String MAJOR_PLATFORM_SET = "major_platform:set";
	/**
	 * 回款自动派发红包新增编辑绑定机构
	 */
	public static final String REPAYMENT_REDPACKET_EDIT = "repayment_redpacket:edit";
	/**
	 * 红包管理新增编辑
	 */
	public static final String REDPACKET_EDIT = "redpacket:edit";
	/**
	 * 红包管理发放红包
	 */
	public static final String REDPACKET_SEND = "redpacket:send";
	/**
	 * 意见反馈新增编辑删除
	 */
	public static final String FEEDBACK_EDIT = "feedback:edit";
	/**
	 * 灰度添加删除
	 */
	public static final String GRAY_EDIT = "gray:edit";
	/**
	 * 公告新增编辑删除
	 */
	public static final String NOTICE_EDIT = "notice:edit";
	/**
	 * 批量调整职级
	 */
	public static final String BATCH_CHANGE_GRADE = "cfp-list:batch";
	/**
	 * 加拥券管理新增编辑
	 */
	public static final String ADDFEECOUPON_EDIT = "addFeeCoupon:edit";
	/**
	 * 新增职级体验券
	 */
	public static final String JOB_GRADE_VOUCHER_ADD = "job-grade:add";
	/**
	 * 切换短信通道
	 */
	public static final String CHANGE_MESSAGE_CHANNEL = "message:change";
	/**
	 * 个人加拥券管理发放
	 */
    public static final String PERSON_ADD_FEE_TICKET_SEND = "personAddfeeTicket:send";
	/**
	 * 个人加拥券管理编辑
	 */
	public static final String PERSON_ADD_FEE_TICKET_EDIT = "personAddfeeTicket:edit";

	/**
	 * A专区机构新增编辑
	 */
	public static final String ORG_A_DETAIL_EDIT = "org_a_detail:edit";
}
