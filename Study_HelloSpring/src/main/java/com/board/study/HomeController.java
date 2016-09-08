package com.board.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
// 컨트롤러는 Spring이 최종 결과물을 보일 수 있도록 하는 최종 단계이다. 
// servlet-context에서 데이터를 넘겨받아 적절한 컨트롤러가 실행되고 설정된 path에서 .jsp가 실행 될 수 있도록 return 값을 넘겨준다.

// 이 클래스는 컨트롤 수행을 하는 선언이다. Controller 어노테이션이라고 하며 이러한 어노테이션이 여러게 있다.
@Controller
public class HomeController {
	
	//상수
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// WEB.xml에서 넘겨받은 url 요청을 수행하는 어노테이션이다.
	// '/' url 주소로 들어온 get 방식 요청이라면 아래 내용을 실행하라는 선언이다.
	// 특히 적절한 요청이 선언되지 않는다면 404 에러를 출력하게 된다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // 모델 안에 두개의 인자 값을 주입하게 된다.
		
		return "home"; // 메소드가 끝나고 home이라는 인자를 넘겨줘 'home.jsp'파일로 전달이 되게 된다..

		
	}
	
}
