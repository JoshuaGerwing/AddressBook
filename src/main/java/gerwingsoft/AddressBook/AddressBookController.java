package gerwingsoft.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/createAddressBook")
    public AddressBook createAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @GetMapping("/addBuddyInfo")
    public AddressBook addBuddyInfo(@RequestParam(value = "bookId") int bookId, @RequestParam(value = "name") String name, @RequestParam(value = "phoneNumber") String phoneNumber, @RequestParam(value = "address") String address) {
        AddressBook addressBook = addressBookRepository.findById(bookId);
        addressBook.addBuddyInfo(new BuddyInfo(name, phoneNumber, address));
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @GetMapping("/removeBuddyInfo")
    public AddressBook removeBuddyInfo(@RequestParam(value = "bookId") int bookId, @RequestParam(value = "buddyId") int buddyId) {
        AddressBook addressBook = addressBookRepository.findById(bookId);
        addressBook.removeBuddyInfo(buddyId);
        addressBookRepository.save(addressBook);
        return addressBook;
    }
}
