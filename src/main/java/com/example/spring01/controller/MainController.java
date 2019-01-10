package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);//로깅용 변수
	
	@RequestMapping("/")
	public String main(Model model) {
		//model = 서블릿의 request 객체에 해당, map구조
		model.addAttribute("message","홈페이지 방문을 환영합니다.");
		return "main";
	}
	
	@RequestMapping(value="gugu.do")
	public String gugu(Model model, @RequestParam(defaultValue="2") int dan) {
//	  int dan = 7;
	  
	    String result = "";
	    for(int i=0; i<=9; i++) {
	        result += dan + "x" + i + "=" + dan*i + "<br>";
	    }
	    model.addAttribute("result", result);
	    return "test/gugu";
	}
	
	@RequestMapping(value="test.do")
	public void test(Model model) {
		//return타입이 void일땐 호출한 url name과 같은 페이지로 포워딩
	}
	
	@RequestMapping("test/doA")
	public String doA(Model model) {
	    model.addAttribute("message","홈페이지 방문을 환영합니다.");
	    return "test/doA";
	}
	
	@RequestMapping("test/doB")
	public void doB() {
	    logger.info("doB 호출...");
	}
	
	@RequestMapping("test/doC")
	public ModelAndView doC() {
	    Map<String,Object> map = new HashMap<String,Object>();
	    map.put("product", new ProductDTO("샤프",1000));
	    //new ModelAndView("페이지 이름","변수","값");
	    return new ModelAndView("test/doC","map",map);
	}
	
	@RequestMapping("test/doD")
	public String doD() {
	    return "redirect:/test/doE";
	}
	
	@RequestMapping("test/doE")
	public void doE() {}
	
	//q뷰를 리턴하는것이 아닌 데이터를 리턴할 경우
	@ResponseBody
	@RequestMapping("test/doF")
	public ProductDTO doF() {
	    return new ProductDTO("냉장고",500000);
	}
	
	
}
