package com.layui.dao.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 团体保单表
 * </p>
 *
 * @author zhulin
 * @since 2019-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lcgrpcont extends Model<Lcgrpcont> {

    private static final long serialVersionUID = 1L;

    /**
     * 团体合同号码
     */
    @TableId("GRPCONTNO")
    private String grpcontno;

    /**
     * 团体投保单号码
     */
    @TableField("PROPOSALGRPCONTNO")
    private String proposalgrpcontno;

    /**
     * 印刷号码
     */
    @TableField("PRTNO")
    private String prtno;

    /**
     * 销售渠道
     */
    @TableField("SALECHNL")
    private String salechnl;

    /**
     * 管理机构
     */
    @TableField("MANAGECOM")
    private String managecom;

    /**
     * 代理机构
     */
    @TableField("AGENTCOM")
    private String agentcom;

    /**
     * 代理机构内部分类 详见LDCODE codetype = agenttype
     */
    @TableField("AGENTTYPE")
    private String agenttype;

    /**
     * 代理人编码
     */
    @TableField("AGENTCODE")
    private String agentcode;

    /**
     * 代理人组别
     */
    @TableField("AGENTGROUP")
    private String agentgroup;

    /**
     * 联合代理人代码
     */
    @TableField("AGENTCODE1")
    private String agentcode1;

    /**
     * 保单口令
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 密码
     */
    @TableField("PASSWORD2")
    private String password2;

    /**
     * 客户号码
     */
    @TableField("APPNTNO")
    private String appntno;

    /**
     * 地址号码
     */
    @TableField("ADDRESSNO")
    private String addressno;

    /**
     * 投保总人数
     */
    @TableField("PEOPLES2")
    private BigDecimal peoples2;

    /**
     * 单位名称
     */
    @TableField("GRPNAME")
    private String grpname;

    /**
     * 行业分类
     */
    @TableField("BUSINESSTYPE")
    private String businesstype;

    /**
     * 单位性质
     */
    @TableField("GRPNATURE")
    private String grpnature;

    /**
     * 注册资本
     */
    @TableField("RGTMONEY")
    private BigDecimal rgtmoney;

    /**
     * 资产总额
     */
    @TableField("ASSET")
    private BigDecimal asset;

    /**
     * 净资产收益率
     */
    @TableField("NETPROFITRATE")
    private BigDecimal netprofitrate;

    /**
     * 主营业务
     */
    @TableField("MAINBUSSINESS")
    private String mainbussiness;

    /**
     * 法人
     */
    @TableField("CORPORATION")
    private String corporation;

    /**
     * 机构分布区域
     */
    @TableField("COMAERA")
    private String comaera;

    /**
     * 单位传真
     */
    @TableField("FAX")
    private String fax;

    /**
     * 单位电话
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 付款方式 详见LDCODE codetype = paymode
     */
    @TableField("GETFLAG")
    private String getflag;

    /**
     * 负责人
     */
    @TableField("SATRAP")
    private String satrap;

    /**
     * 公司e_mail
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 成立日期
     */
    @TableField("FOUNDDATE")
    private LocalDateTime founddate;

    /**
     * 客户组号码
     */
    @TableField("GRPGROUPNO")
    private String grpgroupno;

    /**
     * 银行编码
     */
    @TableField("BANKCODE")
    private String bankcode;

    /**
     * 银行帐号
     */
    @TableField("BANKACCNO")
    private String bankaccno;

    /**
     * 银行帐户名
     */
    @TableField("ACCNAME")
    private String accname;

    /**
     * 合同争议处理方式
     */
    @TableField("DISPUTEDFLAG")
    private String disputedflag;

    /**
     * 溢交处理方式
     */
    @TableField("OUTPAYFLAG")
    private String outpayflag;

    /**
     * 保单送达方式
     */
    @TableField("GETPOLMODE")
    private String getpolmode;

    /**
     * 语种标记
     */
    @TableField("LANG")
    private String lang;

    /**
     * 币别
     */
    @TableField("CURRENCY")
    private String currency;

    /**
     * 遗失补发次数
     */
    @TableField("LOSTTIMES")
    private BigDecimal losttimes;

    /**
     * 保单打印次数
     */
    @TableField("PRINTCOUNT")
    private BigDecimal printcount;

    /**
     * 最后一次催收日期
     */
    @TableField("REGETDATE")
    private LocalDateTime regetdate;

    /**
     * 最后一次保全日期
     */
    @TableField("LASTEDORDATE")
    private LocalDateTime lastedordate;

    /**
     * 最后一次给付日期
     */
    @TableField("LASTGETDATE")
    private LocalDateTime lastgetdate;

    /**
     * 最后一次借款日期
     */
    @TableField("LASTLOANDATE")
    private LocalDateTime lastloandate;

    /**
     * 团体特殊业务标志
     */
    @TableField("SPECFLAG")
    private String specflag;

    /**
     * 团体特约
     */
    @TableField("GRPSPEC")
    private String grpspec;

    /**
     * 交费方式
     */
    @TableField("PAYMODE")
    private String paymode;

    /**
     * 签单机构
     */
    @TableField("SIGNCOM")
    private String signcom;

    /**
     * 签单日期
     */
    @TableField("SIGNDATE")
    private LocalDateTime signdate;

    /**
     * 签单时间
     */
    @TableField("SIGNTIME")
    private String signtime;

    /**
     * 保单生效日期
     */
    @TableField("CVALIDATE")
    private LocalDateTime cvalidate;

    /**
     * 交费间隔 详见LDCODE codetype =payintv
     */
    @TableField("PAYINTV")
    private BigDecimal payintv;

    /**
     * 管理费比例
     */
    @TableField("MANAGEFEERATE")
    private Double managefeerate;

    /**
     * 预计人数
     */
    @TableField("EXPPEOPLES")
    private BigDecimal exppeoples;

    /**
     * 预计保费
     */
    @TableField("EXPPREMIUM")
    private BigDecimal exppremium;

    /**
     * 预计保额
     */
    @TableField("EXPAMNT")
    private BigDecimal expamnt;

    /**
     * 总人数
     */
    @TableField("PEOPLES")
    private BigDecimal peoples;

    /**
     * 总份数
     */
    @TableField("MULT")
    private BigDecimal mult;

    /**
     * 总保费
     */
    @TableField("PREM")
    private BigDecimal prem;

    /**
     * 总保额
     */
    @TableField("AMNT")
    private BigDecimal amnt;

    /**
     * 总累计保费
     */
    @TableField("SUMPREM")
    private BigDecimal sumprem;

    /**
     * 总累计交费
     */
    @TableField("SUMPAY")
    private BigDecimal sumpay;

    /**
     * 差额
     */
    @TableField("DIF")
    private BigDecimal dif;

    /**
     * 特别约定信息
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 保单备注
     */
    @TableField("STANDBYFLAG1")
    private String standbyflag1;

    /**
     * 保单样式 0-纸质保单 1-电子保单
     */
    @TableField("STANDBYFLAG2")
    private String standbyflag2;

    /**
     * 电子保单返回值 Error:0001-接口用户账号密码错误 Error:0002-模板编号不正确 Error:0003-接口用户无生成此电子保单权限
Error:0004-模板不存在或已删除 Error:0005-接口用户无操纵此模板的权限 Error:0006-保单号不存在
Error:0007-保险期间不正确 Error:0008-保单号重复 Error:0009-接口用户无注销电子保单权限
     */
    @TableField("STANDBYFLAG3")
    private String standbyflag3;

    /**
     * 录单人
     */
    @TableField("INPUTOPERATOR")
    private String inputoperator;

    /**
     * 录单完成日期
     */
    @TableField("INPUTDATE")
    private LocalDateTime inputdate;

    /**
     * 录单完成时间
     */
    @TableField("INPUTTIME")
    private String inputtime;

    /**
     * 复核状态
     */
    @TableField("APPROVEFLAG")
    private String approveflag;

    /**
     * 复核人编码
     */
    @TableField("APPROVECODE")
    private String approvecode;

    /**
     * 复核日期
     */
    @TableField("APPROVEDATE")
    private LocalDateTime approvedate;

    /**
     * 复核时间
     */
    @TableField("APPROVETIME")
    private String approvetime;

    /**
     * 核保人
     */
    @TableField("UWOPERATOR")
    private String uwoperator;

    /**
     * 核保状态
     */
    @TableField("UWFLAG")
    private String uwflag;

    /**
     * 核保完成日期
     */
    @TableField("UWDATE")
    private LocalDateTime uwdate;

    /**
     * 核保完成时间
     */
    @TableField("UWTIME")
    private String uwtime;

    /**
     * 投保单/保单标志 详见LDCODE codetype = appflag
     */
    @TableField("APPFLAG")
    private String appflag;

    /**
     * 投保单申请日期
     */
    @TableField("POLAPPLYDATE")
    private LocalDateTime polapplydate;

    /**
     * 保单回执客户签收日期
     */
    @TableField("CUSTOMGETPOLDATE")
    private LocalDateTime customgetpoldate;

    /**
     * 保单送达日期
     */
    @TableField("GETPOLDATE")
    private LocalDateTime getpoldate;

    /**
     * 保单送达时间
     */
    @TableField("GETPOLTIME")
    private String getpoltime;

    /**
     * 状态
     */
    @TableField("STATE")
    private String state;

    /**
     * 操作员
     */
    @TableField("OPERATOR")
    private String operator;

    /**
     * 入机日期
     */
    @TableField("MAKEDATE")
    private LocalDateTime makedate;

    /**
     * 入机时间
     */
    @TableField("MAKETIME")
    private String maketime;

    /**
     * 最后一次修改日期
     */
    @TableField("MODIFYDATE")
    private LocalDateTime modifydate;

    /**
     * 最后一次修改时间
     */
    @TableField("MODIFYTIME")
    private String modifytime;

    /**
     * 参保形式
     */
    @TableField("ENTERKIND")
    private String enterkind;

    /**
     * 保额等级
     */
    @TableField("AMNTGRADE")
    private String amntgrade;

    /**
     * 单位可投保人数
     */
    @TableField("PEOPLES3")
    private BigDecimal peoples3;

    /**
     * 在职投保人数
     */
    @TableField("ONWORKPEOPLES")
    private BigDecimal onworkpeoples;

    /**
     * 退休投保人数
     */
    @TableField("OFFWORKPEOPLES")
    private BigDecimal offworkpeoples;

    /**
     * 其它投保人数
     */
    @TableField("OTHERPEOPLES")
    private BigDecimal otherpeoples;

    /**
     * 连带投保人数
     */
    @TableField("RELAPEOPLES")
    private BigDecimal relapeoples;

    /**
     * 连带配偶投保人数
     */
    @TableField("RELAMATEPEOPLES")
    private BigDecimal relamatepeoples;

    /**
     * 连带子女投保人数
     */
    @TableField("RELAYOUNGPEOPLES")
    private BigDecimal relayoungpeoples;

    /**
     * 连带其它投保人数
     */
    @TableField("RELAOTHERPEOPLES")
    private BigDecimal relaotherpeoples;

    /**
     * 初审人
     */
    @TableField("FIRSTTRIALOPERATOR")
    private String firsttrialoperator;

    /**
     * 初审日期
     */
    @TableField("FIRSTTRIALDATE")
    private LocalDateTime firsttrialdate;

    /**
     * 初审时间
     */
    @TableField("FIRSTTRIALTIME")
    private String firsttrialtime;

    /**
     * 收单人
     */
    @TableField("RECEIVEOPERATOR")
    private String receiveoperator;

    /**
     * 收单日期
     */
    @TableField("RECEIVEDATE")
    private LocalDateTime receivedate;

    /**
     * 收单时间
     */
    @TableField("RECEIVETIME")
    private String receivetime;

    /**
     * 暂收据号
     */
    @TableField("TEMPFEENO")
    private String tempfeeno;

    /**
     * 投保经办人
     */
    @TableField("HANDLERNAME")
    private String handlername;

    /**
     * 投保单填写日期
     */
    @TableField("HANDLERDATE")
    private LocalDateTime handlerdate;

    /**
     * 投保单位章
     */
    @TableField("HANDLERPRINT")
    private String handlerprint;

    /**
     * 业务员填写日期
     */
    @TableField("AGENTDATE")
    private LocalDateTime agentdate;

    /**
     * 行业大类
     */
    @TableField("BUSINESSBIGTYPE")
    private String businessbigtype;

    /**
     * 市场类型
     */
    @TableField("MARKETTYPE")
    private String markettype;

    /**
     * 呈报号
     */
    @TableField("REPORTNO")
    private String reportno;

    /**
     * 协议书号
     */
    @TableField("CONFERNO")
    private String conferno;

    /**
     * 签报件号
     */
    @TableField("SIGNREPORTNO")
    private String signreportno;

    /**
     * 代理协议书号
     */
    @TableField("AGENTCONFERNO")
    private String agentconferno;

    /**
     * 交叉销售业务员编码
     */
    @TableField("CROSSAGENTCODE")
    private String crossagentcode;

    /**
     * 交叉销售网点
     */
    @TableField("CROSSAGENTCOM")
    private String crossagentcom;

    /**
     * 工程名字
     */
    @TableField("PROJECT_NAME")
    private String projectName;

    /**
     * 工程地址
     */
    @TableField("PROJECT_ADDRESS")
    private String projectAddress;

    /**
     * 工程类型,1市政公路 2高速公路 3铁路 4水电站 5其他
     */
    @TableField("PROJECT_TYPE")
    private String projectType;

    /**
     * 施工企业性质,1特级 2一级 3二级 4三级 5不分级
     */
    @TableField("PRO_COM_TYPE")
    private String proComType;

    /**
     * 是否统括业务单位
     */
    @TableField("IS_MASTER_POLICY")
    private String isMasterPolicy;

    /**
     * 统括业务单位编码
     */
    @TableField("MASTER_CUSTOMER")
    private String masterCustomer;

    /**
     * 是否非标件
     */
    @TableField("NONSTAFLAG")
    private String nonstaflag;

    /**
     * 非标件代码
     */
    @TableField("NONSTACODE")
    private String nonstacode;

    /**
     * 是否提供安监事故证明
     */
    @TableField("ISACCPROVE")
    private String isaccprove;

    /**
     * 建工险渠道
     */
    @TableField("PROJECTCHANNEL")
    private String projectchannel;

    /**
     * 合同类型
     */
    @TableField("HEALTHCAREBUSITYPE")
    private String healthcarebusitype;

    /**
     * 业务类型
     */
    @TableField("HEALTHCARETYPE")
    private String healthcaretype;

    /**
     * 保单类型
     */
    @TableField("CONTTYPE")
    private String conttype;

    /**
     * 第三方账管机构
     */
    @TableField("THIRD_PARTY_ORG")
    private String thirdPartyOrg;

    /**
     * 第三方直付理赔机构
     */
    @TableField("THIRD_PARTY_CLAIMS")
    private String thirdPartyClaims;

    /**
     * 无名单标志 0-有名单 1-无名单
     */
    @TableField("UNNAMESTATE")
    private String unnamestate;

    /**
     * 共保标志 0-非共保保单 1-共保保单
     */
    @TableField("COINSURANCESTATE")
    private String coinsurancestate;

    /**
     * 保全结算方式 0-即时结算 1-定期/定额结算
     */
    @TableField("SETTLESTATE")
    private String settlestate;

    /**
     * 销售方式
     */
    @TableField("AGENTMODE")
    private String agentmode;

    /**
     * 销售模式 详见LDCODE codetype="salemode"
     */
    @TableField("SALEMODE")
    private String salemode;

    /**
     * 是否临分件标示
     */
    @TableField("ISREINSURANCE")
    private String isreinsurance;

    /**
     * 项目标识,4位数字,0001开始
     */
    @TableField("HEALTHCARENO")
    private String healthcareno;

    /**
     * 投保人类型（G-团体投保人，P-个人投保人）
     */
    @TableField("APPNTTYPE")
    private String appnttype;

    /**
     * 内部合作协议代码
     */
    @TableField("BLANKETNO")
    private String blanketno;


    @Override
    protected Serializable pkVal() {
        return this.grpcontno;
    }

}
