package web.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.Entity.Read_Book;
import service.Read_BookService;
import service.model.Read_BookContext;

@Controller
@RequestMapping("/pages")
public class PageController {

	@Autowired
	private Read_BookService read_BookService;
	
	@RequestMapping(value = "/read_Book/list", method = RequestMethod.GET)
	public String getRead_Book(Model model) {
		
		List<Read_Book> read_Book = read_BookService.getAllRead_BookList();
		model.addAttribute("read_Book",read_Book);
		
		return "thyme_read_Book_list";
	}
	
	@RequestMapping(value = "/read_Book", method = RequestMethod.GET)
	public String getRead_BookSavePage(Read_BookContext read_BookContext) {
		
		return "thyme_read_Book_save";
	}
	
	@RequestMapping(value = "/read_Book", method = RequestMethod.POST)
    public String save(Read_BookContext read_BookContext, BindingResult result, Model model) {
        
		
		read_BookService.save(read_BookContext);
        
		model.addAttribute("employees", read_BookService.getAllRead_BookList());
        
        return "thyme_read_Book_list";
    }
	
}
