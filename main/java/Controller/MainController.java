package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	String name = "Bob";
    int number = 42;
    
    @GetMapping("test")
    public String testPage(Model model) {
        
        model.addAttribute("number", number);
        model.addAttribute("firstName", name);
        
        return "test";
    }
    
    @GetMapping("testList") 
    public String testList(Model model) {
        List<Integer> numbers = new ArrayList<>();
        
        numbers.add(0);
        numbers.add(10);
        numbers.add(6);
        numbers.add(35);
        
        model.addAttribute("numberList", numbers);
        
        return "testList";
    }
    
    @PostMapping("testForm")
    public String testForm(HttpServletRequest request) {
        name = request.getParameter("formFirstName");
        number = Integer.parseInt(request.getParameter("formNumber"));
        
        return "redirect:/test";
    }
	
	
}
