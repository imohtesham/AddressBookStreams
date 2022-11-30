import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    public void displayContacts()
    {
        for(Person element : list)
        {
            if(element != null)
            {
                System.out.println(element);
            }
        }
    }
}