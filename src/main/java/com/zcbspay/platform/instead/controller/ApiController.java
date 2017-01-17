package com.zcbspay.platform.instead.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.business.merch.bean.MerchMkBean;
import com.zcbspay.platform.business.merch.service.QueryMerchMkService;
import com.zcbspay.platform.instead.service.NoticeService;
import com.zcbspay.platform.instead.service.OrderService;
import com.zcbspay.platform.instead.service.PayService;
import com.zcbspay.platform.instead.service.RsaService;
import com.zcbspay.platform.instead.service.TradeService;
import com.zcbspay.platform.instead.utils.JsonUtils;
import com.zcbspay.platform.instead.utils.StringUtil;
import com.zcbspay.platform.instead.utils.security.GateKeeper;
import com.zcbspay.platform.instead.utils.security.MixEncryptUtil;
import com.zcbspay.platform.instead.vo.NoticeAsynRequestBean;
import com.zcbspay.platform.instead.vo.OrderSubmitRequestBean;
import com.zcbspay.platform.instead.vo.OtherPayRequestBean;
import com.zcbspay.platform.instead.vo.SimplePayRequestBean;
import com.zcbspay.platform.instead.vo.TradeQueryRequestBean;

@Controller
@RequestMapping("/api")
public class ApiController{
	private static final Log log = LogFactory.getLog(ApiController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private PayService payService;
	
	@Autowired
	private TradeService tradeService;
	
	@Autowired
	private RsaService rsaService;
	
	@Autowired
	private QueryMerchMkService queryMerchMkService;
	
	
	private static String merid="200000000000610";
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/deco")
	public ModelAndView deco(String sign,String data,String addit) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("sign", sign);
	    mv.addObject("data", data);
	    mv.addObject("addit", addit);
	    GateKeeper keeper=MixEncryptUtil.decode(data, sign, addit,rsaService.getLocalPrivateKey(merid));
	    Map<String, String> returnmap = new HashMap<>();
	    returnmap.put("data", keeper.getData().toString());
	    returnmap.put("sign", keeper.getSign().toString());
	    returnmap.put("addit", keeper.getAddit().toString());
	    mv.addObject("txt", returnmap);
		return mv;
	}
	
	/**
	 * 订单提交的数据加密
	 * @param orderSubmitBean
	 * @return
	 */
	@RequestMapping("/enordersubmit")
	@ResponseBody
	public Map<String, String> enordersubmit(OrderSubmitRequestBean obj) {
		return enc(obj);
	}
	
	/**
	 * 订单提交
	 * @param sign
	 * @param data
	 * @param addit
	 */
	@RequestMapping("/ordersubmit")
	@ResponseBody
	public Map<String, String> ordersubmit(String sign,String data,String addit) {
		if (!checkData(sign, data, addit)) {
			return null;
		}
		return orderService.orderSubmit(sign, data, addit);
	}

	
	/**
	 * 异步通知的数据加密
	 * @param orderSubmitBean
	 * @return
	 */
	@RequestMapping("/ennoticeasyn")
	@ResponseBody
	public Map<String, String> ennoticeasyn(NoticeAsynRequestBean obj) {
		return enc(obj);
	}
	/**
	 * 异步通知
	 * @param sign
	 * @param data
	 * @param addit
	 */
	@RequestMapping("/noticeasyn")
	@ResponseBody
	public Map<String, String> noticeasyn(String sign,String data,String addit) {
		if (!checkData(sign, data, addit)) {
			return null;
		}
		return noticeService.noticeasyn(sign, data, addit);
	}
	
	/**
	 * 快捷支付的数据加密
	 * @param 
	 * @return
	 */
	@RequestMapping("/ensimplypay")
	@ResponseBody
	public Map<String, String> ensimplypay(SimplePayRequestBean obj) {
		return enc(obj);
	}
	/**
	 * 快捷支付
	 * @param sign
	 * @param data
	 * @param addit
	 */
	@RequestMapping("/simplypay")
	@ResponseBody
	public Map<String, String> simplypay(String sign,String data,String addit) {
		if (!checkData(sign, data, addit)) {
			return null;
		}
		return payService.simplePay(sign, data, addit);
	}
	
	/**
	 * 交易查询的数据加密
	 * @param 
	 * @return
	 */
	@RequestMapping("/entradequery")
	@ResponseBody
	public Map<String, String> entradequery(TradeQueryRequestBean obj) {
		return enc(obj);
	}
	/**
	 * 交易查询
	 * @param sign
	 * @param data
	 * @param addit
	 */
	@RequestMapping("/tradequery")
	@ResponseBody
	public Map<String, String> tradequery(String sign,String data,String addit) {
		if (!checkData(sign, data, addit)) {
			return null;
		}
		return tradeService.tradeQuery(sign, data, addit);
	}
	
	/**
	 * 代付的数据加密
	 * @param 
	 * @return
	 */
	@RequestMapping("/enotherpay")
	@ResponseBody
	public Map<String, String> enotherpay(OtherPayRequestBean obj) {
		return enc(obj);
	}
	/**
	 * 代付
	 * @param sign
	 * @param data
	 * @param addit
	 */
	@RequestMapping("/otherpay")
	@ResponseBody
	public Map<String, String> otherpay(String sign,String data,String addit) {
		if (!checkData(sign, data, addit)) {
			return null;
		}
		return payService.otherPay(sign, data, addit);
	}
	
	/**
	 * 加密
	 * @param orderSubmitBean
	 * @return
	 */
	private Map<String, String> enc(Object orderSubmitBean) {
		String dataString= JsonUtils.objectToJson(orderSubmitBean);
		Map<String, String> result =MixEncryptUtil.encode(dataString,rsaService.getLocalPublicKey(merid));
		return result;
	}
	/**
	 * 数据验证
	 * @param sign
	 * @param data
	 * @param addit
	 * @return
	 */
	private boolean checkData(String sign, String data, String addit) {
		if (log.isDebugEnabled()) {
			log.debug("【原报文数据sign=】" + sign);
			log.debug("【原报文数据addit=】" + addit);
			log.debug("【原报文数据data=】" + data);
		}
		if (StringUtil.isEmpty(data) || StringUtil.isEmpty(sign) || StringUtil.isEmpty(addit)) {
			log.error("业务数据或签名或附加数据为空");
			return false;
		}
		return true;
	}
}
