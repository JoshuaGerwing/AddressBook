package gerwingsoft.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookWebController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/getAddressBook")
    public String getAddressBook(@RequestParam(value = "bookId") int bookId, Model model) {
        AddressBook addressBook = addressBookRepository.findById(bookId);
        model.addAttribute("addressBook", addressBook.toString());
        return "addressBook";
    }
}
