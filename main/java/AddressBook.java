import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

    ArrayList<Person> list;
    // as we use hashSet here multiple entries are not allowed.
    Scanner sc;

    HashMap<String, ArrayList<Person>> contacts;

    // instantiating scanner and ArrayList in constructor.
    public AddressBook() {
        sc = new Scanner(System.in);
        list = new ArrayList<Person>();
        contacts = new HashMap<String, ArrayList<Person>>();
    }

    // Adding contacts to address book
    public void addDetails() {
        sc = new Scanner(System.in);
        System.out.print("Enter how many contacts you want to store at a time : ");
        int enterCount = sc.nextInt();
        for (int i = 0; i < enterCount; i++) {

            Person contactDetails = new Person();
            System.out.print("Enter First Name : ");
            String firstName = sc.next();
            contactDetails.setFirstName(firstName);

            System.out.print("Enter Last Name : ");
            contactDetails.setLastName(sc.next());

            System.out.print("Enter Address : ");
            contactDetails.setAddress(sc.next());

            System.out.print("Enter City : ");
            contactDetails.setCity(sc.next());

            System.out.print("Enter State : ");
            contactDetails.setState(sc.next());

            System.out.print("Enter ZipCode : ");
            contactDetails.setZipCode(sc.nextInt());

            System.out.print("Enter Phone-Number : ");
            contactDetails.setPhoneNumber(sc.nextLong());

            System.out.print("Enter Email-Id : ");
            contactDetails.setEmailId(sc.next());

            System.out.print("Enter Book name to which you have to add contact : ");
            String bookName = sc.next();

            if (contacts.containsKey(bookName)) {
                ArrayList<Person> contactList = contacts.get(bookName);
                for (int j = 0; j < contactList.size(); j++) {
                    if (contactList.get(j).getFirstName() == firstName) {
                        System.out.println("Sorry can not allow duplicate contact :");
                        addDetails();
                    }
                }
                contactList.add(contactDetails);
                contacts.put(bookName, contactList);
                System.out.println("New Contact Added Successfully");
            } else {
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k).getFirstName() == firstName) {
                        System.out.println("Sorry can not allow duplicate contact :");
                        addDetails();
                    }
                }
                list.add(contactDetails);
                contacts.put(bookName, list);
                System.out.println("New Address-Book created and added Contact Added Successfully");
            }
        }

    }

//	Edit the contact details

    public void editContact() {
        System.out.print("Enter mobile number to select the contact to be edited : ");
        int searchMNumber = sc.nextInt();
        System.out.println("Select filed number that you want to edit :\n1.Edit First-Name,\n2.Edit Last-Name,\n3.Edit Address,\n4.Edit City.\n5.Edit State,\n6.Edit ZipCode,\n7.Edit Phone-Number,\n8.Edit EmailId.\n");
        int fieldNumber = sc.nextInt();
        switch(fieldNumber)
        {
            case 1:
                //Edit Fist-Name
                System.out.print("What new first name you want to set : ");
                String editFistName = sc.next();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setFirstName(editFistName);
                        System.out.println("\nFirst-Name of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 2:
                //Edit Last-Name
                System.out.print("What new last name you want to set : ");
                String editLastName = sc.next();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setLastName(editLastName);
                        System.out.println("\nLast-Name of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 3:
                //Edit Address
                System.out.print("What new address you want to set : ");
                String editAddress = sc.next();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setAddress(editAddress);
                        System.out.println("\nAddress of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 4:
                //Edit City
                System.out.print("What new city you want to set : ");
                String editCity = sc.next();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setCity(editCity);
                        System.out.println("\nCity of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 5:
                //Edit State
                System.out.print("What new state you want to set : ");
                String editState = sc.next();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setState(editState);
                        System.out.println("\nState of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 6:
                //Edit ZipCode
                System.out.print("What new zipcode you want to set : ");
                int editZipCode = sc.nextInt();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setZipCode(editZipCode);
                        System.out.println("\nZip-Code of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 7:
                //Edit Mobile-Number
                System.out.print("What new mobile number you want to set : ");
                long editPhoneNumber = sc.nextLong();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setPhoneNumber(editPhoneNumber);
                        System.out.println("\nMobile-Number of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 8:
                //Edit Email-id
                System.out.print("What new email-id you want to set : ");
                String editEmailId = sc.next();
                for (Person person : list) {
                    if (person.getPhoneNumber() == searchMNumber) {
                        person.setEmailId(editEmailId);
                        System.out.println("\nEmail-Id of respective contact has been successfully edited.\n");
                    }
                }
                break;
            default:
                System.out.println("Incorrect Entry !");
        }	}


//	Delete contact using person's name

    public void deleteContact() {
        System.out.print("\nGive a mobile number to deleted associated contact : ");
        long searchNumber = sc.nextLong();
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getPhoneNumber() == searchNumber)
            {
                list.remove(i);
                System.out.println("\nContact successfully deleted\n");
                break;
            }
            else
            {
                System.out.println("Contact associated with the given mobile number does not exist." +
                        "Enter correct mobile number.");
                deleteContact();
            }
        }

    }
    public void SearchPersonInACityOrState()
    {
        System.out.print("Enter City Name Or State Name To Search Contact : ");
        String searchCityState = sc.next();
        System.out.println("\nFollowing are the persons who belongs to : " + searchCityState);
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getCity().equals(searchCityState) || list.get(i).getState().equals(searchCityState))
            {
                Person personDetails = list.get(i);
                System.out.println(personDetails.getFirstName());
            }
        }
    }
    public void GetNumberOfContacts()
    {
        System.out.print("Enter City Name Or State Name To Get The Count Of Contacts : ");
        String countContacts = sc.next();
        int totalCount = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getCity().equals(countContacts) || list.get(i).getState().equals(countContacts))
            {
                Person personDetails = list.get(i);
                System.out.println(personDetails);
                totalCount ++;
            }
        }
        System.out.println("\nTotal number of contacts present in " + countContacts + " is : " + totalCount);
    }
    public void SortContactByFirstName()
    {
        contacts.keySet().forEach((String name) -> {
            contacts.get(name).stream().sorted(Comparator.comparing(Person::getFirstName))
                    .collect(Collectors.toList()).forEach(person -> System.out.println(person.toString()));
        });
    }
    public void SortByZipCode()
    {
        contacts.keySet().forEach((String key) -> {
            contacts.get(key).stream()
                    .sorted(Comparator.comparing(Person::getZipCode))
                    .collect(Collectors.toList())
                    .forEach(person -> System.out.println(person.toString()));
        });
    }

    public void displayContacts(){
        System.out.println(contacts);
    }
    public void fileCreate() {
        System.out.println("Enter the file name to creat");
        String filename = sc.next();
        File     myfile = new File(filename);
        try {
            myfile.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create this file ");
            e.printStackTrace();
        }
    }
    public void fileWrite() {
        System.out.println("Enter the file name to in which you want to write");
        String filename = sc.next();
        try {
            FileWriter fileWriter = new FileWriter(filename);
            for (Person str : list) {
                fileWriter.write(str + System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void fileReader() {
        System.out.println("Enter the file name to in which you want to Read");
        String filename = sc.next();
        File myfile = new File(filename);
        try {
            Scanner s = new Scanner(myfile);
            while(s.hasNextLine()) {
                String Line = s.nextLine();
                System.out.println(Line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}