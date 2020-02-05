package gerwingsoft.AddressBook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

@Entity
public class AddressBook extends Observable {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyInfoList;

    public AddressBook() {
        buddyInfoList = new ArrayList<BuddyInfo>();
    }

    public void addBuddyInfo(BuddyInfo buddyInfo) {
        buddyInfoList.add(buddyInfo);
        setChanged();
        notifyObservers();
    }

    public void removeBuddyInfo(int id) {
        buddyInfoList.removeIf(b -> b.getId() == id);
        setChanged();
        notifyObservers();
    }

    public int size() {
        return buddyInfoList.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BuddyInfo> getBuddyInfoList() {
        return buddyInfoList;
    }

    public void setBuddyInfoList(List<BuddyInfo> buddyInfoList) {
        this.buddyInfoList = buddyInfoList;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "buddyInfoList=" + Arrays.toString(buddyInfoList.toArray()) +
                '}';
    }
}
